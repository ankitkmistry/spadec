grammar Spade;

sep: ';'*;          // Separator

compilationUnit: packageStmt? importStmt* declaration* EOF;

packageStmt: PACKAGE reference sep;
importStmt: IMPORT reference (AS IDENTIFIER)? sep;

reference: IDENTIFIER ('.' IDENTIFIER)*;

// Declarations
declaration: modifiers (
                 varDecl sep
               | functionDecl
               | classDecl
               | interfaceDecl
               | enumDecl
               | annoDecl
            );

// Enum declaration
enumDecl: ENUM IDENTIFIER (IMPLEMENTS parentList)? ('{' enumList sep memberDecl* '}')?;

enumList: enumerator (',' enumerator)* ','?;
enumerator: IDENTIFIER ('=' expr | '(' args? ')')?;

// Annotation declaration
annoDecl: ANNOTATION declName (EXTENDS parent)? (IMPLEMENTS parentList)? ('{' memberDecl* '}')?;
// Interface declaration
interfaceDecl: INTERFACE declName (EXTENDS parentList)? ('{' memberDecl* '}')?;
// Class declaration
classDecl: CLASS declName (EXTENDS parent)? (IMPLEMENTS parentList)? ('{' memberDecl* '}')?;

parentList: parent (',' parent)* ','?;
parent: reference ('<'typeArgs'>')?;

declName: IDENTIFIER ('<' typeParams '>')?;
typeParams: typeParam (',' typeParam)* ','?;
typeParam: (OUT | IN)? IDENTIFIER (':' variantOf=type)? ('=' defaultValue=type)?;

// Member declaration
memberDecl: modifiers (
                fieldDecl
              | methodDecl
              | constructorDecl
              | classDecl
              | interfaceDecl
              | enumDecl
           ) sep;

fieldDecl: CONST? name ('=' expr)?;
methodDecl: (IDENTIFIER | 'operator' op=operators | 'as' type) '(' params? ')' ('->' type)? definition?;
operators: '!' | '-' | '~' | '+'
         | '??'
         | '**' | '*' | '/' | '%'
         | '<<' | '>>>' | '>>'
         | '<' | '<=' | '==' | '!=' | '>=' | '>'
         | '&' | '^' | '|'
         | 'is' 'not'? | 'not'? 'in'
         | 'not' | 'and' | 'or';
constructorDecl: INIT '(' params? ')' definition?;

modifiers: (ABSTRACT | FINAL | STATIC | INLINE | accessors)*;
accessors: PRIVATE | INTERNAL | PROTECTED | PUBLIC;

// Function declaration
functionDecl: FUN methodDecl;
definition: '=' stmt sep | block;

// Parameter declaration
params: paramList ('|' paramList?)?;
paramList: param (',' param)* ','?;
param: (CONST | REF)? '*'? (IDENTIFIER | '_') (':' type)? ('=' expr)?;

// Variable declaration
varDecl: (VAR | CONST) name ('=' expr)?;

name: IDENTIFIER (':' type)? | destructDecl;

// Statement
stmts: stmt sep | block;
stmt
    : IF expr body else?                                  # ifStmt
    | WHILE expr body else?                               # whileStmt
    | DO block WHILE expr else?                           # doStmt
    | FOR (varDecl | expr) ';' expr ';' expr body else?               # forStmt
    | FOR IDENTIFIER IN postfix body else?                # foreachStmt
    | MATCH expr '{'
        matchCase*
        (ELSE '->' stmts)?
      '}'                                                   # matchStmt
    | THROW expr                                            # throwStmt
    | TRY block (catchStmt+ finallyStmt? | finallyStmt)     # tryStmt
    | CONTINUE                                              # continueStmt
    | BREAK                                                 # breakStmt
    | RETURN stmts                                          # returnStmt
    | YIELD expr                                            # yieldStmt
    | '...'                                                 # noStmt
    | expr                                                  # exprStmt
    ;

block: '{' (block | declaration | stmt)* '}';

matchCase: WHEN items (IF expr)? '->' stmts;

catchStmt: CATCH typeList (AS IDENTIFIER)? block;
finallyStmt: FINALLY block;

body: ':' stmt sep | block;
else: ELSE body;

// Expression
expr
    : op=(BANG|TILDE|DASH|PLUS)? postfix                            # unaryExpr
    | expr '??' expr                                        # elvisExpr
    | expr (AS safe='?'? type)*                                   # castExpr
    | <assoc=right> expr '**' expr                          # powerExpr
    | expr op=(STAR|SLASH|MODULUS) expr                               # factorExpr
    | expr op=(PLUS|DASH) expr                                   # termExpr
    | expr ('<''<'|'>''>'|'>''>''>') expr                   # shiftExpr
    | expr '&' expr                                         # bitAndExpr
    | expr '^' expr                                         # bitXorExpr
    | expr '|' expr                                         # bitOrExpr
    | expr op=(LT|LE|EQ|NE|GE|GT) expr               # relationalExpr
    | expr (IS NOT?|NOT? IN) expr                   # conditionalExpr
    | NOT expr                                            # notExpr
    | expr AND expr                                       # andExpr
    | expr OR expr                                        # orExpr
    | expr if expr else expr                                # ternaryExpr
    | (param | '(' params? ')') '->' type? (block | expr)   # lambdaExpr
    | assigneeList assignOperator items                     # assignExpr
    ;

assigneeList: assignee (',' assignee)* ','?;
assignee: postfix | destructDecl;
assignOperator: '='|'+='|'-='|'*='|'/='|'%='|'**='|'<<='|'>>='|'>>>='|'&='|'|='|'^='|'??=';

