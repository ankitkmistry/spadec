#ifndef SOURCE_UTILS_FORMAT_HPP_
#define SOURCE_UTILS_FORMAT_HPP_

#include <stdexcept>
#include "common.hpp"

namespace spade
{
    template<typename... Args>
    string format(const string &format, Args... args) {
        int size_s = std::snprintf(nullptr, 0, format.c_str(), args...) + 1;    // Extra space for '\0'
        if (size_s <= 0) {
            throw std::runtime_error("Error during formatting.");
        }
        auto size = static_cast<size_t>(size_s);
        std::unique_ptr<char[]> buf(new char[size]);
        std::snprintf(buf.get(), size, format.c_str(), args...);
        return string{buf.get(), buf.get() + size - 1};    // We don't want the '\0' inside
    }
}    // namespace spade

#endif /* SOURCE_UTILS_FORMAT_HPP_ */
