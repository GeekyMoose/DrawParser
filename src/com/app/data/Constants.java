/*
 * Creation:    May 8, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.app.data;

import java.awt.Dimension;
import java.awt.Point;



/**
 *
 * @author Constantin MASSON
 */
public interface Constants {
    //**************************************************************************
    // Dimensions
    //**************************************************************************
    public static final Dimension   DIM_GENERAL         = new Dimension(500, 250);
    public static final Dimension   DIM_HEAD_BAR        = new Dimension(0, 40);
    public static final Dimension   DIM_CONSOL_PANEL    = new Dimension(400, 200);
    public static final Dimension   DIM_CODE_PANEL      = new Dimension(400, 800);
    
    public static final Dimension   DIM_INST_PANEL      = new Dimension(180, 0);
    public static final Dimension   DIM_ACTION_PANEL    = new Dimension(140, 50);
    
    //**************************************************************************
    //Other
    //**************************************************************************
    public static final String      DEFAULT_TMP_FILE    = "tmp.txt";
    public static final Point       DEFAULT_POSITION    = new Point(0,0);
    public static final int         DEFAULT_ANGLE       = 0;
    public static final boolean     DEFAULT_IS_DRAWING  = true;
    public static final int         DEFAULT_THICKNESS   = 2;
}
