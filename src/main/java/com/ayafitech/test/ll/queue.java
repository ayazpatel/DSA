package com.ayafitech.test.ll;

public class queue {
    static class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    static class Queue {
        static Node front = null;
        static Node rear = null;
        
        public static boolean isEmpty() {
            return front == null && rear == null;
        }
        
        // entry at rear
        public static void enqueue(int data) {
            Node newNode = new Node(data);
            if (rear == null) {
                rear = newNode;
                front = newNode;
            }
            rear.next = newNode;
            rear = newNode;
            
        }
        
        // exit from front
        public static int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            
            int value = front.data;
            if (front == rear) {
                rear = null;
            }
            front = front.next;
            
            return value;
        }
        
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return front.data;
        }
        
        static void display() {
            if (isEmpty()) {
                return;
            }
            Node currNode = front;
            while(currNode != null) {
                System.out.print(currNode.data + " ");
                currNode = currNode.next;
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        
        q.display();
    }
}
