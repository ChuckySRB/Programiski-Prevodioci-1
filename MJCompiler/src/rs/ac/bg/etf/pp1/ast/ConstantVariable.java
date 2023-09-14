// generated with ast extension for cup
// version 0.8
// 14/8/2023 19:26:9


package rs.ac.bg.etf.pp1.ast;

public class ConstantVariable extends ConstVariable {

    private String constName;
    private ConstExpr ConstExpr;

    public ConstantVariable (String constName, ConstExpr ConstExpr) {
        this.constName=constName;
        this.ConstExpr=ConstExpr;
        if(ConstExpr!=null) ConstExpr.setParent(this);
    }

    public String getConstName() {
        return constName;
    }

    public void setConstName(String constName) {
        this.constName=constName;
    }

    public ConstExpr getConstExpr() {
        return ConstExpr;
    }

    public void setConstExpr(ConstExpr ConstExpr) {
        this.ConstExpr=ConstExpr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstExpr!=null) ConstExpr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstExpr!=null) ConstExpr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstExpr!=null) ConstExpr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstantVariable(\n");

        buffer.append(" "+tab+constName);
        buffer.append("\n");

        if(ConstExpr!=null)
            buffer.append(ConstExpr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstantVariable]");
        return buffer.toString();
    }
}
