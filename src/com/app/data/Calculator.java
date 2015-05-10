/*
 * Creation:    May 9, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.app.data;

import java.awt.Point;



/**
 * <h1>Calculator</h1>
 * <p>public abstract class Calculator</p>
 *
 * @date    May 10, 2015
 * @author  Constantin MASSON
 */
public abstract class Calculator {
    //**************************************************************************
    // Constants - Variables
    //**************************************************************************
    

    //**************************************************************************
    // Functions
    //**************************************************************************
    public static Point getNewPosition(Point currentPos, int pAngle, int pMove){
        double angle = Math.toRadians(pAngle);
        Point p = new Point();
        p.x = (int)(currentPos.x + pMove * Math.sin(angle));
        p.y = (int)(currentPos.y + pMove * Math.cos(angle));
        return p;
    }
}
