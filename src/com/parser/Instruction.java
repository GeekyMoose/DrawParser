/*
 * Creation:    May 8, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.parser;

import com.exceptions.ForbiddenAction;
import java.util.ArrayList;



/**
 * <h1>Instruction</h1>
 * <p>public abstract class Instruction</p>
 *
 * 
 * @date    May 8, 2015
 * @author  Constantin MASSON
 */
abstract class Instruction {
	abstract void exec(ValueEnvironment env) throws ForbiddenAction;
}


//******************************************************************************
// Porgram Instruction
//******************************************************************************
/**
 * Declare a new variable
 * @author Constantin MASSON
 */
class Declaration extends Instruction {
	private String varName;
	public Declaration(String s) {
		this.varName = s;
	}
    @Override
	public void exec(ValueEnvironment env) {
		env.addVariable(this.varName);
	}
}


/**
 * Assign a new value in existing variable
 * @author Constantin MASSON
 */
class Assignment extends Instruction {
	private String 		varName;
	private Expression 	exp;
	public Assignment(String s, Expression e) {
		this.varName = s;
		this.exp 	= e;
	}
    @Override
	public void exec(ValueEnvironment env) throws ForbiddenAction{
        env.setVariable(this.varName, this.exp.eval(env));
	}
}

/**
 * else if Instruction. Can have only if, if else or if - else if * x  - else 
 * @author Constantin MASSON
 */
class IfInstruction extends Instruction{
    private AbstractSyntax  abs;
    private Expression      exp1;
    private Expression      exp2;
    private Instruction     elseInst;
    private ArrayList<ElifInstruction> listElif;
    public IfInstruction(Expression pExp1, Expression pExp2, AbstractSyntax pAbs){
        this.abs            = pAbs;
        this.exp1           = pExp1;
        this.exp2           = pExp2;
        this.listElif       = new ArrayList();
        this.elseInst       = null;
    }
    @Override
    void exec(ValueEnvironment env){
        if(exp1 == exp2){
            
        }
    }
    public void addElifInstruction(ElifInstruction pInst){
        this.listElif.add(pInst);
    }
    public void addElseInstruction(ElseInstruction pInst){
        this.elseInst = pInst;
    }
}

class ElifInstruction extends Instruction{
    private AbstractSyntax  abs;
    private Expression      exp1;
    private Expression      exp2;
    public ElifInstruction(Expression pExp1, Expression pExp2, AbstractSyntax pAbs){
        this.abs            = pAbs;
        this.exp1           = pExp1;
        this.exp2           = pExp2;
    }

    @Override
    void exec(ValueEnvironment env) throws ForbiddenAction{
    
    }
}

class ElseInstruction extends Instruction{
    private AbstractSyntax  abs;
    public ElseInstruction(AbstractSyntax pAbs){
        this.abs = pAbs;
    }

    @Override
    void exec(ValueEnvironment env) throws ForbiddenAction{
    
    }
}


class WhileInstruction extends Instruction{
    private AbstractSyntax  abs;
    private Expression      exp1;
    private Expression      exp2;
    public WhileInstruction(Expression pExp1, Expression pExp2, AbstractSyntax pAbs){
        this.abs    = pAbs;
        this.exp1   = pExp1;
        this.exp2   = pExp2;
    }

    @Override
    void exec(ValueEnvironment env) throws ForbiddenAction{
    
    }
}


class ForInstruction extends Instruction{
    private AbstractSyntax  abs;
    private Expression      exp1;
    public ForInstruction(Expression pExp1, AbstractSyntax pAbs){
        this.abs    = pAbs;
        this.exp1   = pExp1;
    }

    @Override
    void exec(ValueEnvironment env) throws ForbiddenAction{
    
    }
}


//******************************************************************************
// Action Instruction
//******************************************************************************
/**
 * Move action
 * @author Constantin MASSON
 */
class Move extends Instruction {
	private Expression 	exp;
    private int         distance;
	public Move(Expression e) {
		this.exp        = e;
        this.distance   = 0;
	}
    @Override
    void exec(ValueEnvironment env) throws ForbiddenAction{
        this.distance = this.exp.eval(env);
    }
}


/**
 * Make a rotation
 * @author Constantin MASSON
 */
class Rotate extends Instruction {
	private Expression 	exp;
    private int         angle;
	public Rotate(Expression e) {
		this.exp 	= e;
        this.angle  = 0;
	}
    @Override
    void exec(ValueEnvironment env) throws ForbiddenAction{
        this.angle = this.exp.eval(env);
    }
}


/**
 * Place in up position
 * @author Constantin MASSON
 */
class Up extends Instruction {
    @Override
    void exec(ValueEnvironment env){
        
    }
}


/**
 * Place in down position
 * @author Constantin MASSON
 */
class Down extends Instruction {
    @Override
    void exec(ValueEnvironment env){
        
    }
}