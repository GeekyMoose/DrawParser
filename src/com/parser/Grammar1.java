/* 
 * Creation : May 8, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.parser;

import com.exceptions.AppError;
import com.exceptions.ParserException;


/**
 * <h1>Grammar1</h1>
 * <p>
 * class Grammar1<br/>
 * extends Grammar
 * </p>
 * 
 * @date    May 8, 2015
 * @author  Constantin MASSON
 */
public class Grammar1 extends Grammar{
    //**************************************************************************
    // Functions from Grammar
    //**************************************************************************
    @Override
    public AbstractSyntax processGeneralMode(LookAhead1 pLook) throws AppError, ParserException{
        AbstractSyntax abs  = super.processGeneralMode(pLook);
        if(this.reader.check(Sym.PROG)){
            this.reader.eat(Sym.PROG);
            this.reader.eat(Sym.L_CB);
            this.program(abs);
            this.reader.eat(Sym.R_CB);
            reader.eat(Sym.EOF);
        } 
        else{
            reader.eat(Sym.EOF);
        }
        return abs;
    }

    @Override
    public AbstractSyntax processInterpreterMode(LookAhead1 pLook) throws AppError, ParserException{
        AbstractSyntax abs  = super.processGeneralMode(pLook);
        this.program(abs);
        return abs;
    }
    
    @Override
    public String toString(){
        return null;
    }
    
	
    //**************************************************************************
    // Not term functions
    //**************************************************************************
    /**
     * Process a program
     * @param abs AbstractSyntax where to add elements
     * @throws AppError         thrown if critical error
     * @throws ParserException  thrown if not valid expression (Text not valid)
     */
    private void program(AbstractSyntax abs) throws AppError, ParserException{
        if(!this.reader.check(Sym.R_CB)){
            this.declarations(abs);
            this.blockInstructions(abs);
        }
    }
    
    /**
     * Check if there is a variable declaration. If variable, add in current 
     * AbstractSyntax and call itself again (Recursively while variable present)
     * @param abs AbstractSyntax where to add elements
     * @throws AppError         thrown if critical error
     * @throws ParserException  thrown if not valid expression (Text not valid)
     */
    private void declarations(AbstractSyntax abs) throws AppError, ParserException{
        if(this.reader.check(Sym.VAR_CREA)){
            this.reader.eat(Sym.VAR_CREA);
            abs.addInstruction(new Declaration(this.reader.getStrValue()));
            this.reader.eat(Sym.VAR_NAME);
            this.reader.eat(Sym.CONCAT);
            this.declarations(abs);
        }
    }
    
    /**
     * Block of instruction. All instruction are added in AbstractSyntax given 
     * in parameter
     * @param abs AbstractSyntax where to ad instruction
     * @throws AppError         thrown if critical error
     * @throws ParserException  thrown if not valid expression (Text not valid)
     */
    private void blockInstructions(AbstractSyntax abs) throws AppError, ParserException{
        if(this.checkNextIsInstruction()){
            this.instructions(abs);
            this.blockInstructions(abs);
        }
    }
    
