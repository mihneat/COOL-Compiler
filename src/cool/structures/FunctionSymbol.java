package cool.structures;

import java.util.LinkedHashMap;
import java.util.Map;

public class FunctionSymbol extends IdSymbol implements Scope {
    protected Map<String, Symbol> symbols = new LinkedHashMap<>();

    protected Scope parent;

    protected int offset;

    protected int localsCnt;

    public FunctionSymbol(String name, Scope parent) {
        super(name);
        this.parent = parent;
    }

    @Override
    public boolean add(Symbol s) {
        // Check if the symbol is already in this scope
        if (symbols.containsKey(s.getName())) {
            return false;
        }

        symbols.put(s.getName(), s);

        return true;
    }

    @Override
    public Symbol lookup(String s) {
        if (symbols.containsKey(s)) {
            return symbols.get(s);
        }

        if (parent != null) {
            return parent.lookup(s);
        }

        return null;
    }

    public Map<String, Symbol> getFormals() {
        return symbols;
    }

    @Override
    public Scope getParent() {
        return parent;
    }
    
    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLocalsCnt() {
        return localsCnt;
    }

    public void setLocalsCnt(int localsCnt) {
        this.localsCnt = localsCnt;
    }
}
