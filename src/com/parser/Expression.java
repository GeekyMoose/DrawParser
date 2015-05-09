/* 
 * Creation : May 8, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.parser;

import com.exceptions.ForbiddenAction;


/**
 * <h1>Expression</h1>
 * <p>public abstract class Expression</p>
 * <p></p>
 *
 * @date    May 8, 2015
 * @author  Constantin MASSON
 */
public abstract class Expression {
	public abstract int eval(ValueEnvironment env) throws ForbiddenAction;
}


class IntExp extends Expression {
	private int value;
	public IntExp(int i) {
		this.value = i;
	}
    @Override
	public int eval(ValueEnvironment env) throws ForbiddenAction{
		return this.value;
	}
}

class Var extends Expression {
	private String name;
	public Var(String s) {
		this.name = s;
	}
    @Override
	public int eval(ValueEnvironment env) throws ForbiddenAction{
		return env.getValue(this.name);
	}
}

class Sum extends Expression {
	private Expression left, right;
	public Sum(Expression l, Expression r) {
		this.left = l;
		this.right = r;
	}
    @Override
	public int eval(ValueEnvironment env) throws ForbiddenAction{
		return this.left.eval(env) + this.right.eval(env);
	}
}

class Difference extends Expression {
	private Expression left, right;
	public Difference(Expression l, Expression r) {
		left = l;
		right = r;
	}
    @Override
	public int eval(ValueEnvironment env) throws ForbiddenAction{
		return left.eval(env) - right.eval(env);
	}
}

class Product extends Expression {
	private Expression left, right;
	public Product(Expression l, Expression r) {
		left = l;
		right = r;
	}
    @Override
	public int eval(ValueEnvironment env) throws ForbiddenAction{
		return left.eval(env) * right.eval(env);
	}
}

class Division extends Expression {
	private Expression left, right;
	public Division(Expression l, Expression r) {
		left = l;
		right = r;
	}
    @Override
	public int eval(ValueEnvironment env) throws ForbiddenAction{
        int rightEval = right.eval(env);
        if(rightEval == 0){
            throw new ForbiddenAction("Divide by 0");
        }
		return left.eval(env) / rightEval;
	}
}
