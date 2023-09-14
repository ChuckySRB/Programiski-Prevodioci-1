// generated with ast extension for cup
// version 0.8
// 14/8/2023 19:26:9


package rs.ac.bg.etf.pp1.ast;

public class VariableDeclaration extends VarDeclaration {

    private Type Type;
    private VarName VarName;
    private VarNameList VarNameList;

    public VariableDeclaration (Type Type, VarName VarName, VarNameList VarNameList) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.VarName=VarName;
        if(VarName!=null) VarName.setParent(this);
        this.VarNameList=VarNameList;
        if(VarNameList!=null) VarNameList.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public VarName getVarName() {
        return VarName;
    }

    public void setVarName(VarName VarName) {
        this.VarName=VarName;
    }

    public VarNameList getVarNameList() {
        return VarNameList;
    }

    public void setVarNameList(VarNameList VarNameList) {
        this.VarNameList=VarNameList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(VarName!=null) VarName.accept(visitor);
        if(VarNameList!=null) VarNameList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(VarName!=null) VarName.traverseTopDown(visitor);
        if(VarNameList!=null) VarNameList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(VarName!=null) VarName.traverseBottomUp(visitor);
        if(VarNameList!=null) VarNameList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VariableDeclaration(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarName!=null)
            buffer.append(VarName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarNameList!=null)
            buffer.append(VarNameList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VariableDeclaration]");
        return buffer.toString();
    }
}
