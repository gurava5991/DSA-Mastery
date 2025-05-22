package SortingAlgorithms;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 9, 8, 2, 4, 7};
        System.out.println("Before sorting : "+Arrays.toString(arr));
        mergeSort(arr, 0 , arr.length - 1);
        System.out.println("After sorting : "+Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if(low < high){
            int mid = low + (high - low) / 2;
            mergeSort(arr , low , mid);
            mergeSort(arr, mid + 1 , high);
            merge(arr ,low , mid , high);
        }
    }
    public static void merge(int[] arr , int low , int mid , int high){
        //setting up the Auxilary space array
        int[] left = Arrays.copyOfRange(arr , low , mid + 1);
        int[] right = Arrays.copyOfRange(arr , mid + 1 , high + 1);
        int n1 = left.length , n2 = right.length;
        //standard merge sort algorithms
        int i = 0 , j = 0 , k = low;
        while(i < n1 && j < n2){
            if(left[i] <= right[j]){
                arr[k++] = left[i++];
            }
            else
                arr[k++] = right[j++];
        }

        while(i < n1) arr[k++] = left[i++];
        while(j < n2) arr[k++] = right[j++];
    }

}
