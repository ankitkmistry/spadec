cmake_minimum_required(VERSION 3.25)
project(spadec)

list(APPEND CMAKE_MODULE_PATH ${CMAKE_CURRENT_SOURCE_DIR}/cmake)

set(CMAKE_CXX_STANDARD 17)

# required if linking to static library
add_definitions(-DANTLR4CPP_STATIC)

# using /MD flag for antlr4_runtime (for Visual C++ compilers only)
set(ANTLR4_WITH_STATIC_CRT OFF)

# Specify the version of the antlr4 library needed for this project.
# By default the latest version of antlr4 will be used.  You can specify a
# specific, stable version by setting a repository tag value or a link
# to a zip file containing the libary source.
# set(ANTLR4_TAG 4.13.0)
# set(ANTLR4_ZIP_REPOSITORY https://github.com/antlr/antlr4/archive/refs/tags/4.13.0.zip)

# add external build for antlr-cpp
include(ExternalAntlr4Cpp)

# add antlr4cpp artifacts to project environment
include_directories(${ANTLR4_INCLUDE_DIRS})

# set variable pointing to the antlr tool that supports C++
# this is not required if the jar file can be found under PATH environment
if (WIN32)
    set(ANTLR_EXECUTABLE "D:\\Programming (Ankit)\\Libraries\\antlr4\\antlr-4.13.0-complete.jar")
else ()
    set(ANTLR_EXECUTABLE "mnt/d/Programming (Ankit)/Libraries/antlr4/antlr-4.13.0-complete.jar")
endif ()

# add macros to generate ANTLR Cpp code from grammar
find_package(ANTLR REQUIRED)

# Call macro to add lexer and grammar to your build dependencies.
#antlr_target(Spade grammar/Spade.g4 LEXER PARSER VISITOR)

# include generated files in project environment
#include_directories(${ANTLR_SPADE_OUTPUT_DIR})

add_executable(spadec main.cpp
#        ${ANTLR_SPADE_CXX_OUTPUTS}
        grammar/SpadeVisitor.cpp grammar/SpadeParser.cpp grammar/SpadeLexer.cpp grammar/Visitor.cpp compiler/node.cpp compiler/node.hpp compiler/tree.cpp compiler/tree.hpp grammar/ErrorListener.cpp grammar/ErrorListener.hpp utils/utils.hpp utils/utils.cpp utils/sign.cpp)
target_link_libraries(spadec antlr4_static)
