/* 
 * Creation : May 8, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.parser;

/**
 * <h1>Token</h1>
 * <p>public class Token</p>
 * 
 * @date    May 8, 2015
 * @author  Constantin MASSON
 */
public class Token {
    protected   Sym symbol;
    protected   int linePosition; //Line where token was found
    public Token(Sym s, int pLine) {
    	this.symbol         = s;
        this.linePosition   = pLine;
    }
    public Sym getSymbol() {
    	return symbol;
    }
    public int getLine(){
        return this.linePosition;
    }
    public boolean isEqual(Token t){
    	return (t.symbol == this.symbol);
    }
    @Override
    public String toString(){
    	return "Token :"+this.symbol.toString()+" at position : "+this.linePosition;
    }
}


/**
 * <h1>IntToken</h1>
 * <p>
 * public class IntToken<br/>
 * extends Token
 * </p>
 * <p>Token with specific Integer value</p>
 * 
 * @date    May 8, 2015
 * @author  Constantin MASSON
 */
class IntToken extends Token {
    private final int value;
    public IntToken(Sym s, int pLine, int v){
        super(s, pLine);
        this.value = v;
    }

    public int getValue(){
        return this.value;
    }

    @Override
    public String toString(){
        return super.toString()+" with value : "+this.value;
    }
}


/**
 * <h1>StrToken</h1>
 * <p>
 * public class StrToken<br/>
 * extends Token
 * </p>
 * <p>Token with a specific String value</p>
 * 
 * @date    May 8, 2015
 * @author  Constantin MASSON
 */
class StrToken extends Token {
    private final String str;
    public StrToken(Sym s, int pLine, String v){
        super(s, pLine);
        this.str = v;
    }

    public String getValue(){
        return this.str;
    }

    @Override
    public String toString(){
        return super.toString()+" with string : "+this.str;
    }
}
