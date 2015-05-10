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
 * <h1>Move</h1>
 * <p>
 * public class Move<br/>
 * extends ActionInstruction
 * </p>
 *
 * @date    May 9, 2015
 * @author  Constantin MASSON
 */
public class Move extends ActionInstruction{
    //**************************************************************************
    // Constants - Variables
    //**************************************************************************
	private Expression 	exp;
    private int         distance;
    

    //**************************************************************************
    // Constructor - Initialization
    //**************************************************************************
	public Move(Expression e) {
		this.exp        = e;
        this.distance   = 0;
	}
    
    private Move(Expression e, int pDistance){
		this.exp        = e;
        this.distance   = pDistance;
    }
    

    //**************************************************************************
    // Functions
    //**************************************************************************
    @Override
    public void exec(ValueEnvironment env) throws ForbiddenAction{
        this.distance = this.exp.eval(env);
    }
    
    @Override
    public void addActionInstruction(ArrayList<ActionInstruction> pList){
        pList.add(this);
    }
    
    
    //**************************************************************************
    // Getters - Setters
    //**************************************************************************
    @Override
    public int getValue(){
        return this.distance;
    }
    
    @Override
    public String getDescription(){
        return "Move ("+this.distance+")";
    }
    
    @Override
    public Instruction getCopy(){
        return new Move(this.exp, this.distance);
    }
    
    @Override
    public int getTypeAction(){
        return ACTION_MOVE;
    }
}
