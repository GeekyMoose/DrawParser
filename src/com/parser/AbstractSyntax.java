/* 
 * Creation : May 8, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.parser;

import java.util.*;


abstract class AbstractSyntax{
    
}

/**
 * 
 * @author Constantin MASSON
 */
class Program {
	private Instruction first;
	private Program 	rest;
	public Program(Instruction i, Program p) {
		this.first 	= i;
		this.rest 	= p;
	}
	public void run(ValueEnvironment env) throws Exception {
		if (first != null) {
			first.exec(env);
			if(rest != null){
				rest.run(env);
			}
		}
	} 
}

/**
 * Contains all variable already created (With or without value)
 */
class ValueEnvironment extends HashMap<String, Integer> {
	public ValueEnvironment() {
		//this = new HashMap<String, Integer>();
	}

	public void addVariable(String name) throws Exception {
		this.put(name, null);
	}

	public void setVariable(String name, int value) throws Exception {
		this.replace(name, value);
	}

	public int getValue(String name) throws Exception {
		return this.get(name);
	}
}
