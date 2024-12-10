/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ayafitech.dsa.nonPrimitiveDS.non_linear_DS;

import java.util.Queue;
import java.util.LinkedList;

/**
 *
 * @author Ayaz
 */
public class BinaryTree {
    
    static class Node {
        int data;
        Node left;
        Node right;
        
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    static class myBinaryTree{
        static int idx = -1; //index;
        public static Node buildTree(int nodes[]) {
            idx++;
            if (idx >= nodes.length || nodes[idx] == -1) { //The condition idx >= nodes.length ensures that the method doesn't access elements outside the array bounds.
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);           
            //recursively
            return newNode;
        }
    }
    
    public static void preorder(Node root) {
        if (root == null) {
//            System.out.println("-1");
//            System.out.println("null");
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    
    public static void inorder(Node root) {
        if (root == null) {
//            System.out.println("-1");
//            System.out.println("null");
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    
    public static void postorder(Node root) {
        if (root == null) {
//            System.out.println("-1");
//            System.out.println("null");
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }
    
    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        
        while(!q.isEmpty()) {
            Node currentNode = q.remove();
            if (currentNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break; 
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currentNode.data + " ");
                if (currentNode.left != null) {
                    q.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    q.add(currentNode.right);
                }
            }
        }
    }
    
    public static int countOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftNodes = countOfNodes(root.left);
        int rightNodes = countOfNodes(root.right);
        
        return leftNodes + rightNodes + 1;
    }
    
    public static int sumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);
        
        return leftSum + rightSum + root.data;
    }
    
    public static int height(Node root) {
        if (root == null) {
            return 0;
            
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        
        int myHeight = Math.max(leftHeight, leftHeight) + 1;
        
        return myHeight;
    }
    
    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        myBinaryTree tree = new myBinaryTree();
        Node root = tree.buildTree(nodes);
        if (root != null) {
            System.out.println("Root data: " + root.data);
            
            System.out.print("PreOrder:  ");
            preorder(root);
            System.out.print("\n");
            
            System.out.print("Inorder:   ");
            inorder(root);
            System.out.print("\n");
            
            System.out.print("PostOrder: ");
            postorder(root);
            System.out.print("\n");
            
            System.out.print("LevelOrder: \n");
            levelOrder(root);
            System.out.print("\n");
            
            System.out.print("Calculate Total Nodes: " + countOfNodes(root) + "\n "); 
            
            System.out.print("Sum Of Data Of Total Nodes: " + sumOfNodes(root) + "\n");
            
            System.out.print("Total Height: " + height(root) + "\n");
            
            
        } else { 
            System.out.println("The tree is empty."); 
        }
        
    }
    
}
