import java.io.*;

public class Parser {

    private BufferedReader reader;
    private String currentInstruction;

    public Parser(String fileName) throws IOException {
        reader = new BufferedReader(new FileReader(fileName));
    }

    public boolean hasMoreCommands() throws IOException {
        return reader.ready();
    }

    public void advance() throws IOException {
        currentInstruction = reader.readLine();

        while (currentInstruction != null) {
            currentInstruction = currentInstruction.trim();

            if (!currentInstruction.isEmpty() && !currentInstruction.startsWith("//")) {
                break;
            }

            currentInstruction = reader.readLine();
        }
    }

    public String instructionType() {
        if (currentInstruction.startsWith("@")) {
            return "A_INSTRUCTION";
        }

        if (currentInstruction.startsWith("(") && currentInstruction.endsWith(")")) {
            return "L_INSTRUCTION";
        }

        return "C_INSTRUCTION";
    }

    public String symbol() {
        if (instructionType().equals("A_INSTRUCTION")) {
            return currentInstruction.substring(1);
        }

        if (instructionType().equals("L_INSTRUCTION")) {
            return currentInstruction.substring(1, currentInstruction.length() - 1);
        }

        return null;
    }

    public String dest() {
        if (instructionType().equals("C_INSTRUCTION")) {
            int equalsIndex = currentInstruction.indexOf("=");

            if (equalsIndex != -1) {
                return currentInstruction.substring(0, equalsIndex);
            }
        }

        return null;
    }

    public String comp() {
        if (instructionType().equals("C_INSTRUCTION")) {
            int start = currentInstruction.indexOf("=") + 1;

            if (currentInstruction.indexOf("=") == -1) {
                start = 0;
            }

            int end = currentInstruction.indexOf(";");

            if (end == -1) {
                end = currentInstruction.length();
            }

            return currentInstruction.substring(start, end);
        }

        return null;
    }

    public String jump() {
        if (instructionType().equals("C_INSTRUCTION")) {
            int semicolonIndex = currentInstruction.indexOf(";");

            if (semicolonIndex != -1) {
                return currentInstruction.substring(semicolonIndex + 1);
            }
        }

        return null;
    }

    public void close() throws IOException {
        reader.close();
    }
}