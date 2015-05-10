/*
 * Creation:    May 8, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.app.view;

import com.app.data.Action;
import com.app.data.AppController;
import com.app.data.Constants;
import com.exceptions.AppError;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.border.Border;


/**
 * <h1>ActionView</h1>
 * <p>
 * public class ActionView<br/>
 * extends ContentPanel<br/>
 * implements MouseListener
 * </p>
 * <p>Display an action generated from file</p>
 * 
 * 
 * @date    May 9, 2015
 * @author  Constantin MASSON
 */
public class ActionView extends ContentPanel implements MouseListener{
    //**************************************************************************
    // Constants - Variables
    //**************************************************************************
    private final Color     color_hover     = Color.GRAY;
    private final Color     color_default   = Color.LIGHT_GRAY;
    private final Color     color_running   = Color.GREEN;
    
    //Data
    private     Action      actionModel;
    
    //Display
    private     JLabel      l_description;
    private     JCheckBox   cb_isUsedBut;
    
    //Action button panel event
    private     boolean     isHover;
    private     Border      border_running;
    private     Border      border_default;
    private     Border      border_hover;
    private     Border      border_notUsed;
    
    
    //**************************************************************************
    // Constructor - Initialization
    //**************************************************************************
    /**
     * Create a new ActionView linked with Application given in parameter
     * @param pAction       action model to display
     * @param pParent       application parent
     * @param pController   controller 
     * @throws AppError thrown if unable to create Action view (Critical, controller null etc)
     */
    public ActionView(Action pAction, Application pParent, AppController pController) throws AppError{
        super(pParent, pController);
        this.actionModel    = pAction;
        this.setPreferredSize(Constants.DIM_ACTION_PANEL);
        this.addMouseListener(this);
        this.initComponents();
    }
    
    /*
     * Init components
     */
    private void initComponents(){
        this.l_description  = new JLabel(this.actionModel.getDescription());
        this.cb_isUsedBut   = new JCheckBox();
        this.isHover        = false;
        
        this.cb_isUsedBut   .setSelected(true);
        this.cb_isUsedBut   .setOpaque(false);
        
        //Set action for check button
        this.cb_isUsedBut   .addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(cb_isUsedBut.isSelected()==true){
                    controller.useAction(actionModel, true);
                } else{
                    controller.useAction(actionModel, false);
                }
            }
        });
        
        //Create border
        this.border_default = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK);
        this.border_hover   = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.DARK_GRAY);
        this.border_running = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.GREEN);
        this.border_notUsed = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.LIGHT_GRAY);
        
        this    .setBackground(color_default);
        this    .setLayout(new BorderLayout());
        this    .setBorder(this.border_default);
        this    .add(this.cb_isUsedBut, BorderLayout.EAST);
        this    .add(this.l_description, BorderLayout.CENTER);
    }
    
    
    //**************************************************************************
    // Functions 
    //**************************************************************************
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(this.isHover){
            this.setBackground(this.color_hover);
        }
        else if(this.actionModel.isUsed()==false){
            this.setBackground(this.color_default);
            this.setBorder(this.border_notUsed);
        }
        else if(this.actionModel.isRunning()){
            this.setBackground(this.color_running);
        }
        else{
            this.setBackground(this.color_default);
        }
    }
    
    /**
     * Draw the action view
     * @param g2d 
     */
    public void drawAction(Graphics2D g2d){
        if(this.actionModel.isDrawing() && this.actionModel.isRunning()){
            BasicStroke bs1 = new BasicStroke(this.actionModel.getThickness(), 
                    BasicStroke.CAP_ROUND, 
                    BasicStroke.JOIN_BEVEL);
            g2d.setStroke(bs1);
            Point p1 = this.actionModel.getPosition();
            Point p2 = this.actionModel.getEndPosition();
            g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }
    
    
    //**************************************************************************
    // Functions MouseListener
    //**************************************************************************
    @Override
    public void mouseClicked(MouseEvent e){
        controller.runAction(this.actionModel);
    }

    @Override
    public void mousePressed(MouseEvent e){
        this.setBorder(this.border_running);
    }

    @Override
    public void mouseReleased(MouseEvent e){
    }

    @Override
    public void mouseEntered(MouseEvent e){
        this.setBorder(this.border_hover);
        this.isHover = true;
        this.repaint();
    }

    @Override
    public void mouseExited(MouseEvent e){
        this.setBorder(this.border_default);
        this.isHover = false;
        this.repaint();
    }
}