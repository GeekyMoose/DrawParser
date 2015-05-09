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
 * <h1>IfInstruction</h1>
 * <p>
 * public class IfInstruction<br/>
 * extends Instruction
 * </p>
 * <p>else if Instruction. Can have only if, if else or if - else if * x  - else </p>
 * 
 * @date    May 9, 2015
 * @author  Constantin MASSON
 */
public class IfInstruction extends Instruction{
    //**************************************************************************
    // Constants - Variables
    //**************************************************************************
    private AbstractSyntax                  abs;
    private Expression                      exp1;
    private Expression                      exp2;
    private ElseInstruction                 elseInst;
    private ArrayList<ElifInstruction>      listElif;
    
    //Save the AbstractSyntax to ultimately use (check by exec)
    private AbstractSyntax                  matchedAbs;
    
    
    //**************************************************************************
    // Constants - Variables
    //**************************************************************************
    /**
     * Create a new IfInstruction 
     * @param pExp1     Left expression in if
     * @param pExp2     right expression in if
     * @param pAbs      Abstract Syntax in if block
     */
    public IfInstruction(Expression pExp1, Expression pExp2, AbstractSyntax pAbs){
        this.abs            = pAbs;
        this.exp1           = pExp1;
        this.exp2           = pExp2;
        this.listElif       = new ArrayList();
        this.elseInst       = null;
        this.matchedAbs     = null;
    }
    
    /**
     * Add an instruction type Else if in this if instruction
     * @param pInst elif instruction
     */
    public void addElifInstruction(ElifInstruction pInst){
        this.listElif.add(pInst);
    }
    
    /**
     * Add an else instruction in this if instruction
     * @param pInst else instruction
     */
    public void addElseInstruction(ElseInstruction pInst){
        this.elseInst = pInst;
    }
    
    
    //**************************************************************************
    // Functions redifined from Instruction
    //**************************************************************************
    @Override
    public void exec(ValueEnvironment env) throws ForbiddenAction{
        //Check first expression from : if(a==b){}
        if(exp1.eval(env) == exp2.eval(env)){
            try {
                abs.exec(env);
                this.matchedAbs = abs;
                return;
            } catch(ParserException ex) {
                throw new ForbiddenAction(ex.getMessage());
            }
        }
        //Check the first else if correct (Or nothing is null)
        else if (!this.listElif.isEmpty()){
            for(ElifInstruction i : this.listElif){
                if(i.checkExpression(env)==true){
                    i.exec(env);
                    this.matchedAbs = i.getAbstractSyntax();
                    return;
                }
            }
        }
        //else, process the else instruction (If exists)
        if (this.elseInst != null){
            this.elseInst.exec(env);
            this.matchedAbs = this.elseInst.getAbstractSyntax();
        }
    }
    
    @Override
    public void addActionInstruction(ArrayList<ActionInstruction> pList){
        if(this.matchedAbs != null){
            for(ActionInstruction i : this.matchedAbs.getActionsInstruction()){
                pList.add(i);
            }  
        }
    }

    @Override
    public String toString(){
        String str = super.toString();
        str += "If instruction with "+this.listElif.size()+" else if and ";
        str += (this.elseInst==null)? "no else" : "one else";
        return str;
    }
}



