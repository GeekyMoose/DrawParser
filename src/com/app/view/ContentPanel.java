/*
 * Creation:    May 9, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.app.view;

import com.app.data.AppController;
import com.exceptions.AppError;
import javax.swing.JPanel;



/**
 * <h1>ContentPanel</h1>
 * <p>
 * public abstract class ContentPanel<br/>
 * extends JPanel
 * </p>
 * <p>ContentPanel is a JPanel with a specific controller</p>
 *
 * @date    May 9, 2015
 * @author  Constantin MASSON
 */
public abstract class ContentPanel extends JPanel{
    protected   AppController   controller;
    protected   Application     parent;
    
    public ContentPanel(Application pParent, AppController pController) throws AppError{
        if(pController == null || pParent == null){
            throw new AppError("Invalid parameter : null given");
        }
        this.controller = pController;
        this.parent     = pParent;
    }
}
