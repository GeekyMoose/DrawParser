/*
 * Creation:    May 8, 2015
 * 
 */

package com.main;

import com.app.Application;
import java.awt.EventQueue;



/**
 * <h1>Main</h1>
 * <p>public class Main</p>
 *
 * @date    May 8, 2015
 * @author  Constantin MASSON
 */
public class Main {

    /**
     * Main function
     * Call and display the program
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Application ap = new Application();
                ap.pack();
                ap.setLocationRelativeTo(null);
                ap.setVisible(true);
            }
        });
    }
    
    /*
    if (args.length < 1) {
        System.out.println("Wrong parameter : java Main <namefile>");
        //System.exit(1);
    }
    Grammar1    gr  = new Grammar1();
    Parser      p   = new Parser(gr);
    p.startParser(Parser.MODE_GENERAL, "data/testFiles/good/good1.txt");
    */
}
