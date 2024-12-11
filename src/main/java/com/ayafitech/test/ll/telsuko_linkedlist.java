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
    public void insertAtStart(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    
    public void insertAt(int index, int data) {
        if (index == 0) {
            insertAtStart(data);
        }
        Node newNode = new Node(data);
        
        Node currNode = head;
        for (int i = 0; i < index-1; i++) { //-1 for next -> to go prev
            currNode = currNode.next;
        }
        newNode.next = currNode.next;
        currNode.next = newNode;
    }
    
    public void deleteAt(int index) {
        if (index == 0) {
            head = head.next;
        }
        Node currNode = head;
        Node prevNode = null;
        for (int i = 0; i < index; i++) {
            prevNode = currNode;
            currNode = currNode.next;
        }
        prevNode.next = currNode.next;
    }
    
    public void delete(int data) {
        if (head.data == data) {
            System.out.println("Found & Deleted");
            head = head.next;
            return;
        }
        Node currNode = head;
        Node prevNode = null;
        while (currNode != null && currNode.data != data) {
            prevNode = currNode;
            currNode = currNode.next;
        }
        if (currNode == null) {
            System.out.println("Not Found");
            return;
        }
        prevNode.next = currNode.next;
        System.out.println("Found & Deleted");
    }
    
    public void search(int data) {
        Node currNode = head;
        while(currNode != null && currNode.data != data) {
            currNode = currNode.next;
        }
        
        if (currNode == null) {
            System.out.println("Not Found " + data);
            return;
        }
        
        if (currNode.data == data) {
            System.out.println("Found " + data + " ->["+ currNode.data + "]");
        }
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
        System.out.println();
        list.delete(15);
        list.display();
        System.out.println();
        list.search(20);
        list.search(50);
//        System.out.println();
        list.delete(0);
        list.display();
    }
}
