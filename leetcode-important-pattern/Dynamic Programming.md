### **Introduction to Dynamic Programming**
Dynamic programming (DP) is a method used in computer science and mathematics to solve complex problems by breaking them down into simpler sub-problems. It is particularly useful for **optimization problems** where the problem can be divided into **overlapping subproblems**, which can be solved independently and combined to form the solution to the overall problem.

## **Types of Dynamic Programming Approaches**
### **1. Memoization (Top-Down Approach)**
- Solves the problem **recursively**, starting from the main problem and breaking it down into smaller subproblems.
- Uses a **cache (array or dictionary)** to store computed values to avoid redundant calculations.
- Reduces the time complexity significantly.

### **2. Tabulation (Bottom-Up Approach)**
- Uses an **iterative** approach, solving all possible subproblems **first** before solving the main problem.
- Stores results in a table and **builds the solution** step by step.
- Eliminates recursion overhead.

### **3. Space Optimization**
- Further optimizes the tabulation method by **reducing space complexity**.
- Instead of storing an entire DP table, only stores **necessary values** to compute the result.

---

## **Example: Fibonacci Numbers**
The Fibonacci sequence is defined as:
```
0, 1, 1, 2, 3, 5, 8, 13, 21, ...
```
Find the **nth Fibonacci number**, where:
```
F(n) = F(n-1) + F(n-2), with base cases F(0) = 0 and F(1) = 1.
```

---

## **Solution: Recursion (Naive Approach)**
```java
class Solution {
    public int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
```
### **Complexity Analysis:**
- **Time Complexity:** O(2ⁿ) (Exponential) ❌
- **Space Complexity:** O(N) (Recursive stack space)

🔴 **Issue:** Overlapping subproblems cause redundant calculations.

### **Recursion Tree for F(4):**
```
        F(4)
       /    \
   F(3)     F(2)
  /    \     /   \
F(2)   F(1) F(1)  F(0)
 /   \
F(1)  F(0)
```

---

## **Solution: Memoization (Top-Down DP)**
Memoization solves the problem by storing already computed values in an array to avoid recomputation.

### **Steps to Implement Memoization:**
1. Create an array `dp[n+1]` initialized to `-1`.
2. If the value is already computed (`dp[n] != -1`), return it.
3. Compute the value recursively and store it in `dp[n]`.

```java
import java.util.Arrays;

public class FibonacciMemoization {
    public static int fibonacci(int n, int[] dp) {
        if (n <= 1) return n;
        if (dp[n] != -1) return dp[n];
        return dp[n] = fibonacci(n - 1, dp) + fibonacci(n - 2, dp);
    }
    
    public static int fib(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return fibonacci(n, dp);
    }
}
```
### **Complexity Analysis:**
- **Time Complexity:** O(N) ✅
- **Space Complexity:** O(N) (Recursion stack + DP array) ❌

---

## **Solution: Tabulation (Bottom-Up DP)**
Tabulation builds the solution iteratively, avoiding recursion.

### **Steps to Implement Tabulation:**
1. Declare a `dp[]` array of size `n+1`.
2. Initialize `dp[0] = 0` and `dp[1] = 1`.
3. Use a loop to compute each value iteratively.

```java
public class FibonacciTabulation {
    public static int fib(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
```
### **Complexity Analysis:**
- **Time Complexity:** O(N) ✅
- **Space Complexity:** O(N) ❌

---

## **Solution: Space Optimization**
Instead of using an entire DP array, we only store the last two values needed for the computation.

### **Steps to Implement Space Optimization:**
1. Maintain two variables `prev1` and `prev2` for storing the last two computed values.
2. Compute the next Fibonacci number using `prev1 + prev2`.
3. Update `prev2 = prev1` and `prev1 = curr` in each iteration.

