/* 
 * Creation : May 8, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.asset;


/**
 * <h1>LexerException</h1>
 * <p>
 * public class LexerException<br/>
 * extends Exception
 * </p>
 * 
 * <p>Critical error from lexer</p>
 */
public class LexerException extends Exception {
    public LexerException() {
    }
    
    public LexerException(String pMsg) {
        super(pMsg);
    }
    
	public LexerException(String pGiven, int line, int column) {
		super("Unknown character at line "+line+" column "+column+" : "+pGiven);
	}
}