    /**
     * Check if next Token is an instruction. If is instruction, create it and 
     * return the new instruction created
     * @param abs AbstractSyntax where to add elements
     * @throws AppError
     * @throws ParserException 
     */
    private void instructions(AbstractSyntax abs) throws AppError, ParserException{
        if(this.reader.check(Sym.MOVE)){
            this.reader.eat(Sym.MOVE);
            Expression e = this.expressions();
            this.reader.eat(Sym.CONCAT);
            abs.addInstruction(new Move(e));
        } 
        else if(this.reader.check(Sym.ROTATE)){
            this.reader.eat(Sym.ROTATE);
            Expression e = this.expressions();
            this.reader.eat(Sym.CONCAT);
            abs.addInstruction(new Rotate(e));
        } 
        else if(this.reader.check(Sym.UP)){
            this.reader.eat(Sym.UP);
            this.reader.eat(Sym.CONCAT);
            abs.addInstruction(new Up());
        } 
        else if(this.reader.check(Sym.DOWN)){
            this.reader.eat(Sym.DOWN);
            this.reader.eat(Sym.CONCAT);
            abs.addInstruction(new Down());
        } 
        else if(this.reader.check(Sym.VAR_NAME)){
            String varName = this.reader.getStrValue();
            this.reader.eat(Sym.VAR_NAME);
            this.reader.eat(Sym.ASSIGN);
            Expression e = this.expressions();
            this.reader.eat(Sym.CONCAT);
            abs.addInstruction(new Assignment(varName, e));
        } 
        else if(this.reader.check(Sym.IF)){
            this.ifInstruction(abs);
        } 
        else if(this.reader.check(Sym.WHILE)){
            this.whileLoop(abs);
        } 
        else if(this.reader.check(Sym.FOR)){
            this.forLoop(abs);
        } 
        else{
            throw new ParserException("Instruction", this.reader.getCurrentToken());
        }
    }
    
    private void ifInstruction(AbstractSyntax abs) throws AppError, ParserException{
        AbstractSyntax ifAbs = new AbstractSyntax();
        //If
        this.reader.eat(Sym.IF);
        this.reader.eat(Sym.L_PAR);
        Expression e1 = this.expressions();
        this.reader.eat(Sym.EQ);
        Expression e2 = this.expressions();
        this.reader.eat(Sym.R_PAR);
        this.reader.eat(Sym.L_CB);
        this.blockInstructions(ifAbs);
        this.reader.eat(Sym.R_CB);
        IfInstruction ifInst = new IfInstruction(e1, e2, ifAbs);
        
        //Else if
        while (this.reader.check(Sym.ELIF)){
            AbstractSyntax elifAbs = new AbstractSyntax();
            this.reader.eat(Sym.ELIF);
            this.reader.eat(Sym.L_PAR);
            Expression e3 = this.expressions();
            this.reader.eat(Sym.EQ);
            Expression e4 = this.expressions();
            this.reader.eat(Sym.R_PAR);
            this.reader.eat(Sym.L_CB);
            this.blockInstructions(elifAbs);
            this.reader.eat(Sym.R_CB);
            ElifInstruction elseifInst = new ElifInstruction(e3, e4, elifAbs);
            ifInst.addElifInstruction(elseifInst);
        }
        
        //Else
        if(this.reader.check(Sym.ELSE)){
            AbstractSyntax elseAbs = new AbstractSyntax();
            this.reader.eat(Sym.ELSE);
            this.reader.eat(Sym.L_CB);
            this.blockInstructions(elseAbs);
            this.reader.eat(Sym.R_CB);
            ElseInstruction elseInst = new ElseInstruction(elseAbs);
            ifInst.addElseInstruction(elseInst);
        }
        abs.addInstruction(ifInst);
    }
    
    private void whileLoop(AbstractSyntax abs) throws AppError, ParserException{
        AbstractSyntax whileAbs = new AbstractSyntax();
        this.reader.eat(Sym.WHILE);
        this.reader.eat(Sym.L_PAR);
        Expression e1 = this.expressions();
        this.reader.eat(Sym.EQ);
        Expression e2 = this.expressions();
        this.reader.eat(Sym.R_PAR);
        this.reader.eat(Sym.L_CB);
        this.blockInstructions(whileAbs);
        this.reader.eat(Sym.R_CB);
        WhileInstruction whileInst = new WhileInstruction(e1, e2, whileAbs);
        abs.addInstruction(whileInst);
    }
    
    private void forLoop(AbstractSyntax abs) throws AppError, ParserException{
        AbstractSyntax forAbs = new AbstractSyntax();
        this.reader.eat(Sym.FOR);
        this.reader.eat(Sym.L_PAR);
        Expression e = this.expressions();
        this.reader.eat(Sym.R_PAR);
        this.reader.eat(Sym.L_CB);
        this.blockInstructions(forAbs);
        this.reader.eat(Sym.R_CB);
        ForInstruction forInst = new ForInstruction(e, forAbs);
        abs.addInstruction(forInst);
    }
    
