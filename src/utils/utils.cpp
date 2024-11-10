#include <cmath>
#include "utils.hpp"

#if defined COMPILER_MSVC
#    include <windows.h>
#    include <dbghelp.h>

#elif defined COMPILER_GCC
#    include <cxxabi.h>
#endif
namespace spade
{
#if defined COMPILER_MSVC
    bool init() {
        SymSetOptions(SYMOPT_UNDNAME | SYMOPT_DEFERRED_LOADS);
        if (!SymInitialize(GetCurrentProcess(), NULL, TRUE)) {
            return false;
        }
        return true;
    }
#endif

    string cpp_demangle(string str) {
        if (str.empty()) return str;
#if defined COMPILER_MSVC
        static bool sym_init = false;
        if (!sym_init) {
            sym_init = init();
        }
        constexpr int size = 4096;
        std::unique_ptr<char[]> buf(new char[size]);
        auto length = UnDecorateSymbolName(str.c_str(), buf.get(), size, UNDNAME_NAME_ONLY);
        if (length == 0) return str;
        return string{buf.get(), buf.get() + length};
#elif defined COMPILER_GCC
        int status;
        char *outStr = abi::__cxa_demangle(str.c_str(), null, null, &status);
        if (status != 0 || outStr == null) return str;
        return string{outStr};
#elif defined COMPILER_OTHER
        return str;
#endif
    }
}    // namespace spade