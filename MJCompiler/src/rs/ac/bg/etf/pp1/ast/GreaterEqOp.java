// generated with ast extension for cup
// version 0.8
// 15/8/2023 3:23:48


package rs.ac.bg.etf.pp1.ast;

public class GreaterEqOp extends Relop {

    public GreaterEqOp () {
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
        buffer.append("GreaterEqOp(\n");

        buffer.append(tab);
        buffer.append(") [GreaterEqOp]");
        return buffer.toString();
    }
}
