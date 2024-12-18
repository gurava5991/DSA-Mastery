package SortingAlgorithms;


import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = { 4, 5, 1, 2, 4, 5, 6 };
        System.out.println("Before sorting the arrays : " + Arrays.toString(arr));
        quickSort(arr , 0 , arr.length - 1);
        System.out.println("After sorting the arrays : " + Arrays.toString(arr));
    }
    private static void quickSort(int[] arr , int low , int high){
        if(low < high){
            int pi = partition(arr , low , high);
            quickSort(arr , low , pi - 1);
            quickSort(arr , pi + 1 , high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low + 1;
        int j = high;

        while (i < j) {
            // Find the first element greater than or equal to pivot from the left
            while (i < j && arr[i] <= pivot) {
                i++;
            }
            // Find the first element less than or equal to pivot from the right
            while (arr[j] > pivot) {
                j--;
            }
            // Swap elements at i and j if they have not crossed
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
        // Swap pivot with the element at j
        arr[low] = arr[j];
        arr[j] = pivot;
        return j;
    }

}

