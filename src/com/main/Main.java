/* 
 * Creation : May 8, 2015
 * Project Computer Science L2 Semester 4 - DrawParser
 */

package com.main;

import com.parser.Parser;
import com.parser.Grammar1;

class Main {

    public static void main(String[] args) throws Exception {
    	if (args.length < 1) {
    		System.out.println("Wrong parameter : java Main <namefile>");
    		//System.exit(1);
    	}
        Grammar1    gr  = new Grammar1();
        Parser      p   = new Parser(gr);
        p.startParser(Parser.MODE_GENERAL, "data/testFiles/good/good1.txt");
    }
}
