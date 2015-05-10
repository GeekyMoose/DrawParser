/*
 * Creation:    May 9, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */

package com.app.data;

import com.exceptions.AppError;
import com.exceptions.ExecError;
import com.exceptions.ForbiddenAction;
import com.exceptions.ParserException;
import com.main.DebugTrack;
import com.parser.asset.AbstractSyntax;
import com.parser.asset.Grammar;
import com.parser.asset.Grammar1;
import com.parser.asset.Parser;
import com.parser.asset.ValueEnvironment;
import com.parser.instructions.actions.ActionInstruction;
import java.io.File;
import java.util.ArrayList;



/**
 * <h1>AppData</h1>
 * <p>public class AppData</p>
 *
 * @date    May 9, 2015
 * @author  Constantin MASSON
 */
public class AppData {
    //**************************************************************************
    // Constants - Variables
    //**************************************************************************
    private     Grammar             grammer;
    private     Parser              parser;
    private     ArrayList<Action>   listActions;
    

    //**************************************************************************
    // Constructor - Initialization
    //**************************************************************************
    /**
     * Create a new AppData with default grammar and parser
     */
    public AppData(){
        this.grammer        = new Grammar1();
        this.parser         = new Parser(grammer);
        this.listActions    = new ArrayList();
    }
    

    //**************************************************************************
    // Functions
    //**************************************************************************
    /**
     * 
     * @param pFile File to process with parser
     * @throws ParserException  thrown if text given is not valid
     * @throws ForbiddenAction  thrown whether no grammar set
     * @throws ExecError        thrown if unable to load file (Wrong path etc)
     * @throws AppError         thrown if critical program error
     */
    public void runParser(File pFile) throws ForbiddenAction, ParserException, AppError, ExecError{
        AbstractSyntax abs = this.parser.startParser(Parser.MODE_GENERAL, pFile);
        abs.exec(new ValueEnvironment());
        ArrayList<ActionInstruction> list = abs.getActionsInstruction();
        DebugTrack.showActionInstructions(list);
        this.createListeAction(list);
    }
    
    /**
     * Create a list of action from ActionInstruction 
     * @param pList ArrayList with all ActionInstruction to process
     */
    public void createListeAction(ArrayList<ActionInstruction> pList){
        this.listActions = new ArrayList();
        for(ActionInstruction i : pList){
            this.listActions.add(new Action(i));
        }
    }
    
    /**
     * Run all action before pAction given in parameter (pAction included)
     * @param pAction last action to run
     */
    public void runAction(Action pAction){
        boolean actionReached = false;
        for(Action a : this.listActions){
            if(actionReached == false){
                a.setIsRunning(true);
            } else{
                a.setIsRunning(false);
            }
            if(a == pAction){
                actionReached = true;
            }
        }
    }
    
    
    //**************************************************************************
    // Getters - Setters
    //**************************************************************************
    /**
     * Return current list of actions
     * @return ArrayList of Action
     */
    public ArrayList<Action> getListActions(){
        return this.listActions;
    }
}
