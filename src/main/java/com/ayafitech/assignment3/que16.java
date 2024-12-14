package com.ayafitech.assignment3;

public class que16 {
    private String[] array;

    public que16(String[] array) {
        this.array = array;
    }

    // Method for insertion sort
    public void insertionSort() {
        for (int i = 1; i < array.length; i++) {
            String key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j].compareTo(key) > 0) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    // Method for selection sort
    public void selectionSort() {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            String temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    // Method for bubble sort
    public void bubbleSort() {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    String temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Method for quick sort
    public void quickSort() {
        quickSortHelper(0, array.length - 1);
    }

    private void quickSortHelper(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            quickSortHelper(low, pi - 1);
            quickSortHelper(pi + 1, high);
        }
    }

    private int partition(int low, int high) {
        String pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) < 0) {
                i++;
                String temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        String temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    // Method for merge sort
    public void mergeSort() {
        mergeSortHelper(0, array.length - 1);
    }

    private void mergeSortHelper(int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSortHelper(left, middle);
            mergeSortHelper(middle + 1, right);
            merge(left, middle, right);
        }
    }

    private void merge(int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;
        String[] L = new String[n1];
        String[] R = new String[n2];
        for (int i = 0; i < n1; ++i) {
            L[i] = array[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = array[middle + 1 + j];
        }
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i].compareTo(R[j]) <= 0) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    // Method to display the array
    public void display() {
        for (String s : array) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String[] names = {"John", "Alice", "Bob", "Diana", "Charlie"};
        que16 sorter = new que16(names);

        System.out.println("Original Array:");
        sorter.display();

        sorter.insertionSort();
        System.out.println("Sorted by Insertion Sort:");
        sorter.display();

        sorter = new que16(names);
        sorter.selectionSort();
        System.out.println("Sorted by Selection Sort:");
        sorter.display();

        sorter = new que16(names);
        sorter.bubbleSort();
        System.out.println("Sorted by Bubble Sort:");
        sorter.display();

        sorter = new que16(names);
        sorter.quickSort();
        System.out.println("Sorted by Quick Sort:");
        sorter.display();

        sorter = new que16(names);
        sorter.mergeSort();
        System.out.println("Sorted by Merge Sort:");
        sorter.display();
    }
}

