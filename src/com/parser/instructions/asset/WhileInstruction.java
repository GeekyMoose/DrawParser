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
    
    private ArrayList<AbstractSyntax> listAbs;
    
    
    //**************************************************************************
    // Constructors - Initialization
    //**************************************************************************
    public WhileInstruction(Expression pExp1, Expression pExp2, AbstractSyntax pAbs){
        this.abs        = pAbs;
        this.exp1       = pExp1;
        this.exp2       = pExp2;
        this.nbLoop     = 0;
        this.listAbs    = new ArrayList();
    }
    
    
    //**************************************************************************
    // Constants - Variables
    //**************************************************************************
    @Override
    public void exec(ValueEnvironment env) throws ForbiddenAction{
        while(this.exp1.eval(env) == this.exp2.eval(env)){
            this.nbLoop++;
            try {
                abs.exec(env);
                this.listAbs.add(abs.getCopy());
            } catch(ParserException ex) {
                throw new ForbiddenAction(ex.getMessage());
            }
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
        str += "\n***** While loop instruction with abstract syntax : \n"+abs.toString();
        str += "***** End while loop ***** ";
        return str;
    }
}