    /**
     * Process a not term expression and return this expression
     * @return Expression
     * @throws AppError         thrown if critical error
     * @throws ParserException  thrown if not valid expression (Text not valid)
     */
    private Expression expressions() throws AppError, ParserException{
        if(this.reader.check(Sym.NUMBER_INT)){
            Expression e = new IntExp(this.reader.getIntValue());
            this.reader.eat(Sym.NUMBER_INT);
            return this.expressionFollow(e);
        } 
        else if(this.reader.check(Sym.VAR_NAME)){
            Expression e = new Var(this.reader.getStrValue());
            this.reader.eat(Sym.VAR_NAME);
            return this.expressionFollow(e);
        }
        else if(this.reader.check(Sym.L_PAR)){
            this.reader.eat(Sym.L_PAR);
            Expression e = this.expressions();
            this.reader.eat(Sym.R_PAR);
            return this.expressionFollow(e);
        } 
        else {
            throw new ParserException("Expression", this.reader.getCurrentToken());
        }
    }
    
    private Expression expressionFollow(Expression pExpBefore) throws AppError, ParserException{
        if(this.checkNextIsOperator()){
            Expression e2 = this.operator(pExpBefore);
            return this.expressionFollow(e2);
        } else {
            return pExpBefore;
        }
    }
    
    /**
     * Process an expression with an operator. Means expression as operator 
     * + or - or * or /
     * @param pExpBefore expression to process with operator and next expression
     * @return Expression new expression
     * @throws AppError         thrown if critical error
     * @throws ParserException  thrown if not valid expression (Text not valid)
     */
    private Expression operator(Expression pExpBefore) throws AppError, ParserException{
        if(this.reader.check(Sym.PLUS)){
            this.reader.eat(Sym.PLUS);
            return new Sum(pExpBefore, this.expressions());
        }
        else if(this.reader.check(Sym.LESS)){
            this.reader.eat(Sym.LESS);
            return new Difference(pExpBefore, this.expressions());
        } 
        else if(this.reader.check(Sym.MULTIPLY)){
            this.reader.eat(Sym.MULTIPLY);
            return new Product(pExpBefore, this.expressions());
        } 
        else if (this.reader.check(Sym.DIV)){
            this.reader.eat(Sym.DIV);
            return new Division(pExpBefore, this.expressions());
        } 
        else{
            throw new ParserException("Operator", this.reader.getCurrentToken());
        }
    }
    
    
    //**************************************************************************
    // Term functions
    //**************************************************************************
    /**
     * Check if c is a term
     * @param c char to process
     * @throws AppError thrown if critical program error 
     * @throws ParserException thrown if current token is unexpected
     */
    private void term (Sym c) throws AppError, ParserException{
        this.reader.eat(c);
    }
    
    /**
     * Check if next Token is an instruction
     * @return true if is instruction, otherwise, return false
     */
    private boolean checkNextIsInstruction(){
        if(this.reader.check(Sym.MOVE) ||
           this.reader.check(Sym.ROTATE) ||
           this.reader.check(Sym.UP) ||
           this.reader.check(Sym.DOWN) ||
           this.reader.check(Sym.VAR_NAME) ||
           this.reader.check(Sym.IF) ||
           this.reader.check(Sym.WHILE) ||
           this.reader.check(Sym.FOR))
        {
            return true;
        }
        return false;
    }
    
    /**
     * Check if next Token is an operator
     * @return true if an operator, otherwise, return false
     */
    private boolean checkNextIsOperator(){
        if(this.reader.check(Sym.PLUS) ||
           this.reader.check(Sym.LESS) ||
           this.reader.check(Sym.MULTIPLY) ||
           this.reader.check(Sym.DIV))
        {
            return true;
        }
        return false;
    }
}