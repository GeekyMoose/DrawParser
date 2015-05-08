/* 
 * Creation : May 8, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.parser;

import com.asset.AppError;
import com.asset.ParserException;


/**
 * <h1>Grammar</h1>
 * <p>public abstract class Grammar</p>
 * <p>
 * Grammar define grammar used to process a text. It must be used with a specific 
 * grammar (Extending Grammar)
 * </p>
 * 
 * @date    May 8, 2015
 * @author  Constantin MASSON<br/>
 * @see     Parser
 * @see     Lexer
 * 
 */
public abstract class Grammar{
    //**************************************************************************
    // Variables - Constants
    //**************************************************************************
    public      static final int    MODE_INTERPRETER        = 1;
    public      static final int    MODE_GENERAL            = 2;
    protected   LookAhead1          reader; //Current position in the reader
    
    
    //**************************************************************************
    // Constroctor - Initialization
    //**************************************************************************
	public Grammar(){
		//Nothing, reader will be set later (When start)
	}
    
    /**
     * Start to process a text using this grammar. Text is process from a 
     * Lexer class (Create before from Parser). LookAhead1 is the current 
     * position in Lexer. (Lexer is a generated class by JFlex). 
     * Do nothing if a bad mode is given
     * @param pMode     current reading mode
     * @param pLook     reader for this process.
     * @throws AppError Exception thrown if pParser if null or wrong mode
     */
    public void processGrammar(int pMode, LookAhead1 pLook) throws AppError{
        if(pLook == null){
            throw new AppError();
        }
        this.reader = pLook;
        switch(pMode){
            case MODE_GENERAL:
                this.processGeneralMode();
                break;
            case MODE_INTERPRETER:
                this.processInterpreterMode();
                break;
            default:
                throw new AppError("Unkow parsing mode");
        }
    }
    
    /**
     * Process grammar with general mode
     */
    protected abstract void processGeneralMode();
    
    /**
     * Process grammar with interpreter mode
     */
    protected abstract void processInterpreterMode();
    
    /**
     * Display the grammar rules
     * @return String displaying grammar rule used
     */
    @Override
    public abstract String toString();
}



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
class Grammar1 extends Grammar{
    //**************************************************************************
    // Functions from Grammar
    //**************************************************************************
    @Override
    protected void processGeneralMode(){
    
    }

    @Override
    protected void processInterpreterMode(){
    
    }
    
    @Override
    public String toString(){
        return null;
    }
    
	
    //**************************************************************************
    // Not term functions
    //**************************************************************************
    /**
     * Code -> Prog$
     */
    public Program nontermCode() throws Exception {
        //Program prog = notermProg();
        reader.eat(Sym.EOF);
        return null;
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