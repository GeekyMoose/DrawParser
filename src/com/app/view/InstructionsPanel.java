/*
 * Creation:    May 9, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.app.view;

import com.app.data.Action;
import com.app.data.AppController;
import com.app.data.Constants;
import com.exceptions.AppError;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;



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
public class InstructionsPanel extends ContentPanel implements Constants{
    //**************************************************************************
    // Constants - Variables
    //**************************************************************************
    private ArrayList<ActionPanel>  listActions;
    private JScrollPane             scroll;
    private JPanel                  wrapper;
    
    
    //**************************************************************************
    // Constructor - Initialization
    //**************************************************************************
    /**
     * Create a new Instructions Panel to display all Action
     * @param pParent
     * @param pController
     * @throws AppError 
     */
    public InstructionsPanel(Application pParent, AppController pController) throws AppError{
        super(pParent, pController);
        this.setPreferredSize(DIM_INST_PANEL);
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.listActions = new ArrayList();
        this.initComponents();
    }
    
    private void initComponents(){
        this.wrapper    = new JPanel();
        this.scroll     = new JScrollPane(wrapper);
        this.scroll     .setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.wrapper    .setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        this            .setLayout(new BorderLayout());
        this.wrapper    .setLayout(new FlowLayout());
        
        this.add(this.scroll, BorderLayout.CENTER);
    }
    
    
    //**************************************************************************
    // Function
    //**************************************************************************
    /**
     * Create a list of Action panel and display this list
     * @param pList ArrayList of Action used to create ActionPanel
     * @throws AppError if critical error
     */
    public void createActionPanel(ArrayList<Action> pList) throws AppError{
        this.listActions = new ArrayList();
        this.wrapper.removeAll();
        for(Action a : pList){
            ActionPanel action = new ActionPanel(a, this.parent, this.controller);
            this.listActions.add(action);
            this.wrapper.add(action);
        }
        Dimension   dim = new Dimension(DIM_ACTION_PANEL.width, 
                                        DIM_ACTION_PANEL.height*pList.size());
        this.wrapper.setPreferredSize(dim);
        this.wrapper.revalidate();
        this.repaint();
    }
}


/**
 * <h1>ActionPanel</h1>
 * <p>
 * class ActionPanel<br/>
 * extends ContentPanel
 * </p>
 * <p>Display an action generated from file</p>
 * 
 * @date    May 9, 2015
 * @author  Constantin MASSON
 */
class ActionPanel extends ContentPanel implements MouseListener{
    //**************************************************************************
    // Constants - Variables
    //**************************************************************************
    private final Color     color_hover     = Color.GRAY;
    private final Color     color_default   = Color.LIGHT_GRAY;
    private final Color     color_running   = Color.GREEN;
    
    private     Color       color_current;
    private     Action      actionModel;
    private     boolean     isHover;
    
    
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