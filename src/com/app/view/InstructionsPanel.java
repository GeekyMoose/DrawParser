/*
 * Creation:    May 9, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.app.view;

import com.app.data.AppController;
import com.app.data.Constants;
import com.exceptions.AppError;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;



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
    
    
    //**************************************************************************
    // Constructor - Initialization
    //**************************************************************************
    public InstructionsPanel(Application pParent, AppController pController) throws AppError{
        super(pParent, pController);
        this.listActions = new ArrayList();
        this.initComponents();
    }
    
    private void initComponents(){
        this.setLayout(new FlowLayout());
        this.setPreferredSize(DIM_INST_PANEL);
    }
}


/**
 * <h1>ActionPanel</h1>
 * <p>
 * class ActionPanel<br/>
 * extends JPanel
 * </p>
 * <p>Display an action generated from file</p>
 * 
 * @date    May 9, 2015
 * @author  Constantin MASSON
 */
class ActionPanel extends JPanel implements MouseListener{
    private final Color     color_hover     = Color.LIGHT_GRAY;
    private final Color     color_default   = Color.GRAY;
    private final Color     color_selected  = Color.CYAN;
    private final Color     color_valid     = Color.GREEN;
    private final Color     color_other     = Color.DARK_GRAY;
    
    
    public ActionPanel(){
        this.setPreferredSize(Constants.DIM_ACTION_PANEL);
    }

    @Override
    public void mouseClicked(MouseEvent e){
    }

    @Override
    public void mousePressed(MouseEvent e){
    }

    @Override
    public void mouseReleased(MouseEvent e){
    }

    @Override
    public void mouseEntered(MouseEvent e){
        this.setBackground(Color.DARK_GRAY);
    }

    @Override
    public void mouseExited(MouseEvent e){
    }
}