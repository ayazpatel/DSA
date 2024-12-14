package com.ayafitech.assignment2;

import java.util.Scanner;

class Product {
    int code;
    String name;
    double price;
    Product next;

    public Product(int code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.next = null;
    }
}

class CircularLinkedList {
    private Product last;

    public CircularLinkedList() {
        last = null;
    }

    // Insert a node at the last position
    public void insertLast(int code, String name, double price) {
        Product newProduct = new Product(code, name, price);
        if (last == null) {
            last = newProduct;
            last.next = last;
        } else {
            newProduct.next = last.next;
            last.next = newProduct;
            last = newProduct;
        }
    }

    // Search for a node by name and display all records starting from the searched node
    public void searchAndDisplay(String name) {
        if (last == null) {
            System.out.println("The list is empty.");
            return;
        }

        Product current = last.next;
        boolean found = false;
        do {
            if (current.name.equals(name)) {
                found = true;
                break;
            }
            current = current.next;
        } while (current != last.next);

        if (found) {
            System.out.println("Displaying products starting from the searched node:");
            Product start = current;
            do {
                System.out.println("Code: " + current.code + ", Name: " + current.name + ", Price: " + current.price);
                current = current.next;
            } while (current != start);
        } else {
            System.out.println("Product with name '" + name + "' not found.");
        }
    }
}

public class que11 {
    public static void main(String[] args) {
        CircularLinkedList productList = new CircularLinkedList();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Insert a product");
            System.out.println("2. Search and display products from a given name");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter product code: ");
                    int code = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();
                    productList.insertLast(code, name, price);
                    break;
                case 2:
                    System.out.print("Enter product name to search: ");
                    String searchName = scanner.nextLine();
                    productList.searchAndDisplay(searchName);
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
