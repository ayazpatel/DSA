package com.ayafitech.assignment2;

import java.util.Scanner;

class Book {
    int bookId;
    String bookTitle;
    double price;
    Book prev;
    Book next;

    public Book(int bookId, String bookTitle, double price) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.price = price;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    private Book head;

    public void insert(int bookId, String bookTitle, double price) {
        Book newBook = new Book(bookId, bookTitle, price);
        if (head == null) {
            head = newBook;
        } else {
            Book temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newBook;
            newBook.prev = temp;
        }
    }

    public void delete(int bookId) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Book temp = head;
        while (temp != null && temp.bookId != bookId) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Book not found.");
            return;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        } else {
            head = temp.next;
        }
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
        System.out.println("Book with ID " + bookId + " deleted.");
    }

    public void search(String bookTitle) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Book temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.bookTitle.equalsIgnoreCase(bookTitle)) {
                System.out.println("Book ID: " + temp.bookId + ", Title: " + temp.bookTitle + ", Price: " + temp.price);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("No books found with the title: " + bookTitle);
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Book temp = head;
        while (temp != null) {
            System.out.println("Book ID: " + temp.bookId + ", Title: " + temp.bookTitle + ", Price: " + temp.price);
            temp = temp.next;
        }
    }
}

public class que10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoublyLinkedList bookList = new DoublyLinkedList();
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Insert a record");
            System.out.println("2. Delete a record by book ID");
            System.out.println("3. Search books by title");
            System.out.println("4. Display all books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book ID: ");
                    int bookId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter book title: ");
                    String bookTitle = scanner.nextLine();
                    System.out.print("Enter book price: ");
                    double price = scanner.nextDouble();
                    bookList.insert(bookId, bookTitle, price);
                    break;
                case 2:
                    System.out.print("Enter book ID to delete: ");
                    int deleteId = scanner.nextInt();
                    bookList.delete(deleteId);
                    break;
                case 3:
                    System.out.print("Enter book title to search: ");
                    String searchTitle = scanner.nextLine();
                    bookList.search(searchTitle);
                    break;
                case 4:
                    bookList.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
