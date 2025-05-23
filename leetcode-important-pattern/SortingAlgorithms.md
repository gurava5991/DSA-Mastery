# Sorting Algorithms 
### Introduction of Sorting Algorithms 
Sorting algorithms are fundamental to computer science and are used to arrange elements of a list or array in a specific order, such as ascending or descending. These algorithms form the backbone of many computational tasks, enhancing the efficiency of searching, organizing, and optimizing data.

### Why Sorting is Important?

**1 . Efficient Searching :** <br>

Sorted data can be quickly searched using algorithms like binary search, which operate in O(logn) compared to O(n) for unsorted data.

**2 . Data Organization:**

Sorting helps in arranging data logically, making it more readable and easier to process.

**3 . Optimization:**

Many algorithms, like divide-and-conquer methods, rely on sorted input for optimal performance.


**4. Preprocessing:**

Sorting is often a prerequisite for other algorithms, such as finding unique elements or performing binary operations on arrays.

### Classification of Sorting Algorithms

Sorting algorithms can be classified into different categories based on their approach and characteristics. Let's go through them step by step with examples to make the concepts easy to grasp.


**1. Based on Comparison**

**Comparison-based** sorting algorithms compare two elements to determine their relative order.<br>
```
(a) Bubble Sort
Description: Repeatedly swaps adjacent elements if they are in the wrong order.
Time Complexity: O(n ^ 2)
Example: Input: [4, 2, 3, 1]
Process:
Compare 4 and 2 → Swap → [2, 4, 3, 1]
Compare 4 and 3 → Swap → [2, 3, 4, 1]
Compare 4 and 1 → Swap → [2, 3, 1, 4]
After multiple passes, the array becomes [1, 2, 3, 4].

(b) Quick Sort
Description: Uses a pivot element to partition the array into two halves, sorting them recursively.
Time Complexity: O(nlogn) for best tc and worts time complexity is O(n ^ 2) 
Example: Input: [8, 3, 6, 1, 4]
Process:
Choose pivot: 4.
Partition: [3, 1] (less than pivot), [4] (pivot), [8, 6] (greater than pivot).
Recursively sort: [1, 3] and [6, 8].
Final Result: [1, 3, 4, 6, 8].
```

**2. Based on Stability**<br>
Stable sorting algorithms maintain the relative order of equal elements.<br>
For example, if [5a, 3, 5b, 1] is sorted, the relative order of 5a and 5b will remain the same.<br>

(a) Stable Algorithms:
* Bubble Sort
* Merge Sort
* Counting Sort<br>
```Example:
Input: [(5a, 1), (3, 2), (5b, 3)]
Sorting by the first element (stable):

Bubble Sort/Merge Sort result: [(3, 2), (5a, 1), (5b, 3)].
```

**3. Based on In-place vs. Out-of-place**

(a) In-place Sorting:<br>
Sorts the array using constant or O(logn) extra space.<br>
Examples: Quick Sort, Heap Sort.<br>
Example:Quick Sort modifies the array directly during the partitioning process.<br>
(b) Out-of-place Sorting:<br>
Requires extra memory to store intermediate data.<br>
Examples: Merge Sort, Counting Sort.<br>
Example:Merge Sort creates temporary arrays during merging.

**4 . Based on Non-comparison**

Non-comparison-based algorithms use techniques like counting or hashing.

(a) Counting Sort:`<br>
Count` the occurrences of each element.<br>
Reconstruct the array based on counts.<br>
Example: Input: [3, 1, 4, 1, 3]<br>
Process:<br>
Count: {1: 2, 3: 2, 4: 1}.<br>
Output: [1, 1, 3, 3, 4].<br>
(b) Radix Sort:<br>
Sort numbers digit by digit.<br>
Example: Input: [170, 45, 75, 90]<br>
Process:<br>
Sort by the least significant digit.<br>
Sort by the next digit.<br>
Final Result: [45, 75, 90, 170].<br>

## Bubble sorting Algorithm
**Intuition**

