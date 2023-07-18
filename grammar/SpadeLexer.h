
// Generated from D:/Programming (Ankit)/Projects/spadec/grammar\Spade.g4 by ANTLR 4.12.0

#pragma once


#include "antlr4-runtime.h"




class  SpadeLexer : public antlr4::Lexer {
public:
  enum {
    T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7, 
    T__7 = 8, T__8 = 9, T__9 = 10, T__10 = 11, T__11 = 12, T__12 = 13, T__13 = 14, 
    T__14 = 15, T__15 = 16, T__16 = 17, T__17 = 18, T__18 = 19, T__19 = 20, 
    T__20 = 21, T__21 = 22, T__22 = 23, T__23 = 24, T__24 = 25, T__25 = 26, 
    T__26 = 27, T__27 = 28, T__28 = 29, T__29 = 30, T__30 = 31, T__31 = 32, 
    T__32 = 33, T__33 = 34, T__34 = 35, T__35 = 36, T__36 = 37, PACKAGE = 38, 
    IMPORT = 39, EXPORT = 40, EXTENDS = 41, IMPLEMENTS = 42, ENUM = 43, 
    CLASS = 44, INTERFACE = 45, ANNOTATION = 46, INIT = 47, FUN = 48, CONST = 49, 
    VAR = 50, ABSTRACT = 51, FINAL = 52, STATIC = 53, INLINE = 54, PRIVATE = 55, 
    PROTECTED = 56, INTERNAL = 57, PUBLIC = 58, IF = 59, ELSE = 60, WHILE = 61, 
    DO = 62, FOR = 63, IN = 64, MATCH = 65, WHEN = 66, THROW = 67, TRY = 68, 
    CATCH = 69, FINALLY = 70, CONTINUE = 71, BREAK = 72, RETURN = 73, YIELD = 74, 
    GT = 75, GE = 76, NE = 77, EQ = 78, LE = 79, LT = 80, MODULUS = 81, 
    SLASH = 82, STAR = 83, PLUS = 84, DASH = 85, TILDE = 86, BANG = 87, 
    AS = 88, IS = 89, NOT = 90, AND = 91, OR = 92, SUPER = 93, THIS = 94, 
    TRUE = 95, FALSE = 96, NULL_ = 97, OBJECT = 98, TYPE = 99, TYPEOF = 100, 
    OUT = 101, REF = 102, IDENTIFIER = 103, INTEGER = 104, FLOAT = 105, 
    STRING = 106, WS = 107, NEWLINE = 108, BLOCK_COMMENT = 109, LINE_COMMENT = 110
  };

  explicit SpadeLexer(antlr4::CharStream *input);

  ~SpadeLexer() override;


  std::string getGrammarFileName() const override;

  const std::vector<std::string>& getRuleNames() const override;

  const std::vector<std::string>& getChannelNames() const override;

  const std::vector<std::string>& getModeNames() const override;

  const antlr4::dfa::Vocabulary& getVocabulary() const override;

  antlr4::atn::SerializedATNView getSerializedATN() const override;

  const antlr4::atn::ATN& getATN() const override;

  // By default the static state used to implement the lexer is lazily initialized during the first
  // call to the constructor. You can call this function if you wish to initialize the static state
  // ahead of time.
  static void initialize();

private:

  // Individual action functions triggered by action() above.

  // Individual semantic predicate functions triggered by sempred() above.

};

