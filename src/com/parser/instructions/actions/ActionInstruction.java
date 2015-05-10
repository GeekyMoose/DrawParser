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
    public static final int ACTION_UP       = 0;
    public static final int ACTION_DOWN     = 1;
    public static final int ACTION_MOVE     = 2;
    public static final int ACTION_ROTATE   = 3;
    
    /**
     * Get a short description of the action
     * @return 
     */
    public abstract String getDescription();
    
    /**
     * Return id of the kind of action
     * @return int type of action
     */
    public abstract int getTypeAction();
    
    /**
     * Return value saved by this action
     * @return 
     */
    public abstract int getValue();
}
