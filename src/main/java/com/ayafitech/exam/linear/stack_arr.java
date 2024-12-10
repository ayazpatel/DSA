package com.ayafitech.exam.linear;

class Stack {
    int stack[];
    int top;
    
    Stack(int size) {
        this.stack = new int[size];
        this.top = 0;
    }

    public void push(int data) {
        stack[top] = data;
        top++;
    }

    public int peek() {
        return stack[top-1];
    }

    public int pop() {
        top--;
        int data = stack[top];
        stack[top] = 0;
        return data;
    }

    public void disp() {
        for (int n : stack) {
            if (n == 0) {
                System.out.println(" ");
            } else {
                System.out.print(n + " ");
            }
        }
    }
}

public class stack_arr {

    public static void main(String[] args) {
        Stack nums = new Stack(5);
        nums.push(5);
        nums.push(10);
        nums.push(15);
        nums.disp();
        System.out.println("POP ELEMENT: " + nums.pop());
        nums.disp();
        System.out.println("PEEK ELEMENT: " + nums.peek());

    }
}
