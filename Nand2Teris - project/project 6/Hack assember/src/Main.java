import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        if (args.length != 1) {
            System.out.println("Usage: java -cp src Main file.asm");
            return;
        }

        String inputFile = args[0];

        if (!inputFile.endsWith(".asm")) {
            System.out.println("Please provide an .asm file.");
            return;
        }

        String outputFile = inputFile.substring(0, inputFile.length() - 4) + ".hack";

        // First pass
        // Find labels and store their addresses
        SymbolTable symbolTable = new SymbolTable();
        Parser parser = new Parser(inputFile);

        int romAddress = 0;

        while (parser.hasMoreCommands()) {
            parser.advance();

            String type = parser.instructionType();

            if (type.equals("L_INSTRUCTION")) {
                String symbol = parser.symbol();

                if (!symbolTable.contains(symbol)) {
                    symbolTable.addEntry(symbol, romAddress);
                }
            } else {
                romAddress++;
            }
        }

        parser.close();

        // Second pass
        // Translate instructions into binary
        parser = new Parser(inputFile);

        BufferedWriter writer = new BufferedWriter(
                new FileWriter(outputFile)
        );

        int variableAddress = 16;

        while (parser.hasMoreCommands()) {
            parser.advance();

            String type = parser.instructionType();

            if (type.equals("L_INSTRUCTION")) {
                continue;
            }

            if (type.equals("A_INSTRUCTION")) {

                String symbol = parser.symbol();

                int address;

                if (symbol.matches("\\d+")) {
                    address = Integer.parseInt(symbol);
                } else {

                    if (!symbolTable.contains(symbol)) {
                        symbolTable.addEntry(symbol, variableAddress);
                        variableAddress++;
                    }

                    address = symbolTable.getAddress(symbol);
                }

                String binary = String.format("%16s",
                        Integer.toBinaryString(address)
                ).replace(' ', '0');

                writer.write(binary);
                writer.newLine();

            } else if (type.equals("C_INSTRUCTION")) {

                String comp = Code.comp(parser.comp());
                String dest = Code.dest(parser.dest());
                String jump = Code.jump(parser.jump());

                String instruction = "111" + comp + dest + jump;

                writer.write(instruction);
                writer.newLine();
            }
        }

        parser.close();
        writer.close();

        System.out.println("Assembly complete!");
        System.out.println("Output: " + outputFile);
    }
}