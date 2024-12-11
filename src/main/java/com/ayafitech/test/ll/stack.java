package com.ayafitech.test.ll;

public class stack {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Stack {
        static Node head;
        public static void push(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }

            newNode.next = head;
            head = newNode;
        }

        public static int peek() {
            if (head == null) {
                return -1;
            }
            int top = head.data;
            return top;
        }

        public static int pop() {
            if (head == null) {
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        public static void display() {
            System.out.print("Stack Elements(From Top): ");
            while(head != null) {
                System.out.print(head.data + " ");
                head = head.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(15);
        s.push(8);
        s.push(2);
        System.out.println("Peek: "+s.peek());
        System.out.println("Pop Called");
        s.pop();
        s.display();
    }
}
