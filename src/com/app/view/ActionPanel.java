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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;


/**
 * <h1>ActionPanel</h1>
 * <p>
 * public class ActionPanel<br/>
 * extends ContentPanel<br/>
 * implements MouseListener
 * </p>
 * <p>Display an action generated from file</p>
 * 
 * @date    May 9, 2015
 * @author  Constantin MASSON
 */
public class ActionPanel extends ContentPanel implements MouseListener{
    //**************************************************************************
    // Constants - Variables
    //**************************************************************************
    private final Color     color_hover     = Color.GRAY;
    private final Color     color_default   = Color.LIGHT_GRAY;
    private final Color     color_running   = Color.GREEN;
    
    private     Action      actionModel;
    private     boolean     isHover;
    private     JLabel      l_description;
    
    
    //**************************************************************************
    // Constructor - Initialization
    //**************************************************************************
    public ActionPanel(Action pAction, Application pParent, AppController pController) throws AppError{
        super(pParent, pController);
        this.actionModel    = pAction;
        this.isHover        = false;
        this.setPreferredSize(Constants.DIM_ACTION_PANEL);
        this.setBackground(color_default);
        this.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        this.addMouseListener(this);
        this.initComponents();
    }
    
    private void initComponents(){
        this.l_description = new JLabel(this.actionModel.getDescription());
        this.setLayout(new BorderLayout());
        this.add(this.l_description, BorderLayout.CENTER);
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
        else if(this.actionModel.isRunning()){
            this.setBackground(this.color_running);
        }
        else{
            this.setBackground(this.color_default);
        }
    }
    
    public void drawAction(Graphics2D g2d){
        if(this.actionModel.isDrawing() && this.actionModel.isRunning()){
            BasicStroke bs1 = new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
            g2d.setStroke(bs1);
            Point p1 = this.actionModel.getPosition();
            Point p2 = this.actionModel.getNextPosition();
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
    }

    @Override
    public void mouseReleased(MouseEvent e){
    }

    @Override
    public void mouseEntered(MouseEvent e){
        this.isHover = true;
        this.repaint();
    }

    @Override
    public void mouseExited(MouseEvent e){
        this.isHover = false;
        this.repaint();
    }
}