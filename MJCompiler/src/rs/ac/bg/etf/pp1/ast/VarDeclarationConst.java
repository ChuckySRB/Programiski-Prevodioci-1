// generated with ast extension for cup
// version 0.8
// 15/8/2023 3:23:48


package rs.ac.bg.etf.pp1.ast;

public class VarDeclarationConst extends VarDecl {

    private VarConstDecl VarConstDecl;

    public VarDeclarationConst (VarConstDecl VarConstDecl) {
        this.VarConstDecl=VarConstDecl;
        if(VarConstDecl!=null) VarConstDecl.setParent(this);
    }

    public VarConstDecl getVarConstDecl() {
        return VarConstDecl;
    }

    public void setVarConstDecl(VarConstDecl VarConstDecl) {
        this.VarConstDecl=VarConstDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarConstDecl!=null) VarConstDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarConstDecl!=null) VarConstDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarConstDecl!=null) VarConstDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclarationConst(\n");

        if(VarConstDecl!=null)
            buffer.append(VarConstDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclarationConst]");
        return buffer.toString();
    }
}
