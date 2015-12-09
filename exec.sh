#!/bin/bash
#
# Autor: Constantin MASSON
#
# Compile and then, execute drawPanel project 
# Compiled files (.class) are saved in a specific folder (See constants DOSS_BUILD)



#*******************************************************************************
# Variables and Constants
#*******************************************************************************
PWD_EXEC=`pwd`
DOSS_BUILD="build/"

#Constants for execution
MAIN_PATH="src/com/main/"
EXEC_CLASS_NAME="com.main.Main"


#*******************************************************************************
# General functions
#*******************************************************************************

# Create the build folder with all .class files generated
function createArbo(){
	if [[ -e $DOSS_BUILD ]];then
	    rm -r $DOSS_BUILD ; checkError #Remove old file if exists
	fi
	mkdir $DOSS_BUILD ; checkError
}

# Execute
# Generate Lexer from JFlex file (Delete old lexer)
# Compile Main.java file
# Execute Main function (Start program)
#
# All build files are saved in specific file (from constants $DOSS_BUILD)
function execute(){
	javac -d $DOSS_BUILD -sourcepath src $MAIN_PATH"Main.java"
	checkError
	java -cp $DOSS_BUILD $EXEC_CLASS_NAME &
}

# Create the jar file
function createJar(){
	echo "Manifest-Version: 1.0" > $DOSS_BUILD"manifest.mf"
	echo "Main-Class: $EXEC_CLASS_NAME" >> $DOSS_BUILD"manifest.mf"
	echo -e "\n\n\n" >> $DOSS_BUILD"manifest.mf"

	cd $DOSS_BUILD
	jar -cfm drawparser.jar manifest.mf com/*
	cd ..
	cp build/drawparser.jar .
}


#*******************************************************************************
# Tools functions
#*******************************************************************************
# Check if last process failed 
# Stop program if error
function checkError(){
    if [[ $? -ne 0 ]];then
        echo "Error"
        exit 1
    fi
}



#*******************************************************************************
#Launch script
createArbo
execute
createJar

