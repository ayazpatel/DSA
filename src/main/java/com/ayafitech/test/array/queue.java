package com.ayafitech.test.array;

public class queue {
    
    static class Queue {
        int array[];
        int front;
        int rear;
        int size;
        
        Queue(int size) {
            this.array = new int[size];
            this.front = 0;
            this.rear = 0;
            this.size = 0;
        }
        
        public void enqueue(int data) {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }
            array[rear] = data;
            rear = rear + 1;
            size = size + 1;
        }
        
        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return 0;
            }
            if (isFull()) {
                System.out.println("Queue is full");
                return 5;
            }
            int data = array[front];
            front = front + 1;
            size = size - 1;
            return data;
        }
        
        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return 0;
            }
            if (isFull()) {
                System.out.println("Queue is full");
                return 5;
            }
            return array[front];
        }
        
        public void display() {
            for (int i = front; i <= size /* array.length */ && array[i] != 0  ; i++) {
                System.out.println(array[i]);
            }
        }
        
        public int getSize() {
            return size;
        }
        
        public boolean isEmpty() {
            if (rear == 0) {
                return true;
            }
            return false;
        }
        
        public boolean isFull() {
            if (size == array.length) {
                return true;
            }
            return false;
        }
        
    }
    
    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.enqueue(5);
        q.enqueue(10);
        q.enqueue(15);
        q.display();
        System.out.println("Dequeue Value: " + q.dequeue());
        q.enqueue(20);
        q.display();
    }
}
