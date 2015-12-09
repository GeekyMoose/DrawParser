# Draw Parser


<!-- ********************************************************************** -->
## Description
May 2015

This project was done for the Automata university topic. The goal was to implemente a parser for a specific grammar.

Basically, the grammar enable us to create a draw from basic instructions like moving, rotating etc. Most of Java instruction are also implemented like
while loop and if conditions. (Note the while manage only '==' statement). The parsing process generate the draw and display it on the screen.

Various tools enable us to handle the draw result. For instance, temporary disabling an instruction and compare the result, or adding an instruction without
modifying the source file etc)


<!-- ********************************************************************** -->
## Installation
Clone this project on your computer using `git clone https://github.com/GeekyMoose/drawparser.git`


<!-- ********************************************************************** -->
## Run the project
#### On Linux
Simply execute the script `exec.sh`<br/>
Don't forget to give the execution right (With `chmod 755 exec.sh` for example)

#### On Windows
Execute the drawparser.jar file

#### On Mac
Follow the same step than linux. Note that I didn't check if it's actually working, I know some people had trouble with the exec.sh encoding.


<!-- ********************************************************************** -->
## Features
The 3 main buttons allow you to:

* `Run` Start the parsing process (From the text editor at the left)
* `Load` Load a code from an existing file
* `Print` Create a PNG image of the current screen parsing render

The command line block (Bottom-Left corner) allow to add instructions without modifying the source code.

The right componant display the list of resulting drawing actions. It enable us to enable or disable a specific action an watch the result without
modifying the source code. When we are hover an element, the next elements (Which are going to be affected if the current is changed) are displayed
with a yellow color.

<!-- ********************************************************************** -->
## How does it work
The grammar is parsed from a file (Which can be loaded and edited from the left editor panel). A JFlex file initally parse the file and create a list
of token which are going to be used by the parser.

The final result is a ArrayList with all the draw action. This object can be displayed and processed.


<!-- ********************************************************************** -->
## Syntax error management
The parsing process detect the syntax error and display it. If many error occured, the first one will be displayed. The line, found token and expected
one are displayed.

This process work both for source code parsing and command line parsing.


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


<!-- ********************************************************************** -->
## Author
Constantin MASSON [GeekyMoose](https://github.com/GeekyMoose)