```java
public class Fibonacci {
    public static int fib(int n) {
        if (n <= 1) return n;
        int prev2 = 0, prev1 = 1, curr = 0;

        for (int i = 2; i <= n; i++) {
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }
}
```
### **Complexity Analysis:**
- **Time Complexity:** O(N) ✅
- **Space Complexity:** O(1) ✅ (Most optimized)

---

## **Conclusion**
Dynamic programming is a powerful technique for solving complex problems by breaking them into simpler subproblems. By using **memoization and tabulation**, we can significantly optimize both time and space complexity.

### **Key Takeaways:**
- **Recursion:** Naive but inefficient due to redundant calculations.
- **Memoization:** Reduces redundancy using caching (Top-Down DP).
- **Tabulation:** Eliminates recursion overhead using iteration (Bottom-Up DP).
- **Space Optimization:** Further reduces memory usage by storing only necessary values.

### **Comparison Table:**
| Approach          | Time Complexity | Space Complexity | Method |
|------------------|----------------|----------------|------------|
| **Recursion**    | O(2ⁿ)           | O(N)          | Naive recursion (exponential) |
| **Memoization**  | O(N)            | O(N)          | Top-down with caching |
| **Tabulation**   | O(N)            | O(N)          | Bottom-up DP table |
| **Space Opt. DP**| O(N)            | O(1)          | Two variables |

## Dp on 1D
### **Dynamic Programming Problems**

## **1. Climbing Stairs**
### **Problem Statement:**
You are climbing a staircase. It takes `n` steps to reach the top. You can climb 1 or 2 steps at a time. How many distinct ways can you reach the top?

### **Recursion Approach:**
```java
class Solution {
    public int climbStairs(int n) {
        if (n <= 1) return 1;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
```
**Time Complexity:** O(2^N)  
**Space Complexity:** O(N) (Recursion stack space)

### **Memoization Approach:**
```java
class Solution {
    public int climbStairs(int n, int[] dp) {
        if (n <= 1) return 1;
        if (dp[n] != -1) return dp[n];
        return dp[n] = climbStairs(n - 1, dp) + climbStairs(n - 2, dp);
    }
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return climbStairs(n, dp);
    }
}
```
**Time Complexity:** O(N)  
**Space Complexity:** O(N)

### **Tabulation Approach:**
```java
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }
}
```
**Time Complexity:** O(N)  
**Space Complexity:** O(N)

### **Space Optimization:**
```java
class Solution {
    public int climbStairs(int n) {
        int prev2 = 1, prev1 = 1, curr;
        for (int i = 2; i <= n; i++) {
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
```
**Time Complexity:** O(N)  
**Space Complexity:** O(1)

---

## **2. Frog Jump**
### **Problem Statement:**
Given an array `heights[]` where `heights[i]` represents the height of stone `i`, the frog starts at index `0` and wants to reach the last stone. The frog can jump from stone `i` to stone `i+1` or `i+2`. The cost of a jump is `|heights[i] - heights[j]|`. Find the minimum total cost to reach the last stone.

### **Recursion Approach:**
```java
class Solution {
    public int frogJump(int index, int[] heights) {
        if (index == 0) return 0;
        int left = frogJump(index - 1, heights) + Math.abs(heights[index] - heights[index - 1]);
        int right = (index > 1) ? frogJump(index - 2, heights) + Math.abs(heights[index] - heights[index - 2]) : Integer.MAX_VALUE;
        return Math.min(left, right);
    }
}
```

### **Memoization Approach:**
```java
class Solution {
    public int frogJump(int index, int[] heights, int[] dp) {
        if (index == 0) return 0;
        if (dp[index] != -1) return dp[index];
        int left = frogJump(index - 1, heights, dp) + Math.abs(heights[index] - heights[index - 1]);
        int right = (index > 1) ? frogJump(index - 2, heights, dp) + Math.abs(heights[index] - heights[index - 2]) : Integer.MAX_VALUE;
        return dp[index] = Math.min(left, right);
    }
}
```

