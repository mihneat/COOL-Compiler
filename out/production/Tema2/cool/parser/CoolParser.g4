parser grammar CoolParser;

options {
    tokenVocab = CoolLexer;
}

@header{
    package cool.parser;
}

/* Base program */

program : (class SEMICOLON)+ EOF ;

class : CLASS this=TYPE_ID (INHERITS parent=TYPE_ID)? LBRACE (feature SEMICOLON)* RBRACE ;


/* Definitions */

feature : method | attribute ;

method : OBJECT_ID LPAREN (defs+=formal (COMMA defs+=formal)*)? RPAREN COLON TYPE_ID LBRACE expr RBRACE ;

attribute : OBJECT_ID COLON TYPE_ID (ASSIGN init=expr)? ;

formal : OBJECT_ID COLON TYPE_ID ;


/* Expressions */

expr
    : obj=expr (AT TYPE_ID)? DOT OBJECT_ID LPAREN (params+=expr (COMMA params+=expr)*)? RPAREN  # explicitDispatch
    | OBJECT_ID LPAREN (params+=expr (COMMA params+=expr)*)? RPAREN                             # implicitDispatch
    | IF cond=expr THEN then=expr ELSE else=expr FI                                             # if
    | WHILE cond=expr LOOP body=expr POOL                                                       # while
    | LBRACE (expr SEMICOLON)+ RBRACE                                                           # block
    | LET defs+=localVarDef (COMMA defs+=localVarDef)* IN body=expr                             # let
    | CASE expr OF caseBranch+ ESAC                                                             # case
    | NEW TYPE_ID                                                                               # new
    | INVERSE expr                                                                              # invert
    | ISVOID expr                                                                               # isVoid
    | left=expr (STAR | SLASH) right=expr                                                       # mulDiv
    | left=expr (PLUS | MINUS) right=expr                                                       # plusMinus
    | left=expr (LE | LT | EQ) right=expr                                                       # booleanOp
    | NOT expr                                                                                  # negate
    | OBJECT_ID ASSIGN expr                                                                     # assign
    | LPAREN expr RPAREN                                                                        # paren
    | OBJECT_ID                                                                                 # objVal
    | INT                                                                                       # int
    | STRING                                                                                    # string
    | (TRUE | FALSE)                                                                            # bool
    ;

localVarDef : OBJECT_ID COLON TYPE_ID (ASSIGN expr)? ;

caseBranch : OBJECT_ID COLON TYPE_ID RESULTS expr SEMICOLON ;
