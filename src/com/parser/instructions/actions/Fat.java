/*
 * Creation:    May 10, 2015
 * 
 */

package com.parser.instructions.actions;

import com.exceptions.ForbiddenAction;
import com.parser.asset.Expression;
import com.parser.asset.ValueEnvironment;
import java.util.ArrayList;



/**
 * <h1>Fat</h1>
 * <p>
 * public class Fat<br/>
 * extends ActionInstruction
 * </p>
 * <p>Modify thickness of draw line</p>
 *
 * @date    May 10, 2015
 * @author  Constantin MASSON
 */
public class Fat extends ActionInstruction{
    //**************************************************************************
    // Constants - Variables
    //**************************************************************************
    private Expression  exp1;
    private int         thickness;
    
    
    //**************************************************************************
    // Constructor - Initialization
    //**************************************************************************
    public Fat(Expression pExp1){
        this.exp1       = pExp1;
        this.thickness  = 1;
    }
    

    //**************************************************************************
    // Functions
    //**************************************************************************
    @Override
    public void exec(ValueEnvironment env) throws ForbiddenAction{
        this.thickness = this.exp1.eval(env);
    }

    @Override
    public void addActionInstruction(ArrayList<ActionInstruction> pList){
        pList.add(this);
    }
    
    
    //**************************************************************************
    // Getters - Setters
    //**************************************************************************
    @Override
    public int getTypeAction(){
        return ACTION_FAT;
    }

    @Override
    public int getValue(){
        return this.thickness;
    }
    
    @Override
    public String getDescription(){
        return "Thickness ("+this.thickness+")";
    }
}
