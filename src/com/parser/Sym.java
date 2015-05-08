/* 
 * Creation : May 8, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.parser;


/**
 * <h1>Sym</h1>
 * <p>public enum Sym</p>
 * <p>Sym saved every available Token.</p>
 * 
 * @date    16 April 2015
 * @author  Constantin MASSON 
 */
public enum Sym {
    //Separator
    L_PAR("("),
    R_PAR(")"),
    L_CB("{"),
    R_CB("}"),
    CONCAT(";"), 
    
    //Expressions calculator
    PLUS("+"),
    LESS("-"),
    MULTIPLY("*"),
    DIV("/"),
    
    //Prgram
    PROG("PROG"),
    
    //Actions
    UP("UP"),
    DOWN("DOWN"),
    MOVE("MOVE"),
    ROTATE("ROTATE"),
    
    //Check elements
    EQ("=="),
    IF("IF"),
    ELIF("ELIF"),
    ELSE("ELSE"),
    
    //Check elements
    WHILE("WHILE"),
    FOR("FOR"),
    
    
    //Variables
    VAR_CREA("VAR_CREA"),
    VAR_NAME("VAR_NAME"),
    NUMBER_INT("NUMBER_INT"),
    ASSIGN("="),
    
    //Other
    EOF("EOF"); //token representinting the end of file


    //**************************************************************************
    // Functions used by Sym enum
    //**************************************************************************
    private String description;

    /** Create a new Sym with specific description */
    private Sym(String pStr){
        this.description = pStr;
    }

    /** 
     * Return description of the Sym
     * @return  String description
     */
    @Override
    public String toString(){
        return this.description;
    }
}
