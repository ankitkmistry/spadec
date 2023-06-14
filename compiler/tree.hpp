#ifndef SPADEC_TREE_HPP
#define SPADEC_TREE_HPP

#include "node.hpp"

class DeclTree {
private:
    DeclNode *root;
public:
    explicit DeclTree(DeclNode *root = null) : root(root) {}

    DeclNode *getRoot() const { return root; }

    void setRoot(DeclNode *root_) { root = root_; }
};

#endif //SPADEC_TREE_HPP
