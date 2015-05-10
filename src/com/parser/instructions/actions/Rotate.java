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
 * <h1>Rotate</h1>
 * <p>
 * public class Rotate<br/>
 * extends ActionInstruction
 * </p>
 *
 * @date    May 9, 2015
 * @author  Constantin MASSON
 */
public class Rotate extends ActionInstruction{
    //**************************************************************************
    // Constants - Variables
    //**************************************************************************
	private Expression 	exp;
    private int         angle;
    

    //**************************************************************************
    // Constructor - Initialization
    //**************************************************************************
	public Rotate(Expression e) {
		this.exp        = e;
        this.angle      = 0;
	}
    
    private Rotate(Expression e, int pAngle){
        this.exp        = e;
        this.angle      = pAngle;
    }
    

    //**************************************************************************
    // Functions
    //**************************************************************************
    @Override
    public void exec(ValueEnvironment env) throws ForbiddenAction{
        this.angle = this.exp.eval(env);
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
        return this.angle;
    }
    
    @Override
    public String getDescription(){
        return "Rotate ("+this.angle+")";
    }
    
    @Override
    public Instruction getCopy(){
        return new Rotate(this.exp, this.angle);
    }
    
    @Override
    public int getTypeAction(){
        return ACTION_ROTATE;
    }
}
