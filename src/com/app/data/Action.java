/*
 * Creation:    May 9, 2015
 * 
 */

package com.app.data;

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
    
    private int     state;
    private boolean movable;
    private boolean isSelected;
    
    private Action  nextAction;
    private Point   origin;
    private int     angle;
    
    
    
    
    

    //**************************************************************************
    // Constructor - Initialization
    //**************************************************************************
    public Action(int pState){
        this.movable    = false;
        this.state      = pState;
        this.origin     = new Point(0, 0);
    }
    
    
    
    
    

    //**************************************************************************
    // Functions
    //**************************************************************************
    
    
    
    
    

    //**************************************************************************
    // Getters - Setters
    //**************************************************************************
}
