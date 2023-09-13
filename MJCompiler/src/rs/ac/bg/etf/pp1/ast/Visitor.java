// generated with ast extension for cup
// version 0.8
// 13/8/2023 16:54:46


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(Unmatched Unmatched);
    public void visit(DesignatorOne DesignatorOne);
    public void visit(NumberList NumberList);
    public void visit(Mulop Mulop);
    public void visit(MethodDecl MethodDecl);
    public void visit(VarDeclaration VarDeclaration);
    public void visit(Matched Matched);
    public void visit(Relop Relop);
    public void visit(ConstVarNameList ConstVarNameList);
    public void visit(CondTermList CondTermList);
    public void visit(MinusOne MinusOne);
    public void visit(VarName VarName);
    public void visit(StatementList StatementList);
    public void visit(FactorList FactorList);
    public void visit(ConstVariable ConstVariable);
    public void visit(Factor Factor);
    public void visit(CondTerm CondTerm);
    public void visit(CondFactList CondFactList);
    public void visit(Designator Designator);
    public void visit(VarNameList VarNameList);
    public void visit(ExprList ExprList);
    public void visit(ReturnStatement ReturnStatement);
    public void visit(VarDeclList VarDeclList);
    public void visit(FormalParamList FormalParamList);
    public void visit(Expr Expr);
    public void visit(AddOp AddOp);
    public void visit(DesignatorList DesignatorList);
    public void visit(DesignatorStatement DesignatorStatement);
    public void visit(ConstExpr ConstExpr);
    public void visit(Statement Statement);
    public void visit(VarDecl VarDecl);
    public void visit(CondFact CondFact);
    public void visit(MethodDeclList MethodDeclList);
    public void visit(ActParsOne ActParsOne);
    public void visit(FormPars FormPars);
    public void visit(TypeMain TypeMain);
    public void visit(AddopTermList AddopTermList);
    public void visit(Type Type);
    public void visit(NotEqualOp NotEqualOp);
    public void visit(EqualOp EqualOp);
    public void visit(GreaterEqOp GreaterEqOp);
    public void visit(GreaterOp GreaterOp);
    public void visit(LessEqOp LessEqOp);
    public void visit(LessOp LessOp);
    public void visit(ModuleOp ModuleOp);
    public void visit(DivideOp DivideOp);
    public void visit(MultiplyOp MultiplyOp);
    public void visit(MinusOp MinusOp);
    public void visit(PlusOp PlusOp);
    public void visit(AddopTermNone AddopTermNone);
    public void visit(AddopTerms AddopTerms);
    public void visit(FFunction FFunction);
    public void visit(FDesignator FDesignator);
    public void visit(FNew FNew);
    public void visit(FExpretion FExpretion);
    public void visit(FBoolConst FBoolConst);
    public void visit(FCharConst FCharConst);
    public void visit(FIntConst FIntConst);
    public void visit(FactorListNone FactorListNone);
    public void visit(FactorListMulop FactorListMulop);
    public void visit(Term Term);
    public void visit(Positive Positive);
    public void visit(Negative Negative);
    public void visit(ExpresionListNone ExpresionListNone);
    public void visit(ExpretionList ExpretionList);
    public void visit(Expretion Expretion);
    public void visit(ConditionFactNot ConditionFactNot);
    public void visit(ConditionFactRel ConditionFactRel);
    public void visit(ConditionFact ConditionFact);
    public void visit(CondFactNone CondFactNone);
    public void visit(ConditionFactList ConditionFactList);
    public void visit(ConditionTerm ConditionTerm);
    public void visit(CondTermNone CondTermNone);
    public void visit(ConditionTermList ConditionTermList);
    public void visit(Condition Condition);
    public void visit(NoNumber NoNumber);
    public void visit(NumberListList NumberListList);
    public void visit(ActPars ActPars);
    public void visit(ActParsNone ActParsNone);
    public void visit(ActParsOneOne ActParsOneOne);
    public void visit(ReturnVal ReturnVal);
    public void visit(ReturnVoid ReturnVoid);
    public void visit(ErrorStmt ErrorStmt);
    public void visit(StatementVarDecl StatementVarDecl);
    public void visit(Statements Statements);
    public void visit(StatementForeach StatementForeach);
    public void visit(StatementReturn StatementReturn);
    public void visit(StatementContinue StatementContinue);
    public void visit(StatementBreak StatementBreak);
    public void visit(StatementWhile StatementWhile);
    public void visit(StatementPrint StatementPrint);
    public void visit(StatementRead StatementRead);
    public void visit(StatementDesignator StatementDesignator);
    public void visit(IfMatched IfMatched);
    public void visit(WhileUnmatched WhileUnmatched);
    public void visit(IfStatement IfStatement);
    public void visit(IfElseUnmatched IfElseUnmatched);
    public void visit(StatementUnmatched StatementUnmatched);
    public void visit(StatementMatched StatementMatched);
    public void visit(DesignatorArray DesignatorArray);
    public void visit(DesignatorIdent DesignatorIdent);
    public void visit(DesignatorListNone DesignatorListNone);
    public void visit(DesignatorListList DesignatorListList);
    public void visit(DesignatorNone DesignatorNone);
    public void visit(DesignatorOneOne DesignatorOneOne);
    public void visit(DesignatorStatementFunc DesignatorStatementFunc);
    public void visit(DesignatorStatementDec DesignatorStatementDec);
    public void visit(DesignatorStatementInc DesignatorStatementInc);
    public void visit(DesignatorStatementBrackets DesignatorStatementBrackets);
    public void visit(DesignatorStatementEqual DesignatorStatementEqual);
    public void visit(FunctionCallName FunctionCallName);
    public void visit(NoStmt NoStmt);
    public void visit(StmtList StmtList);
    public void visit(FormalParamDecl FormalParamDecl);
    public void visit(SingleFormalParamDecl SingleFormalParamDecl);
    public void visit(FormalParamDecls FormalParamDecls);
    public void visit(NoFormParam NoFormParam);
    public void visit(FormParams FormParams);
    public void visit(MethodTypeName MethodTypeName);
    public void visit(MethodDeclaration MethodDeclaration);
    public void visit(MethodDeclarationNone MethodDeclarationNone);
    public void visit(MethodDeclarations MethodDeclarations);
    public void visit(VarArray VarArray);
    public void visit(VarSingle VarSingle);
    public void visit(IntConst IntConst);
    public void visit(BoolConst BoolConst);
    public void visit(CharConst CharConst);
    public void visit(ConstantVariable ConstantVariable);
    public void visit(ConstVarNone ConstVarNone);
    public void visit(ConstVarName ConstVarName);
    public void visit(VarConstDecl VarConstDecl);
    public void visit(VariableNameNone VariableNameNone);
    public void visit(VariableNameList VariableNameList);
    public void visit(VariableDeclaration VariableDeclaration);
    public void visit(VarDeclar VarDeclar);
    public void visit(VarDeclarationConst VarDeclarationConst);
    public void visit(NoVarDecl NoVarDecl);
    public void visit(VarDeclarations VarDeclarations);
    public void visit(ProgName ProgName);
    public void visit(Program Program);

}
