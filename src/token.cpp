#include <unordered_map>

#include "token.hpp"

namespace spade
{
    const static std::unordered_map<string, TokenType> KEYWORDS = {
            {
             "package", TokenType::PACKAGE,
             },
            {
             "import", TokenType::IMPORT,
             },
            {
             "export", TokenType::EXPORT,
             },
            {
             "extends", TokenType::EXTENDS,
             },
            {
             "implements", TokenType::IMPLEMENTS,
             },
            {
             "enum", TokenType::ENUM,
             },
            {
             "class", TokenType::CLASS,
             },
            {
             "interface", TokenType::INTERFACE,
             },
            {
             "annotation", TokenType::ANNOTATION,
             },
            {
             "init", TokenType::INIT,
             },
            {
             "fun", TokenType::FUN,
             },
            {
             "const", TokenType::CONST,
             },
            {
             "var", TokenType::VAR,
             },
            {
             "abstract", TokenType::ABSTRACT,
             },
            {
             "final", TokenType::FINAL,
             },
            {
             "static", TokenType::STATIC,
             },
            {
             "inline", TokenType::INLINE,
             },
            {
             "private", TokenType::PRIVATE,
             },
            {
             "protected", TokenType::PROTECTED,
             },
            {
             "internal", TokenType::INTERNAL,
             },
            {
             "public", TokenType::PUBLIC,
             },
            {"if", TokenType::IF},
            {"else", TokenType::ELSE},
            {"while", TokenType::WHILE},
            {"do", TokenType::DO},
            {"for", TokenType::FOR},
            {"in", TokenType::IN},
            {"match", TokenType::MATCH},
            {"when", TokenType::WHEN},
            {"throw", TokenType::THROW},
            {"try", TokenType::TRY},
            {"catch", TokenType::CATCH},
            {"finally", TokenType::FINALLY},
            {"continue", TokenType::CONTINUE},
            {"break", TokenType::BREAK},
            {"return", TokenType::RETURN},
            {"yield", TokenType::YIELD},
            {"as", TokenType::AS},
            {"is", TokenType::IS},
            {"not", TokenType::NOT},
            {"and", TokenType::AND},
            {"or", TokenType::OR},
            {"super", TokenType::SUPER},
            {"self", TokenType::SELF},
            {"true", TokenType::TRUE},
            {"false", TokenType::FALSE},
            {"null", TokenType::NULL},
            {"object", TokenType::OBJECT},
            {"type", TokenType::TYPE},
            {"typeof", TokenType::TYPEOF}
    };

    string Token::to_string() const {
        return std::format("[{:02d}:{:02d}] {} {}", line, col, TokenInfo::to_string(type), text.c_str());
    }

    std::shared_ptr<Token> make_token(TokenType type, const string &text, int line, int col) {
        return std::make_shared<Token>(type, text, line, col);
    }

    bool TokenInfo::get_type_if_keyword(const string &text, TokenType &type) {
        try {
            type = KEYWORDS.at(text);
            return true;
        } catch (const std::out_of_range &) {
            return false;
        }
    }

    static string get_token_type_repr(TokenType type) {
        switch (type) {
            case TokenType::LPAREN:
                return "(";
            case TokenType::RPAREN:
                return ")";
            case TokenType::LBRACE:
                return "{";
            case TokenType::RBRACE:
                return "}";
            case TokenType::LBRACKET:
                return "[";
            case TokenType::RBRACKET:
                return "]";
            case TokenType::LANGLE:
                return "<";
            case TokenType::RANGLE:
                return ">";
            case TokenType::BANG:
                return "!";
            case TokenType::HOOK:
                return "?";
            case TokenType::TILDE:
                return "~";
            case TokenType::PLUS:
                return "+";
            case TokenType::DASH:
                return "-";
            case TokenType::ELVIS:
                return "??";
            case TokenType::STAR:
                return "*";
            case TokenType::STAR_STAR:
                return "**";
            case TokenType::SLASH:
                return "/";
            case TokenType::PERCENT:
                return "%";
            case TokenType::LSHIFT:
                return "<<";
            case TokenType::RSHIFT:
                return ">>";
            case TokenType::URSHIFT:
                return ">>>";
            case TokenType::AMPERSAND:
                return "&";
            case TokenType::PIPE:
                return "|";
            case TokenType::CARET:
                return "^";
            case TokenType::DOT:
                return ".";
            case TokenType::COMMA:
                return ",";
            case TokenType::EQUAL:
                return "=";
            case TokenType::COLON:
                return ":";
            case TokenType::PACKAGE:
                return "package";
            case TokenType::IMPORT:
                return "import";
            case TokenType::EXPORT:
                return "export";
            case TokenType::EXTENDS:
                return "extends";
            case TokenType::IMPLEMENTS:
                return "implements";
            case TokenType::ENUM:
                return "enum";
            case TokenType::CLASS:
                return "class";
            case TokenType::INTERFACE:
                return "interface";
            case TokenType::ANNOTATION:
                return "annotation";
            case TokenType::INIT:
                return "init";
            case TokenType::FUN:
                return "fun";
            case TokenType::CONST:
                return "const";
            case TokenType::VAR:
                return "var";
            case TokenType::ABSTRACT:
                return "abstract";
            case TokenType::FINAL:
                return "final";
            case TokenType::STATIC:
                return "static";
            case TokenType::INLINE:
                return "inline";
            case TokenType::PRIVATE:
                return "private";
            case TokenType::PROTECTED:
                return "protected";
            case TokenType::INTERNAL:
                return "internal";
            case TokenType::PUBLIC:
                return "public";
            case TokenType::IF:
                return "if";
            case TokenType::ELSE:
                return "else";
            case TokenType::WHILE:
                return "while";
            case TokenType::DO:
                return "do";
            case TokenType::FOR:
                return "for";
            case TokenType::IN:
                return "in";
            case TokenType::MATCH:
                return "match";
            case TokenType::WHEN:
                return "when";
            case TokenType::THROW:
                return "throw";
            case TokenType::TRY:
                return "try";
            case TokenType::CATCH:
                return "catch";
            case TokenType::FINALLY:
                return "finally";
            case TokenType::CONTINUE:
                return "continue";
            case TokenType::BREAK:
                return "break";
            case TokenType::RETURN:
                return "return";
            case TokenType::YIELD:
                return "yield";
            case TokenType::AS:
                return "as";
            case TokenType::IS:
                return "is";
            case TokenType::NOT:
                return "not";
            case TokenType::AND:
                return "and";
            case TokenType::OR:
                return "or";
            case TokenType::SUPER:
                return "super";
            case TokenType::SELF:
                return "self";
            case TokenType::TRUE:
                return "true";
            case TokenType::FALSE:
                return "false";
            case TokenType::NULL:
                return "null";
            case TokenType::OBJECT:
                return "object";
            case TokenType::TYPE:
                return "type";
            case TokenType::TYPEOF:
                return "typeof";
            case TokenType::IDENTIFIER:
                return "<identifier>";
            case TokenType::INTEGER:
                return "<integer>";
            case TokenType::FLOAT:
                return "<float>";
            case TokenType::STRING:
                return "<string>";
            case TokenType::END_OF_FILE:
                return "<EOF>";
            default:
                return "";
        }
    }

    string TokenInfo::get_repr(TokenType type) {
        auto repr = get_token_type_repr(type);
        if (repr.front() == '<' || repr.back() == '>') {
            return repr;
        }
        return "'" + repr + "'";
    }

    string TokenInfo::to_string(TokenType type) {
        switch (type) {
            default:
                return "";
        }
    }
}    // namespace spade