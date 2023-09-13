package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.Designator;
import rs.ac.bg.etf.pp1.ast.MethodDecl;
import rs.ac.bg.etf.pp1.ast.MethodTypeName;
import rs.ac.bg.etf.pp1.ast.SyntaxNode;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.ac.bg.etf.pp1.ast.*;
import rs.ac.bg.etf.pp1.CounterVisitor.FormParamCounter;
import rs.ac.bg.etf.pp1.CounterVisitor.VarCounter;

public class CodeGenerator extends VisitorAdaptor {

	private int mainPc;
	
	public int getMainPc(){
		return mainPc;
	}
	
	public void visit(StatementPrint printStmt) {
		if (printStmt.getExpr().struct == Tab.intType) {
			Code.loadConst(10);
			Code.put(Code.print);
		}else{
			Code.loadConst(1);
			Code.put(Code.bprint);
		}
	}
	
	public void visit(FIntConst constant) {
		Obj con = Tab.insert(Obj.Con, "$", constant.struct);
		con.setLevel(0);
		con.setAdr(constant.getVal());
		
		Code.load(con);
	}
	
	public void visit(FCharConst constant) {
		Obj con = Tab.insert(Obj.Con, "$", constant.struct);
		con.setLevel(0);
		con.setAdr(constant.getVal());
		
		Code.load(con);
	}
	
	public void visit(FBoolConst constant) {
		Obj con = Tab.insert(Obj.Con, "$", constant.struct);
		con.setLevel(0);
		con.setAdr(constant.getVal()=="true" ? 1:0);
		
		Code.load(con);
	}
	
	public void visit(MethodTypeName methodTypeName) {
		if ("main".equalsIgnoreCase(methodTypeName.getMethName())) {
			mainPc = Code.pc;
		}
		methodTypeName.obj.setAdr(Code.pc);
		
		SyntaxNode methodNode = methodTypeName.getParent();
		
		VarCounter varCnt = new VarCounter();
		methodNode.traverseTopDown(varCnt);
		
		FormParamCounter fpCnt = new FormParamCounter();
		methodNode.traverseTopDown(fpCnt);
		
		// Generate the entry
		Code.put(Code.enter);
		Code.put(fpCnt.getCount());
		Code.put(fpCnt.getCount() + varCnt.getCount());
	}
	
	public void visit(MethodDeclaration methodDecl) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	
}
