package com.ayafitech.exam.linear;

class Queue {
    int queue[];
    int front;
    int rear;
    int size;
    
    Queue(int size) {
        this.queue = new int[size];
        this.front = 0; 
        this.rear = 0; 
        this.size = 0;
    }
    
    void enqueue(int data) {
        queue[rear] = data;
        rear = rear + 1;
        size = size + 1;
    }
    
    void dequeue() {
        
    }
    
    void display() {
        System.out.print("Elements: ");
        for (int i = 0 ; i < size ; i++) {
            System.out.print( queue[i] + " ");
        }
    }
}

public class Queue_arr {
    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.enqueue(5);
        q.display();
    }
}
