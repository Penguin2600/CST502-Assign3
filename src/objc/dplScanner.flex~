/**
 * Purpose: This is a sample flex input file for parsing a language of
 * expressions and assignments over doubles. The implementation of the
 * symbol table is done in objective-c, as are the actions in bison.
 * The purpose of this project is to demonstrate the use of
 * flex and bison working together. Flex recognizes tokens and returns them
 * to the bison generated parser. The parser places identifiers into the
 * symbol table if they are not already there. Values for variables are
 * stored in the symbol table.
 * see http://pooh.poly.asu.edu/Cst502
 * @author Tim Lindquist (Tim.Lindquist@asu.edu), ASU Polytechnic, Engineering
 * @version January 2011
 */
%option noyywrap
%{
#include "dplParser.tab.h"
#include <stdio.h>
#import <Foundation/Foundation.h>/
%}
%%
"read"                { return READ; }
"print"               { return PRINT; }
"="                   { return ASSIGN; }
"("                   { return LPAREN; }
")"                   { return RPAREN; }
"{"                   { return LBRACE; }
"}"                   { return RBRACE; }
"+"                   { return PLUS; }
"-"                   { return MINUS; }
"*"                   { return STAR; }
"/"                   { return SLASH; }
">"                   { return GT; }
"<"                   { return LT; }
"=="                  { return EQ; }
"if"                  { return IF; }
";"                   { return SEMI; }
"while"               { return WHILE; }
[0-9]+\.[0-9]* 	      { yylval.val = yytext;//atof(yytext);
                        return(ADOUBLE); }
[0-9]+                { yylval.val = yytext;//atof(yytext);
                        return(ADOUBLE); }

[a-zA-Z][a-zA-Z0-9]*  { yylval.string=(char *)strdup(yytext);
                        return(ID); }

"/*"([^*]|("*"+[^*/]))*"*"+"/\n" { }
"/*"([^*]|("*"+[^*/]))*"*"+"/"   { }

"\n"                  {return NEWLINE;}
.                     {}

%%
