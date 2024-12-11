package com.ayafitech.test.ll;

public class doubly_ll {
    static class Node {
        int data;
        Node previous;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.previous = null;
            this.next = null;
        }
    }
    
    static class LL {
        static Node head;
        static Node tail;
        
        static void addFirst(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
        
        static void addLast(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head= newNode;
                return;
            }
            Node currNode = head;
            while(currNode != null) {
                currNode = currNode.next;
            }
            currNode.next = newNode;
            newNode.previous = currNode;
        }
        
        static void removeFirst(int data) {
            if (head == null) {
                System.out.println("List is empty. Nothing to remove.");
                return;
            }
            if (head.next == null) {
                head = null;
                return;
            }
            head = head.next;
            head.previous = null;
        }
        
        static void removeLast(int data) {
            if (head == null) {
                return;
            }
            if (head.next == null) {
                head = null;
                return;
            }
            Node currNode = head;
            while(currNode.next != null) {
                currNode = currNode.next;
            }
            System.out.println(currNode);
            System.out.println(currNode.previous);
            System.out.println(currNode.next);
            currNode.previous.next = null;
        }
    }
    
    public static void main(String[] args) {
        LL ll = new LL();
    }
}
