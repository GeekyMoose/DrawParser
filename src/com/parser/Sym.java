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
    
    //Actions
    UP("Up"),
    DOWN("Down"),
    MOVE("Move"),
    ROTATE("Rotate"),
    
    //Check elements
    EQ("=="),
    IF("if"),
    ELIF("elif"),
    ELSE("else"),
    
    //Check elements
    WHILE("While"),
    FOR("For"),
    
    
    //Variables
    VAR_CREA("Var"),
    VAR_NAME("Variable name"),
    NUMBER_INT("Integer Number"),
    ASSIGN("="),
    
    //Other
    EOF ("EoF"); //token representinting the end of file


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
