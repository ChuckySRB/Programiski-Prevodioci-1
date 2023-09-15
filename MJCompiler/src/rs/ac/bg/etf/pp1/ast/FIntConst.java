// generated with ast extension for cup
// version 0.8
// 15/8/2023 3:23:48


package rs.ac.bg.etf.pp1.ast;

public class FIntConst extends Factor {

    private Integer Val;

    public FIntConst (Integer Val) {
        this.Val=Val;
    }

    public Integer getVal() {
        return Val;
    }

    public void setVal(Integer Val) {
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
        buffer.append("FIntConst(\n");

        buffer.append(" "+tab+Val);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FIntConst]");
        return buffer.toString();
    }
}
