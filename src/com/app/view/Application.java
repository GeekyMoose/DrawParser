/*
 * Creation:    May 8, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.app.view;

import com.app.data.AppController;
import com.app.data.Constants;
import com.exceptions.AppError;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;



/**
 * <h1>Application</h1>
 * <p>
 * public class Application<br/>
 * extends JFrame<br/>
 * implements Constants
 * </p>
 *
 * @date    May 8, 2015
 * @author  Constantin MASSON
 */
public class Application extends JFrame implements Constants{
    //**************************************************************************
    // Constants - Variables
    //**************************************************************************
    private     AppController       controller;
    
    private     HeadBar             headBar;
    private     DrawPanel           drawPanel;
    private     CodePanel           codePanel;
    private     ConsolPanel         consolPanel;
    private     InstructionsPanel   instructionsPanel;
    
    private     JPanel              wrap_dataPanel;
    private     JPanel              wrap_center;
    

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
        this.setPreferredSize(DIM_APP);
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
        this.instructionsPanel  = new InstructionsPanel(this, this.controller);
        this.drawPanel          = new DrawPanel(this, this.controller);
        this.codePanel          = new CodePanel(this, this.controller);
        this.consolPanel        = new ConsolPanel(this, this.controller);
        
        this.wrap_dataPanel     = new JPanel();
        this.wrap_center        = new JPanel();
        
        this.wrap_dataPanel     .setLayout(new BorderLayout());
        this.wrap_center        .setLayout(new BorderLayout());
        
        this.wrap_dataPanel     .setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.wrap_center        .setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.wrap_dataPanel     .setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        this.wrap_dataPanel     .add(this.codePanel, BorderLayout.CENTER);
        this.wrap_dataPanel     .add(this.consolPanel, BorderLayout.SOUTH);
        this.wrap_center        .add(this.drawPanel, BorderLayout.CENTER);
        this.wrap_center        .add(this.instructionsPanel, BorderLayout.EAST);
        
        
        this.setLayout(new BorderLayout());
        this.add(this.headBar, BorderLayout.NORTH);
        this.add(this.wrap_center, BorderLayout.CENTER);
        this.add(this.wrap_dataPanel, BorderLayout.WEST);
    }
    
    
    //**************************************************************************
    //Functions 
    //**************************************************************************
    /**
     * Write a cmd in consol
     * @param pStr String to write
     */
    public void writeCmd(String pStr){
        this.consolPanel.writeConsol(pStr);
    }
    
    
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
    
    /**
     * Return current application consol panel
     * @return Consol Panel for this Application
     */
    public ConsolPanel getConsolPanel(){
        return this.consolPanel;
    }
    
    /**
     * Return Application HeadBar
     * @return HeadBar
     */
    public HeadBar getHeadBar(){
        return this.headBar;
    }
    
    /**
     * Return drawPanel
     * @return DrawPanel
     */
    public DrawPanel getDrawPanel(){
        return this.drawPanel;
    }
    
    /**
     * Return application Instruction Panel
     * @return InstructionsPanel of this application
     */
    public InstructionsPanel getInstructionPanel(){
        return this.instructionsPanel;
    }
}
