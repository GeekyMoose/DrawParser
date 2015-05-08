package com.parser;
import com.asset.LexerException;

%%
%public
%class Lexer
%unicode
%type Token
%line
%column

%{
	//package com.parser;
    
  	private Token getToken(Sym type) {
      	return new Token(type, yyline);
  	}

  	private IntToken getToken(Sym pType, int pValue) {
      	return new IntToken(pType, yyline, pValue);
  	}

    private StrToken getToken(Sym pType, String pValue){
        return new StrToken(pType, yyline, pValue);
    }

    public int getLine(){
        return yyline;
    }

    public int getColumn(){
        return yycolumn;
    }
%}

%yylexthrow{
	LexerException
%yylexthrow}



blank               = "\n" | "\r" | " " | "\t"

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



%%
<YYINITIAL> {
   	"("             {return getToken(Sym.L_PAR);}
   	")"             {return getToken(Sym.R_PAR);}
   	"{"             {return getToken(Sym.L_CB);}
   	"}"             {return getToken(Sym.R_CB);}
    ";"             {return getToken(Sym.CONCAT);}


    "+"             {return getToken(Sym.PLUS);}
	"-"             {return getToken(Sym.LESS);}
	"*"             {return getToken(Sym.MULTIPLY);}
	"/"             {return getToken(Sym.DIV);}

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
    <<EOF>>         {return getToken(Sym.EOF);}
    [^]             {throw new LexerException(yyline, yycolumn);}
}



