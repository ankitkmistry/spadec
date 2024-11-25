cmake_minimum_required(VERSION 3.15)
project(spadec)

set(CMAKE_CXX_STANDARD 20)
include_directories(src)

file(GLOB_RECURSE SPADEC_SRCS src/*.cpp)
file(GLOB_RECURSE SPADEC_INCLUDES src/*.hpp)

add_executable(spadec ${SPADEC_SRCS} ${SPADEC_INCLUDES} "src/parser/import.cpp")

if (MSVC)
    find_library(DBGHELP_LIB dbghelp REQUIRED)
    target_link_libraries(spadec ${DBGHELP_LIB}) 
    add_compile_options(/Zi)
elseif (LINUX)
endif ()

