# Sliding Window Pattern 

## Sliding Window Technique: An Overview
The **sliding window technique** is a popular and efficient method used to solve problems that involve processing contiguous subarrays (or sublists) of an array or list. Instead of recalculating values from scratch for each subarray, sliding window methods allow us to efficiently process and analyze data by "sliding" a window across the array, making adjustments incrementally as the window moves.
### When to Use the Sliding Window Technique
Sliding window techniques are ideal in problems where:

* You need to process or analyze contiguous subarrays (sublists) of the input.
* The goal is to optimize time complexity, especially when a brute-force solution would be inefficient.
* The problem involves searching, counting, or calculating something based on the elements within a certain range (window) of the array or list.
<br/>

## Types of Sliding Window Techniques
### 1. Static  Window(Fixed Sliding Window Technique):
In the fixed sliding window technique, the size of the window remains constant as it moves across the array. This means that at each step, we include a new element in the window and remove the oldest element, while maintaining and updating the relevant metrics or properties (like sum, max, etc.).
**When to Use:**
* The problem specifies a fixed window size (e.g., "find the maximum sum of a subarray of size k").
* The window size doesn’t need to change based on the data itself.

### Find Averages of Sub Arrays
**Leetcode Link :** [Find Averages of Sub Arrays](https://leetcode.com/problems/maximum-average-subarray-i/)

You are given an integer array nums consisting of n elements, and an integer k.<br>
Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.

```
Example 1:

Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
Example 2:

Input: nums = [5], k = 1
Output: 5.00000
```
A brute-force algorithm will calculate the sum of every 5-element contiguous subarray of the given array and divide the sum by 5 to find the average.

```java
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Double> findAvgOfSubarrays(int[] arr, int K) {
        List<Double> results = new ArrayList<>();
        
        for (int i = 0; i <= arr.length - K; i++) {
            double sum = 0;
            
            for (int j = i; j < i + K; j++) {
                sum += arr[j];
            }
            
            results.add(sum / K);
        }
        
        return results;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 6, -1, 4, 1, 8, 2};
        int K = 5;
        
        List<Double> result = findAvgOfSubarrays(arr, K);
        System.out.println(result);
    }
}
```
**Explanation of Time Complexity (TC):**
**Outer Loop:** The outer loop runs from i = 0 to i = arr.length - K. So it iterates (arr.length - K + 1) times.
Inner Loop: For each iteration of the outer loop, the inner loop runs exactly K times to calculate the sum of the elements in the current subarray.
Thus, the total number of iterations is proportional to:

Outer loop: (arr.length - K + 1) ≈ n
Inner loop: K operations for each outer loop iteration
Hence, the time complexity is O(n * K)

**Explanation of Space Complexity (SC):**
Auxiliary Space for results list: We store the averages of (arr.length - K + 1) subarrays in the results list. Thus, the space needed for this is proportional to O(n - K + 1), which simplifies to O(n).

**Can we find a better solution? Do you see any inefficiency in the above approach?**

Optimized Solution Using Sliding Window:
In the sliding window approach, we can maintain a running sum of the subarray of size K. When the window moves forward by one position, we:

Subtract the element that goes out of the window (left side).
Add the element that enters the window (right side).
This way, the sum is updated in constant time, making the solution more efficient.

```java
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Double> findAveragesOfSubarrays(int[] arr, int k) {
        List<Double> results = new ArrayList<>();
        double windowSum = 0;
        int windowStart = 0;
        
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            // Add the next element to the window
            windowSum += arr[windowEnd];
            
            // Slide the window once we've hit the window size `k`
            if (windowEnd >= k - 1) {
                // Calculate and store the average of the current window
                results.add(windowSum / k);
                
                // Subtract the element that is going out of the window
                windowSum -= arr[windowStart];
                
                // Slide the window forward
                windowStart++;
            }
        }
        
        return results;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 6, -1, 4, 1, 8, 2};
        int k = 5;
        
        List<Double> result = findAveragesOfSubarrays(arr, k);
        System.out.println(result);
    }
}
```
This optimized sliding window approach efficiently calculates the averages in O(n) **time complexity**, where n is the length of the input array, and has a **space complexity** of O(n) due to storing the result list.

## Maximum Sum Subarray of Size K (easy)
**Leetcode Link :** [Maximum Sum Subarray of Size K](https://leetcode.com/problems/minimum-size-subarray-sum/)

Given an array of positive numbers and a positive number S, find the length of the smallest contiguous subarray whose sum is greater than or equal to S.
Return 0 if no such subarray exist
```dtd
Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
```
**Sliding Window Approach**<br>
If you observe closely, you will realize that to calculate the sum of a contiguous subarray, we can utilize the sum of the previous subarray. For this, consider each subarray as a Sliding Window of size K. To calculate the sum of the next subarray, we need to slide the window ahead by one element. So to slide the window forward and calculate the sum of the new position of the sliding window, we need to do two things:

* Subtract the element going out of the sliding window, i.e., subtract the first element of the window.
* Add the new element getting included in the sliding window, i.e., the element coming right after the end of the window.
* This approach will save us from re-calculating the sum of the overlapping part of the sliding window.

```java
public class Main {
    public static int maxSubarrayOfSizeK(int[] arr, int k) {
        int maxSum = 0;
        int windowSum = 0;
        int windowStart = 0;
        
        // Loop through the array
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            // Add the next element to the window sum
            windowSum += arr[windowEnd];
            
            // Slide the window when we hit the required window size 'k'
            if (windowEnd >= k - 1) {
                // Calculate the maximum sum of the current window
                maxSum = Math.max(maxSum, windowSum);
                
                // Subtract the element that's sliding out of the window
                windowSum -= arr[windowStart];
                
                // Move the window forward
                windowStart++;
            }
        }
        
        return maxSum;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(maxSubarrayOfSizeK(new int[]{2, 1, 5, 1, 3, 2}, 3)); // Output: 9
        System.out.println(maxSubarrayOfSizeK(new int[]{2, 3, 4, 1, 5}, 2));   // Output: 7
    }
}

```
* The time complexity of the above algorithm will be O(N)
* The space complexity of the above algorithm will be O(1)

### 438. Find All Anagrams in a String<br>
Leetcode Link : [Find All Anagrams in a String](https://leetcode.com/problems/find-all-anagrams-in-a-string/description/)<br>
Given two strings s and p, return an array of all the start indices of p's
anagrams
in s. You may return the answer in any order.

```dtd
Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
```
**Sliding window Approach**
* Frequency Count for p: We create a frequency map for the characters in p.
* Sliding Window on s: As we iterate over s, we maintain a window of size equal to the length of p and update a frequency map for the characters in the current window.
* Check for Anagram: After every window shift, we compare the frequency map of the current window with the frequency map of p. If they match, we record the starting index of the current window.
* Efficiency: Instead of recalculating the frequency map from scratch for each window, we update it incrementally by adding the new character entering the window and removing the one that's sliding out.
```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result; // Edge case if s is smaller than p
        }

        // Frequency map for characters in p
        Map<Character, Integer> pCount = new HashMap<>();
        for (char c : p.toCharArray()) {
            pCount.put(c, pCount.getOrDefault(c, 0) + 1);
        }

        // Sliding window variables
        Map<Character, Integer> sCount = new HashMap<>();
        int windowSize = p.length();
        int matches = 0; // to track when all characters match

        // Traverse the string s with sliding window
        for (int i = 0; i < s.length(); i++) {
            // Add the current character to the window
            char endChar = s.charAt(i);
            sCount.put(endChar, sCount.getOrDefault(endChar, 0) + 1);

            // If we have passed the first window, slide the window
            if (i >= windowSize) {
                char startChar = s.charAt(i - windowSize);
                if (sCount.get(startChar) == 1) {
                    sCount.remove(startChar);
                } else {
                    sCount.put(startChar, sCount.get(startChar) - 1);
                }
            }

            // Check if the current window matches the frequency of p
            if (sCount.equals(pCount)) {
                result.add(i - windowSize + 1); // Add the start index of the anagram
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findAnagrams("cbaebabacd", "abc")); // Output: [0, 6]
        System.out.println(sol.findAnagrams("abab", "ab")); // Output: [0, 1, 2]
    }
}

```
**Time Complexity:**
O(n): where n is the length of string s. The sliding window ensures we only pass through s once, and each update (adding/removing characters) is O(1) due to hash map operations.<br>
**Space Complexity:**
O(k): where k is the number of unique characters in p and s, since we are using hash maps to track frequencies.

### Alternative approach 
```java
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        int[] pHash = new int[26];  // Frequency array for string `p`
        int[] sHash = new int[26];  // Frequency array for current window in `s`

        // Fill the pHash and initial window in sHash
        for (int i = 0; i < p.length(); i++) {
            pHash[p.charAt(i) - 'a']++;
            sHash[s.charAt(i) - 'a']++;
        }

        // Compare the first window
        if (match(pHash, sHash)) {
            result.add(0);
        }

        // Sliding the window across string `s`
        int left = 0;
        for (int right = p.length(); right < s.length(); right++) {
            // Include the next character in the window
            sHash[s.charAt(right) - 'a']++;

            // Exclude the character going out of the window
            sHash[s.charAt(left) - 'a']--;
            left++;

            // Compare window's frequency map with p's map
            if (match(pHash, sHash)) {
                result.add(left);  // `left` is the starting index of the current window
            }
        }

        return result;
    }

    // Helper function to check if two frequency arrays are identical
    private boolean match(int[] pHash, int[] sHash) {
        for (int i = 0; i < 26; i++) {
            if (pHash[i] != sHash[i]) return false;
        }
        return true;
    }
}
```
**Time Complexity:**
O(n): where n is the length of string s. The sliding window ensures we only pass through s once, and each update (adding/removing characters) is O(1) due to hash map operations.<br>
**Space Complexity:**
O(k): where k is the number of unique characters in p and s, since we are using hash maps to track frequencies.


Question Bank
A slight variation using the template for Sliding Window that can be used in the following problems that follow a similar pattern:

1. [30. Substring with Concatenation of All Words](https://leetcode.com/problems/substring-with-concatenation-of-all-words/)
2. [187. Repeated DNA Sequences](https://leetcode.com/problems/repeated-dna-sequences/)
3. [438. Find All Anagrams in a String](https://leetcode.com/problems/find-all-anagrams-in-a-string/)
4. [567. Permutation in String](https://leetcode.com/problems/permutation-in-string/)
5. [643. Maximum Average Subarray I](https://leetcode.com/problems/maximum-average-subarray-i/)
6. [995. Minimum Number of K Consecutive Bit Flips](https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/)
7. [1100. Find K-Length Substrings With No Repeated Characters](https://leetcode.com/problems/find-k-length-substrings-with-no-repeated-characters/)
8. [1151. Minimum Swaps to Group All 1's Together](https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together/)
9. [1176. Diet Plan Performance](https://leetcode.com/problems/diet-plan-performance/)
10. [1343. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold](https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/)
11. [1423. Maximum Points You Can Obtain from Cards](https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/)
12. [1456. Maximum Number of Vowels in a Substring of Given Length](https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/)
13. [1652. Defuse the Bomb](https://leetcode.com/problems/defuse-the-bomb/)
14. [1876. Substrings of Size Three with Distinct Characters](https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/)
15. [2090. K Radius Subarray Averages](https://leetcode.com/problems/k-radius-subarray-averages/)
16. [2134. Minimum Swaps to Group All 1's Together II](https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together-ii/)
17. [2269. Find the K-Beauty of a Number](https://leetcode.com/problems/find-the-k-beauty-of-a-number/)
18. [2379. Minimum Recolors to Get K Consecutive Black Blocks](https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/)

### 2. Dynamic Sliding Window (Variable-Sized Window)
In the **dynamic sliding window technique**, the window size is flexible and can grow or shrink based on the conditions specified by the problem. This is especially useful when you're trying to find a subarray that satisfies a certain condition, but you don’t know its size in advance. the window size is flexible and can grow or shrink based on the conditions specified by the problem. This is especially useful when you're trying to find a subarray that satisfies a certain condition, but you don’t know its size in advance.

**When to Use:**
* When you need to find the smallest or largest subarray that meets a specific condition.
* The window size isn’t fixed and can expand or contract depending on the data as you process it.

## 209. Minimum Size Subarray Sum
Leetcode Linke : [209. Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/description/)

Given an array of positive integers nums and a positive integer target, return the minimal length of a
subarray
whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

```dtd
Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
 
```
There is one difference though: in this problem, the sliding window size is not fixed. Here is how we will solve this problem:

1. First, we will add-up elements from the beginning of the array until their sum becomes greater than or equal to S.
2. These elements will constitute our sliding window. We are asked to find the smallest such window having a sum greater than or equal to S. We will remember the length of this window as the smallest window so far.
3. After this, we will keep adding one element in the sliding window (i.e., slide the window ahead) in a stepwise fashion.
4. In each step, we will also try to shrink the window from the beginning. We will shrink the window until the windows sum is smaller than S again. This is needed as we intend to find the smallest window. This shrinking will also happen in multiple steps; in each step, we will do two things:
5. Check if the current window length is the smallest so far, and if so, remember its length.
6. Subtract the first element of the window from the running sum to shrink the sliding window.

```java
public class SmallestSubarrayWithGivenSum {
    
    public static int findMinSubArray(int s, int[] arr) {
        int windowSum = 0;
        int minLength = Integer.MAX_VALUE;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            // Add the next element to the window sum
            windowSum += arr[windowEnd];

            // Shrink the window as small as possible while the sum is greater than or equal to 's'
            while (windowSum >= s) {
                // Update the minimum length if we found a smaller window
                minLength = Math.min(minLength, windowEnd - windowStart + 1);

                // Subtract the element going out and slide the window forward
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }

        // If no such subarray exists, return 0
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        System.out.println(findMinSubArray(7, new int[] {2, 1, 5, 2, 3, 2})); // Output: 2
        System.out.println(findMinSubArray(7, new int[] {2, 1, 5, 2, 8}));    // Output: 1
        System.out.println(findMinSubArray(8, new int[] {3, 4, 1, 1, 6}));    // Output: 3
    }
}

```
The **time complexity** of this solution is O(n), where n is the number of elements in the array. This is because each element is added and removed from the window at most once.<br>
The **space complexity** is O(1) since we only use a few variables (constant space) to store the running sum, window boundaries, and minimum length.

## Longest K unique characters substring
GFG Link : [Longest K unique characters substring](https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1)<br>
Given a string you need to print the size of the longest possible substring that has exactly K unique characters. If there is no possible substring then print -1.

```java
Input:S = "aabacbebebe", K = 3
Output:7
Explanation : "cbebebe" is the longest substring with 3 distinct characters.

Input:
S = "aaaa", K = 2
Output: -1
Explanation:
There's no substring with 2 distinct characters.
```
1 . Initialize Pointers & Data Structures:

* Two pointers windowStart and windowEnd are used to define the boundaries of the sliding window.
* Use a HashMap charFrequency to track the frequency of each character in the window.<br>

2 . Expand the Window:

* Traverse the string by moving windowEnd. For every character endChar in the string, increment its count in charFrequency.<br>

3 . Shrink the Window if Necessary:

* Once the size of the map exceeds k, it means there are more than k distinct characters in the window. So, shrink the window by moving windowStart to the right and adjust the character frequency accordingly.
* If the count of any character drops to 0, remove it from the map.<br>

4 . Track the Maximum Length:

* If the number of distinct characters in the current window is exactly k, calculate the window length and update the maxLength variable.<br>

5 . Edge Case:

* If no valid substring with exactly k distinct characters exists, return -1.

```java
class Solution {
    public int longestkSubstr(String str, int k) {
        // code here
        if (str == null || str.length() == 0 || k == 0) {
            return 0;
        }

        int windowStart = 0;
        int maxLength = Integer.MIN_VALUE;
        Map<Character, Integer> charFrequency = new HashMap<>();

        // Extend the window [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char endChar = str.charAt(windowEnd);
            charFrequency.put(endChar, charFrequency.getOrDefault(endChar, 0) + 1);

            // Shrink the sliding window, until we are left with 'k' distinct characters
            while (charFrequency.size() > k) {
                char startChar = str.charAt(windowStart);
                charFrequency.put(startChar, charFrequency.get(startChar) - 1);
                
                // If the count of a character becomes 0, remove it from the map
                if (charFrequency.get(startChar) == 0) {
                    charFrequency.remove(startChar);
                }
                windowStart++;
            }

            // Update the maximum length of the substring
            if(charFrequency.size() == k)
                maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength == Integer.MIN_VALUE ? -1 : maxLength;
    }
    public static void main(String[] args) {
        System.out.println(longestkSubstr("aabacbebebe",3)); 
        System.out.println(longestkSubstr("aaaa" , 2));    
        System.out.println(longestkSubstr("araaci" , 2));//4    
    }
    
}
```
**Time and Space Complexity:**<br>
**Time Complexity:** O(n), where n is the length of the string. Each character is processed exactly twice — once when added to the window and once when removed from the window.<br>
**Space Complexity:** O(k), for storing at most k distinct characters in the HashMap.

## 3. Longest Substring Without Repeating Characters
Given a string s, find the length of the longest substring without repeating characters.<br>
 **a substring is a contiguous sequence of characters within a string**

```java
Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
```
**sliding window Approach**
* We maintain a window between windowStart and windowEnd which contains only unique characters. As windowEnd expands, we add the character at windowEnd to the window.
* If a character is repeated (i.e., already exists in the window), we update the windowStart pointer to the index after the previous occurrence of the repeated character. This ensures that the window only contains unique characters.
* To find the previous occurrence of the character, we use a HashMap (charFrequency) that stores each character and its most recent index.
* For every iteration, we calculate the length of the current window (windowEnd - windowStart + 1) and update maxLength if this length is greater than the current maximum.
* If the input string is empty, the function will return 0.

```java
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int windowStart = 0;
        int maxLength = 0;  // Using 0 to handle empty string scenario
        Map<Character, Integer> charFrequency = new HashMap<>();

        // Extend the window [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char endChar = s.charAt(windowEnd);

            // If the character is already in the map, shrink the window
            if (charFrequency.containsKey(endChar)) {
                // Move the windowStart to the next index after the previous occurrence
                windowStart = Math.max(windowStart, charFrequency.get(endChar) + 1);
            }

            // Insert/update the character's latest index in the map
            charFrequency.put(endChar, windowEnd);

            // Calculate the maximum length of the substring
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String test1 = "abcabcbb";
        System.out.println("Length of longest substring without repeating characters (Test 1): " 
                            + solution.lengthOfLongestSubstring(test1));  // Output: 3 ("abc")

        // Test case 2
        String test2 = "bbbbb";
        System.out.println("Length of longest substring without repeating characters (Test 2): " 
                            + solution.lengthOfLongestSubstring(test2));  // Output: 1 ("b")
    }
}

```
**Time Complexity:**
The algorithm runs in O(n) time, where n is the length of the string. Each character is processed at most twice, once when it is added to the window and once when it is removed.

**Space Complexity:**
O(k) where k is the number of distinct characters in the string, as we store them in the HashMap.


## 1004. Max Consecutive Ones III
Leetcode Link z: [1004. Max Consecutive Ones III](https://leetcode.com/problems/max-consecutive-ones-iii/description/)
### **Intuition**
The problem **"Longest Subarray of 1s After at Most K Flips"** can be solved using a **Sliding Window (Two Pointer) approach**.

1. **Expanding the Window:**
 - We iterate through the array with a `windowEnd` pointer.
 - If we encounter a `0`, we **increase** the `zero_flipped` count.

2. **Shrinking the Window:**
 - If `zero_flipped > k`, it means we have flipped more than allowed `k` zeros.
 - To **balance it**, we start shrinking the window from `windowStart` until `zero_flipped` becomes ≤ `k`.

3. **Calculating the Maximum Length:**
 - After adjusting the window, we update `maximum_len` with the current window size.

---

### **Time and Space Complexity**
#### **Time Complexity: `O(N)`**
- We traverse the `nums` array exactly **once** with `windowEnd`.
- `windowStart` also moves from left to right but only once.
- **Total iterations:** Each element is processed **at most twice** (once when expanding, once when shrinking).
- Hence, the complexity is **O(N)**.

#### **Space Complexity: `O(1)`**
- We use only a few integer variables (`windowStart`, `zero_flipped`, `maximum_len`).
- No extra space proportional to the input size.
- **Space complexity is O(1).**

---

### **Fixed Code (Correcting `Integer.MIN_VALUE`)**
```java
class Solution {
    public int longestOnes(int[] nums, int k) {
        int windowStart = 0, maximum_len = 0;
        int zero_flipped = 0;
        
        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            if (nums[windowEnd] == 0) {
                zero_flipped++;
            }

            while (zero_flipped > k) {  // Shrinking the window if flips exceed k
                if (nums[windowStart] == 0) {
                    zero_flipped--;
                }
                windowStart++;
            }

            // Update the maximum length of subarray found
            maximum_len = Math.max(maximum_len, windowEnd - windowStart + 1);
        }
        
        return maximum_len;
    }
}
```
---

### **Example Walkthrough**
#### **Example 1:**
```java
Input: nums = [1,1,0,0,1,1,1,0,1,1,0,1], k = 2
Output: 8
```
**Step-by-step execution:**
```
Window expands:  [1,1,0,0,1,1,1,0]   →  Flipped 2 zeros → max_len = 8
```

#### **Example 2:**
```java
Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0], k = 3
Output: 10
```
**Step-by-step execution:**
```
Window expands:  [1,1,0,0,1,1,1,0,1,1]  →  Flipped 3 zeros → max_len = 10
```

---
### **Problem: Longest Repeating Character Replacement**
You are given a string `s` and an integer `k`. You can replace at most `k` characters in `s` to make the longest contiguous substring with repeating characters.

#### **Example**
```java
Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the 'B' at index 2 with 'A' to get "AAAABBA". The longest substring of repeating characters is "AAAA".
```

---

## **Intuition**
We need to find the longest contiguous substring where we can change at most `k` characters to make all characters the same.

### **Sliding Window Approach**
1. We use a **two-pointer sliding window** with `windowStart` and `windowEnd` to track a valid substring.
2. We maintain a **frequency map** to store character counts in the current window.
3. The **main condition** for a valid window:  
   \[
   \text{window size} - \text{max frequency character count} \leq k
   \]
 - If this condition holds, we can make the entire window uniform by changing at most `k` characters.
 - If not, we **shrink** the window from `windowStart` to maintain validity.
4. The **goal** is to maximize the window size.

---

## **Time and Space Complexity**
- **Time Complexity:** `O(N)`
 - Each character is processed at most **twice** (once when expanding and once when shrinking).
- **Space Complexity:** `O(1)`
 - Uses a fixed-sized frequency array of length `26` (constant).

---

## **Java Implementation**
```java
class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];  // Frequency map for characters
        int windowStart = 0, maxCount = 0, maxLength = 0;
        
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char endChar = s.charAt(windowEnd);
            freq[endChar - 'A']++;
            maxCount = Math.max(maxCount, freq[endChar - 'A']);
            
            // If window size - max frequency char > k, shrink the window
            while ((windowEnd - windowStart + 1) - maxCount > k) {
                char startChar = s.charAt(windowStart);
                freq[startChar - 'A']--;
                windowStart++;
            }
            
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        
        return maxLength;
    }
}
```

---

## **Dry Run Example**
### **Input:** `"AABABBA"`, `k = 1`
```
Window expands: "AAB" (valid, max_len = 3)
Window expands: "AABA" (valid, max_len = 4)
Window expands: "AABAB" (valid, max_len = 5)
Window shrinks: "ABAB" (still valid, max_len = 4)
Final max_len = 4
```

---

### **Intuition Behind the Approach**
The problem requires us to count **all vowel substrings** in a given string `word`. A **vowel substring** is a contiguous substring that contains **only vowels (`a, e, i, o, u`)** and includes **all five vowels at least once**.

To solve this efficiently, we use the **sliding window technique with a HashMap**.

#### **Observations**
1. **If a character is not a vowel**, then it **cannot be part of any valid substring**. Thus, we must reset the window when encountering a non-vowel.
2. **Tracking the last occurrence of each vowel** helps in quickly determining how far back a substring can be valid.
3. If we have **all five vowels in the current window**, the number of valid substrings that end at index `i` is determined by the **earliest occurrence** of any vowel in the window.

---

### **Approach**
1. **Use a HashMap (`map`)** to store the **last occurrence index** of each vowel.
2. **Iterate through the string (`i` loop)**:
    - If `word[i]` is a vowel, store its **index** in the HashMap.
    - If it’s a consonant, reset the HashMap and move `j` (start of window).
3. **Once all five vowels are found**, the number of valid substrings ending at `i` is determined by the smallest index in `map`.
    - The number of valid substrings is `min(map.values()) - j`.

---

### **Code Implementation (Without Streams)**
```java
import java.util.*;

class Solution {
    public int countVowelSubstrings(String word) {
        int ans = 0;
        String vowels = "aeiou";
        Map<Integer, Integer> map = new HashMap<>();
        
        int j = -1; // The last position where a consonant was found

        for (int i = 0; i < word.length(); i++) {
            int found = vowels.indexOf(word.charAt(i));
            
            if (found == -1) { 
                // Reset everything if a consonant is found
                map.clear();
                j = i;  
            } else {
                // Store the latest index of this vowel
                map.put(found, i);
            }

            // If all 5 vowels are present at least once, calculate valid substrings
            if (map.size() == 5) {
                int minIndex = Integer.MAX_VALUE;
                for (int index : map.values()) {
                    minIndex = Math.min(minIndex, index);
                }
                ans += (minIndex - j);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.countVowelSubstrings("aeiouu")); // Output: 7
        System.out.println(sol.countVowelSubstrings("unicornarihan")); // Output: 2
    }
}
```

---

### **Dry Run Example**
#### **Example Input:** `"aeiouu"`
```
word = "aeiouu"
```
| `i` | `word[i]` | `map` (last seen indexes) | `j` (last consonant) | `min(map.values())` | `ans` (total)  |
|----|-----------|-------------------------|-------------------|-----------------|----------------|
| 0  | `a`       | `{0}`                    | `-1`              | —               | 0              |
| 1  | `e`       | `{0, 1}`                  | `-1`              | —               | 0              |
| 2  | `i`       | `{0, 1, 2}`               | `-1`              | —               | 0              |
| 3  | `o`       | `{0, 1, 2, 3}`            | `-1`              | —               | 0              |
| 4  | `u`       | `{0, 1, 2, 3, 4}`         | `-1`              | `0`             | `0 - (-1) = 1` |
| 5  | `u`       | `{0, 1, 2, 3, 5}`         | `-1`              | `0`             | `0 - (-1) = 1` |

**Final Output:** `2`

---

### **Complexity Analysis**
- **Time Complexity:** `O(N)`
    - We iterate through the string **once** (`O(N)`).
    - The HashMap operations (`put` and `get`) run in **O(1)** time.
    - Finding the **minimum value** in the HashMap takes **O(5) = O(1)** since it only contains five entries.
    - Overall, the complexity is **O(N)**.

- **Space Complexity:** `O(1)`
    - We use a HashMap of **at most 5 elements (for vowels)**, which is **constant space**.

---

### **Problem Statement:**
**"Count Substrings With At Least K-Frequency Characters"**  
Given a string `s`, return the number of substrings where at least one character appears **at least `K` times**.

---

### **Intuition Behind the Approach:**
We use a **sliding window** approach to efficiently count substrings that satisfy the condition.

1. **Expand the window (`windowEnd`)** by adding characters and updating their frequencies in a HashMap.
2. **Shrink the window (`windowStart`)** when any character’s frequency becomes at least `K`.
    - When `charFreq[ch] >= k`, all substrings ending at `windowEnd` and starting from `windowStart` contribute to the count.
    - We add `(n - windowEnd)` to the count because all substrings `s[windowStart : windowEnd]`, `s[windowStart + 1 : windowEnd]`, ..., `s[windowEnd : windowEnd]` are valid.
3. **Remove characters from the left (`windowStart`)** until the condition breaks, ensuring we count all possible substrings efficiently.

---
**Java Implementation**

```java
class Solution {
    public int numberOfSubstrings(String s, int k) {
        if(s == null)
            return 0;
        int n = s.length();
        Map<Character , Integer> charFreq = new HashMap<>();
        int windowStart = 0;
        int count = 0;
        for(int windowEnd = 0 ; windowEnd < s.length() ; windowEnd++){
            char ch = s.charAt(windowEnd);
            charFreq.put(ch , charFreq.getOrDefault(ch , 0) + 1);
            while(charFreq.getOrDefault(ch , 0) >= k){
                count += n - windowEnd;
                char leftChar = s.charAt(windowStart);
                charFreq.put(leftChar , charFreq.get(leftChar) - 1);
                if(charFreq.get(leftChar) == 0)
                    charFreq.remove(leftChar);
                windowStart++;

            }
        }
        return count;

        
    }
}
```

### **Dry Run Example**
Let’s consider the input:  
`s = "aabcb"` and `k = 2`

#### **Step-by-step Execution:**

| `windowStart` | `windowEnd` | Current Window | Character Frequencies | Valid Substrings |
|--------------|-------------|----------------|-----------------------|------------------|
| 0           | 0           | "a"            | `{a:1}`               | 0                |
| 0           | 1           | "aa"           | `{a:2}`               | `5 - 1 = 4` (Valid: "aa", "aab", "aabc", "aabcb") |
| 1           | 2           | "ab"           | `{a:1, b:1}`          | 0 |
| 1           | 3           | "abc"          | `{a:1, b:1, c:1}`     | 0 |
| 1           | 4           | "abcb"         | `{a:1, b:2, c:1}`     | `5 - 4 = 1` (Valid: "bcb") |

Total substrings = **5**.

---

### **Time & Space Complexity**

#### **Time Complexity:**
- Each character is processed at most **twice** (once when added, once when removed).
- **O(N)** in total.

#### **Space Complexity:**
- The frequency map stores at most **26** characters.
- **O(1)** (since 26 is a constant).

---
## **239. Sliding Window Maximum**
### **Intuition**
The problem requires us to find the maximum element in every **contiguous subarray (window) of size `k`** in an array. A brute force approach would involve iterating through each window and finding the maximum, but this would be inefficient (O(N*K)). Instead, we can efficiently maintain the maximum using a **monotonic decreasing deque (double-ended queue - `Deque`)**.

### **Efficient Approach (Using Deque)**
- We maintain a **Deque** (double-ended queue) to store indices of elements in a way that ensures:
    1. The **front** of the deque (`dq.peek()`) always holds the index of the **maximum** element in the current window.
    2. The elements in the deque are **in decreasing order** of values (i.e., from largest to smallest).
    3. We remove elements **from the back** of the deque if they are **smaller than or equal to** the current element (since they can never be a maximum in any future window).
    4. If the element at the **front** of the deque is **out of the current window**, we remove it.

---

### **Dry Run**
#### **Example**
```plaintext
nums = [1, 3, -1, -3, 5, 3, 6, 7], k = 3
```
**Step 1: Process first `k` elements (First Window [1, 3, -1])**
1. `dq = [1]` → `nums[1] = 3` is maximum.
2. `Result = []`

**Step 2: Process Remaining Elements**
| i | nums[i] | Deque (Indices) | Deque (Values) | Max in Window |
|---|--------|----------------|---------------|---------------|
| 3 | -3     | [1, 2, 3]      | [3, -1, -3]  | 3             |
| 4 | 5      | [4]            | [5]          | 5             |
| 5 | 3      | [4, 5]         | [5, 3]       | 5             |
| 6 | 6      | [6]            | [6]          | 6             |
| 7 | 7      | [7]            | [7]          | 7             |

---

### **Code Implementation (Java)**
```java
import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        Deque<Integer> dq = new ArrayDeque<>();

        // Process first K elements
        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast(); // Remove smaller elements
            }
            dq.offerLast(i);
        }

        // Process for all windows
        int j = 0;
        for (int i = k; i < n; i++) {
            result[j++] = nums[dq.peek()]; // Store max of current window
            
            // Remove out-of-window elements
            while (!dq.isEmpty() && dq.peek() < i - k + 1) {
                dq.pollFirst();
            }

            // Remove smaller elements from back
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }

        // Store max for the last window
        result[j] = nums[dq.peek()];
        return result;
    }
}
```

---

### **Time and Space Complexity Analysis**
#### **Time Complexity: O(N)**
- Each element is **pushed and popped at most once** from the deque.
- Thus, the operations per element are **O(1)** on average.
- So, the total complexity is **O(N)**.

#### **Space Complexity: O(K)**
- We store **indices of elements** in a deque, with at most **K** elements at a time.
- The `result` array of size **O(N-K+1)** is required to store the output.



Questions bank

## Variable Sized Sliding Window Problems

Below is a list of variable-sized sliding window problems for practice:

1. [3. Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)
2. [76. Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/)
3. [159. Longest Substring with At Most Two Distinct Characters](https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/) (Premium)
4. [209. Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/)
5. [340. Longest Substring with At Most K Distinct Characters](https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/) (Premium)
6. [424. Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/)
7. [487. Max Consecutive Ones II](https://leetcode.com/problems/max-consecutive-ones-ii/) (Premium)
8. [795. Number of Subarrays with Bounded Maximum](https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/)
9. [904. Fruit Into Baskets](https://leetcode.com/problems/fruit-into-baskets/)
10. [992. Subarrays with K Different Integers](https://leetcode.com/problems/subarrays-with-k-different-integers/)
11. [1004. Max Consecutive Ones III](https://leetcode.com/problems/max-consecutive-ones-iii/)
12. [1208. Get Equal Substrings Within Budget](https://leetcode.com/problems/get-equal-substrings-within-budget/)
13. [1297. Maximum Number of Occurrences of a Substring](https://leetcode.com/problems/maximum-number-of-occurrences-of-a-substring/)
14. [1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit](https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/)
15. [1493. Longest Subarray of 1's After Deleting One Element](https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/)
16. [1695. Maximum Erasure Value](https://leetcode.com/problems/maximum-erasure-value/)
17. [1838. Frequency of the Most Frequent Element](https://leetcode.com/problems/frequency-of-the-most-frequent-element/)
18. [1852. Distinct Numbers in Each Subarray](https://leetcode.com/problems/distinct-numbers-in-each-subarray/) (Premium)
19. [2024. Maximize the Confusion of an Exam](https://leetcode.com/problems/maximize-the-confusion-of-an-exam/)
20. [2062. Count Vowel Substrings of a String](https://leetcode.com/problems/count-vowel-substrings-of-a-string/)

