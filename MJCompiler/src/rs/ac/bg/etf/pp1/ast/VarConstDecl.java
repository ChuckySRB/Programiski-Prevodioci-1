// generated with ast extension for cup
// version 0.8
// 14/8/2023 19:26:9


package rs.ac.bg.etf.pp1.ast;

public class VarConstDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Type Type;
    private ConstVariable ConstVariable;
    private ConstVarNameList ConstVarNameList;

    public VarConstDecl (Type Type, ConstVariable ConstVariable, ConstVarNameList ConstVarNameList) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.ConstVariable=ConstVariable;
        if(ConstVariable!=null) ConstVariable.setParent(this);
        this.ConstVarNameList=ConstVarNameList;
        if(ConstVarNameList!=null) ConstVarNameList.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public ConstVariable getConstVariable() {
        return ConstVariable;
    }

    public void setConstVariable(ConstVariable ConstVariable) {
        this.ConstVariable=ConstVariable;
    }

    public ConstVarNameList getConstVarNameList() {
        return ConstVarNameList;
    }

    public void setConstVarNameList(ConstVarNameList ConstVarNameList) {
        this.ConstVarNameList=ConstVarNameList;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(ConstVariable!=null) ConstVariable.accept(visitor);
        if(ConstVarNameList!=null) ConstVarNameList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(ConstVariable!=null) ConstVariable.traverseTopDown(visitor);
        if(ConstVarNameList!=null) ConstVarNameList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(ConstVariable!=null) ConstVariable.traverseBottomUp(visitor);
        if(ConstVarNameList!=null) ConstVarNameList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarConstDecl(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstVariable!=null)
            buffer.append(ConstVariable.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstVarNameList!=null)
            buffer.append(ConstVarNameList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarConstDecl]");
        return buffer.toString();
    }
}
