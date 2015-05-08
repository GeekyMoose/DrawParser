/* 
 * Creation : May 8, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.parser;

import com.exceptions.AppError;
import com.exceptions.ParserException;


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
    protected   LookAhead1          reader; //Current position in the reader
    
    
    //**************************************************************************
    // Constroctor - Initialization
    //**************************************************************************
	public Grammar(){
		//Nothing, reader will be set later (When start)
	}
    
    
    //**************************************************************************
    // Functions
    //**************************************************************************
    /**
     * Process grammar with general mode
     * LookAhead1 is the current position in Lexer.
     * @param pLook reader for file to process
     * @throws AppError thrown if critical error during processing (Bad file etc)
     * @throws ParserException thrown if text is not valid
     */
    public void processGeneralMode(LookAhead1 pLook) throws AppError, ParserException{
        if(pLook == null){
            throw new AppError("LookAhead1 mustn't be null");
        }
        this.reader = pLook;
    }
    
    /**
     * Process grammar with interpreter mode
     * @param pLook reader for file to process
     * @throws AppError thrown if critical error during processing (Bad file etc)
     * @throws ParserException thrown if text is not valid
     */
    public void processInterpreterMode(LookAhead1 pLook) throws AppError, ParserException{
        if(pLook == null){
            throw new AppError("LookAhead1 mustn't be null");
        }
        this.reader = pLook;
    }
    
    /**
     * Display the grammar rules
     * @return String displaying grammar rule used
     */
    @Override
    public abstract String toString();
}