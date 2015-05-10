/*
 * Creation:    May 9, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.app.view;

import com.app.data.AppController;
import com.app.data.Constants;
import com.exceptions.AppError;
import com.exceptions.ExecError;
import com.exceptions.ForbiddenAction;
import com.exceptions.ParserException;
import com.main.DebugTrack;
import com.main.UiDialog;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;




/**
 * <h1>HeadBar</h1>
 * <p>
 * public class HeadBar<br/>
 * extends ContentPanel
 * </p>
 * <p>HeadBar display a bar with action to do, button to manage program etc</p>
 * 
 * @author Constantin MASSON
 */
public class HeadBar extends ContentPanel implements Constants{
    //**************************************************************************
    // Constants - Variables
    //**************************************************************************
    private JPanel      wrapper_button;
    private JButton     butt_run;
    private JButton     butt_load;
    private JButton     butt_print;
    
    private JPanel      wrapper_data;
    private JPanel      wrapper_state;
    private JLabel      l_txtState;
    
    
    //**************************************************************************
    // Constructor - Initialization
    //**************************************************************************
    /**
     * Create a new Headbar
     * @param pParent       parent application where headbar is placed
     * @param pController   controller for head bar
     * @throws AppError thrown if unable to create bar (Critical error, param null)
     */
    public HeadBar(Application pParent, AppController pController) throws AppError{
        super(pParent, pController);
        this.setPreferredSize(DIM_HEAD_BAR); //Width = application width
        this.initComponents();
        this.setButtonActions();
    }
    
    private void initComponents(){
        this.wrapper_button     = new JPanel();
        this.butt_run           = new JButton("Run");
        this.butt_load          = new JButton("Load");
        this.butt_print         = new JButton("Print");
        this.wrapper_data       = new JPanel();
        this.wrapper_state      = new JPanel();
        this.l_txtState         = new JLabel();
        
        this.wrapper_button     .setLayout(new FlowLayout());
        this.wrapper_data       .setLayout(new BorderLayout());
        this.wrapper_state      .setLayout(new FlowLayout());
        this                    .setLayout(new BorderLayout());
        
        this.wrapper_data       .setBorder(BorderFactory.createEmptyBorder(2, 10, 2, 25));
        this.wrapper_state      .setBorder(BorderFactory.createMatteBorder(1, 2, 1, 2, Color.BLACK));
        this.wrapper_state      .setPreferredSize(DIM_DATA_BOX);
        
        this.wrapper_button     .add(this.butt_run);
        this.wrapper_button     .add(this.butt_load);
        this.wrapper_button     .add(this.butt_print);
        this.wrapper_state      .add(this.l_txtState);
        this.wrapper_data       .add(this.wrapper_state, BorderLayout.CENTER);
        this                    .add(this.wrapper_data, BorderLayout.WEST);
        this                    .add(this.wrapper_button, BorderLayout.CENTER);
    }
    
    /*
     * Define action when button selected
     */
    private void setButtonActions(){
        this.butt_load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    controller.loadFile();
                } catch(ForbiddenAction ex) {
                    DebugTrack.showErrMsg(ex.getMessage());
                    UiDialog.showError("Error", ex.getMessage());
                }
            }
        });
        
        this.butt_run.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                boolean isValidText = false;
                try {
                    controller.runGeneralModeParser();
                    isValidText = true;
                    updateTextState(true, "Valid!");
                } 
                catch(ExecError ex) {
                    updateTextState(false, "Not Valid!!");
                    DebugTrack.showErrMsg(ex.getMessage());
                    UiDialog.showError("Error", ex.getMessage());
                } 
                catch(ForbiddenAction ex) {
                    updateTextState(false, "Not Valid!!");
                    DebugTrack.showErrMsg(ex.getMessage());
                    UiDialog.showWarning("Warning", ex.getMessage());
                } 
                catch(ParserException ex) {
                    updateTextState(false, "Not Valid!!");
                    UiDialog.showWarning("Warning", ex.getMessage());
                } 
                catch(AppError ex) {
                    updateTextState(false, "Not Valid!!");
                    UiDialog.showError("Warning", ex.getMessage());
                }
            }
        });
        
        this.butt_print.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                controller.takePicture();
            }
        });
    }
    
    
    
    //**************************************************************************
    // Constructor - Initialization
    //**************************************************************************
    /**
     * Update the text displayed about text state (Valid or not valid etc). 
     * boolean given set if state is valid or not. String given will be displayed 
     * on the text state panel
     * @param pIsValid  true if valid, otherwise, false
     * @param pStr      string to display
     */
    public void updateTextState(boolean pIsValid, String pStr){
        if(pIsValid==true){
            this.wrapper_state.setBackground(Color.GREEN);
            this.l_txtState.setText(pStr);
        } 
        else{
            this.wrapper_state.setBackground(Color.RED);
            this.l_txtState.setText(pStr);
        }
    }
}