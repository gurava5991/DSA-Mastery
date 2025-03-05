## **Bit Manipulation in Java**

Bit manipulation is a technique that uses bitwise operators to perform operations at the bit level. It is often used for efficient computations, optimization, and problem-solving in competitive programming.

### **1. Bitwise Operators in Java**
| Operator | Name | Example | Explanation |
|----------|------|---------|-------------|
| `&` | AND | `5 & 3 = 1` | Bitwise AND of 5 (`101`) and 3 (`011`) results in `001` (1 in decimal). |
| `|` | OR | `5 | 3 = 7` | Bitwise OR of 5 (`101`) and 3 (`011`) results in `111` (7 in decimal). |
| `^` | XOR | `5 ^ 3 = 6` | Bitwise XOR of 5 (`101`) and 3 (`011`) results in `110` (6 in decimal). |
| `~` | NOT | `~5 = -6` | Bitwise NOT of 5 (`101`) flips bits to `...11111010` (Two's complement of -6). |
| `<<` | Left Shift | `5 << 1 = 10` | Shifts bits of 5 (`101`) left by 1 position, making it `1010` (10 in decimal). |
| `>>` | Right Shift | `5 >> 1 = 2` | Shifts bits of 5 (`101`) right by 1 position, making it `010` (2 in decimal). |
| `>>>` | Unsigned Right Shift | `-5 >>> 1` | Similar to `>>`, but fills 0 from the left (used for unsigned numbers). |

---

## **2. Bitwise AND (`&`)**
Performs **bitwise AND** operation on corresponding bits.

```java
public class BitwiseAND {
    public static void main(String[] args) {
        int a = 5;  // 101
        int b = 3;  // 011
        int result = a & b; // 001 (1)
        System.out.println("5 & 3 = " + result);  // Output: 1
    }
}
```

### **Truth Table for AND (`&`)**
| A | B | A & B |
|---|---|-------|
| 0 | 0 | 0 |
| 0 | 1 | 0 |
| 1 | 0 | 0 |
| 1 | 1 | 1 |

---

## **3. Bitwise OR (`|`)**
Performs **bitwise OR** operation.

```java
public class BitwiseOR {
    public static void main(String[] args) {
        int a = 5;  // 101
        int b = 3;  // 011
        int result = a | b; // 111 (7)
        System.out.println("5 | 3 = " + result);  // Output: 7
    }
}
```

### **Truth Table for OR (`|`)**
| A | B | A or B |
|---|---|--------|
| 0 | 0 | 0      |
| 0 | 1 | 0      |
| 1 | 0 | 0      |
| 1 | 1 | 1      |

---

## **4. Bitwise XOR (`^`)**
XOR (Exclusive OR) returns `1` if both bits are different.

```java
public class BitwiseXOR {
    public static void main(String[] args) {
        int a = 5;  // 101
        int b = 3;  // 011
        int result = a ^ b; // 110 (6)
        System.out.println("5 ^ 3 = " + result);  // Output: 6
    }
}
```

### **Truth Table for XOR (`^`)**
| A | B | A ^ B |
|---|---|-------|
| 0 | 0 | 0 |
| 0 | 1 | 1 |
| 1 | 0 | 1 |
| 1 | 1 | 0 |

**Usage of XOR:**
- Swapping two numbers without using a temporary variable.
- Finding the unique number in an array where every element appears twice except one.

---

## **5. Bitwise NOT (`~`)**
Flips all bits of a number (complement).

```java
public class BitwiseNOT {
    public static void main(String[] args) {
        int a = 5;  // 00000000 00000000 00000000 00000101 (Binary)
        int result = ~a; // 11111111 11111111 11111111 11111010 (Two's complement of -6)
        System.out.println("~5 = " + result);  // Output: -6
    }
}
```

---

## **6. Left Shift (`<<`)**
Shifts bits to the left, multiplying by `2^n`.

```java
public class LeftShift {
    public static void main(String[] args) {
        int a = 5;  // 101
        int result = a << 1; // 1010 (10)
        System.out.println("5 << 1 = " + result);  // Output: 10
    }
}
```

- `5 << 1` → `101` → `1010` (10)
- `5 << 2` → `10100` (20)

---

## **7. Right Shift (`>>`)**
Shifts bits to the right, dividing by `2^n`.

```java
public class RightShift {
    public static void main(String[] args) {
        int a = 5;  // 101
        int result = a >> 1; // 10 (2)
        System.out.println("5 >> 1 = " + result);  // Output: 2
    }
}
```

- `5 >> 1` → `101` → `10` (2)
- `5 >> 2` → `1` (1)

---

## **8. Unsigned Right Shift (`>>>`)**
Like `>>`, but fills `0` for negative numbers.

```java
public class UnsignedRightShift {
    public static void main(String[] args) {
        int a = -5;  // 11111111 11111111 11111111 11111011
        int result = a >>> 1; // 01111111 11111111 11111111 11111011
        System.out.println("-5 >>> 1 = " + result);  // Output: 2147483645
    }
}
```

---

## **2. Bit Manipulation Techniques**

### **1. Checking if the i-th Bit is Set**
To check if the i-th bit of a number `n` is set (1):
```java
public boolean isBitSet(int n, int i) {
    return (n & (1 << i)) != 0;
}
```
**Example:** `isBitSet(5, 2)` → `true` (binary: `101` → 2nd bit is set)

**Time Complexity:** O(1)

**Space Complexity:** O(1)

---

### **2. Setting the i-th Bit**
To set (turn on) the i-th bit of `n`:
```java
public int setBit(int n, int i) {
    return n | (1 << i);
}
```
**Example:** `setBit(5, 1)` → `7` (binary: `101` → `111`)

**Time Complexity:** O(1)

**Space Complexity:** O(1)

---

### **3. Clearing the i-th Bit**
To clear (turn off) the i-th bit of `n`:
```java
public int clearBit(int n, int i) {
    return n & ~(1 << i);
}
```
**Example:** `clearBit(7, 1)` → `5` (binary: `111` → `101`)

**Time Complexity:** O(1)

**Space Complexity:** O(1)

---

### **4. Toggling the i-th Bit**
To toggle (flip) the i-th bit of `n`:
```java
public int toggleBit(int n, int i) {
    return n ^ (1 << i);
}
```
**Example:** `toggleBit(5, 0)` → `4` (binary: `101` → `100`)

**Time Complexity:** O(1)

**Space Complexity:** O(1)

---

### **5. Removing the Last Set Bit**
To remove the rightmost set bit:
```java
public int removeLastSetBit(int n) {
    return n & (n - 1);
}
```
**Example:** `removeLastSetBit(6)` → `4` (binary: `110` → `100`)

**Time Complexity:** O(1)

**Space Complexity:** O(1)

---

## **3. Applications of Bit Manipulation**

### **1. Check if a Number is Odd or Even**
```java
if ((num & 1) == 0) 
    System.out.println("Even");
else 
    System.out.println("Odd");
```
**Time Complexity:** O(1)

**Space Complexity:** O(1)

---

### **2. Swap Two Numbers Without Using Extra Variable**
```java
a = a ^ b;
b = a ^ b;
a = a ^ b;
```
**Time Complexity:** O(1)

**Space Complexity:** O(1)

---

### **3. Find the Unique Number in an Array**
```java
int unique = 0;
for (int num : arr) {
    unique ^= num;  // XOR cancels out duplicate numbers
}
System.out.println("Unique Number: " + unique);
```
**Time Complexity:** O(n)

**Space Complexity:** O(1)

---

### **4. Count the Number of Set Bits**
```java
public int countSetBits(int n) {
    int count = 0;
    while (n > 0) {
        count += (n & 1);
        n >>= 1;
    }
    return count;
}
```
**Time Complexity:** O(log n)

**Space Complexity:** O(1)

---

### **5. Check if a Number is a Power of 2**
```java
public boolean isPowerOfTwo(int n) {
    return (n > 0) && (n & (n - 1)) == 0;
}
```
**Time Complexity:** O(1)

**Space Complexity:** O(1)

---

## **XOR Properties and Their Use in Problem Solving**

XOR (`^`) is a powerful bitwise operator widely used in problem-solving for optimizations and trick-based approaches. Let's explore its properties and how they are applied in coding problems.

---

### **1. Basic Properties of XOR**
1. **Self-Cancellation:**  
   \[
   a \oplus a = 0
   \]
    - Any number XOR with itself results in 0.
    - Example: `5 ^ 5 = 0`

2. **Identity Property:**  
   \[
   a \oplus 0 = a
   \]
    - Any number XOR with 0 remains unchanged.
    - Example: `7 ^ 0 = 7`

3. **Commutative Property:**  
   \[
   a \oplus b = b \oplus a
   \]
    - Order of operands does not matter.
    - Example: `3 ^ 5 = 5 ^ 3`

4. **Associative Property:**  
   \[
   a \oplus (b \oplus c) = (a \oplus b) \oplus c
   \]
    - Grouping does not change the result.
    - Example: `(2 ^ (3 ^ 4)) = ((2 ^ 3) ^ 4)`

5. **Involution Property (Inverse):**  
   \[
   (a \oplus b) \oplus b = a
   \]
    - XORing twice with the same number restores the original.
    - Example: `(7 ^ 3) ^ 3 = 7`

---

## **2. Applications of XOR in Problem Solving**

### **1. Finding the Unique Element in an Array**
🔹 **Problem:** Given an array where every element appears twice except for one, find the unique element.  
🔹 **Solution:** Use XOR, since duplicate elements cancel out.

```java
public int findUnique(int[] arr) {
    int unique = 0;
    for (int num : arr) {
        unique ^= num;  // XOR cancels out duplicate numbers
    }
    return unique;
}
```
🔹 **Example:**
```java
arr = [2, 3, 2, 4, 4]
unique = 2 ^ 3 ^ 2 ^ 4 ^ 4 = 3
```
✅ **Time Complexity:** O(n)  
✅ **Space Complexity:** O(1)

---

### **2. Swap Two Numbers Without a Temporary Variable**
🔹 **Problem:** Swap two numbers without using extra space.  
🔹 **Solution:** Use XOR properties.

```java
public void swap(int a, int b) {
    a = a ^ b;
    b = a ^ b;
    a = a ^ b;
    System.out.println("a: " + a + ", b: " + b);
}
```
🔹 **Example:**
```java
a = 5, b = 7
Step 1: a = 5 ^ 7  → a = 2
Step 2: b = 2 ^ 7  → b = 5
Step 3: a = 2 ^ 5  → a = 7
```
✅ **Time Complexity:** O(1)  
✅ **Space Complexity:** O(1)

---

### **3. Find the Missing Number in an Array (1 to N)**
🔹 **Problem:** Given an array containing numbers from `1` to `N` with one missing, find the missing number.  
🔹 **Solution:** Use XOR to cancel out all numbers except the missing one.

```java
public int findMissing(int[] arr, int n) {
    int xor1 = 0, xor2 = 0;

    // XOR of all numbers from 1 to N
    for (int i = 1; i <= n; i++) {
        xor1 ^= i;
    }

    // XOR of all elements in the array
    for (int num : arr) {
        xor2 ^= num;
    }

    return xor1 ^ xor2;
}
```
🔹 **Example:**
```java
arr = [1, 2, 4, 5]  // Missing 3
XOR(1 to 5) = 1 ^ 2 ^ 3 ^ 4 ^ 5 = 1
XOR(arr) = 1 ^ 2 ^ 4 ^ 5 = 4
missing = 1 ^ 4 = 3
```
✅ **Time Complexity:** O(n)  
✅ **Space Complexity:** O(1)

---

### **4. Find Two Unique Numbers in an Array**
🔹 **Problem:** Given an array where every number appears twice except for two unique numbers, find them.  
🔹 **Solution:** Use XOR and bit partitioning.

```java
public int[] findTwoUnique(int[] arr) {
    int xorAll = 0;
    for (int num : arr) xorAll ^= num;

    // Find rightmost set bit
    int rightmostBit = xorAll & -xorAll;
    
    int num1 = 0, num2 = 0;
    for (int num : arr) {
        if ((num & rightmostBit) == 0)
            num1 ^= num;
        else
            num2 ^= num;
    }

    return new int[]{num1, num2};
}
```
🔹 **Example:**
```java
arr = [2, 4, 7, 9, 2, 4]
XOR = 7 ^ 9 = 14
Rightmost bit = 14 & -14 = 2
Groups: [2, 2, 4, 4] and [7, 9]
Result = [7, 9]
```
✅ **Time Complexity:** O(n)  
✅ **Space Complexity:** O(1)

---

## **5. Find the Missing and Repeating Number**
🔹 **Problem:** Given an array of `n` numbers from `1` to `n` but with one missing and one duplicate, find both.  
🔹 **Solution:** Use XOR and bitwise separation.

```java
public int[] findMissingAndDuplicate(int[] arr) {
    int n = arr.length;
    int xorAll = 0;

    // XOR all numbers from 1 to n and the array elements
    for (int i = 1; i <= n; i++) xorAll ^= i;
    for (int num : arr) xorAll ^= num;

    // Get rightmost set bit
    int rightmostBit = xorAll & -xorAll;
    
    int num1 = 0, num2 = 0;
    for (int num : arr) {
        if ((num & rightmostBit) == 0)
            num1 ^= num;
        else
            num2 ^= num;
    }
    for (int i = 1; i <= n; i++) {
        if ((i & rightmostBit) == 0)
            num1 ^= i;
        else
            num2 ^= i;
    }

    // Check which is missing and which is duplicate
    for (int num : arr) {
        if (num == num1) return new int[]{num1, num2}; // num1 is duplicate
    }
    return new int[]{num2, num1}; // num2 is duplicate
}
```
🔹 **Example:**
```java
arr = [1, 3, 3, 4, 5]
XOR = 1 ^ 2 ^ 3 ^ 4 ^ 5 ^ 1 ^ 3 ^ 3 ^ 4 ^ 5 = 2 ^ 3
Rightmost bit = 1
Groups: [1, 1, 4, 4] and [2, 3, 3, 5, 5]
Result = [3, 2] (Duplicate: 3, Missing: 2)
```
✅ **Time Complexity:** O(n)  
✅ **Space Complexity:** O(1)

---

## **6. Find the XOR of All Elements in a Range [L, R]**
🔹 **Problem:** Given a range `[L, R]`, find the XOR of all numbers in it.  
🔹 **Solution:** Use **prefix XOR property**.

```java
public int xorUpto(int n) {
    if (n % 4 == 0) return n;
    if (n % 4 == 1) return 1;
    if (n % 4 == 2) return n + 1;
    return 0;
}

public int rangeXor(int L, int R) {
    return xorUpto(R) ^ xorUpto(L - 1);
}
```
🔹 **Example:**
```java
L = 3, R = 6
XOR(1 to 6) = 1 ^ 2 ^ 3 ^ 4 ^ 5 ^ 6 = 7
XOR(1 to 2) = 1 ^ 2 = 3
Result = 7 ^ 3 = 4
```
✅ **Time Complexity:** O(1)  
✅ **Space Complexity:** O(1)

---

## **7. Gray Code Conversion**
🔹 **Problem:** Convert a number into its **Gray Code** representation.  
🔹 **Solution:** The **Gray Code** of a number `n` is computed as:

\[
Gray(n) = n \oplus (n >> 1)
\]

```java
public int toGrayCode(int n) {
    return n ^ (n >> 1);
}
```
🔹 **Example:**
```java
n = 5 (binary 101)
Gray(5) = 5 ^ (5 >> 1) = 101 ^ 010 = 111 (decimal 7)
```
✅ **Time Complexity:** O(1)  
✅ **Space Complexity:** O(1)

---

## **8. Maximum XOR Pair in an Array**
🔹 **Problem:** Given an array, find the maximum XOR value of any two elements.  
🔹 **Solution:** Use a **Trie-based approach**.

```java
class TrieNode {
    TrieNode[] children = new TrieNode[2];
}

public class MaximumXOR {
    TrieNode root = new TrieNode();
    
    public void insert(int num) {
        TrieNode node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.children[bit] == null)
                node.children[bit] = new TrieNode();
            node = node.children[bit];
        }
    }

    public int findMaxXOR(int num) {
        TrieNode node = root;
        int maxXor = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.children[1 - bit] != null) {
                maxXor |= (1 << i);
                node = node.children[1 - bit];
            } else {
                node = node.children[bit];
            }
        }
        return maxXor;
    }

    public int maxPairXOR(int[] nums) {
        for (int num : nums) insert(num);
        int maxXor = 0;
        for (int num : nums)
            maxXor = Math.max(maxXor, findMaxXOR(num));
        return maxXor;
    }
}
```
✅ **Time Complexity:** O(n log k)  
✅ **Space Complexity:** O(n log k)

### **Solution: Greedy + Sorting Approach**

#### **Intuition:**
- The maximum **odd binary number** means the **rightmost bit** should be `1` (to make it odd).
- We want to place the remaining `1`s at the **leftmost positions** to maximize the value.

#### **Approach:**
1. **Count the number of `1`s** in the binary string.
2. **Place (count - 1) `1`s at the beginning** (to get the highest value).
3. **Place all remaining `0`s in the middle**.
4. **Ensure the last digit is `1` (to make it odd)**.

---

### **Java Code Implementation:**
```java
class Solution {
    public String maximumOddBinaryNumber(String s) {
        int ones = 0, zeros = 0;

        // Count the number of ones and zeros in the string
        for (char c : s.toCharArray()) {
            if (c == '1') ones++;
            else zeros++;
        }

        // Create a result string: `ones-1` ones at the start, then all zeros, then one `1` at the end
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ones - 1; i++) sb.append('1');
        for (int i = 0; i < zeros; i++) sb.append('0');
        sb.append('1'); // Last digit should be `1` to make it odd

        return sb.toString();
    }
}
```

---

### **Complexity Analysis:**
- **Time Complexity:** O(n) → We iterate through the string once and construct the result.
- **Space Complexity:** O(n) → We use a `StringBuilder` of length `n`.

---

### **Example Walkthrough:**
#### **Example 1:**
🔹 **Input:** `s = "0101"`  
🔹 **Step-wise Execution:**
- `ones = 2`, `zeros = 2`
- **Rearrange:** `"10" + "0" + "1"`  
  🔹 **Output:** `"1010"`

#### **Example 2:**
🔹 **Input:** `s = "11100"`  
🔹 **Step-wise Execution:**
- `ones = 3`, `zeros = 2`
- **Rearrange:** `"11" + "00" + "1"`  
  🔹 **Output:** `"11001"`

---
## **Problem: Bitwise AND of Numbers Range**
### **LeetCode 201: Range Bitwise AND**

### **Problem Statement**
Given two integers `left` and `right` where `0 <= left <= right`, return the bitwise AND of all numbers in the range `[left, right]` (inclusive).

### **Intuition**
The **bitwise AND** of a range `[left, right]` means taking the **common prefix** of their binary representations and padding it with zeros.

#### **Key Observations:**
1. **Bitwise AND decreases as numbers increase**
   - If `left != right`, then at least one bit in `left` and `right` will flip during shifting.
   - The changing bits will become `0` after shifting, removing non-common bits.

2. **Right Shift Until Equal**
   - Keep right-shifting `left` and `right` until they become equal.
   - Count how many shifts are done.
   - Shift the result back to get the original magnitude.

---

### **Example Walkthrough**
#### **Example 1**
**Input:**
```  
left = 5 (101)
right = 7 (111)
```
**Process:**  
| Step | left  | right | shift |
|------|------|------|------|
| Initial | `101` (5) | `111` (7) | 0 |
| Shift 1 | `10` (2) | `11` (3) | 1 |
| Shift 2 | `1` (1) | `1` (1) | 2 |

Now, shift back:  
`1 << 2 = 100` (**4 in decimal**)

**Output:** `4`

---

#### **Example 2**
**Input:**
```  
left = 12 (1100)
right = 15 (1111)
```
**Process:**  
| Step | left  | right | shift |
|------|------|------|------|
| Initial | `1100` (12) | `1111` (15) | 0 |
| Shift 1 | `110` (6) | `111` (7) | 1 |
| Shift 2 | `11` (3) | `11` (3) | 2 |

Shift back:  
`11 << 2 = 1100` (**12 in decimal**)

**Output:** `12`

---

### **Code Implementation in Java**
```java
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
       int shift = 0;
        while (left != right) {  // Keep shifting until both numbers become equal
            left = left >> 1;
            right = right >> 1;
            shift++;
        }
        return right << shift; // Shift the result back to its original place
    }
}
```

---

### **Complexity Analysis**
- **Time Complexity:** \( O(\log N) \)
   - Since we keep shifting numbers to the right until they become equal, it runs at most `log(right)` times.
- **Space Complexity:** \( O(1) \)
   - We use only a few integer variables.

---
## **Intuition Behind the Approach**

The key observation in this approach is that every time we **flip** from an index `i`, it toggles all elements from `i` to the end of the array. So, we need to carefully decide when to flip in order to minimize the number of operations.

---

### **Key Insights from the Code**

1. **Using `flips % 2` to Track Effect of Previous Flips**
   - If `flips` is even (`flips % 2 == 0`), then the original `nums[i]` remains unchanged.
   - If `flips` is odd (`flips % 2 == 1`), then `nums[i]` is flipped (i.e., `0` becomes `1` and `1` becomes `0`).

2. **When to Flip?**
   - If `nums[i] == 1` and it has been flipped an **odd number of times**, it is now `0` and **needs to be flipped back to 1**.
   - If `nums[i] == 0` and it has been flipped an **even number of times**, it is still `0` and **needs to be flipped to 1**.
   - In both cases, a flip is required, so we increment `flips`.

---

### **Example Walkthrough**

#### **Example 1**
**Input:**
```  
nums = [0, 1, 0, 1]  
```
**Initial:** `flips = 0`

| Index | `nums[i]` | Condition Checked | `flips` Updated? | Updated `flips` |
|--------|----------|------------------|----------------|----------------|
| 0      | 0        | `flips % 2 == 0`  | Yes (flip)    | 1              |
| 1      | 1        | `flips % 2 == 1`  | Yes (flip)    | 2              |
| 2      | 0        | `flips % 2 == 0`  | Yes (flip)    | 3              |
| 3      | 1        | `flips % 2 == 1`  | Yes (flip)    | 4              |

**Output:** `4`

---

#### **Example 2**
**Input:**
```  
nums = [1, 1, 0, 0, 1, 0]  
```
**Initial:** `flips = 0`

| Index | `nums[i]` | Condition Checked | `flips` Updated? | Updated `flips` |
|--------|----------|------------------|----------------|----------------|
| 0      | 1        | `flips % 2 == 1`  | No            | 0              |
| 1      | 1        | `flips % 2 == 1`  | No            | 0              |
| 2      | 0        | `flips % 2 == 0`  | Yes (flip)    | 1              |
| 3      | 0        | `flips % 2 == 0`  | Yes (flip)    | 2              |
| 4      | 1        | `flips % 2 == 1`  | Yes (flip)    | 3              |
| 5      | 0        | `flips % 2 == 0`  | Yes (flip)    | 4              |

**Output:** `4`

### **Code Implementation in Java**
```java
class Solution {
   public int minOperations(int[] nums) {
      int n = nums.length , flips = 0;
      for(int i = 0 ; i < n ; i++){
         if((nums[i] == 1 && (flips % 2 == 1)) || (nums[i] == 0 && (flips % 2 == 0)))
            flips++;
      }
      return flips++;
   }
}
```

---

### **Time & Space Complexity**
- **Time Complexity:** \( O(n) \) since we iterate through `nums` once.
- **Space Complexity:** \( O(1) \) since we use only a few integer variables.

---
## **Problem Explanation: Minimum Flips to Make `a | b == c`**
Given three integers `a`, `b`, and `c`, our goal is to determine the **minimum number of bit flips** required to make the bitwise OR of `a` and `b` equal to `c`.

### **Intuition**
Each bit in `c` should be the result of the bitwise OR (`|`) of the corresponding bits in `a` and `b`.
- If `c[i] = 1`, then at least one of `a[i]` or `b[i]` must be `1`. If both are `0`, we must flip at least one of them.
- If `c[i] = 0`, then both `a[i]` and `b[i]` must be `0`. If either is `1`, we must flip it to `0`.

### **Breakdown by Cases**
| `bitA` | `bitB` | `bitC` | `a or b` | Flip Needed? |
|--------|--------|--------|----------|--------------|
| 0      | 0      | 0      | 0        | No flip needed |
| 0      | 0      | 1      | 0        | Flip one to 1 |
| 0      | 1      | 0      | 1        | Flip `b` to 0 |
| 0      | 1      | 1      | 1        | No flip needed |
| 1      | 0      | 0      | 1        | Flip `a` to 0 |
| 1      | 0      | 1      | 1        | No flip needed |
| 1      | 1      | 0      | 1        | Flip both `a` and `b` to 0 (2 flips) |
| 1      | 1      | 1      | 1        | No flip needed |

---

## **Code Explanation**
```java
class Solution {
    public int minFlips(int a, int b, int c) {
        int flips = 0;
        for(int i = 0; i < 32; i++){  // Loop through all 32 bits (max for int)
            int bitA = (a >> i) & 1;  // Extract the i-th bit from a
            int bitB = (b >> i) & 1;  // Extract the i-th bit from b
            int bitC = (c >> i) & 1;  // Extract the i-th bit from c
            
            if(bitC == 0){ // If c's bit is 0, both a and b must be 0
                if(bitA == 1 && bitB == 1)
                    flips += 2; // Need to flip both
                else if(bitA == 1 || bitB == 1)
                    flips += 1; // Need to flip one
            }
            else { // If c's bit is 1, at least one of a or b must be 1
                if(bitA == 0 && bitB == 0)
                    flips += 1; // Need to flip one of them to 1
            }
        }
        return flips;
    }
}
```
---

## **Example Walkthrough**
### **Example 1**
**Input:**
```  
a = 2 (010), b = 6 (110), c = 5 (101)  
```
**Binary Representation:**
```
a:  0 1 0  
b:  1 1 0  
c:  1 0 1  
```
- **Bit 0:** `bitA = 0`, `bitB = 0`, `bitC = 1` → Need to flip one (0 → 1). **(1 flip)**
- **Bit 1:** `bitA = 1`, `bitB = 1`, `bitC = 0` → Need to flip both (1 → 0). **(2 flips)**
- **Bit 2:** `bitA = 0`, `bitB = 1`, `bitC = 1` → No flip needed.

**Total Flips = 3**  
**Output:** `3`

---

### **Example 2**
**Input:**
```  
a = 8 (1000), b = 3 (0011), c = 7 (0111)  
```
**Binary Representation:**
```
a:  1 0 0 0  
b:  0 0 1 1  
c:  0 1 1 1  
```
- **Bit 0:** `bitA = 0`, `bitB = 1`, `bitC = 1` → No flip needed.
- **Bit 1:** `bitA = 0`, `bitB = 1`, `bitC = 1` → No flip needed.
- **Bit 2:** `bitA = 0`, `bitB = 0`, `bitC = 1` → Need to flip one (0 → 1). **(1 flip)**
- **Bit 3:** `bitA = 1`, `bitB = 0`, `bitC = 0` → Need to flip `a[3]` to 0. **(1 flip)**

**Total Flips = 2**  
**Output:** `2`

---

## **Complexity Analysis**
- **Time Complexity:** \( O(1) \)
   - Since integers are at most 32 bits, the loop runs at most 32 times → **Constant time**.
- **Space Complexity:** \( O(1) \)
   - Uses only a few integer variables → **Constant space**.

---




