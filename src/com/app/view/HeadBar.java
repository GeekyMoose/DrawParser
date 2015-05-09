/*
 * Creation:    May 9, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.app.view;

import com.app.data.AppController;
import com.exceptions.AppError;
import java.awt.Dimension;
import java.awt.FlowLayout;




/**
 * <h1>HeadBar</h1>
 * <p>
 * class HeadBar<br/>
 * extends ContentPanel
 * </p>
 * <p>HeadBar display a bar with action to do, button to manage program etc</p>
 * 
 * @author Constantin MASSON
 */
class HeadBar extends ContentPanel{
    //**************************************************************************
    // Constructor - Initialization
    //**************************************************************************
    public HeadBar(Application pParent, AppController pController) throws AppError{
        super(pParent, pController);
        this.initComponents();
    }
    
    private void initComponents(){
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(this.parent.getPreferredSize().width, 40));
    }
}