### **Tabulation Approach:**
```java
class Solution {
    public int frogJump(int n, int[] heights) {
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int left = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            int right = (i > 1) ? dp[i - 2] + Math.abs(heights[i] - heights[i - 2]) : Integer.MAX_VALUE;
            dp[i] = Math.min(left, right);
        }
        return dp[n - 1];
    }
}
```

### **Space Optimization:**
```java
class Solution {
    public int frogJump(int n, int[] heights) {
        int prev2 = 0, prev1 = 0, curr;
        for (int i = 1; i < n; i++) {
            int left = prev1 + Math.abs(heights[i] - heights[i - 1]);
            int right = (i > 1) ? prev2 + Math.abs(heights[i] - heights[i - 2]) : Integer.MAX_VALUE;
            curr = Math.min(left, right);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
```

---

## **3. House Robber Problem**
### **Problem Statement:**
A robber wants to rob houses along a street but cannot rob two adjacent houses. Given an array `nums[]`, where `nums[i]` represents the money in house `i`, find the maximum amount the robber can steal.

### **Memoization Approach:**
```java
class Solution {
    public int nonAdjacent(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp , -1);
        return nonAdjacentHelper(nums , n - 1 , dp);
    }
    public int nonAdjacentHelper(int[] nums , int ind , int[] dp){
        if(ind == 0)
            return nums[0];
        //checking the overlapping sub problems exist in the database
        if(dp[ind] != -1){
            return dp[ind];
        }
        int not_pick = 0 + nonAdjacentHelper(nums , ind - 1 , dp);
        int pick = nums[ind];
        if(ind - 2 >= 0){
            pick = pick + nonAdjacentHelper(nums , ind - 2 , dp);

        }
        return dp[ind] = Math.max(pick , not_pick);
    }
}
```
**Time Complexity:** O(N)  
**Space Complexity:** O(N) + O(N)

### **Space Optimized Approach:**
```java
class Solution {
    public int rob(int[] nums) {
        int prev2 = 0, prev1 = 0;
        for (int num : nums) {
            int curr = Math.max(prev1, prev2 + num);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
```

---

## **4. House Robber II**
### **Problem Statement:**
Same as House Robber I, but houses are in a **circular arrangement**. The first and last houses are adjacent.

### **Solution:**
```java
class Solution {
    private int robHelper(int[] nums, int start, int end) {
        int prev2 = 0, prev1 = 0;
        for (int i = start; i <= end; i++) {
            int curr = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
    
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(robHelper(nums, 0, nums.length - 2), robHelper(nums, 1, nums.length - 1));
    }
}
```

---

## **Longest Increasing Subsequence (LIS)** using **Dynamic Programming (DP) and Binary Search**.

---

## **Problem Statement**
Given an integer array `nums`, return the length of the **longest increasing subsequence**.

### **Example**
#### **Input:**
```plaintext
nums = [10, 9, 2, 5, 3, 7, 101, 18]
```
#### **Output:**
```plaintext
4
```
#### **Explanation:**
The longest increasing subsequence is `[2, 3, 7, 18]` (or `[2, 3, 7, 101]`), so the answer is `4`.

---

# **Approach 1: Dynamic Programming (O(N²))**
### **Java Code**
```java
import java.util.*;

public class LongestIncreasingSubsequence {
    static int lis(int arr[]) {
      // code here
      int[] lis = new int[arr.length];
      int maxLen = 1;
      for(int i = 0 ; i < arr.length ; i++){
        lis[i] = 1;
        for(int j = 0 ; j < i ; j++){
          if(arr[i] > arr[j]){
            lis[i] = Math.max(lis[i] , 1 + lis[j]);
          }
  
        }
        maxLen = Math.max(maxLen , lis[i]);
      }
      return maxLen;
    }
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lis(nums)); // Output: 4
    }
}
```

---

