/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ayafitech.dsa.nonPrimitiveDS;

/**
 *
 * @author Ayaz
 */

//never change integral head, as it leads to data loss
public class LinkedList {
    
    private Node head;
    private int size;
    
    LinkedList() {
        this.size = 0;
    }
    
    private class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }
    
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        
        newNode.next = head;
        head = newNode;
    }
    
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        
        // Traversing to last node as its a null
        Node currentNode = head;
        while(currentNode.next != null) {
            currentNode = currentNode.next;
        }
        
        currentNode.next = newNode;
    }
    
    public void addMiddle(int data) {
        // TODO: do it ayaz, if u want to.
    }
    
    public void deleteFirst() {
        if (head == null) {
            System.out.print("List is empty!");
            return;
        }
        size--;
        head = head.next;
    }
    
    public void deleteLast() {
        if (head == null) {
            System.out.print("List is empty!");
            return;
        }
        
        size--;
        
        if (head.next == null) {
            head = null;
            return;
        }
        // cant decrement size head, as then we would miss the below condition from size.
        Node secondLast = head;
        Node lastNode = head.next; // head.next = null -> lastnode = null
        while (lastNode.next != null) { // null.next -> gives error
            lastNode = lastNode.next;
            secondLast = secondLast.next;
        }
        // cant decrement size head, as then we would miss the below condition from size.
        
        secondLast.next = null;
    }
    
    public void deleteMiddle() {
        // TODO: do it ayaz, if u want to.
    }
    
    public int getSize() {
        return size;
    }
    
    public void printList() {
        if (head == null) {
            System.out.print("List is empty!");
            return;
        }
        
        Node currentNode = head;
        while(currentNode != null) { // if done currentNode.next -> leads to last val non printable
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.print("null");
    }
    
    public void reverseList() {
        if (head == null) { 
            return;
        }
        
        if (head == null) {
            System.out.print("List is empty!");
            return;
        }
        
        Node previousNode = null; 
        Node currentNode = head; 
        Node nextNode = null;
        
        while (currentNode != null) { 
            nextNode = currentNode.next; // Store next node 
            currentNode.next = previousNode; // Reverse current node's pointer 
            previousNode = currentNode; // Move pointers one position ahead 
            currentNode = nextNode;
        }
        
        head = previousNode;
        
        System.out.print("null");
    }
    
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        System.out.println("InitialAdd-addFirst()");
        list.addFirst(1);
        list.printList();
        System.out.println("\naddFirst()");
        list.addFirst(2);
        list.printList();
        System.out.println("\naddLast()");
        list.addLast(3);
        list.printList();
        System.out.println("\ndeleteFirst()");
        list.deleteFirst();
        list.printList();
        System.out.println("\ndeleteLast()");
        list.deleteLast();
        list.printList();
        System.out.println("\nreverseList()"); 
        list.reverseList();
//        list.printList();
        
        System.out.println("\nSize: " + list.getSize());
    }
    
}
