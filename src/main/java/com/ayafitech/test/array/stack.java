package com.ayafitech.test.array;

public class stack {
    int array[];
    int top;
    stack(int size) {
        this.array = new int[size];
        this.top = 0;
    }
    
    public void push(int data) {
        array[top] = data;
        top = top + 1;
    }
    
    public int peek() {
        return array[top-1];
    }
    
    public int pop() {
        top = top - 1;
        int data = array[top];
        array[top] = 0;
        return data;
    }
    
    public void display() {
        System.out.print("Emelents: ");
        for (int i = (top-1); i > -1; i--) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        stack obj = new stack(5);
        obj.push(15);
        obj.push(8);
        obj.push(10);
//        System.out.println("Peek: "+obj.peek());
//        System.out.println("Pop: "+obj.pop());
        obj.display();
    }
}
