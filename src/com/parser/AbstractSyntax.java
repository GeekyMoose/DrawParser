/* 
 * Creation : May 8, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.parser;

import java.util.*;

/**
 * 
 * @author Constantin MASSON
 */
class AbstractSyntax {
    private ArrayList<Instruction> listInstruction;
    
    
	public AbstractSyntax() {
        this.listInstruction = new ArrayList();
	}
    
    public void addInstruction(Instruction pInst){
        if(pInst != null){
            this.listInstruction.add(pInst);
        }
    }
}


/**
 * <h1>ValueEnvironment</h1>
 * <p>class ValueEnvironment</p>
 * <p>Contains all variable already created (With or without value)</p>
 */
class ValueEnvironment extends HashMap<String, Integer> {
    /**
     * Add a variable name in current list of environment variables. if ValueEnvironment 
     * already contained a variable with this name, it will be replaced. 
     * New variable value is set to null
     * @param name new variable name
     */
	public void addVariable(String name){
		this.put(name, null);
	}

    /**
     * Set value of an existing variable
     * @param name
     * @param value
     * @throws Exception 
     */
	public void setVariable(String name, int value) {
		this.replace(name, value);
	}
    
    /**
     * Return value of variable given in parameter. 
     * @param name
     * @return 
     */
	public int getValue(String name) {
		return this.get(name);
	}
}