# **Approach 2: DP + Binary Search (O(N log N))**
### **Java Code**
```java
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> subSequence = new ArrayList<>();
        subSequence.add(nums[0]);
        for(int i = 1 ; i < n ; i++){
            if(nums[i] > subSequence.get(subSequence.size() - 1))
                subSequence.add(nums[i]);
            else {
                int lower_bound = lower_bound(subSequence , nums[i]);
                subSequence.set(lower_bound , nums[i]);
            }
        }
        return subSequence.size();
    }
    public int lower_bound(List<Integer> arr , int target){
        int low = 0 , high = arr.size() - 1;
        int lower_bound = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(arr.get(mid) >= target){
                lower_bound = mid;
                high = mid - 1;
            }
            else
                low = mid + 1;
        }
        return lower_bound;
    }
    public static void main(String[] args) {
      int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
      System.out.println(lengthOfLIS(nums)); // Output: 4
    }
    
}
```

---

# **Comparison of Approaches**
| Approach                 | Time Complexity | Space Complexity | When to Use? |
|--------------------------|----------------|------------------|--------------|
| **DP (O(N²))**           | `O(N²)`        | `O(N)`           | Small `N` (≤1000) |
| **Binary Search (O(N log N))** | `O(N log N)`  | `O(N)`           | Large `N` (≤10⁵) |

---

Here’s an explanation of each variation of LIS, along with the intuition and logic behind them:

---
## **LIS Variations** 
### **1) Minimum Deletions to Make an Array Sorted**
#### **Problem Statement**
Given an array, find the **minimum number of deletions** required to make the array sorted in **increasing order**.

#### **Intuition & Logic**
- Instead of deleting elements directly, we can **find the longest increasing subsequence (LIS)** in the array.
- The elements **not in the LIS must be deleted** to make the array sorted.
- If `n` is the array length and `LIS_length` is the length of the longest increasing subsequence, the **answer is**:
  \[
  \text{Minimum deletions} = n - \text{LIS_length}
  \]
- **Example**:
  ```
  nums = [5, 3, 7, 2, 8, 6]
  LIS = [3, 7, 8]  (length = 3)
  Minimum deletions = 6 - 3 = 3
  ```

---

### **2) Maximum Sum Increasing Subsequence**
#### **Problem Statement**
Find the **maximum sum** of an increasing subsequence in an array.

#### **Intuition & Logic**
- Instead of just tracking the length of LIS, track the **sum** of LIS ending at each index.
- Define `dp[i]` as the **maximum sum of an increasing subsequence ending at `i`**.
- Transition:
    - If `nums[j] < nums[i]`, we update `dp[i]`:
      \[
      dp[i] = \max(dp[i], dp[j] + nums[i])
      \]
- The **answer is the maximum value in `dp`**.
- **Example**:
  ```
  nums = [1, 101, 2, 3, 100, 4, 5]
  Maximum sum LIS = [1, 2, 3, 100] → sum = 106
  ```

---

### **3) Maximum Length Bitonic Subsequence**
#### **Problem Statement**
Find the length of the **longest bitonic subsequence** (LBS), where:
1. The sequence **first increases**.
2. Then, the sequence **decreases**.

#### **Intuition & Logic**
- A **bitonic sequence** has two parts:
    - **LIS from the left** (increasing part).
    - **LIS from the right** (decreasing part).
- Compute:
    - `LIS[i]` → Longest Increasing Subsequence **ending at `i`**.
    - `LDS[i]` → Longest Decreasing Subsequence **starting from `i`**.
- The **answer is the max value of**:
  \[
  \text{LIS}[i] + \text{LDS}[i] - 1
  \]
- **Example**:
  ```
  nums = [1, 3, 5, 4, 2]
  LIS = [1, 2, 3, 3, 2]
  LDS = [3, 3, 2, 2, 1]
  Max Bitonic Length = 3 + 2 - 1 = 4
  ```

---

### **4) Building Bridges**
#### **Problem Statement**
Given **two cities** with `n` bridges connecting them, where each bridge has **a north and a south coordinate**, find the **maximum number of non-overlapping bridges**.

