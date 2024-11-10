#ifndef KITE_ERROR_HPP
#define KITE_ERROR_HPP

#include <stdexcept>
#include "format.hpp"

namespace spade
{
    /**
     * The base error class
     */
    class SpadeError : public std::runtime_error {
      public:
        explicit SpadeError(const string &msg) : runtime_error(msg) {}
    };

    class CastError : public SpadeError {
      private:
        string from, to;

      public:
        CastError(const string &from, const string &to)
            : SpadeError(format("cannot cast type '%s' to type '%s'", from.c_str(), to.c_str())), from(from), to(to) {}

        const string &get_from() const {
            return from;
        }

        const string &get_to() const {
            return to;
        }
    };

    class FileOpenError : public SpadeError {
      public:
        explicit FileOpenError(const string &filename) : SpadeError(format("failed to open file: %s", filename.c_str())) {}
    };

    class CompilerError : public std::runtime_error {
      public:
        explicit CompilerError(const string &msg) : runtime_error(msg) {}
    };

    class LexerError : public SpadeError {
        int line_start;
        int col_start;
        int line_end;
        int col_end;

      public:
        LexerError(const string &msg, int line_start, int col_start, int line_end, int col_end)
            : SpadeError(msg), line_start(line_start), col_start(col_start), line_end(line_end), col_end(col_end) {}

        LexerError(const string &msg, int line_start, int col_start)
            : SpadeError(msg), line_start(line_start), col_start(col_start), line_end(line_start + 1), col_end(col_start + 1) {}

        int get_line_start() const {
            return line_start;
        }

        int get_col_start() const {
            return col_start;
        }

        int get_line_end() const {
            return line_end;
        }

        int get_col_end() const {
            return col_end;
        }
    };
}    // namespace spade

#endif    // KITE_ERROR_HPP
