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
	
	// PRINT - READ
	public void visit(StatementPrint printStmt) {
		if (printStmt.getExpr().struct == Tab.intType) {
			Code.loadConst(10);
			Code.put(Code.print);
		}else{
			Code.loadConst(1);
			Code.put(Code.bprint);
		}
	}
	public void visit(StatementPrintWide printStmt) {
		if (printStmt.getExpr().struct == Tab.intType) {
			Code.loadConst(printStmt.getNum());
			Code.put(Code.print);
		}else{
			Code.loadConst(printStmt.getNum());
			Code.put(Code.bprint);
		}
	}
	public void visit(StatementRead readStmt) {
		if (readStmt.getDesignator().obj.getType() == Tab.intType) {
			Code.put(Code.read);
		}else{
			Code.put(Code.bread);
		}
		Code.store(readStmt.getDesignator().obj);
	}
	
	
	// FACTORI
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
		con.setAdr(constant.getVal() ? 1:0);
		
		Code.load(con);
	}
	
	public void visit(FNew fnew) {
		Code.put(Code.newarray);
		if (fnew.struct == Tab.charType) {
			Code.put(0);
		}
		else {
			Code.put(1);
		}
	}
	
	
	// Metodde
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
	
	
	// DESIGNATORI
	public void visit (DesignatorStatementEqual de) {
		Code.store(de.getDesignator().obj);
	}
	
	public void visit(DesignatorIdent designator){
		SyntaxNode parent = designator.getParent();
		
		if(DesignatorStatementEqual.class != parent.getClass() && 
				DesignatorStatementFunc.class != parent.getClass() &&
				StatementFindAny.class != parent.getClass() &&
				designator.obj.getKind() != Obj.Meth){
			Code.load(designator.obj);
		}
	}
	
	public void visit(DesignatorArray designator){
		SyntaxNode parent = designator.getParent();
		
		if(DesignatorStatementEqual.class != parent.getClass() && 
				DesignatorStatementFunc.class != parent.getClass() &&
				StatementFindAny.class != parent.getClass()){
			Code.load(designator.obj);
		}
	}
	
	public void visit(DesignatorStatementInc inc) {
		Code.put(Code.const_1);
		Code.put(Code.add);
		Code.store(inc.getDesignator().obj);
	}
	
	public void visit(DesignatorStatementDec dec) {
		Code.put(Code.const_1);
		Code.put(Code.sub);
		Code.store(dec.getDesignator().obj);
	}
	
	// FUNKCIJE POZIV
	public void visit(DesignatorStatementFunc funcCall){
		Obj functionObj = funcCall.getDesignator().obj;
		int offset = functionObj.getAdr() - Code.pc;
		Code.put(Code.call);
		Code.put2(offset);
		if (!funcCall.getDesignator().obj.getType().equals(Tab.noType)) {
			Code.put(Code.pop);
		}
	}
	
	public void visit(FFunction funcCall){
		Obj functionObj = funcCall.getDesignator().obj;
		int offset = functionObj.getAdr() - Code.pc;
		Code.put(Code.call);
		Code.put2(offset);
	}
	
	public void visit(ReturnVal returnExpr){
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	public void visit(ReturnVoid returnNoExpr){
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	// OPERACIJE
	public void visit(TermFactorList fl) {
		 if(MultiplyOp.class == fl.getMulop().getClass()) {
			 Code.put(Code.mul);
		 } else if (ModuleOp.class == fl.getMulop().getClass()) {
			 Code.put(Code.rem);
		 }
		 else if (DivideOp.class == fl.getMulop().getClass()) {
			 Code.put(Code.div);
		 }
	}
	
	public void visit(Expretion addop) {
		if (addop.getAddOp().getClass() == PlusOp.class) {
			Code.put(Code.add);
		}
		else if(addop.getAddOp().getClass() == MinusOp.class) {
			Code.put(Code.sub);
		}
	}
	
	public void visit (Negative t) {
		Code.put(Code.neg);
	}
	
	public void visit (StatementFindAny findAny) {
		/*
		 i = 0;
		 b = false;
		 while (i < nizlen){
		 	i++;
		 	if (niz[i]==val){
		 		b = true;
		 		break;
		 	}
	 	}
		 return b;
		 */
		// Int i = 0;
		
		Obj niz = findAny.getDesignator1().obj;
		Obj returnbool = findAny.getDesignator().obj;
		Obj boolconst = Tab.insert(Obj.Con, "$", returnbool.getType());
		boolconst.setLevel(0);
		boolconst.setAdr(0);
		Obj val = Tab.insert(Obj.Var, "findany_var_val", findAny.getExpr().struct);
		Code.store(val);
		
		Obj i = Tab.insert(Obj.Var, "findany_var_i", Tab.intType);
		Code.loadConst(0);
		Code.store(i);
		
		// While (i<nizlen)
		int whileBegin = Code.pc;
		Code.load(i);
		Code.load(niz);
		Code.put(Code.arraylength);
		Code.putFalseJump(Code.lt, 0);
		int fixWhile = Code.pc-2;
		
		// i++
		Code.load(i);
		Code.put(Code.const_1);
		Code.put(Code.add);
		Code.store(i);
		
		// if(niz[i] == val)
		Code.load(i);
		Code.load(niz);
		Code.load(val);
		Code.putFalseJump(Code.eq, 0);
		int fixIf = Code.pc - 2;
		// Bool true
		boolconst.setAdr(1);
		Code.loadConst(1);
		Code.loadConst(1);
		// Break;
		Code.putFalseJump(Code.ne, 0);
		int fixBreak = Code.pc - 2;
		//Endif
		Code.fixup(fixIf);
		
		Code.putJump(whileBegin);
		// FIX JUMP ENDWHILE
		Code.fixup(fixWhile);
		Code.fixup(fixBreak);
		
		// BoolReturn = BoolConst;
		Code.load(boolconst);
		Code.store(returnbool);
	}
	

}
