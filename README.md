# Draw Parser
Download and test it: [DrawParser.zip](https://github.com/GeekyMoose/drawparser/releases/download/v1/DrawParser.zip)

![img](https://github.com/GeekyMoose/drawparser/blob/master/documents/screenshots/welcome.png)


<!-- ********************************************************************** -->
## Description
May 2015

University project for the automata topic during my second year of Bachelor in Computer Science.

DrawParser allow to draw on the screen according to a code following specific grammar.

The grammar allow us to draw from basic instructions like moving, rotating etc. Most of Java instruction are also implemented like while loop and if conditions. (Note my while manage only '==' statement). The parsing process generate the draw and display it on the screen.

Various tools enable us to handle the draw result. For instance, by temporary disabling an instruction and compare the result, or adding an instruction without modifying the source file...)


<!-- ********************************************************************** -->
## Installation
Clone this project on your computer using `git clone https://github.com/GeekyMoose/drawparser.git`


<!-- ********************************************************************** -->
## Run the project
#### On Linux
Simply execute the script `exec.sh`
<br/>
Don't forget to give the execution right (With `chmod 755 exec.sh` for example)

#### On Windows
The easiest way is by downloading the executable zip file.

#### On Mac
Follow the same step than Linux. Note that I didn't check if it's actually working, I know some people had trouble with the exec.sh encoding.


<!-- ********************************************************************** -->
## Features
The 3 main buttons allow to:

* `Run` Start the parsing process (From the text editor at the left)
* `Load` Load a code from an existing file (Beware, current code will be lost)
* `Print` Create a PNG image of the current screen parsing render

The command line block (Bottom-Left corner) allow to add instructions without modifying the source code.
<br/>
The right component display the list of resulting drawing actions. It enable us to disable a specific action an watch the result without modifying the source code. When hover an element, the next elements (Which are going to be affected if the current is changed) are displayed with a yellow color.

<!-- ********************************************************************** -->
## How does it work
The grammar is parsed from a file (Which can be loaded and edited using the left editor panel). A JFlex file initially parse the file and create a list of token which are used by the parser.
<br/>
The final result is a ArrayList with all the draw actions. This object can be displayed and processed.


<!-- ********************************************************************** -->
## Syntax error management
The parsing process detect the syntax error and display it. If many error occurred, the first one will be displayed. The line, found token and expected one are displayed.
<br/>
This process work both with source code parsing and command line parsing.


<!-- ********************************************************************** -->
## Grammar
The grammar used is inspired by Java

Prog        -> Declar inst<br/>
Declar      -> VAR INDENTIFIER ; Declar | EOF<br/>
<br/>
Inst        -> FORWARD Exp | ROTATE Exp | UP | DOWN | IDENTIFIER = Exp | START BlocInst END<br/>
BlocInst    -> Inst ; BlocInst | EOF<br/>
<br/>
exp         -> NUMBER ExpFollow | INDENTIFIER ExpFollow  | (Exp) ExpFollow<br/>
ExpFollow   -> Operator ExpFollow | EOF<br/>
Operator    -> + Exp | - Exp | * Exp | / Exp
<br/>

INDENTIFIER -> [a-z][a-zA-Z0-9]&#42;<br/>
NUMBER      -> [1-9][0-9]&#42; | 0

## Screenshots
A full list of screenshots can be found in the [screenshots folder](https://github.com/GeekyMoose/drawparser/tree/master/documents/screenshots)

## Warning!
A folder called data must be in the same directory as the .jar file. (This folder can be empty). This is required since a temporary file called tmp.txt will be created inside with the current source code. However, I'm aware it's not the best way to do so and a more 'transparent' way could be done.


<!-- ********************************************************************** -->
## Author
Constantin MASSON [GeekyMoose](https://github.com/GeekyMoose)

