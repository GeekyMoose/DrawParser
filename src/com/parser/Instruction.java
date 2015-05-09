/*
 * Creation:    May 8, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.parser;



/**
 * <h1>Instruction</h1>
 * <p>public abstract class Instruction</p>
 *
 * 
 * @date    May 8, 2015
 * @author  Constantin MASSON
 */
abstract class Instruction {
	abstract void exec(ValueEnvironment env);
}

/**
 * Declare a new variable
 * @author Constantin MASSON
 */
class Declaration extends Instruction {
	private String varName;
	public Declaration(String s) {
		this.varName = s;
	}
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
		varName = s;
		exp 	= e;
	}
    @Override
	public void exec(ValueEnvironment env) {
		env.setVariable(this.varName, this.exp.eval(env));
	}
}

/**
 * Move action
 * @author Constantin MASSON
 */
class Move extends Instruction {
	private Expression 	exp;
	public Move(Expression e) {
		this.exp 	= e;
	}
    @Override
    void exec(ValueEnvironment env){
        
    }
}

/**
 * Make a rotation
 * @author Constantin MASSON
 */
class Rotate extends Instruction {
	private Expression 	exp;
	public Rotate(Expression e) {
		this.exp 	= e;
	}
    @Override
    void exec(ValueEnvironment env){
        
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

/**
 * Loop of instruction
 * @author Constantin MASSON
 */
class Loop extends Instruction {
	private Expression 	exp;
	private Program 	prog;
	public Loop(Expression e, Program p) {
		this.exp 	= e;
		this.prog 	= p;
	}

	public void exec(ValueEnvironment env){
		if(exp != null){
			for(int k=0; k<exp.eval(env); k++){
				prog.run(env);
			}
		}
	}
}