The bubble sort algorithm sorts an array by repeatedly swapping adjacent elements if they are in the wrong order. The largest elements "bubble" to the end of the array with each pass.

```
Consider an array arr[] = {5, 1, 4, 2, 8}

First Pass(i == 0):
Bubble sort starts with very first two elements, comparing them to check which one is greater.
( 5 1 4 2 8 ) --> ( 1 5 4 2 8 ), Here, algorithm compares the first two elements, and swaps since 5 > 1.
( 1 5 4 2 8 ) -->  ( 1 4 5 2 8 ), Swap since 5 > 4
( 1 4 5 2 8 ) -->  ( 1 4 2 5 8 ), Swap since 5 > 2
( 1 4 2 5 8 ) --> ( 1 4 2 5 8 ), Now, since these elements are already in order (8 > 5), algorithm does not swap them.
Second Pass(i == 1):
Now, during second iteration it should look like this:
( 1 4 2 5 8 ) --> ( 1 4 2 5 8 )
( 1 4 2 5 8 ) --> ( 1 2 4 5 8 ), Swap since 4 > 2
( 1 2 4 5 8 ) --> ( 1 2 4 5 8 )
( 1 2 4 5 8 ) -->  ( 1 2 4 5 8 )
Third Pass(i == 2):
Now, the array is already sorted, but our algorithm does not know if it is completed.
we can break the loop no need to further iterations array is sorted itself.
Fourth Pass(i == 3)
The algorithm needs one whole pass without any swap to know it is sorted.
( 1 2 4 5 8 ) --> ( 1 2 4 5 8 )
( 1 2 4 5 8 ) --> ( 1 2 4 5 8 )
( 1 2 4 5 8 ) --> ( 1 2 4 5 8 )
( 1 2 4 5 8 ) --> ( 1 2 4 5 8 )

time Complexity : O(n^2)
space Complexity : O(1)
```

```java
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2, 8};
        System.out.println("Before sorting the array "+ Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("After sorting the array "+ Arrays.toString(arr));

    }

    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped ;
        for(int i = 0 ; i < n - 1 ; i++){
            swapped = false;
            for(int j = 0 ; j < n - i - 1 ; j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if(swapped == false)
                break;
        }
    }
}
```

**Time Complexity:** O(N2) for the worst and average cases and O(N) for the best case. Here, N is the size of the array.

**Space Complexity:** O(1), because Bubble Sort is an in-place sorting algorithm, meaning it only requires a constant amount of extra space for its operations, regardless of the size of the input array.

## Selections Sort Algorithm

**Intuition :**

Selection Sort works by finding the minimum (or maximum) element from the unsorted part of the array and swapping it with the first element of the unsorted part. During this process, elements with the same value might have their relative order changed.

**Approach :**
* Select the starting index of the unsorted part using a loop with i from 0 to n-1.
* Find the smallest element in the range from i to n-1 using an inner loop.
* Swap this smallest element with the element at index i.
* Repeat the process for the next starting index.

```java
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
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
                swapped = true;
            }
            if(swapped == false)
                break;
        }
    }
}
```

**Time Complexity:** O(N2) where N is the length of the input array. The outer loop runs through each element, and the inner loop finds the smallest element in the unsorted portion of the array.

**Space Complexity:** O(1) as it is an in-place sorting algorithm and does not require additional storage proportional to the input size.

**Is selection sort stable ?**

Input:[4a, 2, 4b, 3]<br>
Process:
Find the minimum: 2<br>
Swap 2 with 4a: [2, 4a, 4b, 3]<br>
Find the next minimum: 3<br>
Swap 3 with 4a: [2, 3, 4b, 4a]<br>
Here, the relative order of 4a and 4b has changed. Initially, 4a came before 4b, but after sorting, 4b comes before 4a.<br>
This shows that Selection Sort is not stable.

## Insertion Sort Algorithms

**Intuition**

Insertion sort builds a sorted array one element at a time by repeatedly picking the next element and inserting it into its correct position within the already sorted part of the array.

