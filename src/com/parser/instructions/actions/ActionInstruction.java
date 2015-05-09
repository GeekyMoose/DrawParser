/*
 * Creation:    May 9, 2015
 * 
 */

package com.parser.instructions.actions;

import com.parser.instructions.asset.Instruction;



/**
 * <h1>ActionInstruction</h1>
 * <p>public class ActionInstruction</p>
 *
 * @date    May 9, 2015
 * @author  Constantin MASSON
 */
public abstract class ActionInstruction extends Instruction{
    
    /**
     * Get a short description of the action
     * @return 
     */
    public abstract String getDescription();
}
