#include <iostream>

#include "lexer/lexer.hpp"
#include "parser/parser.hpp"
#include "utils/error.hpp"

using namespace spade;

void compile() {
    auto file_name = R"(D:\Programming (Ankit)\Projects\spade\1.0\spadec\src\test.sp)";
    FILE *file;
    fopen_s(&file, file_name, "r");
    if (file == null) {
        throw FileOpenError(file_name);
    }
    Lexer lexer(file);
    Parser parser(&lexer);
    parser.expression();
    // auto token = lexer.next_token();
    // while (token->get_type() != TokenType::END_OF_FILE) {
    //     std::cout << *token << '\n';
    //     token = lexer.next_token();
    // }
    std::fclose(file);
}

int main() {
    try {
        compile();
    } catch (const LexerError &err) {
        std::cerr << std::format("error [{}:{}] {}\n", err.get_line_start(), err.get_col_start(), err.what());
    } catch (const ParserError &err) {
        std::cerr << std::format("error [{}:{}] {}\n", err.get_line_start(), err.get_col_start(), err.what());
    }
    return 0;
}
