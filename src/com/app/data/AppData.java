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
import com.parser.asset.Grammar2;
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
    private     ValueEnvironment    env; //Current variable environment
    

    //**************************************************************************
    // Constructor - Initialization
    //**************************************************************************
    /**
     * Create a new AppData with default grammar and parser
     */
    public AppData(){
        this.grammer        = new Grammar2();
        this.parser         = new Parser(grammer);
        this.listActions    = new ArrayList();
        this.env            = new ValueEnvironment();
    }
    

    //**************************************************************************
    // Parser Functions
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
        this.env            = new ValueEnvironment(); //Reset env
        AbstractSyntax abs  = this.parser.startParser(Parser.MODE_GENERAL, pFile);
        abs.exec(this.env);
        ArrayList<ActionInstruction> list = abs.getActionsInstruction();
        DebugTrack.showActionInstructions(list);
        this.createListeAction(list);
    }
    
    public void runInterpreterParser(File pFile) 
    throws ForbiddenAction, ParserException, ExecError, AppError{
        AbstractSyntax abs  = this.parser.startParser(Parser.MODE_INTERPRETER, pFile);
        abs.exec(this.env);
        ArrayList<ActionInstruction> list = abs.getActionsInstruction();
        DebugTrack.showActionInstructions(list);
        this.addActions(list);
    }
    

    //**************************************************************************
    // Actions Functions
    //**************************************************************************
    /**
     * Create a list of action from ActionInstruction 
     * @param pList ArrayList with all ActionInstruction to process
     * @throws AppError
     */
    public void createListeAction(ArrayList<ActionInstruction> pList) throws AppError{
        this.listActions    = new ArrayList();
        Action previous     = new Action();//Create the origin
        this.listActions.add(previous);
        for(ActionInstruction i : pList){
            Action a = new Action(i, previous, Action.ORIGNAL);
            this.listActions.add(a);
            previous = a;
        }
    }
    
    /**
     * Add action at the end of current list of action. If current list of 
     * action is empty, addActions create a new list with from the list 
     * given in parameter
     * @param pList list of ActionInstruction to add (Or set if current is empty)
     * @throws AppError thrown is error during creation
     */
    public void addActions(ArrayList<ActionInstruction> pList) throws AppError{
        //Current list is empty, action to ad is the first one
        if(this.listActions == null || this.listActions.isEmpty()){
            this.createListeAction(pList);
        }
        else{
            Action previous = this.listActions.get(this.listActions.size()-1); //Last current
            for(ActionInstruction i: pList){
                Action a = new Action(i, previous, Action.INTERPRETER);
                this.listActions.add(a);
                previous = a;
            }
        }
    }
    
    /**
     * Run all action before pAction given in parameter (pAction included)
     * @param pAction last action to run
     */
    public void runAction(Action pAction){
        boolean actionReached = false;
        for(Action a : this.listActions){
            a.calculate();
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
    
    /**
     * Change used mode of an action. then Recalculate all position 
     * @param pAction       action to modify
     * @param pIsUsed       used value (True or false)
     */
    public void useAction(Action pAction, boolean pIsUsed){
        for(Action a : this.listActions){
            if(a == pAction){
                a.setIsUsed(pIsUsed);
            }
            a.calculate(); //Recalculate value after modif
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
