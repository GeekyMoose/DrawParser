#!/bin/bash
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
	nohup java -cp $DOSS_BUILD $EXEC_CLASS_NAME
}


#Launch script
createArbo
execute

