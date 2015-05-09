/*
 * Creation:    May 9, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.app.view;

import com.app.data.AppController;
import com.exceptions.AppError;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;



/**
 * <h1>InstructionsPanel</h1>
 * <p>
 * public class InstructionsPanel<br/>
 * extends ContentPanel
 * </p>
 * <p>InstructionsPanel display all action created for this text</p>
 * 
 * @author Constantin MASSON
 */
public class InstructionsPanel extends ContentPanel{
    //**************************************************************************
    // Constants - Variables
    //**************************************************************************
    private static final Dimension  MIN_DIM  = new Dimension(100,Application.DIM_MIN.height);
    private static final Dimension  MAX_DIM  = new Dimension(500,Application.DIM_MIN.height);
    private static final int        PERCENT = 100;
    
    
    //**************************************************************************
    // Constructor - Initialization
    //**************************************************************************
    public InstructionsPanel(Application pParent, AppController pController) throws AppError{
        super(pParent, pController);
        this.initComponents();
    }
    
    private void initComponents(){
        this.setLayout(new FlowLayout());
        this.setMinimumSize(MIN_DIM);
        this.setMaximumSize(MAX_DIM);
        this.setPreferredSize(new Dimension(150, this.parent.getPreferredSize().height));
    }
    
    
    //**************************************************************************
    // Constructor - Initialization
    //**************************************************************************
    @Override
    public void paintComponent(Graphics g){
        int width   = (this.parent.getSize().width / 100)* PERCENT;
        int height  = (this.parent.getSize().height /100) * PERCENT;
        //this.setPreferredSize(new Dimension(width, height));
        this.setSize(new Dimension(width, height));
        super.paintComponent(g);
    }
}