/* 
 * Creation : May 8, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.asset;

import com.parser.Sym;
import com.parser.Token;

/**
 * <h1>ParserException</h1>
 * <p>
 * public class ParserException<br/>
 * extends Exception
 * </p>
 */
public class ParserException extends Exception {
    //**************************************************************************
    // Constructor - Initialization
    //**************************************************************************
    /**
     * Create a PaserException with a specific message
     * @param pMsg message for this exception
     */
    public ParserException(String pMsg){
        super(pMsg);
    }
    
    /**
     * Create a new Parser Exception displaying error message from parser. 
     * It is usually thown when a unexpected Token is found. This exception 
     * display token expected and token found, it also display line where if 
     * was found      
     * @param pExpected element expected (String description)
     * @param pFound    Token found instead
     */
	public ParserException(String pExpected, Token pFound) {
		super("Unexpected Token line "+pFound.getLine()
              +" : "+pExpected+" expected, "
              +pFound.getSymbol()+" found! ");
	}
    
    /**
     * Create a new Parser Exception displaying error message from parser. 
     * It is usually thown when a unexpected Token is found. This exception 
     * display token expected and token found, it also display line where if 
     * was found
     * @param pFound        Sym expected symbol (From Sym class)
     * @param pExpected     Token found
     */
	public ParserException(Sym pExpected, Token pFound) {
		super("Unexpected Token line "+pFound.getLine()
              +" : "+pExpected.toString()+" expected, "
              +pFound.getSymbol()+" found! ");
	}
}