#!/bin/bash
#
# Compile and then, execute drawPanel project 
# Compiled files (.class) are saved in folder jjgenerated



#*******************************************************************************
# Variables and Constants
#*******************************************************************************
PWD_EXEC=`pwd`
DOSS_BUILD="build"

#Constants for execution
JFLEX_PATH="src/parser/"
MAIN_PATH="src/main/"

EXEC_CLASS_NAME="Main"



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
	jflex $JFLEX_PATH"programme.flex"
	rm $JFLEX_PATH"/Lexer.java~"
	javac -d $DOSS_BUILD -sourcepath src $MAIN_PATH"Main.java"
	java -cp $DOSS_BUILD $EXEC_CLASS_NAME
}

#Check if parameters are valid
function checkParam(){
	if [ -z $1 ];then
		echo "Missing parameter (Text to process)"
		exit 1

	elif [ ! -e $1 ];then 
		echo "File $1 doesn't exists"
		exit 1
	fi
}


#Launch script
checkParam "$@"
createArbo
execute

