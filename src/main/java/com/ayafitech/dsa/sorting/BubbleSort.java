/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ayafitech.dsa.sorting;

/**
 *
 * @author Ayaz
 */
public class BubbleSort {
    
    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    
    public static void main(String[] args) {
        int arr[] = {7,8,3,1,2};
        
        //bubble sort
        //time complexity = O(n^2)
        //outer loop will do n-1 iterations -> n-1 are big bubbles, one by one dragged at eng, last 2nd end etc
        for (int i = 0; i < arr.length-1; i++) { // n-1 -> arr.length-1, i is counter
            // inner loop will do iteration like
            // first time-> n times
            // second time-> n-1 .... n-2, n-3.....n^2 times
            for (int j = 0; j < arr.length-i-1; j++) { // (-j) ->coz we are removing iteration for already sorted elements
                if (arr[j] > arr[j+1]) { //actual array is j
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j+1]; // arr[j]->first element, arr[j+1]->2nd element
                    arr[j+1] = temp;
                }
            }
        }
        
        printArray(arr);
        
    }
}
