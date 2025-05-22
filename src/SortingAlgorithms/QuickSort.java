package SortingAlgorithms;
import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = { 4, 5, 1, 2, 4, 5, 6 };
        System.out.println("Before sorting the array: " + Arrays.toString(array));
        quickSort(array, 0, array.length - 1);
        System.out.println("After sorting the array: " + Arrays.toString(array));
    }

    private static void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int pivotIndex = partition(array, start, end);
            quickSort(array, start, pivotIndex - 1);   // Left subarray
            quickSort(array, pivotIndex + 1, end);     // Right subarray
        }
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[start];
        int left = start;
        int right = end;

        while (left < right) {
            while (left < right && array[left] <= pivot) {
                left++;
            }
            while (array[right] > pivot) {
                right--;
            }
            if (left < right) {
                swap(array, left, right);
            }
        }

        swap(array, start, right); // Place pivot in its correct position
        return right;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
