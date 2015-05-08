/* 
 * Creation : May 8, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.asset;



/**
 * <h1>ForbiddenAction</h1>
 * <p>
 * public class ForbiddenAction<br/>
 * extends Exception
 * </p>
 *
 * @date    May 8, 2015
 * @author  Constantin MASSON
 */
public class ForbiddenAction extends Exception {

    /**
     * Creates a new instance of <code>ForbiddenAction</code> without detail message.
     */
    public ForbiddenAction() {
    }


    /**
     * Constructs an instance of <code>ForbiddenAction</code> with the specified detail message.
     * @param msg the detail message.
     */
    public ForbiddenAction(String msg) {
        super(msg);
    }
}
