// generated with ast extension for cup
// version 0.8
// 13/8/2023 16:54:46


package rs.ac.bg.etf.pp1.ast;

public class FactorListNone extends FactorList {

    public FactorListNone () {
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
        buffer.append("FactorListNone(\n");

        buffer.append(tab);
        buffer.append(") [FactorListNone]");
        return buffer.toString();
    }
}