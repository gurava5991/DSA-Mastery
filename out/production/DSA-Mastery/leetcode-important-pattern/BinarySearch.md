# Binary Search Algorithm

Whenever we encounter a sorted array, linked list, or matrix and need to find an element, the best algorithm to use is Binary Search.

**Intuition :**<br>
Binary Search is an efficient algorithm used to find an element in a sorted array or collection. Its intuition lies in repeatedly dividing the search interval into halves, eliminating half of the potential candidates for the target in each step.

**Steps to Implement Binary Search:**

**1 . Set up pointers:**

* Place the start pointer at the beginning of the array.
* Place the end pointer at the end of the array.

**2. Find the middle element**

* Compute the middle index as: mid = start + (end - start) / 2;
* This avoids potential overflow compared to using mid = (start + end) / 2;

**3 . Compare and adjust bounds:**
* If the middle element equals the target, return the index.
* If the middle element is **smaller** than the target: **if(arr[mid] < target)**
* Move the **start pointer** to mid+1. **start = mid + 1**
* If the middle element is **larger** than the target:
* Move the **end pointer** to mid−1.

**4 . Repeat the process:**

* Continue until the **start pointer** crosses the **end pointer**

**5 . Return the result:**

* If the target is found, return its index.
* If the target is not found, return an indicator

```java
public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            // Calculate the mid-point
            int mid = start + (end - start) / 2;

            // Check if the middle element is the target
            if (arr[mid] == target) {
                return mid; // Target found
            } 
            // If the target is greater, ignore the left half
            else if (arr[mid] < target) {
                start = mid + 1;
            } 
            // If the target is smaller, ignore the right half
            else {
                end = mid - 1;
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13}; // Sorted array
        int target = 7;

        int result = binarySearch(arr, target);
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found.");
        }
    }
}

```

**Time Complexity:** The time complexity is O(log n) due to the binary search mechanism, halving the search space with each iteration.<br>
**Space Complexity:** The space complexity is O(1) as it uses a constant amount of extra space for variables.

**Implement Lower Bound**
You are given an array 'arr' sorted in non-decreasing order and a number 'x'. You must return the index of the lower bound of 'x'

The lower bound is the smallest index, ind, where arr[ind] >= x. But if any such index is not found, the lower bound algorithm returns n i.e. size of the given array.

**Intuition :**
As the array is sorted, we will apply the Binary Search algorithm to find the index.



```java
public class Solution {
    public static int lowerBound(int []arr, int n, int x) {
        // Write your code here
        int low=0 , high=n-1;
        int ans = n;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid]>=x){
                ans=mid;
                high=mid-1;
            }
            else   
            low=mid+1;

        }
        return ans;
        
    }
}
```

**Time Complexity:** The time complexity is O(log n) due to the binary search mechanism, halving the search space with each iteration.<br>
**Space Complexity:** The space complexity is O(1) as it uses a constant amount of extra space for variables.

