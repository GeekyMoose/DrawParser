/*
 * Creation:    May 9, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.app.data;

import com.exceptions.ExecError;
import com.exceptions.ForbiddenAction;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.text.JTextComponent;



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
    // Files Management Functions
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
    
    /**
     * Create a file from a string. 
     * @param pStr      string to place in the file
     * @param pFileName file name (It is also the path)
     * @return file created
     * @throws ForbiddenAction thrown if unable to create the file 
     */
    public static File getFileFromStr(String pStr, String pFileName )throws ForbiddenAction{
        if(pStr == null || pFileName == null ){
            throw new ForbiddenAction("Unable to create the file");
        }
        File f = new File(pFileName);
        FileWriter fw;
        try{
            fw = new FileWriter(f);
            fw.write(pStr);
            fw.close();
        } catch(IOException ex) {
            f.delete();
            throw new ForbiddenAction("Unable to create file");
        }
        return f;
    }
    
    
    /**
     * Create a file from a JTextField content. File is created using path 
     * given as parameter. If path is not valid, throw error
     * @param pPath path and name where to create file (ex: /home/rabbit/myFile.txt)
     * @param pText JTextComponent to export
     * @return File created 
     * @throws ExecError thrown if error during file creation
     * @throws ForbiddenAction throw if not valid name
     */
    public static File getFileFromJTextComp(String pPath, JTextComponent pText) 
    throws ExecError, ForbiddenAction{
        if(pPath == null){
            throw new ForbiddenAction("Unable to create file, not valid name");
        }
        File file = new File(pPath);
        BufferedWriter out;
        try {
            out = new BufferedWriter(new FileWriter(file));
            pText.write(out);
            out.flush();
            out.close();
        } catch(IOException ex) {
            file.delete();
            throw new ExecError("Unable to create file");
        }
        return file;
    }
}
