// generated with ast extension for cup
// version 0.8
// 13/8/2023 16:54:46


package rs.ac.bg.etf.pp1.ast;

public class StatementReturn extends Matched {

    private ReturnStatement ReturnStatement;

    public StatementReturn (ReturnStatement ReturnStatement) {
        this.ReturnStatement=ReturnStatement;
        if(ReturnStatement!=null) ReturnStatement.setParent(this);
    }

    public ReturnStatement getReturnStatement() {
        return ReturnStatement;
    }

    public void setReturnStatement(ReturnStatement ReturnStatement) {
        this.ReturnStatement=ReturnStatement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ReturnStatement!=null) ReturnStatement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ReturnStatement!=null) ReturnStatement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ReturnStatement!=null) ReturnStatement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementReturn(\n");

        if(ReturnStatement!=null)
            buffer.append(ReturnStatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementReturn]");
        return buffer.toString();
    }
}