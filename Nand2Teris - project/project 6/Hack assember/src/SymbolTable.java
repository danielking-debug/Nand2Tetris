import java.util.HashMap;
import java.util.Map;

public class SymbolTable {

    private Map<String, Integer> symbols;

    public SymbolTable() {
        symbols = new HashMap<>();

        // Predefined symbols
        symbols.put("SP", 0);
        symbols.put("LCL", 1);
        symbols.put("ARG", 2);
        symbols.put("THIS", 3);
        symbols.put("THAT", 4);

        // R0 - R15
        for (int i = 0; i <= 15; i++) {
            symbols.put("R" + i, i);
        }

        symbols.put("SCREEN", 16384);
        symbols.put("KBD", 24576);
    }

    public void addEntry(String symbol, int address) {
        symbols.put(symbol, address);
    }

    public boolean contains(String symbol) {
        return symbols.containsKey(symbol);
    }

    public int getAddress(String symbol) {
        return symbols.get(symbol);
    }
}