/*
 * Creation:    May 9, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.app.view;

import com.app.data.AppController;
import com.exceptions.AppError;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;




/**
 * <h1>TextPanel</h1>
 * <p>
 * class TextPanel<br/>
 * extends ContentPanel
 * </p>
 * <p>Display a text area where user can write code to process</p>
 * 
 * @author Constantin MASSON
 */
class TextPanel extends ContentPanel{
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
    public TextPanel(Application pParent, AppController pController) throws AppError{
        super(pParent, pController);
        this.setPreferredSize(new Dimension(300, 0));
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
    // Constructor - Initialization
    //**************************************************************************
}