package com.ayafitech.assignment3;

class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int item) {
        value = item;
        left = right = null;
    }
}

class BinarySearchTree {
    TreeNode root;

    BinarySearchTree() {
        root = null;
    }

    // Function to insert a new key in BST
    void insert(int value) {
        root = insertRec(root, value);
    }

    // A recursive function to insert a new key in BST
    TreeNode insertRec(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }

        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }

        return root;
    }

    // Function to search a given key in BST
    boolean search(int value) {
        return searchRec(root, value);
    }

    // A recursive function to search a given key in BST
    boolean searchRec(TreeNode root, int value) {
        if (root == null) {
            return false;
        }
        if (root.value == value) {
            return true;
        }
        return value < root.value ? searchRec(root.left, value) : searchRec(root.right, value);
    }
}

public class que12 {
    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        BinarySearchTree bst = new BinarySearchTree();

        // Insert elements of the sorted array into the BST
        for (int value : sortedArray) {
            bst.insert(value);
        }

        int searchValue = 5; // Example value to search
        if (bst.search(searchValue)) {
            System.out.println("Value " + searchValue + " found in the BST.");
        } else {
            System.out.println("Value " + searchValue + " not found in the BST.");
        }
    }
}

