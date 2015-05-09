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
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;




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
    private JButton     butt_run;
    private JButton     butt_load;
    private JButton     butt_print;
    
    
    //**************************************************************************
    // Constructor - Initialization
    //**************************************************************************
    public HeadBar(Application pParent, AppController pController) throws AppError{
        super(pParent, pController);
        this.setPreferredSize(DIM_HEAD_BAR); //Width = application width
        this.initComponents();
        this.setButtonActions();
    }
    
    private void initComponents(){
        this.butt_run   = new JButton("Run");
        this.butt_load  = new JButton("Load");
        this.butt_print = new JButton("Print");
        this            .setLayout(new FlowLayout());
        this            .add(this.butt_run);
        this            .add(this.butt_load);
        this            .add(this.butt_print);
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
                    controller.runCodePanelParser();
                    isValidText = true;
                } 
                catch(ExecError ex) {
                    DebugTrack.showErrMsg(ex.getMessage());
                    UiDialog.showError("Error", ex.getMessage());
                } 
                catch(ForbiddenAction ex) {
                    DebugTrack.showErrMsg(ex.getMessage());
                    UiDialog.showWarning("Warning", ex.getMessage());
                } 
                catch(ParserException ex) {
                    UiDialog.showWarning("Warning", ex.getMessage());
                } 
                catch(AppError ex) {
                    UiDialog.showError("Warning", ex.getMessage());
                } 
                finally{
                    if(isValidText){
                    UiDialog.showInfoDialog("Valid", "Text is valid");
                    }
                }
            }
        });
    }
}