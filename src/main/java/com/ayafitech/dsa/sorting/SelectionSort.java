/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ayafitech.dsa.sorting;

/**
 *
 * @author Ayaz
 */
public class SelectionSort {
    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    
    //selection sort
    public static void main(String[] args) {
        int arr[] = {7,8,3,1,2};
        // n-1 iterations frst time then n-2, n-3.... (arethmetic progression series AP)
        // time coplexity = O(n^2);
        for (int i = 0; i < arr.length-1; i++) {
            int smallest = i;
            //hear arr updated
            //i+1 because front elements are already sorted,so reducing length of arr from front to iterate as front are sorted
            for (int j = i+1; j < arr.length; j++) {
                //hear arr traversed
                if (arr[smallest] > arr[j]) { 
                    //understand for frst iteration
                    //arr[smallest] is frst element like arr[0] > arr[0+1] then arr[0] = arr[j] j is 0+1 means next index
                    smallest = j;
                }
                // all are compared in smaller loop
                // if smaller found then that var is added to smallest var for further swapp
            }
            int temp = arr[smallest];
            //smallest is the smallest value found and arr[i] is actual array traversed
            arr[smallest] = arr[i];
            arr[i] = temp;
        }
    printArray(arr);
    }
}
