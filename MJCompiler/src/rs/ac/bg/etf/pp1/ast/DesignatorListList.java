// generated with ast extension for cup
// version 0.8
// 14/8/2023 19:26:9


package rs.ac.bg.etf.pp1.ast;

public class DesignatorListList extends DesignatorList {

    private DesignatorOne DesignatorOne;
    private DesignatorList DesignatorList;

    public DesignatorListList (DesignatorOne DesignatorOne, DesignatorList DesignatorList) {
        this.DesignatorOne=DesignatorOne;
        if(DesignatorOne!=null) DesignatorOne.setParent(this);
        this.DesignatorList=DesignatorList;
        if(DesignatorList!=null) DesignatorList.setParent(this);
    }

    public DesignatorOne getDesignatorOne() {
        return DesignatorOne;
    }

    public void setDesignatorOne(DesignatorOne DesignatorOne) {
        this.DesignatorOne=DesignatorOne;
    }

    public DesignatorList getDesignatorList() {
        return DesignatorList;
    }

    public void setDesignatorList(DesignatorList DesignatorList) {
        this.DesignatorList=DesignatorList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorOne!=null) DesignatorOne.accept(visitor);
        if(DesignatorList!=null) DesignatorList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorOne!=null) DesignatorOne.traverseTopDown(visitor);
        if(DesignatorList!=null) DesignatorList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorOne!=null) DesignatorOne.traverseBottomUp(visitor);
        if(DesignatorList!=null) DesignatorList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorListList(\n");

        if(DesignatorOne!=null)
            buffer.append(DesignatorOne.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorList!=null)
            buffer.append(DesignatorList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorListList]");
        return buffer.toString();
    }
}
