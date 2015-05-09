/*
 * Creation:    May 9, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.parser.instructions.asset;

import com.exceptions.ForbiddenAction;
import com.parser.asset.Expression;
import com.parser.asset.ValueEnvironment;
import com.parser.instructions.actions.ActionInstruction;
import java.util.ArrayList;


/**
 * <h1>Assignment</h1>
 * <p>
 * public class Assignment<br/>
 * extends Instruction
 * </p>
 * <p>Assign a new value in existing variable</p>
 * 
 * @date    May 9, 2015
 * @author  Constantin MASSON
 */
public class Assignment extends Instruction {
    //**************************************************************************
    // Constants - Variables
    //**************************************************************************
	private String 		varName;
	private Expression 	exp;
    
    
    //**************************************************************************
    // Constructor - Initialization
    //**************************************************************************
	public Assignment(String s, Expression e) {
		this.varName    = s;
		this.exp        = e;
	}
    
    
    //**************************************************************************
    // Redefin function from Instruction
    //**************************************************************************
    @Override
	public void exec(ValueEnvironment env) throws ForbiddenAction{
        env.setVariable(this.varName, this.exp.eval(env));
	}
    
    @Override
    public void addActionInstruction(ArrayList<ActionInstruction> pList){
        //Is not an action instruction
        //Do nothing, this instruction is used only during exec
    }

    @Override
    public String toString(){
        String str = super.toString();
        str += "Assignment";
        return str;
    }
}