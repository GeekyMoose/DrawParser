/*
 * Creation:    May 9, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */

package com.app.data;

import com.exceptions.ForbiddenAction;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



/**
 * <h1>Asset</h1>
 * <p>public class Asset</p>
 * <p>Some useful function</p>
 *
 * @date    May 9, 2015
 * @author  Constantin MASSON
 */
public abstract class Asset {
    //**************************************************************************
    // Functions
    //**************************************************************************
    /**
     * Return string content of a file. If given file is null or not valid, 
     * return empty String ("")
     * @param pFile file to process
     * @return String with file content
     * @throws ForbiddenAction thrown if error occur (File null etc)
     */
    public static String getStrFromFile(File pFile) throws ForbiddenAction{
        if(pFile == null){
            throw new ForbiddenAction("Unable to load the file");
        }
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(pFile));
            StringBuilder   sb      = new StringBuilder();
            String          line    = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            return sb.toString();
        } 
        catch(FileNotFoundException ex) {
            throw new ForbiddenAction("Unable to load the file");
        } 
        catch(IOException ex) {
            throw new ForbiddenAction("Error during file reading");
        } 
        finally {
            try {
                br.close();
            } catch(IOException ex) {
                throw new ForbiddenAction("Error during file reading");
            }
        }
    }
}
