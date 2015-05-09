/*
 * Creation:    May 9, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.parser.instructions.asset;

import com.exceptions.ForbiddenAction;
import com.parser.asset.ValueEnvironment;
import com.parser.instructions.actions.ActionInstruction;
import java.util.ArrayList;


/**
 * <h1>Instruction</h1>
 * <p>public abstract class Instruction</p>
 *
 * 
 * @date    May 8, 2015
 * @author  Constantin MASSON
 */
public abstract class Instruction {
    /**
     * Execute this instruction. Set expression value and check if 
     * expression are valid (Division by 0, wrong value etc)
     * @param env ValueEnvironment where variables are saved
     * @throws ForbiddenAction thrown if bad expression
     */
	public abstract void exec(ValueEnvironment env) throws ForbiddenAction;
    
    /**
     * Add instruction in the list of instruction given as parameter
     * @param pList ArrayList of Instruction
     */
    public abstract void addActionInstruction(ArrayList<ActionInstruction> pList);
    
    @Override
    public String toString(){
        return super.toString();
    }
}