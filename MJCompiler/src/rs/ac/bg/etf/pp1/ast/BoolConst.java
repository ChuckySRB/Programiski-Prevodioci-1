// generated with ast extension for cup
// version 0.8
// 15/8/2023 3:23:48


package rs.ac.bg.etf.pp1.ast;

public class BoolConst extends ConstExpr {

    private Boolean val;

    public BoolConst (Boolean val) {
        this.val=val;
        if(val!=null) val.setParent(this);
    }

    public Boolean getVal() {
        return val;
    }

    public void setVal(Boolean val) {
        this.val=val;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(val!=null) val.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(val!=null) val.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(val!=null) val.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("BoolConst(\n");

        if(val!=null)
            buffer.append(val.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [BoolConst]");
        return buffer.toString();
    }
}
