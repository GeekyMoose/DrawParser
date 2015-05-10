/*
 * Creation:    May 9, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */
package com.app.data;

import com.exceptions.ExecError;
import com.exceptions.ForbiddenAction;
import com.main.UiDialog;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;



/**
 * <h1>FileManagement</h1>
 * <p>public class FileManagement</p>
 * <p>Some useful function</p>
 *
 * @date    May 9, 2015
 * @author  Constantin MASSON
 */
public abstract class FileManagement {
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
    public static File getFileFromStr(String pStr, String pFileName)throws ForbiddenAction{
        if(pStr == null || pFileName == null ){
            throw new ForbiddenAction("Unable to create the file");
        }
        File        f = new File(pFileName);
        FileWriter  fw;
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
    
    
    
    
    
    
    //**************************************************************************
    // JFileChooser manager and usefull function
    //**************************************************************************
    /**
     * Display a JFileChooser in OpenDialog mode. It return the file selected, 
     * or null if no file selected
     * @param pDim JFileChooser dimension. Default dim if null given
     * @return File selected, null if no file selected
     */
    public static File fileChooserDialog(Dimension pDim){
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        if(pDim != null){
            chooser.setPreferredSize (pDim);
        }
        if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile();
        }
        return null;
    }
    
    /**
     * Display a JFileChooser in order to create a new file. It return the file 
     * created. If file already exists, display a JOptionPane dialog in order to 
     * valid. If no file created (or cancel operation), return null
     * @param pDim JFileChooser dimension. Default dim if null given
     * @return File to save (New one or old one if already exists) or null if canceled
     */
    public static File fileSaverDialog(Dimension pDim){
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        if(pDim != null){
            chooser.setPreferredSize (pDim);
        }
        
        if(chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
            File f = chooser.getSelectedFile();
            if(f.exists()==false){
                return f;
            }
            
            int choice = UiDialog.showYesNoWarning("File already exists", 
                            "File "+f.getName()+" already exists! Are you sure you want "
                            + "do override it?");
            if(choice==JOptionPane.OK_OPTION){
                return f;
            }
        }
        return null;
    }
    
}
