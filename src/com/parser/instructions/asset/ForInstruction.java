/*
 * Creation:    May 9, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.parser.instructions.asset;

import com.exceptions.ForbiddenAction;
import com.exceptions.ParserException;
import com.parser.asset.AbstractSyntax;
import com.parser.asset.Expression;
import com.parser.asset.ValueEnvironment;
import com.parser.instructions.actions.ActionInstruction;
import java.util.ArrayList;


/**
 * <h1>ForInstruction</h1>
 * <p>
 * public class ForInstruction<br/>
 * extends Instruction
 * </p>
 * <p>Loop</p>
 * 
 * @date    May 9, 2015
 * @author  Constantin MASSON
 */
public class ForInstruction extends Instruction{
    //**************************************************************************
    // Constants - Variables
    //**************************************************************************
    private AbstractSyntax  abs;
    private Expression      exp1;
    private int             nbLoop;
    
    private ArrayList<AbstractSyntax> listAbs;
    
    
    //**************************************************************************
    // Constructor - Initialization
    //**************************************************************************
    public ForInstruction(Expression pExp1, AbstractSyntax pAbs){
        this.abs        = pAbs;
        this.exp1       = pExp1;
        this.nbLoop     = 0;
        this.listAbs    = new ArrayList();
    }

    
    //**************************************************************************
    // Function from Instruction
    //**************************************************************************
    @Override
    public void exec(ValueEnvironment env) throws ForbiddenAction{
        try {
            this.nbLoop = this.exp1.eval(env);
            for(int k=0; k<this.nbLoop; k++){
                abs.exec(env);
                this.listAbs.add(abs.getCopy());
            }
        } catch(ParserException ex) {
            throw new ForbiddenAction(ex.getMessage());
        }
    }
    
    @Override
    public void addActionInstruction(ArrayList<ActionInstruction> pList){
        for(int k=0; k<this.nbLoop; k++){
            ArrayList<ActionInstruction> list = this.listAbs.get(k).getActionsInstruction();;
            for(ActionInstruction i: list){
                pList.add(i);
            }
        }
    }

    @Override
    public String toString(){
        String str = super.toString();
        str += "\n***** For loop instruction with abstract syntax : \n"+abs.toString();
        str += "***** End for loop ***** ";
        return str;
    }
}

