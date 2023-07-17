#include <iostream>
#include "antlr4-runtime.h"
#include "grammar/SpadeLexer.h"
#include "grammar/SpadeParser.h"
#include "utils/constants.hpp"
#include "grammar/ErrorListener.hpp"
#include "grammar/Visitor.h"

using namespace antlr4;

int main() {
    std::ifstream stream;
#if defined(OS_WINDOWS)
    stream.open(R"(D:\Programming (Ankit)\Projects\spadec\fib.sp)");
#elif defined(OS_LINUX)
    stream.open("/mnt/d/Programming (Ankit)/Projects/spadec/fib.sp");
#endif

    ANTLRInputStream input{stream};
    SpadeLexer lexer{&input};
    CommonTokenStream tokens{&lexer};
    SpadeParser parser{&tokens};
    parser.removeErrorListeners();
    auto listener = new ErrorListener;
    parser.addErrorListener(listener);
    Visitor visitor{&parser, listener};
    auto tree = parser.compilationUnit();
    std::cout << tree->getText() << "\n";
    visitor.visitCompilationUnit(tree);

    return 0;
}
