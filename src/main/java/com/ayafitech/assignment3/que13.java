package com.ayafitech.assignment3;

import java.util.Scanner;

class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int item) {
        value = item;
        left = right = null;
    }
}

class BinaryTree {
    TreeNode root;

    BinaryTree() {
        root = null;
    }

    // Function to insert a new node in the binary tree
    void insert(int value) {
        root = insertRec(root, value);
    }

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

    // Function to search and replace a node in the binary tree
    boolean searchAndReplace(int oldValue, int newValue) {
        TreeNode node = search(root, oldValue);
        if (node != null) {
            node.value = newValue;
            return true;
        }
        return false;
    }

    TreeNode search(TreeNode root, int value) {
        if (root == null || root.value == value) {
            return root;
        }
        if (value < root.value) {
            return search(root.left, value);
        }
        return search(root.right, value);
    }

    // Preorder traversal
    void preorder(TreeNode node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    // Inorder traversal
    void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.value + " ");
            inorder(node.right);
        }
    }

    // Postorder traversal
    void postorder(TreeNode node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.value + " ");
        }
    }
}

public class que13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        int choice, value, oldValue, newValue;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Create a binary tree");
            System.out.println("2. Search and replace a node");
            System.out.println("3. Preorder traversal");
            System.out.println("4. Inorder traversal");
            System.out.println("5. Postorder traversal");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    value = scanner.nextInt();
                    tree.insert(value);
                    break;
                case 2:
                    System.out.print("Enter value to search: ");
                    oldValue = scanner.nextInt();
                    System.out.print("Enter new value to replace: ");
                    newValue = scanner.nextInt();
                    if (tree.searchAndReplace(oldValue, newValue)) {
                        System.out.println("Node replaced successfully.");
                    } else {
                        System.out.println("Node not found.");
                    }
                    break;
                case 3:
                    System.out.println("Preorder traversal:");
                    tree.preorder(tree.root);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Inorder traversal:");
                    tree.inorder(tree.root);
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Postorder traversal:");
                    tree.postorder(tree.root);
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}

