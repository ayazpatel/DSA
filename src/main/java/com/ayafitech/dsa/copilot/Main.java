package com.ayafitech.dsa.copilot;

/**
 * Class representing a node in the AVL tree
 */
class AVLNode {
    int key, height;
    AVLNode left, right;

    AVLNode(int d) {
        key = d;
        height = 1;
    }
}

/**
 * Class representing the AVL tree
 */
class AVLTree {
    AVLNode root;

    // Function to get the height of the tree
    int height(AVLNode N) {
        if (N == null)
            return 0;
        return N.height;
    }

    // Function to right rotate subtree rooted with y
    AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // Function to left rotate subtree rooted with x
    AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // Get balance factor of node N
    int getBalance(AVLNode N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    // Function to insert a key in the subtree rooted with node and return the new root of the subtree
    AVLNode insert(AVLNode node, int key) {
        // Perform the normal BST rotation
        if (node == null)
            return new AVLNode(key);

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else  // Duplicate keys not allowed
            return node;

        // Update height of this ancestor node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Get the balance factor of this ancestor node to check whether this node became unbalanced
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there are 4 cases

        // Left Left Case
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        // Return the (unchanged) node pointer
        return node;
    }

    // Function to print the AVL tree pictorially
    void printTree(AVLNode root, String indent, boolean last) {
        if (root != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "   ";
            } else {
                System.out.print("L----");
                indent += "|  ";
            }
            System.out.println(root.key);
            printTree(root.left, indent, false);
            printTree(root.right, indent, true);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        // Array with 30 hard-coded random elements
        int[] arr = {15, 10, 20, 8, 12, 18, 25, 6, 11, 14, 16, 19, 23, 28, 5, 7, 13, 17, 21, 24, 26, 27, 29, 22, 30, 4, 9, 3, 2, 1};

        // Inserting elements into the AVL tree
        for (int i = 0; i < arr.length; i++) {
            tree.root = tree.insert(tree.root, arr[i]);
        }

        // Printing the AVL tree pictorially
        tree.printTree(tree.root, "", true);
    }
}
