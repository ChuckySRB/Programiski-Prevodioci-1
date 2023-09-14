package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class SemanticPass extends VisitorAdaptor {
	
	int printCallCount = 0;
	int varDeclCount = 0;
	int constDeclCount = 0;
	Obj currentMethod = null;
	String currentVarName = null;
	Struct currentType = null;
	boolean returnFound = false;
	boolean errorDetected = false;
	
	
	int nVars;
	
	Logger log = Logger.getLogger(getClass());
	
	// CONSTRUCTOR
	public SemanticPass() {
		Tab.currentScope.addToLocals(new Obj(Obj.Type, "bool", TabBool.boolType));
	}
	
	// MESSAGES
	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.info(msg.toString());
	}
	
	// PROGRAM
    public void visit(ProgName progName){
    	progName.obj = Tab.insert(Obj.Prog, progName.getProgName(), Tab.noType);
    	Tab.openScope();
    }
    
    public void visit(Program program){
    	nVars = Tab.currentScope.getnVars();
    	Tab.chainLocalSymbols(program.getProgName().obj);
    	Tab.closeScope();
    }
    
    
    // GLOBALNA KONSTANTA
	public void visit(ConstantVariable con){
		String name =  con.getConstName();
		if(Tab.currentScope.findSymbol(name) != null)
	  		report_error("Vec postoji konstanta sa imenom " + name, con);
		else {
			report_info("Deklarisana konstante "+ name, con);
			Obj varNode = Tab.insert(Obj.Con, name, currentType);
			Obj o = con.getConstExpr().obj;
			varNode.setAdr(o.getAdr());
			if(o.getType() != currentType)
	  			report_error("Pogresan tip konstante! " + currentType + " " + o.getType(), con);
			else
				constDeclCount++;
		}
	}
	
	public void visit(CharConst c){
		c.obj = new Obj(Obj.Con, "", Tab.charType);
		c.obj.setAdr(c.getVal());
	}
	
	public void visit(IntConst c){
		c.obj = new Obj(Obj.Con, "", Tab.intType);
		c.obj.setAdr((int)c.getVal());
	}
	public void visit(BoolConst c){
		c.obj = new Obj(Obj.Con, "", TabBool.boolType);
		c.obj.setAdr(c.getVal()=="true" ? 1:0);
	}
	
	// GLOBALNE VARIABLE
	public void visit(VarSingle var) {
		String name =  var.getVarName();
		if(Tab.currentScope.findSymbol(name) != null)
	  		report_error("Vec postoji promenljiva sa imenom " + name, var);
		else {
			varDeclCount++;
			report_info("Deklarisana promenljiva "+ name, var);
			Tab.insert(Obj.Var, name, currentType);
		}
	}
	
	public void visit(VarArray var) {
		String name =  var.getArrayName();
		if(Tab.currentScope.findSymbol(name) != null)
	  		report_error("Vec postoji promenljiva sa imenom " + name, var);
		else {
			varDeclCount++;
			report_info("Deklarisana promenljiva "+ name + "[]", var);
			Tab.insert(Obj.Var, name, new Struct(Struct.Array, currentType));
		}
	}
	
	// FAKTORI
	public void visit(FBoolConst c) {
		c.struct = TabBool.boolType;
	}
	public void visit(FCharConst c) {
		c.struct = Tab.charType;
	}
	public void visit(FIntConst c) {
		c.struct = Tab.intType;
	}
	public void visit(FDesignator d) {
		d.struct = d.getDesignator().obj.getType();
	}
	public void visit(FExpretion e) {
		e.struct = e.getExpr().struct;
	}
	public void visit(FNew fNew) {
		String tip = fNew.getType().getTypeName();
		if (fNew.getExpr().struct != Tab.intType) {
			report_error("Greska na liniji " + fNew.getLine() + ": Izraz u new mora biti INT!", null);
		}
		else if(Tab.find(tip) == Tab.noObj) {
			fNew.struct = new Struct(Struct.Array, Tab.noType);
			report_error("Greska na liniji " + fNew.getLine() +": Tip " + tip + "nije definisan!", null);
		} else {
			fNew.struct = new Struct(Struct.Array, Tab.find(tip).getType());
		}
	}
	
	
	// PRINT - READ
    public void visit(StatementPrint printst) {
    	if(printst.getExpr().struct != Tab.intType && 
    			printst.getExpr().struct!= Tab.charType &&
    			printst.getExpr().struct!= TabBool.boolType) 
    		report_error ("Semanticka greska na liniji " + printst.getLine() + ": Operand instrukcije PRINT mora biti char ili int ili bool tipa", null );
		printCallCount++;
	}
    public void visit(StatementPrintWide printst) {
    	if(printst.getExpr().struct != Tab.intType && 
    			printst.getExpr().struct!= Tab.charType &&
    			printst.getExpr().struct!= TabBool.boolType) 
    		report_error ("Semanticka greska na liniji " + printst.getLine() + ": Operand instrukcije PRINT mora biti char ili int ili bool tipa", null );
		printCallCount++;
	}
    
    public void visit(StatementRead readst) {
		if(readst.getDesignator().obj.getKind() != Obj.Var &&
						readst.getDesignator().obj.getKind() != Obj.Elem) {
			report_error("Greska na liniji " + readst.getLine() + 
					": Argument instrukcije READ mora biti promenljiva ili element niza", null);
		} else {
			if(readst.getDesignator().obj.getType() != Tab.intType &&
				readst.getDesignator().obj.getType() != Tab.charType &&
					readst.getDesignator().obj.getType() != TabBool.boolType) {
				report_error("Greska na liniji " + readst.getLine() + 
						": Argument instrukcije READ mora biti primitivnog tipa", null);
			}
		}
	}
    

    // TIP
    public void visit(Type type){
    	if (type.getTypeName().compareTo("bool")==0) {
			type.struct = TabBool.boolType;
			currentType = TabBool.boolType;
		}
    	else if (type.getTypeName().compareTo("void")==0) {
			type.struct = Tab.noType;
			currentType = Tab.noType;
		}
    	else {
	    	Obj typeNode = Tab.find(type.getTypeName());
	    	if(typeNode == Tab.noObj){
	    		report_error("Nije pronadjen tip " + type.getTypeName() + " u tabeli simbola! ", null);
	    		type.struct = Tab.noType;
	    		currentType = Tab.noType;
	    	}else{
	    		if(Obj.Type == typeNode.getKind()){
	    			type.struct = typeNode.getType();
	    			currentType = typeNode.getType();
	    		}else{
	    			report_error("Greska: Ime " + type.getTypeName() + " ne predstavlja tip!", type);
	    			type.struct = Tab.noType;
	    			currentType = Tab.noType;
	    		}
	    	}
	    }
    }
    
    
    /// METODE
    public void visit(MethodTypeName methodTypeName){
    	currentMethod = Tab.insert(Obj.Meth, methodTypeName.getMethName(), methodTypeName.getType().struct);
    	methodTypeName.obj = currentMethod;
    	Tab.openScope();
		report_info("Obradjuje se funkcija " + methodTypeName.getMethName(), methodTypeName);
    }
    
    public void visit(MethodDeclaration methodDecl){
    	if(!returnFound && currentMethod.getType() != Tab.noType){
			report_error("Semanticka greska na liniji " + methodDecl.getLine() + ": funkcija " + currentMethod.getName() + " nema return iskaz!", null);
    	}
    	Tab.chainLocalSymbols(currentMethod);
    	Tab.closeScope();
    	
    	returnFound = false;
    	currentMethod = null;
    }
    
    // DESIGNATORI
    public void visit(DesignatorIdent designator){
    	Obj obj = Tab.find(designator.getName());
    	if(obj == Tab.noObj){
			report_error("Greska na liniji " + designator.getLine()+ " : ime "+designator.obj.getName()+" nije deklarisano! ", null);
    	}
    	designator.obj = obj;
    }
    
    public void visit(DesignatorArray designator){
    	Obj obj = new Obj(Obj.Elem, "", designator.getDesignator().obj.getType().getElemType());
    	if(obj == Tab.noObj){
			report_error("Greska na liniji " + designator.getLine()+ " : ime "+designator.obj.getName()+" nije deklarisano! ", null);
    	}
    	designator.obj = obj;
    }
    
    
    
    // FUNKCIJE
    
  
    
    // TERM
    public void visit(TermFactor term){
    	term.struct = term.getFactor().struct;
    }
    public void visit(TermFactorList term) {
    	term.struct = term.getFactor().struct;
    }
    
    
    // EXPRETION
    public void visit(Expretion expr) {
    	expr.struct = expr.getTerm().struct;
    }
    
    public void visit(Negative expr) {
    	expr.struct = expr.getTerm().struct;
    }
    public void visit(Positive expr) {
    	expr.struct = expr.getTerm().struct;
    }

    /*
    public void visit(AddExpr addExpr){
    	Struct te = addExpr.getExpr().struct;
    	Struct t = addExpr.getTerm().struct;
    	if(te.equals(t) && te == Tab.intType){
    		addExpr.struct = te;
    	}else{
			report_error("Greska na liniji "+ addExpr.getLine()+" : nekompatibilni tipovi u izrazu za sabiranje.", null);
			addExpr.struct = Tab.noType;
    	}
    }*/
    
   
    public void visit(ReturnVal returnExpr){
    	returnFound = true;
    	Struct currMethType = currentMethod.getType();
    	/* if(!currMethType.compatibleWith(returnExpr.getExpr().struct)){
			report_error("Greska na liniji " + returnExpr.getLine() + " : " + "tip izraza u return naredbi ne slaze se sa tipom povratne vrednosti funkcije " + currentMethod.getName(), null);
    	}*/
    }

    
    public boolean passed(){
    	return !errorDetected;
    }
}
