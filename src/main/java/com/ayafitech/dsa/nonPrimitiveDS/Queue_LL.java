/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ayafitech.dsa.nonPrimitiveDS;

/**
 *
 * @author Ayaz
 */
public class Queue_LL {
    
    class Node {
        int data;
        Node next;
    
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    
//    class Queue {
//        static Node head = null;
//        static Node tail = null;
//        
//        public boolean isEmpty() {
//            return head == null & rear == null;
//        }
//        
//        public void add(int data) {
//            Node newNode = new Node(data);
//            tail.next = newNode;
//            tail = newNode;
//        }
//    }
    
}
