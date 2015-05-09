/*
 * Creation:    May 9, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */

package com.app.data;

import com.exceptions.AppError;
import com.exceptions.ExecError;
import com.exceptions.ForbiddenAction;
import com.exceptions.ParserException;
import com.parser.Grammar;
import com.parser.Grammar1;
import com.parser.Parser;
import java.io.File;



/**
 * <h1>AppData</h1>
 * <p>public class AppData</p>
 *
 * @date    May 9, 2015
 * @author  Constantin MASSON
 */
public class AppData {
    //**************************************************************************
    // Constants - Variables
    //**************************************************************************
    private     Grammar     grammer;
    private     Parser      parser;
    

    //**************************************************************************
    // Constructor - Initialization
    //**************************************************************************
    /**
     * Create a new AppData with default grammar and parser
     */
    public AppData(){
        this.grammer    = new Grammar1();
        this.parser     = new Parser(grammer);
    }
    

    //**************************************************************************
    // Functions
    //**************************************************************************
    /**
     * 
     * @param pFile File to process with parser
     * @throws ParserException  thrown if text given is not valid
     * @throws ForbiddenAction  thrown whether no grammar set
     * @throws ExecError        thrown if unable to load file (Wrong path etc)
     * @throws AppError         thrown if critical program error
     */
    public void runParser(File pFile) throws ForbiddenAction, ParserException, AppError, ExecError{
        this.parser.startParser(Parser.MODE_GENERAL, pFile);
    }
    
    
    //**************************************************************************
    // Getters - Setters
    //**************************************************************************
}
