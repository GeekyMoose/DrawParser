/* 
 * Creation : May 8, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.parser.asset;

import com.exceptions.ForbiddenAction;
import java.util.HashMap;


/**
 * <h1>ValueEnvironment</h1>
 * <p>class ValueEnvironment</p>
 * <p>Contains all variable already created (With or without value)</p>
 */
public class ValueEnvironment extends HashMap<String, Integer> {
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
     * Set value of an existing variable, if this variable doesn't exists, throw 
     * an exception
     * @param name  variable to set
     * @param value value to set in this variables
     * @throws ForbiddenAction thrown if variable doesn't exists
     */
	public void setVariable(String name, int value) throws ForbiddenAction {
        if(this.containsKey(name)==false){
            //error -> get return value, I need to check if var is already here
            throw new ForbiddenAction(name+" must be declared before");
        }
		this.replace(name, value);
	}
    
    /**
     * Return value of variable given in parameter. 
     * @param name variable name
     * @return value of this variables if exists, otherwise, throws exception
     * @throws ForbiddenAction thrown if variables doesn't exists
     */
	public int getValue(String name) throws ForbiddenAction {
        Integer value = this.get(name);
        if(value == null){
            throw new ForbiddenAction(name+" must be declared before");
        }
		return this.get(name);
	}
}
