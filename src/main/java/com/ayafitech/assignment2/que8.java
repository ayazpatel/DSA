package com.ayafitech.assignment2;

import java.util.Scanner;

class Student {
    int rollNo;
    String name;
    int marks;
    Student next;

    public Student(int rollNo, String name, int marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
        this.next = null;
    }
}

public class que8 {
    private Student head;

    public que8() {
        head = null;
    }

    // Method to insert a student record in descending order of marks
    public void insertStudent(int rollNo, String name, int marks) {
        Student newStudent = new Student(rollNo, name, marks);
        if (head == null || head.marks < marks) {
            newStudent.next = head;
            head = newStudent;
        } else {
            Student current = head;
            while (current.next != null && current.next.marks >= marks) {
                current = current.next;
            }
            newStudent.next = current.next;
            current.next = newStudent;
        }
    }

    // Method to display all student records
    public void displayRecords() {
        if (head == null) {
            System.out.println("No records to display.");
            return;
        }
        Student current = head;
        while (current != null) {
            System.out.println("Roll No: " + current.rollNo + ", Name: " + current.name + ", Marks: " + current.marks);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        que8 studentList = new que8();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Insert a student record");
            System.out.println("2. Display all records");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter roll number: ");
                    int rollNo = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter marks: ");
                    int marks = scanner.nextInt();
                    studentList.insertStudent(rollNo, name, marks);
                    break;
                case 2:
                    studentList.displayRecords();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);

        scanner.close();
    }
}
