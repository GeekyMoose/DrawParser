/* 
 * Creation : May 8, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.parser;

import com.exceptions.AppError;
import com.exceptions.LexerException;
import com.exceptions.ParserException;
import com.main.DebugTrack;
import java.io.IOException;



/**
 * <h1>LookAhead1</h1>
 * <p>public class LookAhead1</p>
 * <p>Simulating a reader class for a stream of Token</p>
 */
public class LookAhead1  {
    //**************************************************************************
    // Variables
    //**************************************************************************
    private Token   currentToken;  //Current token read
    private Lexer   lexer;    //Lexer used

    
    //**************************************************************************
    // Constroctors - Initialization
    //**************************************************************************
    /**
     * Create a new LookAhead1 used with given Lexer.
     * @param l Lexer to process
     * @throws AppError important error
     * @throws ParserException thrown if text is not valid
     */
    public LookAhead1(Lexer l) throws AppError, ParserException {
        if(l == null){
            throw new AppError("Lexer given is null!");
        }
        this.lexer = l;
        this.switchToNextToken();
    }
    
    
    
    //**************************************************************************
    // Parsing functions - Token check etc (Function from old LookAhead1
    //**************************************************************************
    /**
     * Check whether the current character is of type s. 
     * @param s
     * @return true if is type s, otherwise, return false
     */
    public boolean check(Sym s) {
          return (this.currentToken.getSymbol() == s); 
    }
    
    /**
     * Consumes a token of type s from the stream. Throws exception when the 
     * contents does not start on s.
     * 
     * Check if current token is type s. If ok, switch current token to next token. 
     * otherwise, throw exception
     * @param s expected Symbol
     * @throws AppError thrown if critical program error 
     * @throws ParserException thrown if current token is unexpected
     */
    public void eat(Sym s) throws AppError, ParserException {
    	if (check(s)==false) {
            throw new ParserException(s, this.currentToken);
    	}
        this.switchToNextToken();
    }
    
    /**
     * Return int value of current token. Token must be instance of IntToken! If is 
     * not, throws exception
     * @return Integer value of current token
     * @throws AppError thrown if current token is not instance of IntToken
     */
    public int getIntValue() throws AppError {
    	if (this.currentToken instanceof IntToken) {
    		IntToken t = (IntToken) this.currentToken; 
    		return t.getValue();
        } else {
    		throw new AppError("LookAhead error: get int value from a non-valued token");
        }
    }

    /**
     * Return String value of current token. Token must be instance of StrToken! If is 
     * not, throws exception
     * @return String value of current token
     * @throws AppError thrown if current token is not instance of StrToken
     */
    public String getStrValue() throws AppError {
        if (this.currentToken instanceof StrToken) {
            StrToken t = (StrToken) this.currentToken;
            return t.getValue();
        } else {
            throw new AppError("LookAhead error: get String value from a non-valued token");
        }   
    }

    
    //**************************************************************************
    // useful functions
    //**************************************************************************
    /**
     * Return current Token
     * @return Token 
     */
    public Token getCurrentToken() {
        return this.currentToken;
    }
    
    /**
     * Change current token to the next one. If error in reading next token, 
     * return exception. If next token is not valid, also return exception
     * 
     * @throws AppError thrown if program error (Critical error)
     * @throws ParserException thrown if text is not valid
     */
    private void switchToNextToken() throws AppError, ParserException{
        try {
            this.currentToken = lexer.yylex();
            DebugTrack.showToken(currentToken); //Debug
        } catch(IOException ex) {
            throw new AppError(ex.getMessage());
        } catch(LexerException ex) {
            throw new ParserException(ex.getMessage());
        }
    }
}
