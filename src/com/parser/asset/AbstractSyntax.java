/* 
 * Creation : May 8, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.parser.asset;

import com.exceptions.ForbiddenAction;
import com.exceptions.ParserException;
import com.parser.instructions.actions.ActionInstruction;
import com.parser.instructions.asset.Instruction;
import java.util.*;



/**
 * <h1>AbstractSyntax</h1>
 * <p>public class AbstractSyntax</p>
 * <p>AbstractSyntax is a list of instructions created from a text process.</p>
 * 
 * @date May 8, 2015
 * @author Constantin MASSON
 */
public class AbstractSyntax {
    //**************************************************************************
    // Variables - Constants
    //**************************************************************************
    private ArrayList<Instruction> listInstruction;
    
    
    //**************************************************************************
    // Constructor - Initialization
    //**************************************************************************
    /**
     * Create a new Abstract Syntax with no instruction
     */
	public AbstractSyntax() {
        this.listInstruction = new ArrayList();
	}
    
    /**
     * Add a specific instruction in abstract syntax
     * @param pInst instruction to add, do nothing if null
     */
    public void addInstruction(Instruction pInst){
        if(pInst != null){
            this.listInstruction.add(pInst);
        }
    }
    
    
    //**************************************************************************
    // Functions
    //**************************************************************************
    /**
     * Execute every instruction in this Abstract Syntax. Execute means it 
     * calculate expression (For example, calculate 40 + 2 = 42), add variables 
     * in environment and so on. After creating a AbstractSyntax, we usually 
     * need to process an exec. And it is require before creating the processed 
     * list of instruction (Usable in application)
     * @param env ValueEnvironment used 
     * @throws ParserException thrown if invalid instruction (Division by 0 ...)
     */
    public void exec(ValueEnvironment env) throws ParserException{
        for(Instruction i : this.listInstruction){
            try {
                i.exec(env);
            } catch(ForbiddenAction ex) {
                throw new ParserException(ex.getMessage());
            }
        }
    }
    
    /**
     * Return all instruction used as an Action (Move, rotate etc)
     * @return ArrayList with all Instruction used as an Action
     */
    public ArrayList<ActionInstruction> getActionsInstruction(){
        ArrayList<ActionInstruction> list = new ArrayList();
        for(Instruction i : this.listInstruction){
            i.addActionInstruction(list);
        }
        return list;
    }
    
    @Override
    public String toString(){
        String str = super.toString();
        str += "\nListInstruction : \n";
        for (Instruction i : this.listInstruction){
            str += i.toString()+"\n";
        }
        return str;
    }
}