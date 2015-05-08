/*
 * Creation:    May 8, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.parser;



/**
 * <h1>Instruction</h1>
 * <p>public abstract class Instruction</p>
 *
 * @date    May 8, 2015
 * @author  Constantin MASSON
 */
abstract class Instruction {
	abstract void exec(ValueEnvironment env) throws Exception;
}

class Declaration extends Instruction {
	private String varName;
	public Declaration(String s) {
		varName = s;
	}
	public void exec(ValueEnvironment env) throws Exception {
		env.addVariable(this.varName);
	} 
}

class Assignment extends Instruction {
	private String 		varName;
	private Expression 	exp;
	public Assignment(String s, Expression e) {
		varName = s;
		exp 	= e;
	}
	public void exec(ValueEnvironment env) throws Exception {
		env.setVariable(this.varName, this.exp.eval(env));
	}
}


class Print extends Instruction {
	private Expression exp;
	public Print(Expression e) {
		this.exp = e;
	}
	public void exec(ValueEnvironment env) throws Exception {
		System.out.println(exp.eval(env));
	}
}


class Loop extends Instruction {
	private Expression 	exp;
	private Program 	prog;
	public Loop(Expression e, Program p) {
		this.exp 	= e;
		this.prog 	= p;
	}

	public void exec(ValueEnvironment env) throws Exception {
		if(exp != null){
			for(int k=0; k<exp.eval(env); k++){
				prog.run(env);
			}
		}
	}
}