**Approach**

* In each iteration, select an element from the unsorted part of the array using an outer loop.
* Place this element in its correct position within the sorted part of the array.
* Use an inner loop to shift the remaining elements as necessary to accommodate the selected element. This involves swapping elements until the selected element is in its correct position.
* Continue this process until the entire array is sorted.

```java
import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};
        System.out.println("Before sorting : " + Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("After sorting : " + Arrays.toString(arr));
    }

    private static void insertionSort(int[] arr) {
        for(int i = 1 ; i < arr.length ; i++){
            moveElementToCorrectPosition(arr , i);
        }
    }

    private static void moveElementToCorrectPosition(int[] arr, int currentIndex) {
        int currentValue = arr[currentIndex];
        int i = currentIndex - 1;
        while(i >= 0 && arr[i] > currentValue){
            arr[i + 1] = arr[i];
            i--;
        }
        arr[i + 1] = currentValue;

    }
}

```

**Time Complexity:** O(N2) for the worst and average cases, where N is the size of the array. This is because the outer loop runs N times, and for each pass, the inner loop runs up to N times as well, resulting in approximately N xN operations, hence O(N2). The best-case time complexity occurs when the array is already sorted, in which case the inner loop doesn't run at all, leading to a time complexity of O(N).

**Space Complexity:** O(1) because Insertion Sort is an in-place sorting algorithm, meaning it sorts the array by modifying the original array without using additional data structures that grow with the size of the input.

# Divide And conquer Approach 
## MergeSort Algorithms

**Intuition**

Merge Sort is a powerful sorting algorithm that follows the divide-and-conquer approach. The array is divided into two equal halves until each sub-array contains only one element. Each pair of smaller sorted arrays is then merged into a larger sorted array.

**Two main Functions in Merge Sort**<br>
merge():Merges two sorted halves of the array into a single sorted subarray.<br>
mergeSort():recursively divides the array into two halves and sorts each half using the merge() function.<br>

**Steps to Implement Merge Sort**
1. mergeSort(arr[], low, high)
   **Divide the Array:**

* Split the array into two halves:
  * Left Half: low to mid
  * Right Half: mid + 1 to high
* Where mid = (low + high) / 2.
Recursive Division:
```Html
mergeSort(arr, low, mid);
mergeSort(arr, mid + 1, high);
```
Recursively call mergeSort for the left and right halves:

Base Case:

Stop recursion when the range size is 1 (i.e., low >= high).

**2. merge(arr[], low, mid, high)**<br>
Create a Temporary Array:

1. Combine the two sorted subarrays:
   * Left Half: low to mid
   * Right Half: mid + 1 to high<br>
2 Use Two Pointers:

* Pointer i for the left half starting at low.
* Pointer j for the right half starting at mid + 1.
* Use a while loop to compare elements and insert the smaller one into the temporary array.
* Handle Remaining Elements:

Copy leftover elements from both halves into the temporary array.<br>
Copy Back to Original Array:<br>

Transfer the elements from the temporary array back into the original array from index low to high.<br>

```java
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
```
**Time Complexity: O(nlogn).** At each step, we divide the whole array, which takes logn steps, and we assume n steps are taken to sort the array. So, the overall time complexity is nlogn.

**Space Complexity: O(n).** We are using a temporary array to store elements in sorted order.

## Problems Based On Merge sorting Algorithm 

