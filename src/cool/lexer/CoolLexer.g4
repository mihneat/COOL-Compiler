lexer grammar CoolLexer;

tokens { ERROR }

@header{
    package cool.lexer;
}

@members{
    private void raiseError(String msg) {
        setText(msg);
        setType(ERROR);
    }
}

/* Keywords */

CLASS : [Cc][Ll][Aa][Ss][Ss] ;
ELSE : [Ee][Ll][Ss][Ee] ;
FALSE : 'f'[Aa][Ll][Ss][Ee] ;
FI : [Ff][Ii] ;
IF : [Ii][Ff] ;
IN : [Ii][Nn] ;
INHERITS : [Ii][Nn][Hh][Ee][Rr][Ii][Tt][Ss] ;
ISVOID : [Ii][Ss][Vv][Oo][Ii][Dd] ;
LET : [Ll][Ee][Tt] ;
LOOP : [Ll][Oo][Oo][Pp] ;
POOL : [Pp][Oo][Oo][Ll] ;
THEN : [Tt][Hh][Ee][Nn] ;
WHILE : [Ww][Hh][Ii][Ll][Ee] ;
CASE : [Cc][Aa][Ss][Ee] ;
ESAC : [Ee][Ss][Aa][Cc] ;
NEW : [Nn][Ee][Ww] ;
OF : [Oo][Ff] ;
NOT : [Nn][Oo][Tt] ;
TRUE : 't'[Rr][Uu][Ee] ;


/* Special symbols */

SEMICOLON : ';' ;
COLON : ':' ;
COMMA : ',' ;
AT : '@' ;
ASSIGN : '<-' ;
DOT : '.' ;
RESULTS : '=>' ;

LPAREN : '(' ;
RPAREN : ')' ;

LBRACE : '{' ;
RBRACE : '}' ;

PLUS : '+' ;
MINUS : '-' ;
STAR : '*' ;
SLASH : '/' ;
INVERSE : '~' ;
LT : '<' ;
LE : '<=' ;
EQ : '=' ;


/* Integers */

fragment DIGIT : [0-9] ;
INT : DIGIT+ ;


/* Identifiers */

fragment UPPER_LETTER : [A-Z] ;
fragment LOWER_LETTER : [a-z] ;
fragment LETTER : UPPER_LETTER | LOWER_LETTER ;
fragment ID_CHAR : LETTER | DIGIT | '_';

TYPE_ID : UPPER_LETTER ID_CHAR* ;
OBJECT_ID : LOWER_LETTER ID_CHAR* ;


/* Strings */

fragment NEWLINE : '\n' | '\r\n' ;

fragment ERR_STRING_NEW_LINE : '"' ('\\' ~[\r\n] | ~[\\\r\n"])*? NEWLINE ;
fragment ERR_STRING_NULL_CHAR : '"' ('\\"' | .)*? '\u0000' ('\\"' | .)*? '"' ;
fragment ERR_STRING_EOF : '"' ('\\"' | .)*? EOF ;
fragment CORRECT_STRING : '"' ('\\"' | ~'\u0000')*? '"' ;

STRING
    : ERR_STRING_NEW_LINE { raiseError("Unterminated string constant"); }
    | CORRECT_STRING {

        // Get the unmodified string
        String s = getText();
        StringBuilder sb = new StringBuilder();

        // Remove the start and end quotation marks
        s = s.substring(1, s.length() - 1);

        for (int i = 0; i < s.length(); ++i) {
            char currChar = s.charAt(i);
            if (currChar != '\\') {
                sb.append(currChar);
                continue;
            }

            // Escape the next character
            ++i;
            currChar = s.charAt(i);

            switch (currChar) {
                case 'n':
                    sb.append('\n');
                    break;
                case 't':
                    sb.append('\t');
                    break;
                case 'b':
                    sb.append('\b');
                    break;
                case 'f':
                    sb.append('\f');
                    break;
                default:
                    sb.append(currChar);
            }
        }

        // Check the length
        if (sb.toString().length() > 1024) {
            raiseError("String constant too long");
            return;
        }

        // Return the modified string
        setText(sb.toString());
    }
    | ERR_STRING_NULL_CHAR { raiseError("String contains null character"); }
    | ERR_STRING_EOF { raiseError("EOF in string constant"); }
    ;


/* Comments */

SINGLE_LINE_COMMENT : '--' .*? (NEWLINE | EOF) -> skip ;

MULTI_LINE_COMMENT : '(*' (MULTI_LINE_COMMENT | .)*? ('*)' { skip(); } | EOF { raiseError("EOF in comment"); }) ;

ERR_UNOPENED_COMMENT : '*)' { raiseError("Unmatched *)"); } ;


/* Whitespace */

WS : [ \n\f\r\t]+ -> skip ;


/* Invalid character */

INVALID_CHARACTER : . { raiseError("Invalid character: " + getText()); } ;
