/*
 * Creation:    May 9, 2015
 * 
 */

package com.app.data;

import com.parser.instructions.actions.ActionInstruction;
import java.awt.Point;



/**
 * <h1>Action</h1>
 * <p>public class Action</p>
 *
 * @date    May 9, 2015
 * @author  Constantin MASSON
 */
public class Action {
    //**************************************************************************
    // Constants - Variables
    //**************************************************************************
    private static final int    ORIGNAL     = 0;
    private static final int    DELETED     = 1;
    private static final int    ADDED       = 2;
    
    private ActionInstruction   instruction;
    private boolean             isRunning;
    
    
    
    private int     state;
    private boolean movable;
    private int     actionType;
    
    private Action  previousAction;
    private int     angle;
    private Point   origin;
    
    

    //**************************************************************************
    // Constructor - Initialization
    //**************************************************************************
    public Action(ActionInstruction pInst){
        this.instruction = pInst;
        this.movable    = false;
        this.state      = 0;
        this.isRunning = true;
    }
    
    
    //**************************************************************************
    // Functions
    //**************************************************************************
    /**
     * Check if this action is running
     * @return true if running, otherwise, return false
     */
    public boolean isRunning(){
        return this.isRunning;
    }
    

    //**************************************************************************
    // Getters - Setters
    //**************************************************************************
    public Point getPosition(){
        return this.origin;
    }
    
    public int getAngle(){
        return this.angle;
    }
    
    public void setIsRunning(boolean pValue){
        this.isRunning = pValue;
    }
}
