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
typeParam: (OUT | IN)? IDENTIFIER (':' variantOf=kind)? ('=' defaultValue=kind)?;

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
methodDecl: IDENTIFIER '(' params? ')' ('->' kind)? definition?;
constructorDecl: INIT '(' params? ')' definition?;

modifiers: (ABSTRACT | FINAL | STATIC | INLINE | accessors)*;
accessors: PRIVATE | INTERNAL | PROTECTED | PUBLIC;

// Function declaration
functionDecl: FUN methodDecl;
definition: '=' stmt sep | block;

// Parameter declaration
params: paramList ('|' paramList?)?;
paramList: param (',' param)* ','?;
param: (CONST | REF)? '*'? (IDENTIFIER | '_') (':' kind)? ('=' expr)?;

// Variable declaration
varDecl: (VAR | CONST) name ('=' expr)?;

name: IDENTIFIER (':' kind)? | destructDecl;

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

destructDecl: '[' destruct (',' destruct)* ','? ']';
destruct: '*' IDENTIFIER ('['INTEGER?']')? | IDENTIFIER | '_';

block: '{' (block | declaration | stmt)* '}';

matchCase: WHEN items (IF expr)? '->' stmts;

catchStmt: CATCH typeList (AS IDENTIFIER)? block;
finallyStmt: FINALLY block;

body: ':' stmt sep | block;
else: ELSE body;

// Expression
expr
    : ('!'|'~'|'-'|'+')? postfix                            # unaryExpr
    | expr '??' expr                                        # elvisExpr
    | expr AS '?'? kind                                   # castExpr
    | <assoc=right> expr '**' expr                          # powerExpr
    | expr ('*'|'/'|'%') expr                               # factorExpr
    | expr ('+'|'-') expr                                   # termExpr
    | expr ('<''<'|'>''>'|'>''>''>') expr                   # shiftExpr
    | expr '&' expr                                         # bitAndExpr
    | expr '^' expr                                         # bitXorExpr
    | expr '|' expr                                         # bitOrExpr
    | expr ('<'|'<='|'=='|'!='|'>='|'>') expr               # relationalExpr
    | expr (IS NOT?|NOT? IN) expr                   # conditonalExpr
    | NOT expr                                            # notExpr
    | expr AND expr                                       # andExpr
    | expr OR expr                                        # orExpr
    | expr '?' expr ':' expr                                # ternaryExpr
    | (param | '(' params? ')') '->' kind? (block | expr)   # lambdaExpr
    | assigneeList assignOperator items                     # assignExpr
    ;

assigneeList: assignee (',' assignee)* ','?;
assignee: postfix | destructDecl;
assignOperator: '='|'+='|'-='|'*='|'/='|'%='|'**='|'<<='|'>>='|'>>>='|'&='|'|='|'^='|'??=';

// Postfix expression
postfix: primary                   # postFixPrimary
    | postfix '?'? '.' IDENTIFIER  # postfixDot
    | postfix '<' typeArgs '>'    # postfixGeneric
    | postfix '(' args? ')'        # postfixCall
    | postfix '[' indexer ']'      # postfixIndexer
    | postfix block                # postfixBlock
    ;

args: arg (',' arg)* ','?;
arg: (IDENTIFIER ':')? (expr | '_');

indexer: slice (',' slice)* ','?;
slice: expr
     | expr? ':' expr? (':' expr?)?;

// Primary expressions
primary: constant                       # constantExpr
       | objectBuilder                 # builderExpr
       | SUPER '[' IDENTIFIER ']'     # superExpr
       | THIS                         # thisExpr
       | '(' (expr)  ')'                # groupExpr
       | '(' items? ')'                 # tupleExpr
       | '{' items '}'                  # setExpr
       | '{' entries? '}'               # mapExpr
       | '[' items? ']'                 # listExpr
       | kind                           # typeExpr
       ;

constant: TRUE | FALSE | NULL | literal;
literal: INTEGER | FLOAT | STRING | IDENTIFIER;

objectBuilder: OBJECT (':' kind)? '{' /*member**/ '}';

items: expr (',' expr)* ','?;

entries: entry (',' entry)* ','?;
entry: primary ':' expr;

// Kind expressions
kind: kind '?'                              # nullableType
    | kind '&' kind                         # intersectionType
    | kind '|' kind                         # unionType
    | reference ('<' typeArgs '>')?              # referenceType
    | '(' paramTypes ')' '->' kind          # functionType
    | TYPE                                # literalType
    | OBJECT ('{' memberTypeList? '}')?  # objectType
    | TYPEOF '(' expr ')'                 # typeofType
    ;

typeArgs: typeArg (',' typeArg)* ','?;
typeArg: (OUT | IN)? kind;

paramTypes: paramType (',' paramType)* ','?;
paramType: '*'? kind;

typeList: kind (',' kind)* ','?;

memberTypeList: memberType (',' memberType)* ','?;
memberType: IDENTIFIER (':' kind)?;

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
AS: 'as';
IS: 'is';
NOT: 'not';
AND: 'and';
OR: 'or';
// Primary expressions
SUPER: 'super';
THIS: 'this';
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