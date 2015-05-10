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
    public static final Dimension   DIM_APP             = new Dimension(1250, 600);
    public static final Dimension   DIM_MIN             = new Dimension(700, 500);
    public static final Dimension   DIM_MAX             = new Dimension(1500, 1000);
    
    public static final Dimension   DIM_HEAD_BAR        = new Dimension(0, 30);
    public static final Dimension   DIM_DATA_BOX        = new Dimension(300, 30);
    
    public static final Dimension   DIM_CONSOL_PANEL    = new Dimension(400, 200);
    public static final Dimension   DIM_CONSOL_TXT      = new Dimension(400, 200);
    public static final Dimension   DIM_CONSOL_CMD      = new Dimension(400, 25);
    
    public static final Dimension   DIM_CODE_PANEL      = new Dimension(400, 800);
    
    public static final Dimension   DIM_INST_PANEL      = new Dimension(180, 800);
    public static final Dimension   DIM_ACTION_PANEL    = new Dimension(140, 50);
    
    
    //**************************************************************************
    // Delay
    //**************************************************************************
    public static final int         DELAY_TMP_TXT       = 3000;
    public static final int         DELAY_TXT_INFO      = 3000;
    public static final int         DELAY_TXT_ERROR     = 3000;
    public static final int         DELAY_TXT_WARNING   = 3000;
    public static final int         DELAY_TXT_VALID     = 3000;
    
    
    //**************************************************************************
    // Default setting
    //**************************************************************************
    public static final String      DEFAULT_TMP_FILE    = "data/tmp.txt";
    public static final String      DEFAULT_MSG         = "...";
    
    public static final Point       DEFAULT_POSITION    = new Point(0,0);
    public static final int         DEFAULT_ANGLE       = 0;
    public static final boolean     DEFAULT_IS_DRAWING  = false;
    public static final int         DEFAULT_THICKNESS   = 4;
}
