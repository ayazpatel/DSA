package com.ayafitech.exam.linear;

public class linked_list {
    private int size;
    linked_list() {
        this.size = 0;
    }
    
    class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }
    
    Node head;
    
    // add - first, last
    public void addFirst (int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return;
        }
        
        newNode.next = head;
        head = newNode; 
        size++;
    }
    
    public void addLast (int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return;
        }
        
        Node currNode = head;
        while(currNode.next != null) {
            currNode = currNode.next;
        }
        
        currNode.next = newNode;
    }
    
    public void deleteFirst() {
        if (head == null) {
            System.out.print("list is empty!");
            return;
        }
        size--;
        head = head.next;
    }
    
    public void deleteLast() {
        if (head == null) {
            System.out.print("list is empty!");
            return;
        }
        size--;
        if (head.next == null) {
            head = null;
            return;
        }
        Node secondLast = head;
        Node lastNode = head.next;
        while(lastNode.next != null) {
            lastNode = lastNode.next;
            secondLast = secondLast.next;
        }
        secondLast.next = null;
    }
    
    public void delete(int data) {
        if (head == null) {
            System.out.println("list is empty");
            return;
        }
        if (head.data == data) {
            head = head.next;
            size--;
        }
        Node currNode = head;
        while(currNode.next != null && currNode.next.data != data) {
            currNode = currNode.next;
        }
        if (currNode.next == null) {
            System.out.println("no data found");
        } else {
            currNode.next = currNode.next.next;
            size--;
        }
    }
    
    public void searchi(int data) {
        if (head == null) {
            System.out.println("list is empty!");
            return;
        }
        System.out.println();
        Node currNode = head;
        while(currNode != null) {
            if (currNode.data == data) {
                System.out.println("TRUE");
                return;
            }
            currNode = currNode.next;
        }
        if (currNode.data != data) {
            System.out.println("FALSE");
            return;
        }
    }
    
    public void display() {
        if (head == null) {
            System.out.println("list is empty!");
            return;
        }
        System.out.println();
        Node currNode = head;
        while(currNode != null) {
            System.out.print(currNode.data + "-> ");
            currNode = currNode.next;
        }
        System.out.print("NULL");
    }
    
    public int getSize() {
        return size;
    }
    
    public static void main(String[] args) {
        linked_list list = new linked_list();
        list.addFirst(3);
        list.addFirst(1);
        list.addFirst(2);
        list.addLast(5);
        list.display();
        list.deleteFirst();
        list.display();
        list.deleteLast();
        list.display();
        System.out.println("\nSize: "+list.getSize());
        list.searchi(5);
//        System.out.println(list.search(5));
//        System.out.println(list.search(2));
    }
}