#### **Intuition & Logic**
- Think of the problem as **finding LIS on sorted pairs**:
    1. **Sort the bridges** by their **north** coordinate.
    2. **Find LIS** based on the **south** coordinates.
- If two bridges **overlap**, one must be removed, so **LIS of the south coordinates** gives the maximum number of bridges that can be built **without overlap**.
- **Example**:
  ```
  North: [1, 3, 5, 6]
  South: [2, 4, 1, 7]
  Sorted: [(1,2), (3,4), (5,1), (6,7)]
  LIS on South = [2, 4, 7] → Maximum bridges = 3
  ```

---

### **5) Longest Chain of Pairs**
#### **Problem Statement**
Given a set of pairs `(a, b)`, where `a < b`, find the **longest chain** where:
- `(a1, b1)` → `(a2, b2)` → ... follows `b1 < a2`.

#### **Intuition & Logic**
- Sort pairs by the **second element (`b`)**.
- Find the **maximum number of pairs** that can be linked **without overlapping**.
- This is **LIS based on the second element**.
- **Example**:
  ```
  Pairs: [(5, 24), (15, 25), (27, 40), (50, 60)]
  Sorted: [(5, 24), (15, 25), (27, 40), (50, 60)]
  Chain: [(5,24) → (27,40) → (50,60)] → Length = 3
  ```

---

Great choice! The **Largest Divisible Subset (Leetcode 368)** is a variation of the **Longest Increasing Subsequence (LIS)** problem.

---

## **Problem Statement**
Given a set of **distinct** positive integers, find the **largest subset** such that for every pair `(Si, Sj)` in the subset, either **Si % Sj == 0** or **Sj % Si == 0**.

Return **any valid solution**.

---

## **Example**
#### **Input:**
```plaintext
nums = [1, 2, 3]
```
#### **Output:**
```plaintext
[1, 2] 
```
#### **Explanation:**
- The subset `[1, 3]` is also valid, but we return any one.

#### **Input:**
```plaintext
nums = [1, 2, 4, 8]
```
#### **Output:**
```plaintext
[1, 2, 4, 8]
```
#### **Explanation:**
- Every number is divisible by its previous number.

---

## **Intuition:**
1. **Sort the array**: Sorting helps in ensuring that every number is **only divisible by a previous number**.
2. **Use DP similar to LIS**:
    - Define `dp[i]` as the **size of the largest divisible subset ending at index `i`**.
    - Define `prev[i]` to store the **previous index** to reconstruct the subset.
3. **Transition:**
    - If `nums[j]` divides `nums[i]`, update `dp[i] = dp[j] + 1` (similar to LIS logic).
4. **Find the maximum subset size** from the `dp` array and backtrack using `prev[]` to build the result.

---

## **Java Code**
```java
import java.util.*;

public class LargestDivisibleSubset {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums); // Step 1: Sort the array
        int n = nums.length;
        int[] dp = new int[n]; // Step 2: LIS-based DP
        int[] prev = new int[n]; // Step 3: To track the subset elements
        
        Arrays.fill(dp, 1);  // Each number is a subset of size 1
        Arrays.fill(prev, -1); // -1 means no previous element

        int maxSize = 0, maxIndex = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;  // Track previous element
                }
            }
            if (dp[i] > maxSize) { // Update max subset size
                maxSize = dp[i];
                maxIndex = i;
            }
        }

        // Step 4: Reconstruct the subset
        List<Integer> result = new ArrayList<>();
        while (maxIndex != -1) {
            result.add(nums[maxIndex]);
            maxIndex = prev[maxIndex];
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 8};
        System.out.println(largestDivisibleSubset(nums)); // Output: [1, 2, 4, 8]
    }
}
```

---

