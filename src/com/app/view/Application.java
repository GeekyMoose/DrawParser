/*
 * Creation:    May 8, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.app.view;

import com.app.data.AppController;
import com.exceptions.AppError;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;



/**
 * <h1>Application</h1>
 * <p>public class Application</p>
 *
 * @date    May 8, 2015
 * @author  Constantin MASSON
 */
public class Application extends JFrame{
    //**************************************************************************
    // Constants - Variables
    //**************************************************************************
    public static final Dimension   DIM_DEFAULT   = new Dimension(1000, 700);
    public static final Dimension   DIM_MIN       = new Dimension(300, 300);
    public static final Dimension   DIM_MAX       = new Dimension(1500, 1000);
    private     AppController       controller;
    
    private     HeadBar             headBar;
    private     DrawPanel           drawPanel;
    private     CodePanel           codePanel;
    private     ConsolPanel         consolPanel;
    private     InstructionsPanel   instructionsPanel;
    
    private     JPanel              wrap_dataPanel;
    

    //**************************************************************************
    // Constructor - Initialization
    //**************************************************************************
    /**
     * Create a new displayable Application
     * @param pController controller for application
     * @throws AppError thrown if error during creation
     */
    public Application(AppController pController) throws AppError{
        if(pController == null){ 
            throw new AppError("Invalid parameter : null given"); 
        }
        this.controller = pController;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setPreferredSize(DIM_DEFAULT);
        this.setMaximumSize(DIM_MAX);
        this.setMinimumSize(DIM_MIN);
        this.initComponents();
    }
    
    /*
     * Initialize all components
     * @throws AppError if error during components creation
     */
    private void initComponents() throws AppError{
        this.headBar            = new HeadBar(this, this.controller);
        this.drawPanel          = new DrawPanel(this, this.controller);
        this.codePanel          = new CodePanel(this, this.controller);
        this.consolPanel        = new ConsolPanel(this, this.controller);
        this.instructionsPanel  = new InstructionsPanel(this, this.controller);
        this.wrap_dataPanel     = new JPanel();
        
        this.wrap_dataPanel.setLayout(new GridLayout(2,1));
        this.wrap_dataPanel.add(this.codePanel);
        this.wrap_dataPanel.add(this.consolPanel);
        
        this.headBar.setBackground(Color.red);
        this.codePanel.setBackground(Color.BLUE);
        this.consolPanel.setBackground(Color.CYAN);
        this.drawPanel.setBackground(Color.DARK_GRAY);
        
        
        this.setLayout(new BorderLayout());
        this.add(this.headBar, BorderLayout.NORTH);
        this.add(this.drawPanel, BorderLayout.CENTER);
        this.add(this.wrap_dataPanel, BorderLayout.WEST);
        this.add(this.instructionsPanel, BorderLayout.EAST);
    }
    
    
    
    
    

    //**************************************************************************
    // Functions
    //**************************************************************************
    
    
    
    
    

    //**************************************************************************
    // Getters - Setters
    //**************************************************************************
    /**
     * Return application textPanel
     * @return CodePanel
     */
    public CodePanel getCodePanel(){
        return this.codePanel;
    }
}
