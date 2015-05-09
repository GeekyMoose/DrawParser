/*
 * Creation:    May 9, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */

package com.parser.instructions.actions;

import com.exceptions.ForbiddenAction;
import com.parser.asset.Expression;
import com.parser.asset.ValueEnvironment;
import com.parser.instructions.asset.Instruction;
import java.util.ArrayList;



/**
 * <h1>Down</h1>
 * <p>
 * public class Down<br/>
 * extends ActionInstruction
 * </p>
 *
 * @date    May 9, 2015
 * @author  Constantin MASSON
 */
public class Up extends ActionInstruction{
    //**************************************************************************
    // Constants - Variables
    //**************************************************************************
	private Expression 	exp;
    

    //**************************************************************************
    // Constructor - Initialization
    //**************************************************************************
    public Up(){
    
    }
    

    //**************************************************************************
    // Functions
    //**************************************************************************
    @Override
    public void exec(ValueEnvironment env) throws ForbiddenAction{
    }

    @Override
    public void addActionInstruction(ArrayList<ActionInstruction> pList){
        pList.add(this);
    }
    

    //**************************************************************************
    // Getters - Setters
    //**************************************************************************
    @Override
    public String getDescription(){
        return "Up";
    }
}