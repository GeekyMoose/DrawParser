/* 
 * Creation : May 8, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.parser;

import com.exceptions.AppError;
import com.exceptions.ExecError;
import com.exceptions.ForbiddenAction;
import com.exceptions.ParserException;
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
    public      static final int    MODE_INTERPRETER        = 1;
    public      static final int    MODE_GENERAL            = 2;
    private     Grammar             grammar; //Grammar used
    
    
    //**************************************************************************
    // Constructors - Initialization
    //**************************************************************************
    /**
     * Create a new Parser with specific grammar. Grammar can be changed later. 
     * If null given, parser if created without grammar
     * @param pGrammar grammar to set with this parser
     */
    public Parser(Grammar pGrammar) {
        this.setGrammar(pGrammar);
    }
    
    
    //**************************************************************************
    // Functions 
    //**************************************************************************
    /**
     * 
     * Start to process a text using parser grammar. Text is recovered from a 
     * file given as parameter. Mode set the behavior of processing. 
     * Throws exception if bad mode given
     * 
     * @param pMode     reading mode for this parsing
     * @param pFilePath path of the file (if file is hi.txt -> path/file/hi.txt)
     * @throws ParserException  thrown if text given is not valid
     * @throws ForbiddenAction  thrown whether no grammar set
     * @throws ExecError        thrown if unable to load file (Wrong path etc)
     * @throws AppError         thrown if critical program error
     */
    public void startParser(int pMode, String pFilePath) 
    throws ForbiddenAction, ParserException, AppError, ExecError{
        File input = new File(pFilePath);
        this.startParser(pMode, input);
    }
    
    /**
     * 
     * Start to process a text using parser grammar. Text is recovered from a 
     * file given as parameter. Mode set the behavior of processing. 
     * Throws exception if bad mode given
     * 
     * @param pMode     reading mode for this parsing
     * @param pFile     File to process
     * @throws ParserException  thrown if text given is not valid
     * @throws ForbiddenAction  thrown whether no grammar set
     * @throws ExecError        thrown if unable to load file (Wrong path etc)
     * @throws AppError         thrown if critical program error
     */
    public void startParser(int pMode, File pFile) throws ForbiddenAction, ParserException, ExecError, AppError{
        if(this.grammar == null){
            throw new ForbiddenAction("Parser has not grammar! Add a grammar before!");
        }
        try{
            Reader      r       = new FileReader(pFile);
            Lexer       lexer   = new Lexer(r);
            LookAhead1  look    = new LookAhead1(lexer);
            
            switch(pMode){
                case Parser.MODE_GENERAL:
                    this.grammar.processGeneralMode(look);
                    break;
                case Parser.MODE_INTERPRETER:
                    this.grammar.processInterpreterMode(look);
                    break;
                default:
                    throw new ExecError("Unkow parsing mode");
            }
        }
        catch(FileNotFoundException ex){
            throw new ExecError("Unable to load file "+pFile.getPath()
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
     * parser has no longer a grammar
     * @param pGrammar 
     */
    public void setGrammar(Grammar pGrammar){
        this.grammar = pGrammar;
    }
}
