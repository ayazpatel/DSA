package com.ayafitech.test.array;

public class circularQueue {

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
            array[rear] = data;
//            rear = rear + 1; // for queue
            rear = (rear + 1)%array.length; // for circular queue
            size = size + 1;
        }

        public int dequeue() {
            int data = array[front];
//            front = front + 1; // for queue
            front = (front + 1) % array.length; // for circular queue
            size = size - 1;
            return data;
        }

        public void display() {
            System.out.print("Queue elements: "); 
            for (int i = 0; i < size; i++) { 
                System.out.print(array[(front + i) % array.length] + " "); 
            }
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.enqueue(5);
        q.enqueue(10);
        q.enqueue(15);
        q.display();
        System.out.println("\nDequeue Value: " + q.dequeue());
        q.display();
        q.enqueue(20);
        System.out.println("\nDequeue Value: " + q.dequeue());
        q.enqueue(25);
        q.display();
    }
}
