/* 
 * Creation : May 8, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.parser;

import com.asset.AppError;
import com.asset.ForbiddenAction;
import com.asset.ParserException;
import java.io.*;



/**
 * <h1>Parser</h1>
 * <p>public class Parser</p>
 * 
 * <p>
 * Parser process a text using specific grammar. It create an abstract 
 * representation of the text, usable by other program.
 * </p>
 * 
 * @data    May 8, 2015
 * @author  Constantin MASSON
 * 
 * @see Grammar
 */
public class Parser {
    //**************************************************************************
    // Variables - Constants
    //**************************************************************************
    private     Grammar         grammar; //Grammar used
    
    
    //**************************************************************************
    // Constructors - Initialization
    //**************************************************************************
    /**
     * Create a new Parser with specific grammar. Grammar can be changed later.
     * @param pGrammar grammar to set with this parser
     * @throws AppError thrown if grammar is invalid (null)
     */
    public Parser(Grammar pGrammar) throws AppError {
        this.setGrammar(pGrammar);
    }
    
    
    //**************************************************************************
    // Functions 
    //**************************************************************************
    /**
     * Start the parser. it will parse a given text (Text is from a file given 
     * as parameter)
     * @param pFilePath path of the file (if file is hi.txt -> path/file/hi.txt)
     * @throws ParserException thrown if text given is not valid
     * @throws ForbiddenAction thrown if unable to load file
     * @throws AppError thrown if critical program error
     */
    public void startParser(String pFilePath) throws ForbiddenAction, ParserException, AppError{
        try{
            File        input   = new File(pFilePath);
            Reader      r       = new FileReader(input);
            Lexer       lexer   = new Lexer(r);
            LookAhead1  look    = new LookAhead1(lexer);
            this.grammar.processGrammar(Grammar.MODE_GENERAL, look);
        }
        catch(FileNotFoundException ex){
            throw new ForbiddenAction("Unable to load file "+pFilePath
                                      +"\nError message : "+ex.getMessage());
        }
    }
    
    

    
    //**************************************************************************
    // Getters - Setters 
    //**************************************************************************
    /**
     * Return current grammar used by the Parser
     * @return Grammar
     */
    public Grammar getGrammar(){
        return this.grammar;
    }
    
    /**
     * Set current parser grammar to a new grammar. If grammar given is null, 
     * throw an Exception
     * @param pGrammar 
     * @throws AppError Exception thrown if grammar given is null
     */
    public void setGrammar(Grammar pGrammar) throws AppError{
        if(pGrammar == null){
            throw new AppError("Grammar mustn't be null");
        }
        this.grammar = pGrammar;
    }
}
