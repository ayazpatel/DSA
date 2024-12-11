package com.ayafitech.test.ll;

public class linkedlist {
    
    static class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    static class LinkedList {
        Node head;
        
        public void addLast(int data) {
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
        
        
        
        public void deleteLast(int data) {
            Node last = head.next;
            Node last2nd = head;
            while(last != null) {
                last = last.next;
                last2nd = last2nd.next;
            }
            last2nd.next = null;
        }
        public void delete(int data) {
            if (head == null) {
                System.out.println("list is empty");
                return;
            }
            if (head.data == data) {
                System.out.println(data + " found at head");
                head = head.next;
                return;
            }
            Node currNode = head;
            Node prevNode = null;
            while(currNode != null && currNode.data != data) {
                prevNode = currNode;
                currNode = currNode.next;
            }
            if (currNode == null) {
                System.out.println(data + " not found");
                return;
            }
            prevNode.next = currNode.next;
            System.out.println("Deleted " + data);
        }
        
//        public void deleteAt(int index) {
//            if (head == null) {
//                System.out.println("list is empty");
//                return;
//            }
//            Node currNode = head;
//            Node prevNode = null;
//            for (int i = 0; i < index; i++) {
//                prevNode = currNode;
//                currNode = currNode.next;
//            }
//            prevNode.next = currNode.next;
//        }
        
        public void display() {
            Node currNode = head;
            System.out.println("Elements: ");
            while(currNode != null) {
                System.out.print(currNode.data + " ");
                currNode = currNode.next;
            }
            System.out.println();
        }
    }
    
    
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.display();
        ll.delete(0);
        ll.addLast(4);
        ll.display();
        ll.delete(3);
        ll.display();
//        ll.deleteAt(2);
        ll.display();
    }
}
