/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ayafitech.dsa.sorting;

/**
 *
 * @author Ayaz
 */

/*
Idea: Take an element from the unsorted array, 
    place it in its corresponding position in the sorted part, 
    and shift the elements accordingly. 
Time Complexity: O(N2) 
 */
public class InsertionSort {

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {7, 8, 3, 1, 2};
        
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i-1; // it gets sorted part's last index
            while(j>=0 && arr[j] > current) { // if sorted part is greater than current then maing space for other elements
                //Keep swapping
                arr[j+1] = arr[j]; // space created
                j--;
            }
            //placement of elemnts, as soon as the condition gest dis satisfied
            arr[j+1] = current;
        }
        
        printArray(arr);
    }
}
