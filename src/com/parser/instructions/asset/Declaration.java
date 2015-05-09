/*
 * Creation:    May 9, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.parser.instructions.asset;

import com.parser.asset.ValueEnvironment;
import com.parser.instructions.actions.ActionInstruction;
import java.util.ArrayList;


/**
 * <h1>Declaration</h1>
 * <p>
 * public class Declaration<br/>
 * extends Instruction
 * </p>
 * <p>Declare a new variable</p>
 * 
 * @date    May 9, 2015
 * @author  Constantin MASSON
 */
public class Declaration extends Instruction {
    //**************************************************************************
    // Constants - Variables
    //**************************************************************************
	private String varName;
    
    
    //**************************************************************************
    // Constructor - Initialization
    //**************************************************************************
	public Declaration(String s) {
		this.varName = s;
	}
    
    
    //**************************************************************************
    // Functions from instruction
    //**************************************************************************
    @Override
	public void exec(ValueEnvironment env){
		env.addVariable(this.varName);
	}
    
    @Override
    public void addActionInstruction(ArrayList<ActionInstruction> pList){
        //Is not an action instruction
        //Do nothing, this instruction is used only during exec
    }

    @Override
    public String toString(){
        String str = super.toString();
        str += "Declaration";
        return str;
    }
}