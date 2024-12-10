package com.ayafitech.dsa.nonPrimitiveDS.non_linear_DS;

public class BST {
    static class Node {
        int data;
        Node left;
        Node right;
    
        Node (int data) {
            this.data = data;
//            right and left will be by default null.
        }
    }
    
    // as return type is Node because we will recursively using node, we will return root
    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        
        if (root.data > val ) {
            //left subtree
            root.left = insert(root.left, val); // this will return left child pointer/ reference
        } else {
            //right subtree
            root.right = insert(root.right, val);
        }
        
        return root;
    }
    
    public static void inorder(Node root) { // Sorted Traversal automatically    
        if (root == null) {
            return;
        }
        
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    
    public static boolean search(Node root, int key) {
        // Time Complexity -> O(H)
        if (root == null) {
            return false; // as no value from there
        }
        
        if (root.data > key) {
            //left subtree
            return search(root.left, key); // if exist in left then it will return true else false, as root dont have it.
        } else if(root.data == key) {
            // root of subtree
            return true; // as value found, or exist in root
        } else {
            // right subtree
            return search(root.right, key); // if exist in right then it will return true else false, as root dont have it.
        }
    }
    
    public static Node delete(Node root, int val) {
        if (root == null) {
            
        }
        
        if (root.data > val) {
            root.left = delete(root.left, val);
        } else if(root.data < val){
            root.right = delete(root.right, val);
        } else {
            //root.data == value
            //value found i mean
            // case 1: no child
            if (root.left == null && root.right == null) {
                return null;
            } 
            //case 2: one child
            if (root.left == null) {
                // child at right
                return root.right;
            } else if(root.right == null) {
                // child at left
                return root.left;
            }
            //case 3: two child
            //finding inorder successor -> left most node in right sub tree
            Node IS = inorderSuccessor(root.right);
            root.data = IS.data; // root data is replaced or attached with inorder successor data
            root.right = delete(root.right, IS.data); // it will go in root's right sub tree and will find inorder successor data and delete it, we get updated data and will update it in ours root.right subtree
        }
        
        return root;
    }
    
    public static Node inorderSuccessor(Node root) {
        // root wont be null as we are passing root right and we already checked is it null or not above, so no default check case of null, at line 90
        // hear we will find left most child, inorder successor
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }
    
    public static void main(String[] args) {
        int values[] = {5, 1, 3, 4, 2, 7};
        Node root = null;
        
        for(int i =0; i< values.length; i++) {
            root = insert(root, values[i]);
        }
        
        inorder(root);
        System.out.println();
        if (search(root, 1)) {
            System.out.println("found");
        } else {
            System.out.println("not found");
        }
        delete(root, 1);
        inorder(root);
    }
}
