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
    public void processGeneralMode(LookAhead1 pLook) throws AppError, ParserException{
        super.processGeneralMode(pLook);
        if(this.reader.check(Sym.PROG)){
            this.reader.eat(Sym.PROG);
            this.reader.eat(Sym.L_CB);
            this.program();
            this.reader.eat(Sym.R_CB);
            reader.eat(Sym.EOF);
        } else{
            reader.eat(Sym.EOF);
        }
    }

    @Override
    public void processInterpreterMode(LookAhead1 pLook) throws AppError, ParserException{
        super.processInterpreterMode(pLook);
        this.program();
    }
    @Override
    public String toString(){
        return null;
    }
    
	
    //**************************************************************************
    // Not term functions
    //**************************************************************************
    private void program() throws AppError, ParserException{
        if(!this.reader.check(Sym.R_CB)){
            this.declarations();
            this.blockInstructions();
        }
    }
    
    private void declarations() throws AppError, ParserException{
        if(this.reader.check(Sym.VAR_CREA)){
            this.reader.eat(Sym.VAR_CREA);
            this.reader.eat(Sym.VAR_NAME);
            this.reader.eat(Sym.CONCAT);
            this.declarations();
        }
    }
    
    private void blockInstructions() throws AppError, ParserException{
        if(this.checkNextIsInstruction()){
            this.instructions();
            this.blockInstructions();
        }
    }
    
    private void instructions() throws AppError, ParserException{
        if(this.reader.check(Sym.MOVE)){
            this.reader.eat(Sym.MOVE);
            this.expressions();
            this.reader.eat(Sym.CONCAT);
        } 
        else if(this.reader.check(Sym.ROTATE)){
            this.reader.eat(Sym.ROTATE);
            this.expressions();
            this.reader.eat(Sym.CONCAT);
        } 
        else if(this.reader.check(Sym.UP)){
            this.reader.eat(Sym.UP);
            this.reader.eat(Sym.CONCAT);
        } 
        else if(this.reader.check(Sym.DOWN)){
            this.reader.eat(Sym.DOWN);
            this.reader.eat(Sym.CONCAT);
        } 
        else if(this.reader.check(Sym.VAR_NAME)){
            this.reader.eat(Sym.VAR_NAME);
            this.reader.eat(Sym.ASSIGN);
            this.expressions();
            this.reader.eat(Sym.CONCAT);
        } 
        else if(this.reader.check(Sym.IF)){
            this.ifInstruction();
        } 
        else if(this.reader.check(Sym.WHILE)){
            this.whileLoop();
        } 
        else if(this.reader.check(Sym.FOR)){
            this.forLoop();
        } 
        else{
            throw new ParserException("Instruction", this.reader.getCurrentToken());
        }
    }
    
    private void ifInstruction() throws AppError, ParserException{
        this.reader.eat(Sym.IF);
        this.reader.eat(Sym.L_PAR);
        this.expressions();
        this.reader.eat(Sym.EQ);
        this.expressions();
        this.reader.eat(Sym.R_PAR);
        this.reader.eat(Sym.L_CB);
        this.blockInstructions();
        this.reader.eat(Sym.R_CB);
        while (this.reader.check(Sym.ELIF)){
            this.reader.eat(Sym.ELIF);
            this.reader.eat(Sym.L_PAR);
            this.expressions();
            this.reader.eat(Sym.EQ);
            this.expressions();
            this.reader.eat(Sym.R_PAR);
            this.reader.eat(Sym.L_CB);
            this.blockInstructions();
            this.reader.eat(Sym.R_CB);
        }
        if(this.reader.check(Sym.ELSE)){
            this.reader.eat(Sym.ELSE);
            this.reader.eat(Sym.L_CB);
            this.blockInstructions();
            this.reader.eat(Sym.R_CB);
        }
    }
    
    private void whileLoop() throws AppError, ParserException{
        this.reader.eat(Sym.WHILE);
        this.reader.eat(Sym.L_PAR);
        this.expressions();
        this.reader.eat(Sym.EQ);
        this.expressions();
        this.reader.eat(Sym.R_PAR);
        this.reader.eat(Sym.L_CB);
        this.blockInstructions();
        this.reader.eat(Sym.R_CB);
    }
    
    private void forLoop() throws AppError, ParserException{
        this.reader.eat(Sym.FOR);
        this.reader.eat(Sym.L_PAR);
        this.expressions();
        this.reader.eat(Sym.R_PAR);
        this.reader.eat(Sym.L_CB);
        this.blockInstructions();
        this.reader.eat(Sym.R_CB);
    }
    
    private void expressions() throws AppError, ParserException{
        if(this.reader.check(Sym.NUMBER_INT)){
            this.reader.eat(Sym.NUMBER_INT);
            this.expressionFollow();
        } 
        else if(this.reader.check(Sym.VAR_NAME)){
            this.reader.eat(Sym.VAR_NAME);
            this.expressionFollow();
        }
        else if(this.reader.check(Sym.L_PAR)){
            this.reader.eat(Sym.L_PAR);
            this.expressions();
            this.reader.eat(Sym.R_PAR);
            this.expressionFollow();
        } 
        else {
            throw new ParserException("Expression", this.reader.getCurrentToken());
        }
    }
    
    private void expressionFollow() throws AppError, ParserException{
        if(this.checkNextIsOperator()){
            this.operator();
            this.expressionFollow();
        }
        //Otherwise, do nothing (Can be empty)
    }
    
    private void operator() throws AppError, ParserException{
        if(this.reader.check(Sym.PLUS)){
            this.reader.eat(Sym.PLUS);
            this.expressions();
        }
        else if(this.reader.check(Sym.LESS)){
            this.reader.eat(Sym.LESS);
            this.expressions();
        } 
        else if(this.reader.check(Sym.MULTIPLY)){
            this.reader.eat(Sym.MULTIPLY);
            this.expressions();
        } 
        else if (this.reader.check(Sym.DIV)){
            this.reader.eat(Sym.DIV);
            this.expressions();
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