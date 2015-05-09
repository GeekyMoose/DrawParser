/*
 * Creation:    May 9, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */

package com.app.data;

import com.app.view.Application;
import com.exceptions.AppError;



/**
 * <h1>AppController</h1>
 * <p>public class AppController</p>
 *
 * @date    May 9, 2015
 * @author  Constantin MASSON
 */
public class AppController {
    //**************************************************************************
    // Constants - Variables
    //**************************************************************************
    private Application     view;
    private AppData         model;
    
    
    
    //**************************************************************************
    // Constructor - Initialization
    //**************************************************************************
    /**
     * Create a new controller for Application
     * @param pAppData  model of application
     * @throws AppError thrown if model is null
     */
    public AppController(AppData pAppData) throws AppError{
        if(pAppData==null){
            throw new AppError("Invalid parameter : null parameter in controller");
        }
        this.model  = pAppData;
    }
    

    //**************************************************************************
    // Functions
    //**************************************************************************
    /**
     * Set Application view for this controller. If null given, do nothing
     * @param pApp Application view to add in this controller
     */
    public void setView(Application pApp){
        if(pApp != null){
            this.view = pApp;
        }
    }
}
