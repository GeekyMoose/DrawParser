/* 
 * Creation : May 8, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.exceptions;


/**
 * <h1>AppError</h1>
 * <p>
 * public class AppError<br/>
 * extends Exception
 * </p>
 * <p>AppErro is an error thrown by application</p>
 * 
 * @date    May 8, 2015
 * @author Constantin MASSON
 */
public class AppError extends Exception {

    /**
     * Creates a new instance of <code>ForbiddenAction</code> without detail message.
     */
    public AppError() {
    }


    /**
     * Constructs an instance of <code>ForbiddenAction</code> with the specified detail message.
     * @param msg the detail message.
     */
    public AppError(String msg) {
        super(msg);
    }
}
