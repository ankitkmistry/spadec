#include "ErrorListener.hpp"
#include "../utils/common.hpp"
#include "../utils/utils.hpp"

using namespace antlr4;

void ErrorListener::syntaxError(Recognizer *recognizer, Token *offendingSymbol, size_t line,
                                size_t charPositionInLine, const std::string &msg, std::exception_ptr e) {
    cerr << "line: " << line << ":" << charPositionInLine << " " << msg << "\n";
    underlineError(recognizer, offendingSymbol, line, charPositionInLine);
}

void ErrorListener::underlineError(Recognizer *recognizer, Token *token, size_t line, size_t charPositionInLine) {
    CommonTokenStream *tokens = dynamic_cast<CommonTokenStream *>(recognizer->getInputStream());
    string input = tokens->getTokenSource()->getInputStream()->toString();
    vector<string> lines = split(input, '\n');
    string errorLine = lines[line - 1];
    cerr << line << "\n";
    for (int i = 0; i < charPositionInLine; ++i) cout << ' ';
    int start = token->getStartIndex();
    int stop = token->getStopIndex();
    if (start >= 0 && stop >= 0)
        for (int i = start; i < stop; ++i) cout << "^";
    cerr << "\n";
}
