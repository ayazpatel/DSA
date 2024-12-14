package com.ayafitech.assignment3;

import java.util.Scanner;

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    void converseInorder() {
        converseInorderRec(root);
    }

    void converseInorderRec(Node root) {
        if (root != null) {
            converseInorderRec(root.right);
            System.out.print(root.key + " ");
            converseInorderRec(root.left);
        }
    }
}

public class que14 {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Scanner scanner = new Scanner(System.in);
        int choice, key;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Create a binary tree and insert records");
            System.out.println("2. Display all keys in ascending order (inorder traversal)");
            System.out.println("3. Display all keys in descending order (converse inorder traversal)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter key to insert: ");
                    key = scanner.nextInt();
                    bst.insert(key);
                    break;
                case 2:
                    System.out.println("Keys in ascending order:");
                    bst.inorder();
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Keys in descending order:");
                    bst.converseInorder();
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}

