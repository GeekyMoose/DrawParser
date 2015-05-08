/* 
 * Creation : May 8, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */

package com.main;

import java.io.*;

class Main {

    public static void main(String[] args) throws Exception {
    	if (args.length < 1) {
    		System.out.println("java Main <namefile>");
    		System.exit(1);
    	}
        
    	File        input   = new File(args[0]);
    	Reader      reader  = new FileReader(input);
    }
}
