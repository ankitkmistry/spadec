#ifndef SPADEC_ERROR_LISTENER_HPP
#define SPADEC_ERROR_LISTENER_HPP

#include "antlr4-runtime.h"

class ErrorListener : public antlr4::BaseErrorListener {
public:
    void
    syntaxError(antlr4::Recognizer *recognizer, antlr4::Token *offendingSymbol, size_t line, size_t charPositionInLine,
                const std::string &msg, std::exception_ptr e) override;
    void
    syntaxError(antlr4::Recognizer *recognizer, antlr4::ParserRuleContext *ctx, const std::string &msg);

    void underlineError(antlr4::Recognizer *recognizer, antlr4::Token *token, size_t line, size_t charPositionInLine);

    void underlineError(antlr4::Recognizer *recognizer, antlr4::ParserRuleContext *ctx);
};

#endif //SPADEC_ERROR_LISTENER_HPP
