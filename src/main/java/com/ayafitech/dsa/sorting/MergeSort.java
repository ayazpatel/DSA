package com.ayafitech.dsa.sorting;

/**
 *
 * @author Ayaz
 */
public class MergeSort {
    // time complexity: O(nlogn)
    public static void conquer(int arr[], int startIndex, int mid, int endIndex) {
        // new merged array created, a new memory location
        // as we do zero based indexing and ending is always less 1 of array length so added +1
        int merged[] = new int[endIndex - startIndex + 1]; 
        int idx1 = startIndex;
        int idx2 = mid + 1;
        int x = 0;
        // linear time complexity
        // O(n)
        while (idx1 <= mid && idx2 <= endIndex) {
            if (arr[idx1] <= arr[idx2]) {
                merged[x++] = arr[idx1++];
            } else {
                merged[x++] = arr[idx2++];
            }
        }
        // 2nd array has elements so writing below loop to just copy to merged array
        while (idx1 <= mid) {
            merged[x++] = arr[idx1++];
        }
        // or will run only above or below will run only one condition will be true
        while (idx2 <= endIndex) {
            merged[x++] = arr[idx2++];
        }
        
        // copying merged array value to original array
        for (int i = 0, j = startIndex; i < merged.length; i++, j++) {
            arr[j] = merged[i];
        }
    }

    public static void divide(int arr[], int startIndex, int endIndex) {
        // if start index gets bigger than ending index then, or array is empty
        if (startIndex >= endIndex) {
            return;
        }
        // Avoid potential overflow
        // O(logn)
        // for every logn we need n so time complexity is: O(nlogn)
        int mid = startIndex + (endIndex - startIndex) / 2;
        divide(arr, startIndex, mid);
        divide(arr, mid + 1, endIndex);
        conquer(arr, startIndex, mid, endIndex);
    }

    public static void main(String[] args) {
        int arr[] = {6, 3, 9, 5, 2, 8};
        int n = arr.length;

        System.out.print("Before MergeSort: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        divide(arr, 0, n - 1);

        System.out.println();
        System.out.print("After MergeSort: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
