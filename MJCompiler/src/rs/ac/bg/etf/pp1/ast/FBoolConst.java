// generated with ast extension for cup
// version 0.8
// 15/8/2023 3:23:48


package rs.ac.bg.etf.pp1.ast;

public class FBoolConst extends Factor {

    private Boolean Val;

    public FBoolConst (Boolean Val) {
        this.Val=Val;
        if(Val!=null) Val.setParent(this);
    }

    public Boolean getVal() {
        return Val;
    }

    public void setVal(Boolean Val) {
        this.Val=Val;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Val!=null) Val.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Val!=null) Val.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Val!=null) Val.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FBoolConst(\n");

        if(Val!=null)
            buffer.append(Val.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FBoolConst]");
        return buffer.toString();
    }
}
