/* 
 * Creation : May 8, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.parser;

import com.asset.AppError;
import com.asset.ParserException;


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
        this.reader.eat(Sym.VAR_CREA);
        this.reader.eat(Sym.VAR_NAME);
    }
    
    private void instructions() throws AppError, ParserException{
        
    }
    
    private void blockInstructions() throws AppError, ParserException{
        
    }
    
    private void whileLoop() throws AppError, ParserException{
        
    }
    
    private void expressions() throws AppError, ParserException{
        
    }
    
    private void expressionFollow() throws AppError, ParserException{
        
    }
    
    private void operator() throws AppError, ParserException{
        
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
    public void term (Sym c) throws AppError, ParserException{
        this.reader.eat(c);
    }
}