/*
 * Creation:    May 9, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */

package com.app.data;

import com.app.view.Application;
import com.exceptions.AppError;
import com.exceptions.ExecError;
import com.exceptions.ForbiddenAction;
import com.exceptions.ParserException;
import com.main.DebugTrack;
import java.awt.Dimension;
import java.io.File;
import javax.swing.JFileChooser;



/**
 * <h1>AppController</h1>
 * <p>public class AppController</p>
 *
 * @date    May 9, 2015
 * @author  Constantin MASSON
 */
public class AppController implements Constants{
    //**************************************************************************
    // Constants - Variables
    //**************************************************************************
    private Application     view;
    private AppData         model;
    
    
    
    //**************************************************************************
    // Constructor - Initialization
    //**************************************************************************
    /**
     * Create a new controller for Application
     * @param pAppData  model of application
     * @throws AppError thrown if model is null
     */
    public AppController(AppData pAppData) throws AppError{
        if(pAppData==null){
            throw new AppError("Invalid parameter : null parameter in controller");
        }
        this.model  = pAppData;
    }
    

    //**************************************************************************
    // Functions
    //**************************************************************************
    public void setTextPanelText(String pStr){
        this.view.getCodePanel().setText(pStr);
    }
    
    /**
     * Load a file using JFileChooser. If not valid, throw exception
     * @throws ForbiddenAction thrown if unable to load file
     */
    public void loadFile() throws ForbiddenAction{
        String          txt     = new String();
        JFileChooser    chooser = new JFileChooser();
        chooser.setPreferredSize (new Dimension (500, 300));
        int             choice  = chooser.showOpenDialog(null);
        if (choice == JFileChooser.APPROVE_OPTION) {
            File    selection   = chooser.getSelectedFile();
            String  str         = Asset.getStrFromFile(selection);
            this.view.getCodePanel().setText(str);
        }
    }
    
    /**
     * Run the parser on current code in CodeArea. It will previously create a 
     * file with current CodeArea content 
     * @throws ParserException  thrown if text given is not valid
     * @throws ForbiddenAction  thrown whether no grammar set
     * @throws ExecError        thrown if unable to load file (Wrong path etc)
     * @throws AppError         thrown if critical program error
     */
    public void runCodePanelParser() throws ExecError, ForbiddenAction, ParserException, AppError{
        File f = this.view.getCodePanel().createFile(DEFAULT_TMP_FILE);
        DebugTrack.showDebugMsg("Tmp file created : "+f.getAbsolutePath());
        this.model.runParser(f);
        this.view.getInstructionPanel().createActionPanel(this.model.getListActions());
        this.view.repaint();
    }
    
    /**
     * Run till action given in parameter
     * @param pAction last action to run (Run all action before)
     */
    public void runAction(Action pAction){
        this.model.runAction(pAction);
        this.view.repaint();
    }
    

    //**************************************************************************
    // Getters - Setters
    //**************************************************************************
    /**
     * Set Application view for this controller. If null given, do nothing
     * @param pApp Application view to add in this controller
     */
    public void setView(Application pApp){
        if(pApp != null){
            this.view = pApp;
        }
    }
}