- [Implement Upper Bound ](https://www.naukri.com/code360/problems/implement-upper-bound_8165383) **Note : Upper bound: Find the first element >target.**
- [Find Smallest Letter Greater Than Target](https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/)
- [Find Bad Version](https://leetcode.com/problems/first-bad-version/description/)
  
**Find First and Last Position of Element in Sorted Array**

```html
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]


Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
```
**Intuitions :** 

As the given arrays is sorted . we could use binary search for improved time complexity here.

**Binary Search Logic:**
1. Since the array is sorted, binary search helps reduce the search space at each step.
2. By repeatedly adjusting the low and high pointers, we narrow down the indices where the target could appear.

Since the question is asking about starting and ending position of given target value we would need find the first occurrence of target and last occurrence of the target.

First Occurrence:

* For the first occurrence, the goal is to locate the leftmost position where the target value appears.
* We adjust the search by continuing to look to the left whenever we encounter the target, ensuring that we find its first position.

Last Occurrence:
* For the last occurrence, the aim is to locate the rightmost position where the target appears.
* If we find the target, we check to the right to ensure it's the last instance.

```java
class Solution {
    private int findFirstOccurrence(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] < target) {
                start = mid + 1; // Move to the right half
            } else if (nums[mid] > target) {
                end = mid - 1; // Move to the left half
            } else {
                // Check if it's the first occurrence
                if (mid == 0 || nums[mid] != nums[mid - 1]) {
                    return mid;
                } else {
                    end = mid - 1; // Continue searching on the left
                }
            }
        }
        return -1; // Target not found
    }

    private int findLastOccurrence(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] < target) {
                start = mid + 1; // Move to the right half
            } else if (nums[mid] > target) {
                end = mid - 1; // Move to the left half
            } else {
                // Check if it's the last occurrence
                if (mid == nums.length - 1 || nums[mid] != nums[mid + 1]) {
                    return mid;
                } else {
                    start = mid + 1; // Continue searching on the right
                }
            }
        }
        return -1; // Target not found
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1}; // Handle empty array
        }

        int first = findFirstOccurrence(nums, target, 0, nums.length - 1);
        int last = findLastOccurrence(nums, target, 0, nums.length - 1);

        return new int[]{first, last};
    }
}

```
Time complexity: O(log n).<br>
Space complexity : O(1).

**Practice Question for above approach**<br>
- [Number of occurrence](https://www.geeksforgeeks.org/problems/number-of-occurrence2259/1) 

## Binary Search On 2D Array 
- [Search in a Row-Column sorted matrix](https://leetcode.com/problems/search-a-2d-matrix-ii/description/)

```Bash

Examples:

Input: mat[][] = [[3, 30, 38],[20, 52, 54],[35, 60, 69]], x = 62
Output: false
Explanation: 62 is not present in the matrix, so output is false.
Input: mat[][] = [[18, 21, 27],[38, 55, 67]], x = 55
Output: true
Explanation: 55 is present in the matrix.
Input: mat[][] = [[1, 2, 3],[4, 5, 6],[7, 8, 9]], x = 3
Output: true
Explanation: 3 is present in the matrix.
Constraints:
1 <= n, m <=1000
1 <= mat[i][j] <= 109
1<= x <= 109
```
**Optimized Search in a Sorted Matrix**
The idea is to utilize the property that the matrix is sorted both row-wise (increasing from left to right) and column-wise (increasing from top to bottom). By choosing an appropriate starting corner, efficient traversal can be achieved.<br>

**Corner Selection:**
A suitable corner is chosen from the four possible corners:<br>

(0, 0)<br>
(0, m-1)<br>
(n-1, 0)<br>
(n-1, m-1)<br>
This selection ensures that moving in one direction (either vertically or horizontally) from the chosen corner leads to smaller elements, while moving in the other direction leads to larger elements relative to the target.<br>

**Movement Strategy:**
* If xthe corner element is smaller than the target, move in the direction containing larger elements.
* If the corner element is larger than the target, move in the direction containing smaller elements.
* If neither condition applies, the corner element is the target, and true is returned.<br>

**Analysis of Starting Corners:**<br>
**Corner (0, 0):**<br>
Traversal starts at (0, 0) with a search target of 14.

* Since both the row and column increase in order, it is ambiguous whether to proceed row-wise or column-wise.
* Not suitable for traversal.

**Corner (0, m-1):**
Traversal starts at (0, m-1) with a search target of 14.

* The row increases, and the column decreases.
* Direction of movement is straightforward:
* If matrix[0][m-1] > target, move left (column-wise).
* If matrix[0][m-1] < target, move down (row-wise).
* Suitable for traversal.<br>

**Corner (n-1, m-1):**<br>
Traversal starts at (n-1, m-1) with a search target of 14.

Both row and column decrease.
Directional ambiguity arises, as it is unclear whether to move row-wise or column-wise.
Not suitable for traversal.
**Corner (n-1, 0):**<br>
Traversal starts at (n-1, 0) with a search target of 14.<br>

The row increases, and the column decreases.<br>
* Direction of movement is straightforward:
* If matrix[n-1][0] < target, move right (row-wise).
* If matrix[n-1][0] > target, move up (column-wise).
Suitable for traversal.<br>
Conclusion:<br>
From the above analysis, traversal should start at either (0, m-1) or (n-1, 0).<br>


**Algorithm:**
Assume the starting cell is (0, m-1). Use two variables, row and col, initialized to 0 and m-1 respectively.<br>

**Initialize a while loop**:<br>

Loop runs while row < n (total rows) and col >= 0 (valid columns).
Check the element at (row, col):

If matrix[row][col] == target, return true.<br>
Adjust row and col based on comparison with the target:<br>
If matrix[row][col] > target:<br>
Move left by decrementing col (col--).<br>
If matrix[row][col] < target:<br>
Move down by incrementing row (row++).<br>
Terminate the loop:<br>
If the loop ends without finding the target, return false.<br>

```java
class Solution {
    public static boolean matSearch(int mat[][], int x) {
        // your code here
        int n = mat.length , m = mat[0].length;
        int i = 0 , j = m - 1;
        while(i < n && j >= 0){
            if(mat[i][j] == x)
                return true;
            else if(x > mat[i][j]){
                i++;
            }
            else
                j--;
        }
        return false;
        
        
        
    }
}
```

- [Search a 2D Matrix](https://leetcode.com/problems/search-a-2d-matrix/description/)

```bash
You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

Example 1 : 
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2 : 
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false

```

Intuition Of Question : 

The idea is to consider the given matrix as 1D array and apply only one binary search. For example, for a matrix of size n x m and we can consider it as a 1D array of size n*m, then the first index would be 0 and last index would n*m-1. So, we need to do binary search from low = 0 to high = (n*m-1).

**How to find the element in 2D matrix corresponding to index = mid?**

Since each row of mat[][] will have m elements, so we can find the row of the element as (mid / m) and the column of the element as (mid % m). Then, we can compare x with arr[mid/m][mid%m] for each mid and complete our binary search.

```java
class Solution {
    public boolean searchMatrix(int[][] mat, int x) {
        // code here
        int n = mat.length , m = mat[0].length;
        int low = 0 , high = n * m - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            // Find row and column of element at mid index
            int row = mid / m;
            int col = mid % m;
            if(x == mat[row][col])
                return true;
            else if(mat[row][col] < x)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }
}
```

**Time Complexity:** O(log(n * m)) due to the binary search on the matrix elements<br>
**Space Complexity**: O(1) as only a constant amount of space is used for variables

### 378. Kth Smallest Element in a Sorted Matrix
```
Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

You must find a solution with a memory complexity better than O(n2).

 

Example 1:

Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
Example 2:

Input: matrix = [[-5]], k = 1
Output: -5
 

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 300
-109 <= matrix[i][j] <= 109
All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.
1 <= k <= n2
```
Since the array is sorted in row wise and column wise we could use binary search for improved time complexity
* We will take l as matrix[0][0] and h as matrix[m-1][m-1] where m are the rows in matrix
* Then find mid and count the no of elements < mid in each row
* if count < k means we have to find the greater mid so that count can become equal to k
* else h =mid;
* return l

```java

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0], high = matrix[n - 1][n - 1];
        int ans = 0;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(countSmallerEqual(matrix , mid) >= k){
                ans = mid ;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;   
    }
    public int countSmallerEqual(int[][] matrix , int x){
        int n = matrix.length , count = 0;
        int row = 0 , col = n - 1;

        // Traverse from the top-right corner
        while (row < n && col >= 0) {
            if (matrix[row][col] <= x) {
                // If current element is less than or equal to x,
                // all elements in this row up to the current column are <= x
                count += (col + 1);
                row++;
            } else {
                // Move left in the matrix
                col--;
            }
        }

        return count;
    }
}

```
Time Complexity : o(nlogn)

Space Complexity : O(1)

## **668. Kth Smallest Number in Multiplication Table**

```bash
Nearly everyone has used the Multiplication Table. The multiplication table of size m x n is an integer matrix mat where mat[i][j] == i * j (1-indexed).

Given three integers m, n, and k, return the kth smallest element in the m x n multiplication table.

 

Example 1:

Input: m = 3, n = 3, k = 5
Output: 3
Explanation: The 5th smallest number is 3.
Example 2:  
Input: m = 2, n = 3, k = 6
Output: 6
Explanation: The 6th smallest number is 6.  

Constraints:

1 <= m, n <= 3 * 104
1 <= k <= m * n

```

Approach : we used the Binary search answer pattern here
steps :

1. set low = 1 and high = m*n
2. while(low <= high)
3. mid = low + (high - low)/2
4. if(lessthanK(mid , m , n) < k) low = mid + 1;
5. else high = mid - 1
6. return low

```java
class Solution {
    public int findKthNumber(int m, int n, int k) {
        int low = 1 , high = m * n;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(lessthanK(mid , m , n) < k){
                low = mid + 1;
            }
            else
                high = mid - 1;
        }
        return low;
        
    }
    private int lessthanK(int mid , int m , int n){
        int count = 0;
        for(int i = 1 ; i <= m ; i++){
            count += Math.min(mid / i , n);
        }
        return count;
    }
}
```

---
Time Complexity : O(log(m*n))<br>
Space Complexity : O(1)

---




