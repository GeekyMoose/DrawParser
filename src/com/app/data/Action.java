/*
 * Creation:    May 9, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
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
 * <p>
 * Action is an action displayable by a drawPanel from Parser Application. 
 * It is created from an ActionInstruction. All element are calculated from the 
 * previous action (First action is made with default value)
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
    
    private Action              previousAction;
    private ActionInstruction   instruction;
    private String              description;
    
    private Point               originPoint;
    private Point               endPoint;
    private int                 angle; //Angle in degre, 0 is vertical bottom direction
    private int                 state;
    private int                 thickness;
    private int                 color;
    
    private boolean             isUsed;     //User can temporary delete an action
    private boolean             isRunning;
    private boolean             isDrawing;
    
    
    

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
        this.isUsed         = true;
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
        this.isUsed             = true;
        this.description        = pInst.getDescription();
        this.calculate();
    }
    
    /**
     * Calculate each element (Position, origin etc)
     */
    public void calculate(){
        if(this.previousAction==null){
            //If origin, do nothing
        }
        else if (this.isUsed == false){
            this.isDrawing  = this.previousAction.isDrawing();
            this.angle      = this.previousAction.getAngle();
            this.originPoint= this.previousAction.getEndPosition();
            this.endPoint   = this.originPoint;
            this.thickness  = this.previousAction.getThickness();
        }
        else{
            //Default calcul, recovered from previous action
            this.isDrawing  = this.previousAction.isDrawing();
            this.angle      = this.previousAction.getAngle();
            this.originPoint= this.previousAction.getEndPosition();
            this.endPoint   = this.originPoint;
            this.thickness  = this.previousAction.getThickness();
            //Do specific action
            switch(this.instruction.getTypeAction()){
                case ActionInstruction.ACTION_DOWN:
                    this.isDrawing  = true;
                    break;
                case ActionInstruction.ACTION_MOVE:
                    this.endPoint   = Calculator.getNewPosition(originPoint, angle, this.instruction.getValue());
                    break;
                case ActionInstruction.ACTION_ROTATE:
                    this.angle      = this.previousAction.getAngle()+this.instruction.getValue();
                    break;
                case ActionInstruction.ACTION_UP:
                    this.isDrawing  = false;
                    break;
            }
        }
    }
    
    
    //**************************************************************************
    // Check Functions
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
    
    /**
     * Check whether Action is used in the display mode
     * @return true if used, otherwise, return false
     */
    public boolean isUsed(){
        return this.isUsed;
    }
    

    //**************************************************************************
    // Getters - Setters
    //**************************************************************************
    public Point    getPosition(){          return this.originPoint;     }
    public Point    getEndPosition(){       return this.endPoint;   }
    public int      getAngle(){             return this.angle;  }
    public String   getDescription(){       return this.description;}
    public int      getThickness(){         return this.thickness;}
    
    
    public void     setIsRunning(boolean pValue)    {this.isRunning = pValue;}
    public void     setIsUsed(boolean pValue)       {this.isUsed    = pValue;}
}
