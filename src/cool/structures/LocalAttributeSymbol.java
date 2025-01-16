package cool.structures;

public class LocalAttributeSymbol extends IdSymbol implements Scope {
    protected Scope parent;

    public LocalAttributeSymbol(String name, Scope parent) {
        super(name);
        this.parent = parent;
    }

    @Override
    public boolean add(Symbol s) {
        return false;
    }

    @Override
    public Symbol lookup(String s) {
        if (this.getName().equals(s)) {
            return this;
        }

        if (parent != null) {
            return parent.lookup(s);
        }

        return null;
    }

    @Override
    public Scope getParent() {
        return parent;
    }
}