## **Dry Run**
#### **Input:** `[1, 2, 4, 8]`
#### **Sorted:** `[1, 2, 4, 8]`
| Index | Num | `dp[i]` | `prev[i]` | Explanation |
|--------|------|--------|-----------|-------------|
| 0      | 1    | 1      | -1        | Start with subset `[1]` |
| 1      | 2    | 2      | 0         | `2` is divisible by `1`, so `[1,2]` |
| 2      | 4    | 3      | 1         | `4` is divisible by `2`, so `[1,2,4]` |
| 3      | 8    | 4      | 2         | `8` is divisible by `4`, so `[1,2,4,8]` |

#### **Final Subset:** `[1, 2, 4, 8]`

---

## **Time & Space Complexity**
- **TC:** `O(N²)` (Two nested loops for DP)
- **SC:** `O(N)` (To store `dp` and `prev` arrays)

---
## **Dynamic Programming on String**

### **Longest Common Subsequence (LCS)**
Let's break this down step by step.

---

## **Problem Statement**
Given two strings, `str1` and `str2`, find the **length of the longest common subsequence**.

### **What is a Subsequence?**
- A subsequence is a sequence derived from another sequence **by deleting some or no elements** without changing the relative order of the remaining elements.
- Example:
  ```
  str1 = "abcde"
  str2 = "ace"
  LCS = "ace" → Length = 3
  ```

### **Example Cases**
#### **Example 1**
```plaintext
Input:
str1 = "abcde", str2 = "ace"
Output:
3
Explanation: "ace" is the longest common subsequence.
```

#### **Example 2**
```plaintext
Input:
str1 = "abc", str2 = "def"
Output:
0
Explanation: No common subsequence.
```

---

## **Step 1: Recursive Approach**
### **Idea**
1. If characters match:
  - **Move both pointers** to the next character and add `1` to the count.
    \[
    LCS(i, j) = 1 + LCS(i-1, j-1)
    \]
2. If characters don’t match:
  - **Try two possibilities** (skip one character from either string).
    \[
    LCS(i, j) = \max(LCS(i-1, j), LCS(i, j-1))
    \]

### **Recursive Formula**
\[
LCS(i, j) =
\begin{cases}
0, & \text{if } i < 0 \text{ or } j < 0 \\
1 + LCS(i-1, j-1), & \text{if } \text{str1}[i] = \text{str2}[j] \\
\max(LCS(i-1, j), LCS(i, j-1)), & \text{otherwise}
\end{cases}
\]

---

### **Recursion Tree Example**
For:
```
str1 = "abcde"
str2 = "ace"
```
                      LCS(4,2) [e == e]
                         /       \
             LCS(3,1)          LCS(4,1)
        [d ≠ c]                [e ≠ c]
         /     \                 /     \
  LCS(2,1)  LCS(3,0)       LCS(3,1)  LCS(4,0)
  [c == c]  [d ≠ a]       (Repeats)   [e ≠ a]
    /   \      /   \                  
LCS(1,0) LCS(2,-1) LCS(2,0) LCS(3,-1)
[b ≠ a]                     
 /    \                     
LCS(0,0)  LCS(1,-1)            
[a == a]       
 /       
LCS(-1,-1) -> 0
```java
public class LCSRecursive {
    public static int lcs(String s1, String s2, int i, int j) {
        // Base Case: If any string becomes empty
        if (i < 0 || j < 0) return 0;

        // If characters match, move diagonally
        if (s1.charAt(i) == s2.charAt(j)) {
            return 1 + lcs(s1, s2, i - 1, j - 1);
        }

        // Otherwise, move either left or up
        return Math.max(lcs(s1, s2, i - 1, j), lcs(s1, s2, i, j - 1));
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
        int result = lcs(s1, s2, s1.length() - 1, s2.length() - 1);
        System.out.println("LCS Length: " + result);
    }
}

```
---
- **Time Complexity**: `O(2^N)`
- **Space Complexity**: `O(N)` (Recursion Stack)
---