[Intersection of two sorted Array](https://www.geeksforgeeks.org/problems/intersection-of-two-sorted-array-1587115620/1)

```j
Given two sorted arrays arr1[] and arr2[]. Your task is to return the intersection of both arrays.

Intersection of two arrays is said to be elements that are common in both arrays. The intersection should not count duplicate elements.

Note: If there is no intersection then return an empty array.

 Examples:

Input: arr1[] = [1, 2, 3, 4], arr2[] = [2, 4, 6, 7, 8]
Output: [2, 4]
Explanation: 2 and 4 are only common elements in both the arrays.

Input: arr1[] = [1, 2, 2, 3, 4], arr2[] = [2, 2, 4, 6, 7, 8]
Output: [2, 4]
Explanation: 2 and 4 are the only common elements.
Input: arr1[] = [1, 2], arr2[] = [3, 4]
Output: []
Explanation: No common elements.


Expected Time Complexity: O(n + m)
Expected Auxiliary Space: O(min(n,m))

1 <= arr1.size(),arr2.size() <= 105
1 <= arr1[i], arr2[i] <= 106
```
**Thought Process<br>**
**Leverage Sorted Order:**

Since the arrays are sorted, we can use a two-pointer approach to traverse them in a linear fashion, avoiding unnecessary comparisons.
This approach ensures efficiency compared to brute force, which may require O(n×m) comparisons.
Two-Pointer Technique:

Use two pointers, one for each array:
Pointer i for the first array.
Pointer j for the second array.
Compare the elements at the current positions:
* If they match, add the element to the result.
* If the element in the first array is smaller, move i forward.
* If the element in the second array is smaller, move j forward.
* This way, you skip over elements that cannot be in the intersection.

Handle Duplicates:

If the arrays can have duplicates and the intersection should only contain unique elements, ensure that duplicates are skipped when adding elements to the result.

```java


//User function Template for Java

class Solution
{
    //Function to return a list containing the intersection of two arrays.
    static ArrayList<Integer> printIntersection(int arr1[], int arr2[], int n, int m) 
    {
        // add your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        int i = 0 , j = 0;
        while(i < arr1.length && j < arr2.length){
            if(i > 0 && arr1[i] == arr1[i - 1]){
                i++;
                continue;
            }
            if(arr1[i] < arr2[j]){
                i++;
            }
            else if(arr1[i] > arr2[j]){
                j++;
            }
            else{
                res.add(arr1[i]);
                i++;
                j++;
            }
        }
        return res;
        
    }

}
```
**Time Complexity:** O(n+m), where n and m are the lengths of the arrays. This is because each element is compared at most once.<br>

**Space Complexity:**
O(1) additional space if only pointers are used.<br>
O(k), where k is the size of the result if storing the intersection.

Similar Questions for above patterns : 

- [Union of two sorted array](https://www.geeksforgeeks.org/problems/union-of-two-sorted-arrays-1587115621/1)

VVI - [Count Inversion](https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1)

```
Given an array of integers arr[]. Find the Inversion Count in the array.
Two elements arr[i] and arr[j] form an inversion if arr[i] > arr[j] and i < j.

Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If the array is already sorted then the inversion count is 0.
If an array is sorted in the reverse order then the inversion count is the maximum. 

Examples:

Input: arr[] = [2, 4, 1, 3, 5]
Output: 3
Explanation: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
Input: arr[] = [2, 3, 4, 5, 6]
Output: 0
Explanation: As the sequence is already sorted so there is no inversion count.
Input: arr[] = [10, 10, 10]
Output: 0
Explanation: As all the elements of array are same, so there is no inversion count.
```

Brute force Approach : 

The steps are as follows:

* First, we will run a loop(say i) from 0 to N-1 to select the first element in the pair.
* As index j should be greater than index i, inside loop i, we will run another loop i.e. j from i+1 to N-1.
* Inside this second loop, we will check if a[i] > a[j] i.e. if a[i] and a[j] can be a pair. If they satisfy the condition, we will increase the count by 1.
* Finally, we will return the count i.e. the number of such pairs.

```java
public class CountInversion {

    public static int numberOfInversions(int[] a, int n) {
        // Count the number of pairs:
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j]) cnt++;
            }
        }
        return cnt;
    }


    public static void main(String[] args) {
        int[] a = {5, 4, 3, 2, 1};
        int n = 5;
        int cnt = numberOfInversions(a, n);
        System.out.println("The number of inversions is: " + cnt);
    }
}

```

**Time Complexity:** O(N2), where N = size of the given array.<br>
Reason: We are using nested loops here , those two loops roughly run for N times.

Space Complexity: O(1) as we are not using any extra space to solve this problem.

Here we used the standard merge sort algorithm<br>

There are three scenarios to consider:
* arr[i]>arr[j] occurs within the left half of the array.
* arr[i]>arr[j] occurs within the right half of the array.
* arr[i]>arr[j] exists across both the left and right halves of the array.

If the current element in the left subarray (arr[i]) is greater than the current element in the right subarray  It means that all remaining elements in the left subarray (from index 𝑖 i to mid) are also greater than
arr[j]. <br>
Why? Because the left subarray is already sorted.<br>
The number of such elements in the left subarray is:n1−i


```java
class Solution {
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
        // Your Code Here
        return mergeSort(arr , 0 , arr.length - 1);
        
    }
    static int  mergeSort(int arr[] , int low , int high){
        int count = 0;
        if(low < high){
            int mid = low + (high - low)/2;
            count += mergeSort(arr , low , mid);
            count += mergeSort(arr , mid + 1 , high);
            count += merge(arr , low , mid , high);
        }
        return count;
    }
    static int   merge(int[] arr , int low , int mid , int high){
        int n1 = mid - low + 1 , n2 = high - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];
        int count = 0;
        for(int i = 0 ; i < n1 ; i++ ){
            left[i] = arr[low + i];
        }
        for(int j = 0 ; j < n2 ; j++){
            right[j] = arr[mid + 1 + j];
        }
        //standard merge sort
        int i = 0 , j = 0 , k = low;
        while(i < n1 && j < n2){
            if(left[i] <= right[j]){
                arr[k++] = left[i++];
            }
            else{
                count += (n1 - i);
                arr[k++] = right[j++];
            }
        }
        
        while(i < n1){
            arr[k++] = left[i++];
        }
        while(j < n2) arr[k++] = right[j++];
        return count;
        
    }
}
```
Important practice Questions on Merge sort 
* [Count of Smaller Numbers After Self](https://leetcode.com/problems/count-of-smaller-numbers-after-self/)
* [Reverse Pairs](https://leetcode.com/problems/reverse-pairs/)
* [Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/description/) **Note :We could solve this question using binary search for improved time complexity.**
* [K-th element of two Arrays](https://www.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1) **Note :We could solve this question using binary search for improved time complexity.**


## Quick Sort Algorithm
**Intuition:**<br>
Quick Sort is a divide-and-conquer algorithm like Merge Sort. However, unlike Merge Sort, Quick Sort does not use an extra array for sorting (though it uses an auxiliary stack space). This makes Quick Sort slightly better than Merge Sort from a space perspective.

This algorithm follows two simple steps repeatedly:

1. Pick a pivot and place it in its correct position in the sorted array.
2. Move smaller elements (i.e., smaller than the pivot) to the left of the pivot and larger ones to the right.


**Lomuto’s Partition Algorithm (unstable algorithm)**
Lomutopartition(arr[], lo, hi)

    pivot = arr[hi]
    i = lo -1    // place for swapping
    for j := lo to hi – 1 do
        if arr[j] <= pivot then
            swap arr[i] with arr[j]
            i = i + 1
    swap arr[i] with arr[hi]
    return i


QuickSort(arr[], l,  r)

If r > l
1. Find the partition point of the array  
m =Lomutopartition(a,l,r)
2. Call Quicksort for less than partition point   
Call Quicksort(arr, l, m-1)
3. Call Quicksort for greater than the partition point
Call Quicksort(arr, m+1, r)

```java
// Java program to demonstrate the Lomuto partition
// in quick sort

iimport java.util.*;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = { 4, 5, 1, 2, 4, 5, 6 };
        System.out.println("Before sorting the array: " + Arrays.toString(array));
        quickSort(array, 0, array.length - 1);
        System.out.println("After sorting the array: " + Arrays.toString(array));
    }

    private static void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int pivotIndex = lomutoPartition(array, start, end);
            quickSort(array, start, pivotIndex - 1);    // Left subarray
            quickSort(array, pivotIndex + 1, end);      // Right subarray
        }
    }

    private static int lomutoPartition(int[] array, int start, int end) {
        int pivot = array[end];             // Pivot is the last element
        int smallerIndex = start - 1;       // Points to the last element smaller than pivot

        for (int current = start; current < end; current++) {
            if (array[current] < pivot) {
                smallerIndex++;
                swap(array, smallerIndex, current);
            }
        }

        // Place pivot in its correct sorted position
        swap(array, smallerIndex + 1, end);
        return smallerIndex + 1;
    }

    private static void swap(int[] array, int i, int j) {
        if (i != j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}

```
Hoare's Partition

Hoare’s Partition Scheme works by initializing two indexes that start at two ends, the two indexes move toward each other until an inversion is (A smaller value on the left side and a greater value on the right side) found. When an inversion is found, two values are swapped and the process is repeated.

```text
Hoare's Partition 

Hoare’s Partition Scheme works by initializing two indexes that start at two ends, the two indexes move toward each other until an inversion is (A smaller value on the left side and a greater value on the right side) found. When an inversion is found, two values are swapped and the process is repeated.

Algorithm: 

Hoarepartition(arr[], lo, hi)

   pivot = arr[lo]
   i = lo - 1  // Initialize left index
   j = hi + 1  // Initialize right index

   // Find a value in left side greater
   // than pivot
   do
      i = i + 1
   while arr[i] < pivot

   // Find a value in right side smaller
   // than pivot
   do
      j--;
   while (arr[j] > pivot);

   if i >= j then 
      return j

   swap arr[i] with arr[j]


   
QuickSort(arr[], l,  r)

If r > l
     1. Find the partition point of the array  
              m =Hoarepartition(a,l,r) 
     2. Call Quicksort for less than partition point   
             Call Quicksort(arr, l, m)
     3. Call Quicksort for greater than the partition point 
             Call Quicksort(arr, m+1, r)
```

```java
//Java program to demonstrate the Hoare partition
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

```

* [Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/description/)
```
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?
Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
 

Constraints:

1 <= k <= nums.length <= 105
-104 <= nums[i] <= 104
```
Intuition :

we can use modified version of quick sort algorithm here.

```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k; //since we are sorting array in an  ascending order we could take len - k
        int low = 0 , high = nums.length - 1;
        while(low <= high){
            int pi = partition(nums , low , high);
            if(pi == k)
                return nums[pi];
            if(pi > k){
                high = pi - 1;
            }
            else
                low = pi + 1;
        }
        return -1;

    }
    public int partition(int[] array, int start, int end) {
        int pivot = array[start];
        int left = start;
        int right = end;
        while(left < right){
            while(left < right && array[left] <= pivot){
                left++;
            }
            while(array[right] > pivot){
                right--;
            }
            if(left < right){
                swap(array , left , right);
            }
        }
        swap(array , start , right);
        return right;

    }
    public void swap(int[] array , int first , int second){
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
```

Problems on Quick sort Algorithm : 

- [Minimum difference pair](https://www.geeksforgeeks.org/problems/minimum-difference-pair5444/0)
- [Kth Smallest](https://www.geeksforgeeks.org/problems/kth-smallest-element5635/1)
- [sort the colors](https://leetcode.com/problems/sort-colors/description/)

# **🔢 Counting Sort & Radix Sort: Intuition, Approach, Code, Dry Run, Time Complexity & Space Complexity**

## **📌 1. Counting Sort**
### **👉 Intuition**
Counting Sort is a **non-comparison-based sorting algorithm** that works by counting the occurrences of each unique element in the array and using that information to place the elements in their correct positions.

Unlike other sorting algorithms like **Merge Sort** or **Quick Sort**, which use **comparisons**, Counting Sort works by **grouping elements based on their values**. This makes it very efficient for sorting numbers within a known range.

---

### **👉 Approach**
1. **Find the maximum element (`max`)** in the array to determine the size of the counting array.
2. **Create a frequency array** (`count[]`) of size `max + 1` to store the count of each number.
3. **Compute prefix sum** in `count[]`, which will help us determine the correct position of each element.
4. **Build the output array** using the prefix sum information.
5. **Copy the sorted output array back to the original array.**

---

### **📌 Code: Counting Sort**
```java
class CountingSort {
    public static void countingSort(int[] arr) {
        int n = arr.length;
        int max = 0;

        // Step 1: Find the maximum value
        for (int num : arr) {
            max = Math.max(max, num);
        }

        // Step 2: Create a frequency array (count array)
        int[] count = new int[max + 1];

        for (int num : arr) {
            count[num]++;
        }

        // Step 3: Compute prefix sum in count array
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Step 4: Build the output array
        int[] output = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--; // Decrease count for stability
        }

        // Step 5: Copy the sorted elements back to the original array
        System.arraycopy(output, 0, arr, 0, n);
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};
        countingSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
```

---

### **📌 Dry Run**
#### **Input:** `{4, 2, 2, 8, 3, 3, 1}`
#### **Step-by-Step Execution**
| Step  | Action |
|--------|------------------------------------------------------|
| **1**  | Find `max = 8` |
| **2**  | Build `count[]`: `{0, 1, 2, 2, 1, 0, 0, 0, 1}` |
| **3**  | Compute prefix sum in `count[]`: `{0, 1, 3, 5, 6, 6, 6, 6, 7}` |
| **4**  | Build `output[]`: `{1, 2, 2, 3, 3, 4, 8}` |
| **5**  | Copy sorted output back to `arr[]`: `{1, 2, 2, 3, 3, 4, 8}` |

---

### **📌 Time & Space Complexity**
| **Complexity** | **Counting Sort** |
|--------------|----------------|
| **Time Complexity** | **O(N + K)** (N = size of array, K = max value) |
| **Space Complexity** | **O(N + K)** (for `count[]` and `output[]`) |

---

## **📌 2. Radix Sort**
### **👉 Intuition**
Radix Sort is a **non-comparison-based sorting algorithm** that works by sorting numbers digit by digit, starting from the **least significant digit (LSD)** to the **most significant digit (MSD)**.

It **uses Counting Sort as a subroutine** to sort based on each digit position, which makes it stable and efficient for sorting large numbers.

---

### **👉 Approach**
1. **Find the maximum element (`max`)** to determine the number of digits.
2. **Sort based on each digit** (ones, tens, hundreds, etc.) using **Counting Sort**.
3. **Repeat the process** until all digit places are processed.

---

### **📌 Code: Radix Sort**
```java
class RadixSort {
    static void radixSort(int arr[], int n) {
        int maxNumber = arr[0];

        // Step 1: Find maximum number to determine number of digits
        for (int i = 1; i < n; i++) {
            maxNumber = Math.max(maxNumber, arr[i]);
        }

        // Step 2: Apply Counting Sort for every digit (1s, 10s, 100s, ...)
        for (int exp = 1; maxNumber / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    public static void countingSort(int[] arr, int exp) {
        int[] count = new int[10]; // Digits (0-9)
        int n = arr.length;
        int[] output = new int[n];

        // Count occurrences of digits at the current place value
        for (int val : arr) {
            count[(val / exp) % 10]++;
        }

        // Compute prefix sum
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array (Right to Left to maintain stability)
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i]; 
            count[digit]--; 
        }

        // Copy sorted elements back to the original array
        System.arraycopy(output, 0, arr, 0, n);
    }

    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        radixSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
```

---

### **📌 Dry Run**
#### **Input:** `{170, 45, 75, 90, 802, 24, 2, 66}`
**Pass 1 (exp = 1, sorting by units place):**
- Sorted `{170, 90, 802, 2, 24, 45, 75, 66}`
- (Using Counting Sort on last digit)

**Pass 2 (exp = 10, sorting by tens place):**
- Sorted `{802, 2, 24, 45, 66, 170, 75, 90}`

**Pass 3 (exp = 100, sorting by hundreds place):**
- Sorted `{2, 24, 45, 66, 75, 90, 170, 802}`

**Final Output:** `{2, 24, 45, 66, 75, 90, 170, 802}` ✅

---

### **📌 Time & Space Complexity**
| **Complexity** | **Radix Sort** |
|--------------|----------------|
| **Time Complexity** | **O((N + K) * log₁₀(max))** |
| **Space Complexity** | **O(N + K)** |


---
## Sort Functions on C++ and Java
**Sorting Functions in Java**

Syntax for sorting an array in ascending order using Arrays class:<br>
Arrays.sort(array);<br>
Syntax for sorting an array in descending order using Arrays class:<br>
Arrays.sort(array, Collections.reverseOrder());<br>

syntax for sorting a list in ascending order:<br>
Collections.sort(list);<br>

Syntax for sorting a list in descending order:<br>
Collections.sort(list, Collections.reverseOrder());<br>
```java
import java.util.*;

public class SortFunctions {
    public static void main(String[] args) {
        // Sorting an Array in Ascending Order
        int[] array = {5, 2, 9, 1, 6};
        Arrays.sort(array);
        System.out.println("Array sorted in ascending order: " + Arrays.toString(array));

        // Sorting an Array in Descending Order
        Integer[] descArray = {5, 2, 9, 1, 6};
        Arrays.sort(descArray, Collections.reverseOrder());
        System.out.println("Array sorted in descending order: " + Arrays.toString(descArray));

        // Sorting a List in Ascending Order
        List<Integer> list = new ArrayList<>(Arrays.asList(5, 2, 9, 1, 6));
        Collections.sort(list);
        System.out.println("List sorted in ascending order: " + list);

        // Sorting a List in Descending Order
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("List sorted in descending order: " + list);
    }
}
```

Sorting Function in c++

```CPP
#include<bits/stdc++.h>
using namespace std;

int main() {
    // Sorting an array in ascending order
    int array[] = {5, 2, 9, 1, 6};
    int n = sizeof(array) / sizeof(array[0]);

    sort(array, array + n); // Ascending order
    cout << "Array sorted in ascending order: ";
    for (int i = 0; i < n; i++) {
        cout << array[i] << " ";
    }
    cout << endl;

    // Sorting an array in descending order
    sort(array, array + n, greater<int>()); // Descending order
    cout << "Array sorted in descending order: ";
    for (int i = 0; i < n; i++) {
        cout << array[i] << " ";
    }
    cout << endl;

    // Sorting a vector in ascending order
    vector<int> vec = {5, 2, 9, 1, 6};
    sort(vec.begin(), vec.end()); // Ascending order
    cout << "Vector sorted in ascending order: ";
    for (int v : vec) {
        cout << v << " ";
    }
    cout << endl;

    // Sorting a vector in descending order
    sort(vec.begin(), vec.end(), greater<int>()); // Descending order
    cout << "Vector sorted in descending order: ";
    for (int v : vec) {
        cout << v << " ";
    }
    cout << endl;

    return 0;
}
```

## Programs on Custom Sorting Technique

* [Largest Number](https://leetcode.com/problems/largest-number/description/)
* [Custom Sort String](https://leetcode.com/problems/custom-sort-string/description/)
* [ Sort Characters By Frequency](https://leetcode.com/problems/sort-characters-by-frequency/description/)
* [Sort by Number of Factors](https://www.geeksforgeeks.org/sort-elements-basis-number-factors/)
* [Sort an array of strings according to string lengths](https://www.geeksforgeeks.org/sort-array-strings-according-string-lengths/)
* [sort by set bit count](https://www.geeksforgeeks.org/problems/sort-by-set-bit-count1153/1)
* [Sorting Custom Object by Implementing Comparable Interface in Java](https://www.geeksforgeeks.org/sorting-custom-object-by-implementing-comparable-interface-in-java/)


