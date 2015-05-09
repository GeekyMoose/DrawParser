/*
 * Creation:    May 9, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.parser.instructions.asset;

import com.exceptions.ForbiddenAction;
import com.exceptions.ParserException;
import com.parser.asset.AbstractSyntax;
import com.parser.asset.ValueEnvironment;
import com.parser.instructions.actions.ActionInstruction;
import java.util.ArrayList;


/**
 * <h1>ElseInstruction</h1>
 * <p>
 * public class ElseInstruction<br/>
 * extends Instruction
 * </p>
 * 
 * @date    May 9, 2015
 * @author  Constantin MASSON
 */
public class ElseInstruction extends Instruction{
    //**************************************************************************
    // Constants - Variables
    //**************************************************************************
    private AbstractSyntax  abs;
    
    
    //**************************************************************************
    // Constants - Variables
    //**************************************************************************
    public ElseInstruction(AbstractSyntax pAbs){
        this.abs = pAbs;
    }
    
    
    //**************************************************************************
    // Function
    //**************************************************************************
    @Override
    public void exec(ValueEnvironment env) throws ForbiddenAction{
        try {
            abs.exec(env);
        } catch(ParserException ex) {
            throw new ForbiddenAction(ex.getMessage());
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
     * Return AbstractSyntax used by this else Instruction
     * @return AbstractSyntax
     */
    public AbstractSyntax getAbstractSyntax(){
        return this.abs;
    }
}