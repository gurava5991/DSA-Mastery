package SortingAlgorithms;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 9, 8, 2, 4, 7};
        System.out.println("Before sorting"+ Arrays.toString(arr));
        selctionSort(arr);
        System.out.println("After sorting"+ Arrays.toString(arr));
    }

    private static void selctionSort(int[] arr) {
        int n = arr.length;
        for(int i = 0 ; i < n - 1 ; i++){
            int minIndex = i;
            boolean swapped = false;
            for(int j = i + 1 ; j < n ; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            if(minIndex != i){
                swap(arr , i , minIndex);
                swapped = true;
            }
            if(swapped == false)
                break;
        }
    }
    private static void swap(int[] arr , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
/*
Stability in Sorting Algorithms
A sorting algorithm is said to be stable if it preserves the relative order of records with equal keys (i.e., values).
If two elements with equal values appear in the same order in the sorted output as they appear in the input, then the algorithm is stable
let take arr = {4 , 3 , 4 , 2}
First pass
here 2 is minimum so we are swapping oth index and last index
so 4 went last positions 2 , 3 , 4 , 4--> we lost relative order so selction sort algorithms is not stalbe algorithms
 */