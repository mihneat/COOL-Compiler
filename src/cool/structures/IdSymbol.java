package cool.structures;

public class IdSymbol extends Symbol {
    protected TypeSymbol type;
    protected String typeStr;

    protected int offset;
    protected boolean isFormal;

    public IdSymbol(String name) {
        super(name);
    }

    public void setType(TypeSymbol type) {
        this.type = type;
    }

    public TypeSymbol getType() {
        return type;
    }

    public void setTypeStr(String typeStr) {
        this.typeStr = typeStr;
    }

    public String getTypeStr() {
        return typeStr;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public boolean getFormal() {
        return isFormal;
    }

    public void setFormal() {
        isFormal = true;
    }
}