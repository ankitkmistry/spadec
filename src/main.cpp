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
    auto ast = parser.parse();
    ast::Printer printer{ast};
    std::cout << printer;
}

void repl() {
    while (true) {
        std::stringstream code;
        std::cout << ">>> ";
        while (true) {
            if (!code.str().empty()) std::cout << "... ";
            string line;
            std::getline(std::cin, line);
            if (!line.empty() && line.back() == ';') {
                if (line.size() > 1) code << line.substr(0, line.size() - 1) << '\n';
                break;
            }
            code << line << '\n';
        }
        if (code.str() == "exit" || code.str() == "quit") return;
        try {
            Lexer lexer(code.str());
            Parser parser(&lexer);
            auto tree = parser.parse();
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
        compile();
        // repl();
    } catch (const LexerError &err) {
        std::cerr << std::format("error [{}:{}] {}\n", err.get_line_start(), err.get_col_start(), err.what());
    } catch (const ParserError &err) {
        std::cerr << std::format("error [{}:{}] {}\n", err.get_line_start(), err.get_col_start(), err.what());
    }
    return 0;
}
