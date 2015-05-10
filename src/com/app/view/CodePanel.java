/*
 * Creation:    May 9, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.app.view;

import com.app.data.AppController;
import com.app.data.Asset;
import com.app.data.Constants;
import com.exceptions.AppError;
import com.exceptions.ExecError;
import com.exceptions.ForbiddenAction;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JLabel;
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
public class CodePanel extends ContentPanel implements Constants{
    //**************************************************************************
    // Constants - Variables
    //**************************************************************************
    private     JPanel          wrapper;
    private     JPanel          wrap_data;
    
    private     JTextArea       text;
    private     JScrollPane     scroll;
    
    private     JLabel          l_titleNbLines;
    private     JLabel          l_titleNbChar;
    private     JLabel          l_nbLines;
    private     JLabel          l_nbChar;
    
    
    
    
    
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
        this.setPreferredSize(DIM_CODE_PANEL);
        this.initComponents();
        this.updateNbChar();
        this.updateNbLines();
        this.setKeyActions();
    }
    
    /*
     * Initialize all components as wrapper / title etc
     */
    private void initComponents(){
        this.wrapper        = new JPanel();
        this.text           = new JTextArea();
        this.scroll         = new JScrollPane(this.text);
        
        this.wrap_data      = new JPanel();
        this.l_nbLines      = new JLabel("0");
        this.l_nbChar       = new JLabel("0");
        this.l_titleNbLines = new JLabel("Lines : ");
        this.l_titleNbChar  = new JLabel("Char : ");
        
        this.scroll         .setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.scroll         .setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.text           .setEditable(true);
        this.text           .setTabSize(4);
        this.text           .setMargin(new Insets(10,10,10,10));
        
        this                .setLayout(new BorderLayout());
        this.wrapper        .setLayout(new BorderLayout());
        this.wrap_data      .setLayout(new FlowLayout());
        
        this.wrap_data      .add(this.l_titleNbLines);
        this.wrap_data      .add(this.l_nbLines);
        this.wrap_data      .add(this.l_titleNbChar);
        this.wrap_data      .add(this.l_nbChar);
        this.wrapper        .add(this.wrap_data,BorderLayout.SOUTH);
        this.wrapper        .add(this.scroll,   BorderLayout.CENTER);
        this                .add(this.wrapper,  BorderLayout.CENTER);
    }
    
    /**
     * Set action when tape in the textArea (Update data)
     */
    private void setKeyActions(){
        this.text.addKeyListener(
            new KeyListener() {
                @Override
                public void keyPressed(KeyEvent e) {
                    updateNbChar();
                    updateNbLines();
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    updateNbChar();
                    updateNbLines();
                }

                @Override
                public void keyTyped(KeyEvent e) {
                }
            }
        );
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
        return Asset.getFileFromJTextComp(pPath, this.text);
    }
    
    
    //**************************************************************************
    // Data function
    //**************************************************************************
    /**
     * Update display of number of lines. 
     * @return int number of line in the HTextArea
     */
    private int updateNbLines(){
        int nbLines = this.text.getLineCount();
        this.l_nbLines.setText(String.valueOf(nbLines));
        this.repaint();
        return nbLines;
    }
    
    /**
     * Update display number of char in text area
     * @return int number of char in the HTextArea
     */
    private int updateNbChar(){
        int nb = this.text.getText().length();
        this.l_nbChar.setText(String.valueOf(nb));
        return nb;
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
            this.updateNbChar();
            this.updateNbLines();
            return true;
        }
        return false;
    }
}