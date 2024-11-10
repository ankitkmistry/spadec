#include <iostream>

#include "lexer.hpp"
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
    auto token = lexer.next_token();
    while (token->get_type() != TokenType::END_OF_FILE) {
        std::cout << *token << '\n';
        token = lexer.next_token();
    }
    std::fclose(file);
}

int main() {
    try {
        compile();
    } catch (const LexerError &err) {
        std::cerr << '[' << err.get_line_start() << ':' << err.get_col_start() << "]: " << err.what() << '\n';
    }
    return 0;
}
