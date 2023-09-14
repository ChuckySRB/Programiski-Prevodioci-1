// generated with ast extension for cup
// version 0.8
// 14/8/2023 3:42:13


package rs.ac.bg.etf.pp1.ast;

public class FCharConst extends Factor {

    private Character Val;

    public FCharConst (Character Val) {
        this.Val=Val;
    }

    public Character getVal() {
        return Val;
    }

    public void setVal(Character Val) {
        this.Val=Val;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FCharConst(\n");

        buffer.append(" "+tab+Val);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FCharConst]");
        return buffer.toString();
    }
}
