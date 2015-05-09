package com.parser;
import com.exceptions.LexerException;

%%
%public
%class Lexer
%unicode
%type Token
%line
%column

%{
    /*
     * NOTE : 
     * yyline start at 0, actual line is yyline + 1
     */
    
  	private Token getToken(Sym type) {
      	return new Token(type, yyline+1);
  	}

  	private IntToken getToken(Sym pType, int pValue) {
      	return new IntToken(pType, yyline+1, pValue);
  	}

    private StrToken getToken(Sym pType, String pValue){
        return new StrToken(pType, yyline+1, pValue);
    }

    public int getLine(){
        return yyline+1;
    }

    public int getColumn(){
        return yycolumn+1;
    }
%}

%yylexthrow{
	LexerException
%yylexthrow}



blank               = " " | "\t"
line                = "\r\n" | "\n\r" | "\n" | "\r"


prog                = "prog"

if                  = "if"
elif                = "elif" | "else if"
else                = "else"

while               = "while"
for                 = "for"

var_crea            = "var" | "Var" | "VAR"
var_name            = [a-z][a-zA-Z]*
number_int          = [0-9][0-9]*
assign              = "="


move                = "move" | "Move" | "MOVE"
rotate              = "rotate" | "Rotate" | "ROTATE"
up                  = "up" | "Up" | "UP"
down                = "down" | "Down" | "DOWN"



%state IN_BLOCK_COMMENT
%state IN_LINE_COMMENT
%state IN_STR
%%
<YYINITIAL> {
	"\""            {yybegin(IN_STR);}
  	"/*"            {yybegin(IN_BLOCK_COMMENT);}
  	"//"            {yybegin(IN_LINE_COMMENT);}
   	"("             {return getToken(Sym.L_PAR);}
   	")"             {return getToken(Sym.R_PAR);}
   	"{"             {return getToken(Sym.L_CB);}
   	"}"             {return getToken(Sym.R_CB);}
    ";"             {return getToken(Sym.CONCAT);}


    "+"             {return getToken(Sym.PLUS);}
	"-"             {return getToken(Sym.LESS);}
	"*"             {return getToken(Sym.MULTIPLY);}
	"/"             {return getToken(Sym.DIV);}

    {prog}          {return getToken(Sym.PROG);}

    {up}            {return getToken(Sym.UP);}
    {down}          {return getToken(Sym.DOWN);}
    {move}          {return getToken(Sym.MOVE);}
    {rotate}        {return getToken(Sym.ROTATE);}

    "=="            {return getToken(Sym.EQ);}
    {if}            {return getToken(Sym.IF);}
    {elif}          {return getToken(Sym.ELIF);}
    {else}          {return getToken(Sym.ELSE);}
    
    {while}         {return getToken(Sym.WHILE);}
    {for}           {return getToken(Sym.FOR);}
    
    {var_crea}      {return getToken(Sym.VAR_CREA);}
    {var_name}      {return getToken(Sym.VAR_NAME, String.valueOf(yytext()));}
    {number_int}    {return getToken(Sym.NUMBER_INT, Integer.valueOf(yytext()));}
    {assign}        {return getToken(Sym.ASSIGN);}


    {blank}         {}
    {line}          {}
    <<EOF>>         {return getToken(Sym.EOF);}
    [^]             {throw new LexerException(yytext(), yyline+1, yycolumn+1);}
}

<IN_BLOCK_COMMENT> {
  	"*/"  		{yybegin(YYINITIAL);}
  	[^]    		{}
}

<IN_LINE_COMMENT> {
 	"\n"   		{yybegin(YYINITIAL);}
  	[^]    		{}
}

<IN_STR> {
	"\\\""		{}
	"\""        {yybegin(YYINITIAL);}
  	.			{}
	
}