destructDecl: '[' destruct (',' destruct)* ','? ']';
destruct: '*' IDENTIFIER ('['INTEGER?']')? | IDENTIFIER | '_';

// Postfix expression
postfix: primary                   # postfixPrimary
    | postfix '?'? '.' IDENTIFIER  # postfixDot
    | postfix '(' args? ')'        # postfixCall
    | postfix '[' indexer ']'      # postfixIndexer
    | postfix '[' typeArgs ']'     # postfixGeneric
    | postfix block                # postfixBlock
    ;

args: arg (',' arg)* ','?;
arg: (IDENTIFIER ':')? (expr | '_');

indexer: slice (',' slice)* ','?;
slice: expr
     | expr? ':' expr? (':' expr?)?;

// Primary expressions
primary: TRUE | FALSE | NULL | INTEGER | FLOAT | STRING | IDENTIFIER                       # constantExpr
       | objectBuilder                  # builderExpr
       | SUPER ('[' reference ']')?     # superExpr
       | SELF                           # thisExpr
       | '(' (expr)  ')'                # groupExpr
       | '(' items? ')'                 # tupleExpr
       | '{' items '}'                  # setExpr
       | '{' entries? '}'               # mapExpr
       | '[' items? ']'                 # listExpr
       | type                           # typeExpr
       ;

objectBuilder: OBJECT (':' type)? '{' memberDecl* '}';

items: expr (',' expr)* ','?;

entries: entry (',' entry)* ','?;
entry: primary ':' expr;

// Kind expressions
type: type '|' type                         # unionType
    | type '&' type                         # intersectionType
    | type '?'                              # nullableType
    | primaryType;

primaryType: | reference ('[' typeArgs ']')?              # referenceType
             | TYPEOF '(' expr ')'                 # typeofType
             | TYPE                                # literalType
             | '(' paramTypes? ')' '->' type          # functionType
             | '(' type ')' # groupedType
             | OBJECT ('{' memberTypeList? '}')?  # objectType
    ;

typeArgs: type (',' type)* ','?;

paramTypes: paramType (',' paramType)* ','?;
paramType: '*'? type;

typeList: type (',' type)* ','?;

memberTypeList: memberType (',' memberType)* ','?;
memberType: IDENTIFIER (':' type)?;

// Keywords

// Heading
PACKAGE: 'package';
IMPORT: 'import';
EXPORT: 'export';
// Clauses
EXTENDS: 'extends';
IMPLEMENTS: 'implements';
// Declarations
ENUM: 'enum';
CLASS: 'class';
INTERFACE: 'interface';
ANNOTATION: 'annotation';
INIT: 'init';
FUN: 'fun';
CONST: 'const';
VAR: 'var';
// Modifiers
ABSTRACT: 'abstract';
FINAL: 'final';
STATIC: 'static';
INLINE: 'inline';
// Accessors
PRIVATE: 'private';
PROTECTED: 'protected';
INTERNAL: 'internal';
PUBLIC: 'public';
// Statements
IF: 'if';
ELSE: 'else';
WHILE: 'while';
DO: 'do';
FOR: 'for';
IN: 'in';
MATCH: 'match';
WHEN: 'when';
THROW: 'throw';
TRY: 'try';
CATCH: 'catch';
FINALLY: 'finally';
CONTINUE: 'continue';
BREAK: 'break';
RETURN: 'return';
YIELD: 'yield';
// Operators
GT : '>' ;
GE : '>=' ;
NE : '!=' ;
EQ : '==' ;
LE : '<=' ;
LT : '<' ;
MODULUS : '%' ;
SLASH : '/' ;
STAR : '*' ;
PLUS : '+' ;
DASH : '-' ;
TILDE : '~' ;
BANG : '!' ;
AS: 'as';
IS: 'is';
NOT: 'not';
AND: 'and';
OR: 'or';
// Primary expressions
SUPER: 'super';
SELF: 'self';
// Literals
TRUE: 'true';
FALSE: 'false';
NULL: 'null';
// Special keywords
OBJECT: 'object';
TYPE: 'varKind';
TYPEOF: 'typeof';

// Contextual keywords
OUT: 'out';
REF: 'ref';

IDENTIFIER: [a-zA-Z_][a-zA-Z0-9_]*
          | REF | OUT;

INTEGER: DECIMAL
       | ('0b'|'0B') BINARY
       | '0' OCTAL
       | ('0x'|'0X') HEX
       ;

FLOAT: DECIMAL '.' DECIMAL? (('e'|'E') EXP)?
     | ('0x'|'0X') HEX '.' HEX? (('p'|'P') EXP)?;

STRING: '\'' (ESC|~[\n])*? '\''
      | '"' (ESC|.)*? '"'
      | '`' (ESC|.)*? '`'
      ;

fragment ESC: '\\"' | '\\\\';
fragment EXP: ('+'|'-') DECIMAL;
fragment DECIMAL: (('0'..'9') '_'?)+;
fragment BINARY: (('0'..'1') '_'?)+;
fragment OCTAL: (('0'..'7') '_'?)+;
fragment HEX: ([0-9a-fA-F] '_'?)+;

WS: [ \t\f]+ -> skip;
NEWLINE: '\r'? '\n' -> channel(HIDDEN);

BLOCK_COMMENT
	: '/*' .*? '*/' -> skip
	;
LINE_COMMENT
	: '//' ~[\r\n]* -> skip
	;