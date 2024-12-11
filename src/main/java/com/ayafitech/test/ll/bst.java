package com.ayafitech.test.ll;

// Define the Node class
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree {
    Node root;

    public Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }

        return root;
    }

    public void preorder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public void postorder(Node root) {
        if (root == null) {
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }
}

public class binarysearchtree {
    public static void main(String[] args) {
        int nodes[] = {5, 1, 2, 3, 4, 6, 7, 8, 9, 10};
        BinaryTree bt = new BinaryTree();
        Node root = null;

        for (int i = 0; i < nodes.length; i++) {
            root = bt.insert(root, nodes[i]);
        }
        
        System.out.println("Preorder Traversal:");
        bt.preorder(root);
        System.out.println("\nInorder Traversal:");
        bt.inorder(root);
        System.out.println("\nPostorder Traversal:");
        bt.postorder(root);
    }
}
