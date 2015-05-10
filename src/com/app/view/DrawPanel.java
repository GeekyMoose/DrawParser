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
import java.awt.image.BufferedImage;
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
    // Constructor - Initialization
    //**************************************************************************
    /**
     * Create a new DrawPanel
     * @param pParent       Application parent of this TextPanel
     * @param pController   Application controller
     * @throws AppError thrown if critical error
     */
    public DrawPanel(Application pParent, AppController pController) throws AppError{
        super(pParent, pController);
        this.initComponents();
    }
    
    /*
     * Initialize all components
     */
    private void initComponents(){
        this.setLayout(new FlowLayout());
        this.setBackground(Color.BLACK);
        this.setOpaque(false);
        this.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
    }
    
    @Override
    public void paintComponent(Graphics g){
        Graphics2D      g2d     = (Graphics2D)g;
        RenderingHints  rh      = new RenderingHints(
                                    RenderingHints.KEY_ANTIALIASING,
                                    RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);
        
        g2d.setColor(Color.BLACK);
        ArrayList<ActionView> list = this.parent.getInstructionPanel().getListActionPanel();
        for(ActionView ap : list){
            ap.drawAction(g2d);
        }
    }
    
    
    //**************************************************************************
    // Constants - Variables
    //**************************************************************************
    /**
     * Create a image of current DrawPanel. Return an BufferedImage
     * @return BufferedImage
     */
    public BufferedImage getImage(){
        BufferedImage img;
        img = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics g = img.createGraphics();
        this.paint(g);
        g.dispose();
        return img;
    }
}