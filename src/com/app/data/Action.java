/*
 * Creation:    May 9, 2015
 * 
 */

package com.app.data;

import com.exceptions.AppError;
import com.parser.instructions.actions.ActionInstruction;
import java.awt.Point;



/**
 * <h1>Action</h1>
 * <p>
 * public class Action<br/>
 * implements Constants
 * </p>
 *
 * @date    May 9, 2015
 * @author  Constantin MASSON
 */
public class Action implements Constants{
    //**************************************************************************
    // Constants - Variables
    //**************************************************************************
    public static final int     ORIGNAL         = 0;
    public static final int     ORI_DELETED     = 1;
    public static final int     ADD_DELETED     = 2;
    public static final int     ADDED           = 3;
    
    private ActionInstruction   instruction;
    private String              description;
    private boolean             isRunning;
    private boolean             isDrawing;
    private Action              previousAction;
    private int                 angle;
    private Point               originPoint;
    private Point               endPoint;
    private int                 state;
    private int                 thickness;
    
    
    

    //**************************************************************************
    // Constructor - Initialization
    //**************************************************************************
    /**
     * Create an original action, it is the starting position
     */
    public Action(){
        this.originPoint    = DEFAULT_POSITION;
        this.endPoint       = this.originPoint;
        this.angle          = DEFAULT_ANGLE;
        this.isDrawing      = DEFAULT_IS_DRAWING;
        this.isRunning      = true;
        this.description    = "first";
        this.thickness      = DEFAULT_THICKNESS;
    }
    
    /**
     * Create a new Action from a specific ActionInstructin. It is linked with 
     * the previous action. If previous action is null, it is the first Action 
     * in the list. State save where is the action from (Original parsing or 
     * from interpreter mode)
     * @param pInst             instruction linked with this action
     * @param pPreviousAction   previous action
     * @param pState            state (Original or added etc)
     * @throws AppError         thrown if unable to create action (previous null...) 
     */
    public Action(ActionInstruction pInst, Action pPreviousAction, int pState) throws AppError{
        if(pPreviousAction==null){
            throw new AppError();
        }
        this.previousAction     = pPreviousAction;
        this.instruction        = pInst;
        this.state              = pState;
        this.isRunning          = true;
        this.description        = pInst.getDescription();
        this.calculate();
    }
    
    /**
     * Calculate each element (Position, origin etc)
     */
    public void calculate(){
        if(this.previousAction==null){
            //If origin, do nothing
            return;
        }
        switch(this.instruction.getTypeAction()){
            case ActionInstruction.ACTION_DOWN:
                this.isDrawing  = true;
                this.angle      = this.previousAction.getAngle();
                this.originPoint= this.previousAction.getNextPosition();
                this.endPoint   = this.originPoint;
                this.thickness  = this.previousAction.getThickness();
                break;
            case ActionInstruction.ACTION_MOVE:
                this.isDrawing  = this.previousAction.isDrawing();
                this.angle      = this.previousAction.getAngle();
                this.originPoint= this.previousAction.getNextPosition();
                this.endPoint   = Calculator.getNewPosition(originPoint, angle, this.instruction.getValue());
                this.thickness  = this.previousAction.getThickness();
                break;
            case ActionInstruction.ACTION_ROTATE:
                this.isDrawing  = this.previousAction.isDrawing();
                this.angle      = this.previousAction.getAngle()+this.instruction.getValue();
                this.originPoint= this.previousAction.getNextPosition();
                this.endPoint   = this.originPoint;
                this.thickness  = this.previousAction.getThickness();
                break;
            case ActionInstruction.ACTION_UP:
                this.isDrawing  = false;
                this.angle      = this.previousAction.getAngle();
                this.originPoint= this.previousAction.getNextPosition();
                this.endPoint   = this.originPoint;
                this.thickness  = this.previousAction.getThickness();
                break;
        }
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
    
    /**
     * Check if is in drawing mode
     * @return true if drawing mode, otherwise, return false
     */
    public boolean isDrawing(){
        return this.isDrawing;
    }
    

    //**************************************************************************
    // Getters - Setters
    //**************************************************************************
    public Point getPosition(){
        return this.originPoint;
    }
    
    public Point getNextPosition(){
        return this.endPoint;
    }
    
    public int getAngle(){
        return this.angle;
    }
    
    public String getDescription(){
        return this.description;
    }
    
    public int getThickness(){
        return this.thickness;
    }
    
    public void setIsRunning(boolean pValue){
        this.isRunning = pValue;
    }
    
}
