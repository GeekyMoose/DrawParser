/* 
 * Creation : May 8, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.exceptions;



/**
 * <h1>ExecError</h1>
 * <p>
 * public class ExecError<br/>
 * extends Exception
 * </p>
 * <p>Error during execution</p>
 *
 * @date    May 8, 2015
 * @author  Constantin MASSON
 */
public class ExecError extends Exception {

    /**
     * Creates a new instance of <code>ExecError</code> without detail message.
     */
    public ExecError() {
    }


    /**
     * Constructs an instance of <code>ExecError</code> with the specified detail message.
     * @param msg the detail message.
     */
    public ExecError(String msg) {
        super(msg);
    }
}