## **Step 2: Memoization (Top-Down DP)**
### **Optimization Idea**
- The recursion tree shows **overlapping subproblems**.
- We **store** the results of `LCS(i, j)` in a `dp` table.

### **Memoization Formula**
\[
dp[i][j] =
\begin{cases}
0, & \text{if } i < 0 \text{ or } j < 0 \\
1 + dp[i-1][j-1], & \text{if } \text{str1}[i] = \text{str2}[j] \\
\max(dp[i-1][j], dp[i][j-1]), & \text{otherwise}
\end{cases}
\]

```java
import java.util.Arrays;

public class LCSMemoization {
    public static int lcs(String s1, String s2, int i, int j, int[][] dp) {
        if (i < 0 || j < 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + lcs(s1, s2, i - 1, j - 1, dp);
        }

        return dp[i][j] = Math.max(lcs(s1, s2, i - 1, j, dp), lcs(s1, s2, i, j - 1, dp));
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n][m];
        for (int[] row : dp) Arrays.fill(row, -1);

        int result = lcs(s1, s2, n - 1, m - 1, dp);
        System.out.println("LCS Length: " + result);
    }
}
```

### **Time Complexity**
- **O(N × M)** (since each `(i, j)` is computed once).
- **Space Complexity: O(N × M)** (for the memoization table).

---

## **Step 3: Tabulation (Bottom-Up DP)**
### **Idea**
- Instead of recursion, **build the solution iteratively**.
- Create a `dp` table where:
  - `dp[i][j]` stores **LCS length for substrings str1[0...i] and str2[0...j]**.

### **Steps**
1. **Base Case**: If `i == 0` or `j == 0`, `dp[i][j] = 0`.
2. **Filling the Table**:
  - If `str1[i-1] == str2[j-1]`,  
    \[
    dp[i][j] = 1 + dp[i-1][j-1]
    \]
  - Else,  
    \[
    dp[i][j] = \max(dp[i-1][j], dp[i][j-1])
    \]

### **Table for Example ("abcde", "ace")**
|   |  0  |  A  |  C  |  E  |
|---|-----|-----|-----|-----|
| 0 |  0  |  0  |  0  |  0  |
| A |  0  |  1  |  1  |  1  |
| B |  0  |  1  |  1  |  1  |
| C |  0  |  1  |  2  |  2  |
| D |  0  |  1  |  2  |  2  |
| E |  0  |  1  |  2  |  3  |

```java
public class LCSTabulation {
    public static int lcs(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
        System.out.println("LCS Length: " + lcs(s1, s2));
    }
}
```
### **Time Complexity**
- **O(N × M)** (since each cell is computed once).
- **Space Complexity: O(N × M)**.

---

## **Step 4: Space Optimization**
### **Optimization Idea**
- In **tabulation**, we **only use the previous row**.
- Instead of a 2D `dp` table, use **two 1D arrays**.

### **Steps**
1. Create two arrays, `prev` and `curr`.
2. Update `curr` using `prev`, then swap them.

### **Time Complexity**
- **O(N × M)** (same as tabulation).
- **Space Complexity: O(M)** (only storing one row).

```java
public class LCSSpaceOptimized {
    public static int lcs(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[] prev = new int[m + 1], curr = new int[m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            // Swap the current and previous row
            prev = curr.clone();
        }

        return prev[m];
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
        System.out.println("LCS Length: " + lcs(s1, s2));
    }
}
```

---

## **Final Comparison**
| Approach       | Time Complexity | Space Complexity | Notes |
|---------------|---------------|----------------|-------|
| Recursion      | O(2^N)        | O(N) (stack)  | Exponential, inefficient |
| Memoization   | O(N × M)       | O(N × M)      | Efficient, avoids recomputation |
| Tabulation    | O(N × M)       | O(N × M)      | Bottom-up approach |
| Space Optimized | O(N × M)     | O(M)          | Uses only two 1D arrays |

---









