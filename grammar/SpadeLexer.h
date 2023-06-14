
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
    T__32 = 33, T__33 = 34, T__34 = 35, T__35 = 36, T__36 = 37, T__37 = 38, 
    T__38 = 39, T__39 = 40, T__40 = 41, T__41 = 42, T__42 = 43, T__43 = 44, 
    T__44 = 45, T__45 = 46, PACKAGE = 47, IMPORT = 48, EXPORT = 49, EXTENDS = 50, 
    IMPLEMENTS = 51, ENUM = 52, CLASS = 53, INTERFACE = 54, ANNOTATION = 55, 
    INIT = 56, FUN = 57, CONST = 58, VAR = 59, ABSTRACT = 60, FINAL = 61, 
    STATIC = 62, INLINE = 63, PRIVATE = 64, PROTECTED = 65, INTERNAL = 66, 
    PUBLIC = 67, IF = 68, ELSE = 69, WHILE = 70, DO = 71, FOR = 72, IN = 73, 
    MATCH = 74, WHEN = 75, THROW = 76, TRY = 77, CATCH = 78, FINALLY = 79, 
    CONTINUE = 80, BREAK = 81, RETURN = 82, YIELD = 83, AS = 84, IS = 85, 
    NOT = 86, AND = 87, OR = 88, SUPER = 89, THIS = 90, TRUE = 91, FALSE = 92, 
    NULL_ = 93, OBJECT = 94, TYPE = 95, TYPEOF = 96, OUT = 97, REF = 98, 
    IDENTIFIER = 99, INTEGER = 100, FLOAT = 101, STRING = 102, WS = 103, 
    NEWLINE = 104, BLOCK_COMMENT = 105, LINE_COMMENT = 106
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

