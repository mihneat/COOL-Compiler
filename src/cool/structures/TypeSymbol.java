package cool.structures;

import java.util.LinkedHashMap;
import java.util.Map;

public class TypeSymbol extends Symbol implements Scope {
    protected Map<String, IdSymbol> attributes = new LinkedHashMap<>();
    protected Map<String, FunctionSymbol> methods = new LinkedHashMap<>();

    protected TypeSymbol parentType;

    protected int tag;
    protected int maxTag;

    public TypeSymbol(String name) {
        super(name);

    }

    public TypeSymbol(String name, TypeSymbol parentType) {
        super(name);
        this.parentType = parentType;
    }

    @Override
    public boolean add(Symbol s) {
        // Check the symbol type
        if (s instanceof FunctionSymbol) {
            // Check if the symbol is already in this scope
            if (methods.containsKey(s.getName())) {
                return false;
            }

            methods.put(s.getName(), (FunctionSymbol) s);

            return true;
        } else if (s instanceof IdSymbol) {
            // Check if the symbol is already in this scope
            if (attributes.containsKey(s.getName())) {
                return false;
            }

            attributes.put(s.getName(), (IdSymbol) s);

            return true;
        }

        return false;
    }

    @Override
    public Symbol lookup(String s) {
        if (attributes.containsKey(s)) {
            return attributes.get(s);
        }

        if (parentType != null) {
            return parentType.lookup(s);
        }

        return null;
    }

    public FunctionSymbol lookupMethod(String s) {
        if (methods.containsKey(s)) {
            return methods.get(s);
        }

        if (parentType != null) {
            return parentType.lookupMethod(s);
        }

        return null;
    }

    public Map<String, IdSymbol> getAttributes() {
        return attributes;
    }

    public Map<String, FunctionSymbol> getMethods() {
        return methods;
    }

    @Override
    public Scope getParent() {
        return parentType;
    }

    public void setParent(TypeSymbol parentType) {
        this.parentType = parentType;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public int getMaxTag() {
        return maxTag;
    }

    public void setMaxTag(int maxTag) {
        this.maxTag = Math.max(maxTag, this.maxTag);
    }

    public void setMaxTagForce(int maxTag) {
        this.maxTag = maxTag;
    }

}

