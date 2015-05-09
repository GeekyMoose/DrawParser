/*
 * Creation:    May 9, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.app.view;

import com.app.data.AppController;
import com.exceptions.AppError;
import com.exceptions.ExecError;
import com.exceptions.ForbiddenAction;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;




/**
 * <h1>CodePanel</h1>
 * <p>
 * public class CodePanel<br/>
 * extends ContentPanel
 * </p>
 * <p>Display a text area where user can write code to process</p>
 * 
 * @author Constantin MASSON
 */
public class CodePanel extends ContentPanel{
    //**************************************************************************
    // Constants - Variables
    //**************************************************************************
    private     JPanel          wrapper;
    private     JTextArea       text;
    private     JScrollPane     scroll;
    
    
    //**************************************************************************
    // Constructor - Initialization
    //**************************************************************************
    /**
     * Create a new TextPanel 
     * @param pParent       Application parent of this TextPanel
     * @param pController   Application controller
     * @throws AppError thrown if controller or application is null
     */
    public CodePanel(Application pParent, AppController pController) throws AppError{
        super(pParent, pController);
        this.setPreferredSize(new Dimension(300, 500));
        this.initComponents();
    }
    
    private void initComponents(){
        this.wrapper    = new JPanel();
        this.text       = new JTextArea();
        this.scroll     = new JScrollPane(this.text);
        
        this.scroll     .setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.scroll     .setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.text       .setEditable(true);
        
        this            .setLayout(new BorderLayout());
        this.wrapper    .setLayout(new BorderLayout());
        
        this.wrapper    .add(this.scroll, BorderLayout.CENTER);
        this            .add(this.wrapper, BorderLayout.CENTER);
    }
    
    
    //**************************************************************************
    // Functions
    //**************************************************************************
    /**
     * Create a file with current TextArea content. File is created using path 
     * given as parameter. If path is not valid, throw error
     * @param pPath path and name where to create file (ex: /home/rabbit/myFile.txt)
     * @return File created 
     * @throws ExecError thrown if error during file creation
     * @throws ForbiddenAction throw if not valid name
     */
    public File createFile(String pPath) throws ExecError, ForbiddenAction{
        if(pPath == null){
            throw new ForbiddenAction("Unable to create file, not valid name");
        }
        File file = new File(pPath);
        BufferedWriter out;
        try {
            out = new BufferedWriter(new FileWriter(file));
            this.text.write(out);
            out.flush();
            out.close();
        } catch(IOException ex) {
            file.delete();
            throw new ExecError("Unable to create file");
        }
        return file;
    }
    
    
    //**************************************************************************
    // Getters - Setters
    //**************************************************************************
    /**
     * Replace current text by new text.
     * @param pStr new text (if null given, do nothing and return false)
     * @return true if replaced, otherwise, return false 
     */
    public boolean setText(String pStr){
        if(pStr != null){
            this.text.setText(pStr);
            return true;
        }
        return false;
    }
}