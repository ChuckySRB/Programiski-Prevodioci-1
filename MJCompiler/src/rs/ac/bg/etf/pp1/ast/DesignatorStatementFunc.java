// generated with ast extension for cup
// version 0.8
// 14/8/2023 3:42:13


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStatementFunc extends DesignatorStatement {

    private Designator Designator;
    private ActParsOne ActParsOne;

    public DesignatorStatementFunc (Designator Designator, ActParsOne ActParsOne) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.ActParsOne=ActParsOne;
        if(ActParsOne!=null) ActParsOne.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public ActParsOne getActParsOne() {
        return ActParsOne;
    }

    public void setActParsOne(ActParsOne ActParsOne) {
        this.ActParsOne=ActParsOne;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(ActParsOne!=null) ActParsOne.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(ActParsOne!=null) ActParsOne.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(ActParsOne!=null) ActParsOne.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStatementFunc(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ActParsOne!=null)
            buffer.append(ActParsOne.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStatementFunc]");
        return buffer.toString();
    }
}
