/*
 * Creation:    May 9, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */

package com.app.data;

import com.exceptions.AppError;
import com.exceptions.ExecError;
import com.exceptions.ForbiddenAction;
import com.exceptions.ParserException;
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
    private     Grammar     grammer;
    private     Parser      parser;
    

    //**************************************************************************
    // Constructor - Initialization
    //**************************************************************************
    /**
     * Create a new AppData with default grammar and parser
     */
    public AppData(){
        this.grammer    = new Grammar1();
        this.parser     = new Parser(grammer);
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
        System.out.println("DEBUG in AppData : "+abs.toString());
        
        System.out.println("\n\n ***** DEBUG in AppData");
        ArrayList<ActionInstruction> list = abs.getActionsInstruction();
        for(ActionInstruction i : list){
            System.out.println(i.toString());
        }
        System.out.println("\n ***** END DEBUG *****\n\n");
    }
    
    
    //**************************************************************************
    // Getters - Setters
    //**************************************************************************
}
