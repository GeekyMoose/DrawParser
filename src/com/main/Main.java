/*
 * Creation:    May 8, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.main;

import com.app.data.AppController;
import com.app.data.AppData;
import com.app.view.Application;
import com.exceptions.AppError;
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
                try {
                    AppData         model       = new AppData();
                    AppController   controller  = new AppController(model);
                    Application     app         = new Application(controller);
                    controller.setView(app);
                    app.pack();
                    app.setLocationRelativeTo(null);
                    app.setVisible(true);
                } catch(AppError ex) {
                    DebugTrack.showErrMsg("Unable to start program!");
                    UiDialog.showError("Error", "Unable to load program!");
                }
            }
        });
    }
}
