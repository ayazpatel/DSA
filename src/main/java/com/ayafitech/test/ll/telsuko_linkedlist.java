package com.ayafitech.test.ll;

class Node {
    int data;
    Node next;
    
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node currNode = head;
        while(currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }
    
    public void display() {
        Node currNode = head;
        while(currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }
    
    public void insertFirst (int data) {
        if (head == null) {
            System.out.println("Empty list!");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    
    public void insertAt(int index, int data) {
        Node newNode = new Node(data);
        
        Node currNode = head;
        for (int i = 0; i < index-1; i++) { //-1 for next -> to go prev
            currNode = currNode.next;
        }
        newNode.next = currNode.next;
        currNode.next = newNode;
    }
    
    public void deleteAt(int index) {
        Node currNode = head;
        Node prevNode = null;
        for (int i = 0; i < index; i++) {
            prevNode = currNode;
            currNode = currNode.next;
        }
        prevNode.next = currNode.next;
    }
}

public class telsuko_linkedlist {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(5);
        list.insert(10);
        list.insert(15);
        list.insert(20);
        System.out.println();
        list.display();
        list.insertFirst(0);
        System.out.println();
        list.display();
        list.insertAt(2, 25);
        System.out.println();
        list.display();
        System.out.println();
        list.deleteAt(2);
        list.display();
    }
}
