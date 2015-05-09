/*
 * Creation:    May 9, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.parser.instructions.asset;

import com.exceptions.ForbiddenAction;
import com.parser.asset.AbstractSyntax;
import com.parser.asset.Expression;
import com.parser.asset.ValueEnvironment;
import com.parser.instructions.actions.ActionInstruction;
import java.util.ArrayList;


/**
 * <h1></h1>
 * <p>
 * public class WhileInstruction<br/>
 * extends Instruction
 * </p>
 * <p>While instruction</p>
 * 
 * @date    May 9, 2015
 * @author  Constantin MASSON
 */
public class WhileInstruction extends Instruction{
    //**************************************************************************
    // Constants - Variables
    //**************************************************************************
    private AbstractSyntax  abs;
    private Expression      exp1;
    private Expression      exp2;
    private int             nbLoop;
    
    
    //**************************************************************************
    // Constructors - Initialization
    //**************************************************************************
    public WhileInstruction(Expression pExp1, Expression pExp2, AbstractSyntax pAbs){
        this.abs    = pAbs;
        this.exp1   = pExp1;
        this.exp2   = pExp2;
        this.nbLoop = 0;
    }

    
    //**************************************************************************
    // Constants - Variables
    //**************************************************************************
    @Override
    public void exec(ValueEnvironment env) throws ForbiddenAction{
        while(this.exp1.eval(env) == this.exp2.eval(env)){
            this.nbLoop++;
        }
    }

    @Override
    public void addActionInstruction(ArrayList<ActionInstruction> pList){
        ArrayList<ActionInstruction> list = this.abs.getActionsInstruction();
        for(int k=0; k<this.nbLoop; k++){
            pList.add(list.get(k));
        }
    }

    @Override
    public String toString(){
        String str = super.toString();
        str += "\n***** While loop instruction with abstract syntax : \n"+abs.toString();
        str += "***** End while loop ***** ";
        return str;
    }
}
