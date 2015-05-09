/*
 * Creation:    May 8, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.app.view;

import com.app.data.AppController;
import com.app.data.Constants;
import com.exceptions.AppError;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



/**
 * <h1>ConsolPanel</h1>
 * <p>
 * public class ConsolPanel<br/>
 * extends ContentPanel
 * </p>
 * <p>ConsolPanel display a consol</p>
 * 
 * @author Constantin MASSON
 */
public class ConsolPanel extends ContentPanel implements Constants{
    //**************************************************************************
    // Constants and variables
    //**************************************************************************
    private JTextArea       screenConsol;
    private JTextField      command;
    private JScrollPane     scroll;
    private JPanel          wrapper;
    
    
    //**************************************************************************
    // Constructor - Initialization
    //**************************************************************************
    /**
     * Create a new ConsolPanel
     * @param pParent       Application used 
     * @param pController   Controller Application
     * @throws AppError thrown if Application or controller null
     */
    public ConsolPanel(Application pParent, AppController pController) throws AppError{
        super(pParent, pController);
        this.setPreferredSize(DIM_CONSOL_PANEL);
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.initComponents();
        this.setActionCommand();
    }
    
    private void initComponents(){
        this.wrapper        = new JPanel();
        this.screenConsol   = new JTextArea();
        this.command        = new JTextField();
        this.scroll         = new JScrollPane(this.screenConsol);
        
        this.scroll         .setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.scroll         .setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.screenConsol   .setEditable(false);
        this.screenConsol   .setTabSize(4);
        this.screenConsol   .setMargin(new Insets(10,10,10,10));
        this.command        .setMargin(new Insets(10,10,10,10));
        
        
        this                .setLayout(new BorderLayout());
        this.wrapper        .setLayout(new BorderLayout());
        
        this.wrapper        .add(this.scroll, BorderLayout.CENTER);
        this.wrapper        .add(this.command, BorderLayout.SOUTH);
        this                .add(this.wrapper);
    }
    
    /**
     * Set action when tape in the command JTextField
     */
    private void setActionCommand(){
        this.command.addKeyListener(
            new KeyListener() {
                @Override
                public void keyPressed(KeyEvent e) {
                    int key = e.getKeyCode();
                    if (key == KeyEvent.VK_ENTER) {
                        String cmd = command.getText();
                        writeConsol(cmd);
                        command.setText("");
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {
                }

                @Override
                public void keyTyped(KeyEvent e) {
                }
            }
        );
    }
    
    
    //**************************************************************************
    // Functions screen 
    //**************************************************************************
    /**
     * Write a string in consol. Create a line \n after
     * @param pStr String to write, do nothing if null
     */
    public void writeConsol(String pStr){
        if(pStr != null){
            this.screenConsol.append(pStr+"\n");
            this.screenConsol.setCaretPosition(this.screenConsol.getText().length());
        }
    }
}