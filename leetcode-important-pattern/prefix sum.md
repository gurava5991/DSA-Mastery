# Prefix Sum Pattern
Before diving into the prefix sum , some warm up problems for this patterns

1 . [Running Sum of 1d Array](https://leetcode.com/problems/running-sum-of-1d-array/description/)<br>
2 . [1732. Find the Highest Altitude](https://leetcode.com/problems/find-the-highest-altitude/description/)<br>
3 . [Find the Middle Index in Array](https://leetcode.com/problems/find-the-middle-index-in-array/description/)<br>

Given a sequence of integers a0, a1, . . . , aN−1, you will be given Q queries
of the form [L, R]. For each query, compute S(L, R) = aL+aL+1+· · ·+aR−1.

![Prefix Image](https://github.com/Badam4321/DSA-Mastery/blob/master/leetcode-important-pattern/images/prefix.png?raw=true)

## Prefix Sum Technique (Standard Approach)

The prefix sum technique is a powerful method used in algorithm design to efficiently calculate the sum of a subarray or subsequence of an array. This technique preprocesses the input array into a prefix sum array, allowing for quick queries of the sum of any subarray.

### Concept of Prefix Sum

1. **Definition**:
    - A prefix sum array is an auxiliary array that stores the cumulative sums of the elements of the original array up to each index. Each element in the prefix sum array at index `i` contains the sum of the elements from the start of the original array up to index `i`.

2. **Prefix Sum Array Construction**:
    - Given an array `A` of length `n`, the prefix sum array `P` is defined as:
        - \( P[i] = A[0] + A[1] + A[2] + ... + A[i] \) for \( i = 0 \) to \( n-1 \)
    - Therefore, the prefix sum array `P` has a length of `n` and is calculated as:
        - \( P[0] = A[0] \)
        - \( P[1] = A[0] + A[1] \)
        - \( P[2] = A[0] + A[1] + A[2] \)
        - ...
        - \( P[n-1] = A[0] + A[1] + ... + A[n-1] \)

### Example

Consider an array:

\[ A = [2, 4, 6, 8, 10] \]

The prefix sum array `P` will be:

- \( P[0] = 2 \)
- \( P[1] = 2 + 4 = 6 \)
- \( P[2] = 2 + 4 + 6 = 12 \)
- \( P[3] = 2 + 4 + 6 + 8 = 20 \)
- \( P[4] = 2 + 4 + 6 + 8 + 10 = 30 \)

So, the prefix sum array `P` is:

\[ P = [2, 6, 12, 20, 30] \]

### Querying Subarray Sums

Once you have the prefix sum array, you can easily calculate the sum of any subarray `A[l...r]` using the formula:

- **Subarray Sum**:
  \[
  \text{Sum}(A[l \text{ to } r]) = P[r] - P[l - 1]
  \]
    - If \( l = 0 \), then the sum is simply \( P[r] \).

### Example of Querying Subarray Sums

Using the prefix sum array \( P = [2, 6, 12, 20, 30] \):

- To find the sum of the subarray from index `1` to `3` (i.e., \( A[1] + A[2] + A[3] = 4 + 6 + 8 \)):
    - We compute:
      \[
      \text{Sum}(A[1 \text{ to } 3]) = P[3] - P[0] = 20 - 2 = 18
      \]
- To find the sum of the subarray from index `0` to `4` (i.e., all elements):
  \[
  \text{Sum}(A[0 \text{ to } 4]) = P[4] = 30
  \]

### Time Complexity

1. **Construction**: Building the prefix sum array takes **O(n)** time.
2. **Querying**: Each sum query takes **O(1)** time due to precomputation.


Leetcode Link : [303. Range Sum Query - Immutable](https://leetcode.com/problems/range-sum-query-immutable/description/)

Given an integer array nums, handle multiple queries of the following type:

Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
Implement the NumArray class:

* NumArray(int[] nums) Initializes the object with the integer array nums.
* int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).

```java
Example 1:

Input
["NumArray", "sumRange", "sumRange", "sumRange"]
[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
Output
[null, 1, -1, -3]

Explanation
NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
```

```java
class NumArray {
    private int ps[];
    public NumArray(int[] nums) {
        ps=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            ps[i]=nums[i];
            if(i>0)
                ps[i]+=ps[i-1];
        }

    }

    public int sumRange(int left, int right) {
        return ps[right]-(left==0?0:ps[left-1]);

    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
```
Time Complexity : 0(n + m)

space complexity : o(n)

## 2270. Number of Ways to Split Array
[2270. Number of Ways to Split Array](https://leetcode.com/problems/number-of-ways-to-split-array/description/)

You are given a 0-indexed integer array nums of length n.

nums contains a valid split at index i if the following are true:

The sum of the first i + 1 elements is greater than or equal to the sum of the last n - i - 1 elements.
There is at least one element to the right of i. That is, 0 <= i < n - 1.
Return the number of valid splits in nums.

```java
Example 1:

Input: nums = [10,4,-8,7]
Output: 2
Explanation: 
There are three ways of splitting nums into two non-empty parts:
- Split nums at index 0. Then, the first part is [10], and its sum is 10. The second part is [4,-8,7], and its sum is 3. Since 10 >= 3, i = 0 is a valid split.
- Split nums at index 1. Then, the first part is [10,4], and its sum is 14. The second part is [-8,7], and its sum is -1. Since 14 >= -1, i = 1 is a valid split.
- Split nums at index 2. Then, the first part is [10,4,-8], and its sum is 6. The second part is [7], and its sum is 7. Since 6 < 7, i = 2 is not a valid split.
Thus, the number of valid splits in nums is 2.
Example 2:

Input: nums = [2,3,1,0]
Output: 2
Explanation: 
There are two valid splits in nums:
- Split nums at index 1. Then, the first part is [2,3], and its sum is 5. The second part is [1,0], and its sum is 1. Since 5 >= 1, i = 1 is a valid split. 
- Split nums at index 2. Then, the first part is [2,3,1], and its sum is 6. The second part is [0], and its sum is 0. Since 6 >= 0, i = 2 is a valid split.

```

Example
For an array nums = [10, 4, 3, 2, 5]:

Total Sum Calculation:
10+4+3+2+5=24<br>
Iterate:<br>
* For i = 0:
  lsum = 10, rsum = 14 (not a valid split)
* For i = 1:
  lsum = 14, rsum = 10 (valid split)
* For i = 2:
  lsum = 17, rsum = 7 (valid split)
* For i = 3:
  lsum = 19, rsum = 5 (valid split)
* Count of Valid Splits: 3

```java
class Solution {
    public int waysToSplitArray(int[] nums) {
        long totalSum = 0;
        for(int val : nums){
            totalSum += val;
        }
        int validSplits = 0;
        long lsum = 0;
        for(int i = 0 ; i < nums.length - 1 ; i++){
            lsum += nums[i];
            long rsum = totalSum - lsum;
            if(lsum >= rsum)
                validSplits++;
        }
        return validSplits;
        
    }
}
```

Questions for above patterns
- [Product Of Array Except it self](https://leetcode.com/problems/product-of-array-except-self/)

## Number Of Sub Arrays With Odd Sum
- [number-of-sub-arrays-with-odd-sum](https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/)

```java
Given an array of integers arr, return the number of subarrays with an odd sum.

Since the answer can be very large, return it modulo 109 + 7.

 

Example 1:

Input: arr = [1,3,5]
Output: 4
Explanation: All subarrays are [[1],[1,3],[1,3,5],[3],[3,5],[5]]
All sub-arrays sum are [1,4,9,3,8,5].
Odd sums are [1,9,3,5] so the answer is 4.
Example 2:

Input: arr = [2,4,6]
Output: 0
Explanation: All subarrays are [[2],[2,4],[2,4,6],[4],[4,6],[6]]
All sub-arrays sum are [2,6,12,4,10,6].
All sub-arrays have even sum and the answer is 0.
Example 3:

Input: arr = [1,2,3,4,5,6,7]
Output: 16
```
**Key Observations:**<br>
Odd and Even Properties:
* Odd + Odd = Even
* Even + Even = Even
* Odd + Even = Odd

This property is crucial because it allows us to track the prefix sums of the array to determine whether a sub-array sum is odd.

**Intuition** <br>
1. As we iterate through the array, we can track the number of times the prefix sum has been odd or even so far.
2. If the current prefix sum is odd, the sub-array sum will be odd if the previous prefix sum was even (and vice versa)

**Algorithm Steps:**

**Initialization:**
* Start with odd_count = 0 and even_count = 1 (to handle the case when the prefix sum is odd initially).
* Maintain a running prefix sum (current_sum = 0).
* Initialize result = 0 to count the number of odd sub-arrays.

**Iterate Through the Array:**<br>
* For each element in the array:
* Add the element to current_sum.
* Check if current_sum is odd or even.
* If current_sum is odd, add even_count to result (because only those sub-arrays formed with a previous even prefix sum will result in an odd sum).
* If current_sum is even, add odd_count to result.
* Update odd_count or even_count based on the parity of current_sum.

```java
class Solution {
    public int numOfSubarrays(int[] arr) {
        int oddCount = 0, evenCount = 1, prefixSum = 0, res = 0;
        for (int x : arr) {
            prefixSum += x;
            if (prefixSum % 2 == 1) {
                res += evenCount;
                oddCount++;
            } else {
                res += oddCount;
                evenCount++;
            }
            res %= 1000000007;
        }
        return res;
    }
}
```

**Complexity Analysis:**

**Time Complexity**: O(n), where n is the length of the array, as we iterate through the array once.

**Space Complexity:** O(1), as we use constant extra space.

- [contiguous-array](https://leetcode.com/problems/contiguous-array/)

## Prefix Sum Technique + Hashing(Important for Interview)

### Subarray with 0 sum
Given an array of integers. Find if there is a subarray (of size at-least one) with 0 sum. You just need to return true/false depending upon whether there is a subarray present with 0-sum or not

```java
Examples:

Input: arr = {4,2,-3,1,6}
Output: true
Explanation: 2, -3, 1 is the subarray with sum 0.
Input: arr = {4,2,0,1,6}
Output: true
Explanation: 0 is one of the element in the array so there exist a subarray with sum 0.
Input : arr = {1 , 2 , -3}
Output : true
Explainination : the sum of of array is zero

```

A simple solution is to consider all subarrays one by one and check the sum of every subarray. We can run two loops: the outer loop picks a starting point i and the inner loop tries all subarrays starting from i (See this for implementation). The time complexity of this method is O(n2).

```java
class Solution {
    // Function to check whether there is a subarray present with 0-sum or not.
    static boolean findsum(int arr[]) {
        // Your code here
        for(int i = 0 ; i < arr.length ; i++){
            int curr_sum = 0;
            for(int j = i ; j < arr.length ; j++){
                curr_sum += arr[j];
                if(curr_sum == 0)
                    return true;
                
            }
        }
        return false;
        
    }
}
```
**Time Complexity** : since we are using two for loops so the tc : o(n2)
**Space Complexity** we are not taking any extra space so sc : o(1)

**Can we have better optimized approach ?**

We can also use hashing. The idea is to iterate through the array and for every element arr[i], calculate the sum of elements from 0 to i (this can simply be done as sum += arr[i]). If the current sum has been seen before, then there is a zero-sum array. Hashing is used to store the sum values so that we can quickly store sum and find out whether the current sum is seen before or not.

**Example :**

arr[] = {1, 4, -2, -2, 5, -4, 3}

If we consider all prefix sums, we can
notice that there is a subarray with 0
sum when :
1) Either a prefix sum repeats or
2) Or prefix sum becomes 0.
3) or current element val is zero

Prefix sums for above array are:
1, 5, 3, 1, 6, 2, 5

Since prefix sum 1 repeats, we have a subarray
with 0 sum.

```java
// A Java program to find 
// if there is a zero sum subarray
import java.util.HashSet;
import java.util.Set;

class ZeroSumSubarray 
{
    // Returns true if arr[] 
    // has a subarray with sero sum
    static Boolean subArrayExists(int arr[])
    {
        // Creates an empty hashset hs
        Set<Integer> hs = new HashSet<Integer>();

        // Initialize sum of elements
        int sum = 0;

        // Traverse through the given array
        for (int i = 0; i < arr.length; i++) 
        {
            // Add current element to sum
            sum += arr[i];

            // Return true in following cases
            // a) Current element is 0
            // b) sum of elements from 0 to i is 0
            // c) sum is already present in hash set
            if (arr[i] == 0 
                || sum == 0 
                || hs.contains(sum))
                return true;

            // Add sum to hash set
            hs.add(sum);
        }

        // We reach here only when there is
        // no subarray with 0 sum
        return false;
    }

    // Driver code
    public static void main(String arg[])
    {
        int arr[] = { -3, 2, 3, 1, 6 };
        if (subArrayExists(arr))
            System.out.println(
                "Found a subarray with 0 sum");
        else
            System.out.println("No Such Sub Array Exists!");
    }
}

```

## Subarray Sum Equals K
Leetcode Link : [link](https://leetcode.com/problems/subarray-sum-equals-k/description/)<br>
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

```java
Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
```
**Use of Prefix Sum:**
The prefix sum at index i is the sum of all elements from the start of the array up to i.
If we know the prefix sum up to index j (prefixSum[j]), and we can find a prefix sum at an earlier index i (prefixSum[i]) such that prefixSum[j] - prefixSum[i] = target, then the subarray arr[i+1..j] has a sum equal to target.

**Use of a HashMap:**

We maintain a HashMap sumCount where the key is a prefix sum and the value is how many times that prefix sum has occurred.
This helps us to quickly check if there is a previous prefix sum that we can subtract from the current prefix sum to get the target.

**Initial Setup:**

Initialize prefixSum = 0 to keep track of the running sum of the array elements.
Initialize count = 0 to keep track of how many valid subarrays are found.
Add an initial entry in the HashMap sumCount.put(0, 1) to account for cases where a subarray starts from index 0.

**Iterate Through the Array:**

**For each element in the array:**
1. Add the current element to the prefixSum.
2. Check if prefixSum - tar exists in the HashMap. If it does, add the frequency of that sum to count, as it represents valid subarrays ending at the current index.
3. Update the HashMap with the current prefixSum, incrementing its frequency.<br>


**Edge Cases:**<br>
Arrays with all positive, negative, or zero values. <br>
Handling cases where subarrays start from the first element (prefixSum - tar = 0).

Example Walkthrough:<br>
Example: arr = [1, 2, 3], target = 3<br>
prefixSum starts at 0.<br>
Iterate through the array:<br>
After first element (1): prefixSum = 1. No valid subarray yet. Add 1 to the HashMap.<br>
After second element (2): prefixSum = 3. prefixSum - tar = 0 is found in the HashMap (subarray [1, 2] is valid). Add 1 to count.<br>
After third element (3): prefixSum = 6. prefixSum - tar = 3 is found in the HashMap (subarray [3] is valid). Add 1 to count.<br>
Result: 2 valid subarrays: [1, 2] and [3].<br>
```java
class Solution {
    public int subarraySum(int[] arr, int tar) {
        // add your code here
        // Initialize prefix sum and map to store prefix sum frequencies
        int prefixSum = 0;
        int count = 0;

        // HashMap to store the frequency of prefix sums
        HashMap<Integer, Integer> sumCount = new HashMap<>();

        // Initially, we consider the prefix sum 0 has occurred once (to handle subarrays starting from index 0)
        sumCount.put(0, 1);

        // Traverse the array
        for (int num : arr) {
            // Update the current prefix sum
            prefixSum += num;

            // Check if there is a prefix sum that when subtracted from the current prefix sum gives tar
            if (sumCount.containsKey(prefixSum - tar)) {
                count += sumCount.get(prefixSum - tar);
            }

            // Update the map with the current prefix sum frequency
            sumCount.put(prefixSum, sumCount.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}
```
**Time Complexity** :O(n), where n is the length of the array. Each element is processed once.

**Space Complexity** : O(n), due to the space used by the HashMap to store prefix sums.

**Important Questions Using Above Pattern:**
- [Longest Sub-Array with Sum K](https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1)
- [Subarrays with equal 1s and 0s](https://www.geeksforgeeks.org/problems/count-subarrays-with-equal-number-of-1s-and-0s-1587115620/1)
- [Largest Subarray of 0s and 1s](https://www.geeksforgeeks.org/problems/largest-subarray-of-0s-and-1s/1)

## Prefix Sum with Division / Modulo

## 523. Continuous Subarray Sum
Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.

A good subarray is a subarray where:

its length is at least two, and
the sum of the elements of the subarray is a multiple of k.
Note that:

A subarray is a contiguous part of the array.
An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.

```java
Example 1:

Input: nums = [23,2,4,6,7], k = 6
Output: true
Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.
Example 2:

Input: nums = [23,2,6,4,7], k = 6
Output: true
Explanation: [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose elements sum up to 42.
42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.
Example 3:

Input: nums = [23,2,6,4,7], k = 13
Output: false
```
Intuition of this problem

The mathematical intuition behind this problem can be expressed as:
[a0 , a1 , a2 .... ai-1 , ai , ai+1 ,....aj, ..an-1]

Let P1 be the prefix sum at index i, and P2 be the prefix sum at index j (i < j).<br>
p1 = tsum([a0 , a1 , a2 .... ai-1])<br>
p2 = tsum([a0 , a1 , a2 .... ai-1 , ai , ai+1 ,....aj,])<br>
sum = p2 - p1

The sum of the subarray from index i+1 to j is:<br>
--> sum=P2−P1<br>
--> sum%k=(P2−P1)%k<br>
--> 0 = p2 % k - p1 % k<br>
--> p1 % k = p2 % k<br>
This means that if the remainders of the prefix sums P1 and P2 when divided by k are equal, then the subarray sum between those indices is divisible by k.

```java
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum % k;
            if (map.containsKey(rem)) {
                if (i - map.get(rem) >= 2) {
                    return true;
                }
            } else {
                map.put(rem, i);
            }
        }
        return false;
    }
}
```
**Time Complexity :** : We iterate over the array once, making this an O(n) operation, where n is the length of the array.

**Space Complexity :** : At each index we are inserting it prefix sum and index , so the space complexity is o(n)

## Subarray Sums Divisible by K

Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.

A subarray is a contiguous part of an array.

```java
Example 1:

Input: nums = [4,5,0,-2,-3,1], k = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by k = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
Example 2:

Input: nums = [5], k = 9
Output: 0
```

It is same approach of continuous sub array we should handle the negative prefix sum .<br>
To avoid negative remainders, after computing the remainder (rem = sum % k), we can adjust it as follows:<br>
rem=(rem+k)%k<br>
This ensures that the remainder is always non-negative, even if the prefix sum is negative.<br>

```java
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer> map=new  HashMap<>();
        map.put(0,1);
        int ps=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            ps=ps+nums[i];
            int diff=ps%k;
            if(diff<0)
                diff+=k;
            if(map.containsKey(diff))
                count+=map.get(diff);
            map.put(diff,map.getOrDefault(diff,0)+1);
        }
        return count;
        
    }
}
```
## Find the Divisibility Array of a String
You are given a 0-indexed string word of length n consisting of digits, and a positive integer m.

The divisibility array div of word is an integer array of length n such that:

div[i] = 1 if the numeric value of word[0,...,i] is divisible by m, or
div[i] = 0 otherwise.
Return the divisibility array of word.

```java
Example 1:

Input: word = "998244353", m = 3
Output: [1,1,0,0,0,1,1,0,0]
Explanation: There are only 4 prefixes that are divisible by 3: "9", "99", "998244", and "9982443".
Example 2:

Input: word = "1010", m = 10
Output: [0,1,0,1]
Explanation: There are only 2 prefixes that are divisible by 10: "10", and "1010".
```
P
i
​
=(P
i−1
​
×10+digit at index i)

P
i
​
%m=((P
i−1
​
%m)×10+digit at index i)%m

This can be simplified to:
curr_mod=(prev_mod×10+digit)%m

```java
class Solution {
    public int[] divisibilityArray(String word, int m) {
        int n = word.length();
        int[] res = new int[n];
        long prev_prefix_mod = 0;
        int i = 0;
        for(char ch : word.toCharArray()){
            int digit = ch - '0';
            long curr_pref_mod = (prev_prefix_mod * 10 + digit) % m;
            res[i++] = curr_pref_mod == 0 ? 1 : 0;
            prev_prefix_mod = curr_pref_mod;
        }
        return res;
    }
}

```
**Time Complexity:** As we are iterating entire string so the time complexity is O(n) where n is length of string

**Space Complexity:** here we are not using any extra space so the space complexity is 0(1)


Questions Bank

- [check-if-array-pairs-are-divisible-by-k](https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/)<br>
- [find-the-divisibility-array-of-a-string](https://leetcode.com/problems/find-the-divisibility-array-of-a-string/description/)
- [Count of Interesting Subarrays](https://leetcode.com/problems/count-of-interesting-subarrays/description/)

## Prefix Sum + XOR

-[Subarrays with XOR ‘K’](https://www.naukri.com/code360/problems/subarrays-with-xor-k_6826258)
```java
Problem statement
Given an array ‘A’ consisting of ‘N’ integers and an integer ‘B’, find the number of subarrays of array ‘A’ whose bitwise XOR( ⊕ ) of all elements is equal to ‘B’.

A subarray of an array is obtained by removing some(zero or more) elements from the front and back of the array.
Example:
Input: ‘N’ = 4 ‘B’ = 2
‘A’ = [1, 2, 3, 2]

Output: 3

Explanation: Subarrays have bitwise xor equal to ‘2’ are: [1, 2, 3, 2], [2], [2].
```
**Intuition**

The XOR operation has properties that make it well-suited for this problem:

**Property of XOR**: If a ^ b = c, then a = b ^ c.

This allows us to check for a subarray with XOR K using prefix XORs.

**Prefix XOR:** The XOR of elements from index 0 to i is called the prefix XOR.

The XOR of any subarray nums[l...r] can be calculated using:

prefixXOR[r] ^ prefixXOR[l-1] = K

Rearranging, we get:

prefixXOR[l-1] = prefixXOR[r] ^ K

```java
Approach

Prefix XOR Calculation:

Compute the XOR of elements as we iterate through the array.

Use a hash map to store the frequency of each prefix XOR encountered.

Subarray Count:

For each prefix XOR currXOR, check if currXOR ^ K exists in the hash map.

If it exists, it means there are subarrays ending at the current index whose XOR is K.

Update Hash Map:

Update the frequency of currXOR in the hash map.
```

```java
import java.util.HashMap;

class Solution {
    public int subarraysWithXorK(int[] nums, int K) {
        int currXOR = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Initialize the map with 0 XOR having frequency 1
        map.put(0, 1);
        
        for (int num : nums) {
            currXOR ^= num;

            // Check if currXOR ^ K exists in the map
            if (map.containsKey(currXOR ^ K)) {
                count += map.get(currXOR ^ K);
            }

            // Update the frequency of currXOR in the map
            map.put(currXOR, map.getOrDefault(currXOR, 0) + 1);
        }

        return count;
    }
}
```

**Time Complexity:** where  is the length of the array. We traverse the array once, and all hash map operations (insert, get) are  on average.

**Space Complexity:**
in the worst case, for storing prefix XOR values in the hash map.

-[XOR Queries of a Subarray](https://leetcode.com/problems/xor-queries-of-a-subarray/description/)
You are given an array arr of positive integers. You are also given the array queries where queries[i] = [lefti, righti].

For each query i compute the XOR of elements from lefti to righti (that is, arr[lefti] XOR arr[lefti + 1] XOR ... XOR arr[righti] ).

Return an array answer where answer[i] is the answer to the ith query.
```java
Example 1:

Input: arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
Output: [2,7,14,8] 
Explanation: 
The binary representation of the elements in the array are:
1 = 0001 
3 = 0011 
4 = 0100 
8 = 1000 
The XOR values for queries are:
[0,1] = 1 xor 3 = 2 
[1,2] = 3 xor 4 = 7 
[0,3] = 1 xor 3 xor 4 xor 8 = 14 
[3,3] = 8
Example 2:

Input: arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
Output: [8,0,4,4]
 

Constraints:

1 <= arr.length, queries.length <= 3 * 104
1 <= arr[i] <= 109
queries[i].length == 2
0 <= lefti <= righti < arr.length
```
Intuition for this Question
Lets  take arr[0..r] = xr;
Lets take arr[0..l-1] = x;
lets take arr[l..r] = k;
x ^ k = xr;
x ^ k ^ x = xr ^ x;
k = xr ^ x ;
so our formula is k = arr[0..r] ^ arr[0..l-1]

```java
class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] ans = new int[queries.length];
        for(int  i = 1 ; i < arr.length ; i++){
            arr[i] = arr[i - 1] ^ arr[i];
        } 
        for(int i = 0 ; i < queries.length ; i++){
            if(queries[i][0] == 0){
                ans[i] = arr[queries[i][1]];
            }
            else 
                ans[i] = arr[queries[i][1]] ^ arr[queries[i][0] - 1];
        }
        return ans;
    }
}
```

- [Find the Longest Substring Containing Vowels in Even Counts](https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/description/)

Given the string s, return the size of the longest substring containing each vowel an even number of times. That is, 'a', 'e', 'i', 'o', and 'u' must appear an even number of times.

```java
Example 1:

Input: s = "eleetminicoworoep"
Output: 13
Explanation: The longest substring is "leetminicowor" which contains two each of the vowels: e, i and o and zero of the vowels: a and u.
Example 2:

Input: s = "leetcodeisgreat"
Output: 5
Explanation: The longest substring is "leetc" which contains two e's.
Example 3:

Input: s = "bcbcbc"
Output: 6
Explanation: In this case, the given string "bcbcbc" is the longest because all vowels: a, e, i, o and u appear zero times.
```

**1 Bitmask Representation:**<br>
- 'a' -> bit 0
- 'e' -> bit 1
- 'i' -> bit 2
-  'o' -> bit 3
- 'u' -> bit 4
- The bitmask is used to represent the parity (even or odd count) of vowels encountered in the substring up to the current index.
- Initially, the bitmask mask is set to 0, meaning all vowel counts are even.<br>
  **2 Toggle Bits:** <br>
- As you traverse the string, whenever you encounter a vowel, you toggle its respective bit in the bitmask using the XOR (^) operation. This helps keep track of whether that vowel's count is odd or even.
- For example, if we encounter 'a', we toggle the 0th bit of the mask (mask ^= 1 << 0).

**HashMap (Prefix XOR Approach):**<br>
* Use a HashMap to store the first occurrence of each bitmask.
* If the current bitmask has been seen before, it means the substring between the two occurrences of this mask has even counts of all vowels (since toggling the bits twice leads back to the same state). In this case, calculate the length of the substring and update the maxLength.
* If the bitmask is new, store the current index for this bitmask in the map.

```java
class Solution {
    public int findTheLongestSubstring(String s) {
        Map<Integer , Integer> map = new HashMap<>();
        /*
        a -> bit 0
        e -> bit 1
        i -> bit 2
        o -> bit 3
        u -> bit 4
        */
        map.put(0 , -1);
        int mask = 0;
        int maxLength = 0;

        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);

            // Update the mask depending on the vowel
            switch (ch) {
                case 'a':
                    mask ^= (1 << 0);  // Toggle the bit for 'a'
                    break;
                case 'e':
                    mask ^= (1 << 1);  // Toggle the bit for 'e'
                    break;
                case 'i':
                    mask ^= (1 << 2);  // Toggle the bit for 'i'
                    break;
                case 'o':
                    mask ^= (1 << 3);  // Toggle the bit for 'o'
                    break;
                case 'u':
                    mask ^= (1 << 4);  // Toggle the bit for 'u'
                    break;
            }
            // Check if this mask has been seen before
            if(map.containsKey(mask)){
                maxLength = Math.max(maxLength , i - map.get(mask));
            }
            else{
                map.put(mask , i);
            }
        }
        return maxLength;
    }
}
```
**Time Complexity :** o(n) where n is length of string<br>
We traverse the string once, and for each character, we update the bitmask and check the map. Both updating the bitmask and performing lookups/inserts in the map take constant time, so the overall time complexity is linear in the size of the input string.

**Space Complexity** O(min(n, 32)) for the HashMap, where n is the string length (in the worst case, we could store up to 32 different bitmask states since we're only using 5 bits). Therefore, overall space complexity is O(n) considering the space required for the HashMap.

Question Bank
- [count-triplets-that-can-form-two-arrays-of-equal-xor](https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/)

# **Prefix Sum in a Matrix – A Complete Guide**

## **1. What is Prefix Sum in a Matrix?**
- **Prefix Sum in a Matrix** is a technique used to efficiently compute the sum of submatrices.
- Instead of calculating the sum from scratch every time, we preprocess the matrix into a **prefix sum matrix**, which allows **O(1) query time** for sum calculations.

---

## **2. How to Construct a Prefix Sum Matrix?**
Given an `n × m` matrix `arr[][]`, the **prefix sum matrix** `prefix[][]` is defined as:


### **Row-wise First, Then Column-wise Approach**
Instead of calculating the prefix sum in a single step, we can first compute the row-wise prefix sum and then the column-wise prefix sum.

### **Step 1: Compute Row-wise Prefix Sum**
```java
for (int i = 0; i < n; i++) {
    for (int j = 1; j < m; j++) {
        arr[i][j] += arr[i][j - 1];
    }
}
```

### **Step 2: Compute Column-wise Prefix Sum**
```java
for (int j = 0; j < m; j++) {
    for (int i = 1; i < n; i++) {
        arr[i][j] += arr[i - 1][j];
    }
}
```

### **Formula for Prefix Sum Calculation**

prefix[i][j] = arr[i][j] + prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1]

- **`arr[i][j]`** → Original element
- **`prefix[i-1][j]`** → Sum of elements above
- **`prefix[i][j-1]`** → Sum of elements to the left
- **`prefix[i-1][j-1]`** → Subtracting the extra part (double counted)

---
## **3. Code for Constructing Prefix Sum Matrix**
```java
public static int[][] computePrefixSum(int[][] arr, int n, int m) {
    int[][] prefix = new int[n][m];

    // Step 1: Compute Row-wise Prefix Sum
    for (int i = 0; i < n; i++) {
        for (int j = 1; j < m; j++) {
            arr[i][j] += arr[i][j - 1];
        }
    }

    // Step 2: Compute Column-wise Prefix Sum
    for (int j = 0; j < m; j++) {
        for (int i = 1; i < n; i++) {
            arr[i][j] += arr[i - 1][j];
        }
    }
    return arr;  // The original array now becomes the prefix sum matrix
}
```
---
## **4. Query Sum of Any Submatrix in O(1)**
To find the sum of a submatrix from `(r1, c1)` to `(r2, c2)`, we use:

\[
\text{Sum} = \text{prefix}[r2][c2] - \text{prefix}[r1-1][c2] - \text{prefix}[r2][c1-1] + \text{prefix}[r1-1][c1-1]
\]

### **Code for Finding Submatrix Sum**
```java
public static int findSubMatSum(int[][] prefix, int r1, int c1, int r2, int c2) {
    int sum = prefix[r2][c2];

    if (r1 > 0) sum -= prefix[r1 - 1][c2];  // Remove upper part
    if (c1 > 0) sum -= prefix[r2][c1 - 1];  // Remove left part
    if (r1 > 0 && c1 > 0) sum += prefix[r1 - 1][c1 - 1]; // Add back the overlapping region

    return sum;
}
```
---
## **5. Example Problem: Find Maximum Sum Submatrix**
### **Brute Force Approach (`O(n^4)`)**
```java
public static int maxSumRectangle(int[][] arr, int n, int m) {
    int[][] prefix = computePrefixSum(arr, n, m);
    int maxSum = Integer.MIN_VALUE;

    for (int r1 = 0; r1 < n; r1++) {
        for (int c1 = 0; c1 < m; c1++) {
            for (int r2 = r1; r2 < n; r2++) {
                for (int c2 = c1; c2 < m; c2++) {
                    maxSum = Math.max(maxSum, findSubMatSum(prefix, r1, c1, r2, c2));
                }
            }
        }
    }
    return maxSum;
}
```
---
## **6. Optimized Approach Using Kadane’s Algorithm (`O(n^3)`)**
💡 **Idea:**
1. Fix **two row indices** (`r1` to `r2`).
2. Use a **temporary 1D array (`temp[]`)** to store column-wise sums.
3. Apply **Kadane’s Algorithm** on `temp[]` to get the max sum subarray.

```java
public static int maxSumRectangle(int[][] arr, int n, int m) {
    int maxSum = Integer.MIN_VALUE;

    for (int r1 = 0; r1 < n; r1++) {
        int[] temp = new int[m];  // Temporary array for column-wise sum

        for (int r2 = r1; r2 < n; r2++) {
            // Compute sum of elements between row r1 to r2
            for (int col = 0; col < m; col++) {
                temp[col] += arr[r2][col];
            }
            
            // Apply Kadane’s Algorithm
            maxSum = Math.max(maxSum, kadane(temp));
        }
    }
    return maxSum;
}

private static int kadane(int[] arr) {
    int maxSum = Integer.MIN_VALUE, currSum = 0;
    for (int num : arr) {
        currSum += num;
        maxSum = Math.max(maxSum, currSum);
        if (currSum < 0) currSum = 0;
    }
    return maxSum;
}
```
---
## **7. Other Problems Using Prefix Sum on a Matrix**
- Count the number of submatrices that sum to a target
- Largest square submatrix with sum ≤ `k`
- Number of submatrices with an even sum

---



