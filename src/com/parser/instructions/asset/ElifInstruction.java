/*
 * Creation:    May 9, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.parser.instructions.asset;

import com.exceptions.ForbiddenAction;
import com.exceptions.ParserException;
import com.parser.asset.AbstractSyntax;
import com.parser.asset.Expression;
import com.parser.asset.ValueEnvironment;
import com.parser.instructions.actions.ActionInstruction;
import java.util.ArrayList;


/**
 * <h1>ElifInstruction</h1>
 * <p>
 * public class ElifInstruction<br/>
 * extends Instruction
 * </p>
 * 
 * @date    May 9, 2015
 * @author  Constantin MASSON
 */
public class ElifInstruction extends Instruction{
    //**************************************************************************
    // Constants - Variables
    //**************************************************************************
    private AbstractSyntax  abs;
    private Expression      exp1;
    private Expression      exp2;
    
    
    //**************************************************************************
    // Constructors - Initialization
    //**************************************************************************
    /**
     * Create a new Else if Instruction
     * @param pExp1     Left expression in if
     * @param pExp2     right expression in if
     * @param pAbs      Abstract Syntax in if block
     */
    public ElifInstruction(Expression pExp1, Expression pExp2, AbstractSyntax pAbs){
        this.abs            = pAbs;
        this.exp1           = pExp1;
        this.exp2           = pExp2;
    }
    
    
    //**************************************************************************
    // Functions
    //**************************************************************************
    @Override
    public void exec(ValueEnvironment env) throws ForbiddenAction{
        if(exp1.eval(env) == exp2.eval(env)){
            try {
                abs.exec(env);
            } catch(ParserException ex) {
                throw new ForbiddenAction(ex.getMessage());
            }
        } 
    }

    @Override
    public void addActionInstruction(ArrayList<ActionInstruction> pList){
        //Managed in IfInstruction
    }
    
    
    //**************************************************************************
    // Getters - Setters 
    //**************************************************************************
    /**
     * Check if this else if instruction is verified (value exp1 == value exp2)
     * @param env
     * @return
     * @throws ForbiddenAction thrown if expression are invalid (Division by 0 ...)
     */
    public boolean checkExpression(ValueEnvironment env) throws ForbiddenAction{
        return this.exp1.eval(env) == this.exp2.eval(env);
    }
    
    /**
     * Return AbstractSyntax used by this else Instruction
     * @return AbstractSyntax
     */
    public AbstractSyntax getAbstractSyntax(){
        return this.abs;
    }
}