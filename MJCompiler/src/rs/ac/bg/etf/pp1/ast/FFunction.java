// generated with ast extension for cup
// version 0.8
// 13/8/2023 16:54:46


package rs.ac.bg.etf.pp1.ast;

public class FFunction extends Factor {

    private FunctionCallName FunctionCallName;
    private ActParsOne ActParsOne;

    public FFunction (FunctionCallName FunctionCallName, ActParsOne ActParsOne) {
        this.FunctionCallName=FunctionCallName;
        if(FunctionCallName!=null) FunctionCallName.setParent(this);
        this.ActParsOne=ActParsOne;
        if(ActParsOne!=null) ActParsOne.setParent(this);
    }

    public FunctionCallName getFunctionCallName() {
        return FunctionCallName;
    }

    public void setFunctionCallName(FunctionCallName FunctionCallName) {
        this.FunctionCallName=FunctionCallName;
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
        if(FunctionCallName!=null) FunctionCallName.accept(visitor);
        if(ActParsOne!=null) ActParsOne.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FunctionCallName!=null) FunctionCallName.traverseTopDown(visitor);
        if(ActParsOne!=null) ActParsOne.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FunctionCallName!=null) FunctionCallName.traverseBottomUp(visitor);
        if(ActParsOne!=null) ActParsOne.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FFunction(\n");

        if(FunctionCallName!=null)
            buffer.append(FunctionCallName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ActParsOne!=null)
            buffer.append(ActParsOne.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FFunction]");
        return buffer.toString();
    }
}
