// generated with ast extension for cup
// version 0.8
// 14/8/2023 3:42:13


package rs.ac.bg.etf.pp1.ast;

public class NumberListList extends NumberList {

    private Integer N1;
    private NumberList NumberList;

    public NumberListList (Integer N1, NumberList NumberList) {
        this.N1=N1;
        this.NumberList=NumberList;
        if(NumberList!=null) NumberList.setParent(this);
    }

    public Integer getN1() {
        return N1;
    }

    public void setN1(Integer N1) {
        this.N1=N1;
    }

    public NumberList getNumberList() {
        return NumberList;
    }

    public void setNumberList(NumberList NumberList) {
        this.NumberList=NumberList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(NumberList!=null) NumberList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(NumberList!=null) NumberList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(NumberList!=null) NumberList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NumberListList(\n");

        buffer.append(" "+tab+N1);
        buffer.append("\n");

        if(NumberList!=null)
            buffer.append(NumberList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NumberListList]");
        return buffer.toString();
    }
}
