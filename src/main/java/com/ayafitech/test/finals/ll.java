/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ayafitech.test.finals;

/**
 *
 * @author Ayaz
 */
public class ll {
    static class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    static class linkedlist {
        static Node head;
        
        public void insertLast(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            
            Node currNode = head;
            while(currNode != null) {
                currNode = currNode.next;
            }
            currNode.next = newNode;
        }
        
        public void insertFirst(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }
        
        public void deleteFirst() {
            if (head == null) {
                return;
            }
            head = head.next;
        }
        
        public void deleteLast() {
            if (head == null) {
                return;
            }
            Node last = head.next;
            Node last2nd = head;
            while (last != null) {
                last2nd = last;
                last = last.next;
            }
            last2nd.next = null;
        }
        
        public void delete(int data) {
            if (head == null) {
                return;
            }
            Node currNode = head;
            Node prevNode = null;
            
            while(currNode != null && currNode.data != data) {
                prevNode = currNode;
                currNode = currNode.next;
            }
            
            if (currNode == null) {
                System.out.println("Not Found");
                return;
            }
            
            prevNode.next = currNode.next;
            System.out.println("Found");
        }
        
        public void deleteAt(int index) {
            if (head == null) {
                return;
            }
            if (index == 0) {
                head = head.next;
                return;
            }
            Node currNode = head;
            Node prevNode = null;
            for (int i = 0; i < index; i++) {
                prevNode = currNode;
                currNode = currNode.next;
            }
            prevNode.next = currNode.next;
        }
        
        public void display() {
            Node currNode = head;
            while(currNode!= null) {
                System.out.print(currNode.data + " ");
                currNode = currNode.next;
            }
        }
    }
    
    public static void main(String[] args) {
        
    }
}
