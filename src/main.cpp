#include <iostream>
#include <fstream>

#include "lexer/lexer.hpp"
#include "parser/parser.hpp"
#include "parser/printer.hpp"
#include "utils/error.hpp"

using namespace spade;

void compile() {
    auto file_name = R"(D:\Programming (Ankit)\Projects\spade\1.0\spadec\src\test.sp)";
    std::ifstream in(file_name);
    if (!in) throw FileOpenError(std::format("cannot open file '{}'", file_name));
    std::stringstream buffer;
    buffer << in.rdbuf();
    Lexer lexer(buffer.str());
    Parser parser(&lexer);
    auto ast = parser.expression();
    ast::Printer printer{ast};
    std::cout << printer;
    // auto token = lexer.next_token();
    // while (token->get_type() != TokenType::END_OF_FILE) {
    //     std::cout << *token << '\n';
    //     token = lexer.next_token();
    // }
}

void repl() {
    string code;
    while (true) {
        std::cout << ">>> ";
        std::getline(std::cin, code);
        if (code == "exit" || code == "quit") break;
        try {
            Lexer lexer(code);
            Parser parser(&lexer);
            auto tree = parser.expression();
            ast::Printer printer{tree};
            std::cout << printer;
        } catch (const LexerError &err) {
            std::cerr << std::format("error [{}:{}]: {}\n", err.get_line_start(), err.get_col_start(), err.what());
        } catch (const ParserError &err) {
            std::cerr << std::format("error [{}:{}]: {}\n", err.get_line_start(), err.get_col_start(), err.what());
        }
    }
}

int main() {
    try {
        // compile();
        repl();
    } catch (const LexerError &err) {
        std::cerr << std::format("error [{}:{}] {}\n", err.get_line_start(), err.get_col_start(), err.what());
    } catch (const ParserError &err) {
        std::cerr << std::format("error [{}:{}] {}\n", err.get_line_start(), err.get_col_start(), err.what());
    }
    return 0;
}
