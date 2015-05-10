/*
 * Creation:    May 9, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.app.view;

import com.app.data.AppController;
import com.exceptions.AppError;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import javax.swing.BorderFactory;



/**
 * <h1>DrawPanel</h1>
 * <p>
 * public class DrawPanel<br/>
 * extends ContentPanel
 * </p>
 * <p>DrawPanel is where draw is processed</p>
 * 
 * @author Constantin MASSON
 */
public class DrawPanel extends ContentPanel{
    //**************************************************************************
    // Constants - Variables
    //**************************************************************************
    
    
    //**************************************************************************
    // Constructor - Initialization
    //**************************************************************************
    public DrawPanel(Application pParent, AppController pController) throws AppError{
        super(pParent, pController);
        this.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        //this.setPreferredSize(new Dimension(100, 100));
        this.initComponents();
    }
    
    private void initComponents(){
        this.setLayout(new FlowLayout());
    }
    
    @Override
    public void paintComponent(Graphics g){
        Graphics2D      g2d     = (Graphics2D)g;
        RenderingHints  rh      = new RenderingHints(
                                    RenderingHints.KEY_ANTIALIASING,
                                    RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);
        
        ArrayList<ActionView> list = this.parent.getInstructionPanel().getListActionPanel();
        for(ActionView ap : list){
            ap.drawAction(g2d);
        }
    }
}