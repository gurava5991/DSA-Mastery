# Fast & Slow Pointers(Hare & Tortoise algorithm)
The Fast & Slow pointer approach, also known as the Hare & Tortoise algorithm, is a pointer algorithm that uses two pointers which move through the array (or sequence/LinkedList) at different speeds. This approach is quite useful when dealing with cyclic LinkedLists or arrays.

By moving at different speeds (say, in a cyclic LinkedList), the algorithm proves that the two pointers are bound to meet. The fast pointer should catch the slow pointer once both the pointers are in a cyclic loop.

One of the famous problems solved using this technique was Finding a cycle in a LinkedList. Let’s jump onto this problem to understand the Fast & Slow pattern.

- Image should be added here

## Linked List Cycle - Easy
[Linked list cycle](https://leetcode.com/problems/linked-list-cycle/)

Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

```java
Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.
```

Imagine we have a slow and a fast pointer to traverse the LinkedList. In each iteration, the slow pointer moves one step and the fast pointer moves two steps. This gives us two conclusions:

**Using Two Pointers (floyd’s Cycle Detection)**<br>
This method uses two pointers, a slow pointer and a fast pointer.<br>

Here are the steps:

1. Start both pointers at the head of the list.
2. Move the slow pointer one step at a time.
3. Move the fast pointer two steps at a time.
4. If there is a cycle, the fast pointer will catch up to the slow pointer.
5. This method does not use extra memory.
```java
class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
        this.next = null;
    }
}

public class LinkedListCycle {
    
    public static boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Cycle detected
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        // Check for cycle (should be false)
        System.out.println("LinkedList has cycle: " + hasCycle(head));

        // Create a cycle: 6 -> 3
        head.next.next.next.next.next.next = head.next.next;

        // Check for cycle (should be true)
        System.out.println("LinkedList has cycle: " + hasCycle(head));

        // Create another cycle: 6 -> 4
        head.next.next.next.next.next.next = head.next.next.next;

        // Check for cycle (should be true)
        System.out.println("LinkedList has cycle: " + hasCycle(head));
    }
}

```
**Time Complexity:** O(n) we are traversing linked list atmost one time <br>
**Space Complexity:** O(1)

Follow-up problem for above one <br>
[Length Of Cycle](https://www.geeksforgeeks.org/problems/find-length-of-loop/1)

## Linked List Cycle II 
[linked List cycle II](https://leetcode.com/problems/linked-list-cycle-ii/description/)

Extension of Linked List cycle problem 
1. Start both pointers at the head of the list.
2. Move the slow pointer one step at a time.
3. Move the fast pointer two steps at a time.
4. If there is a cycle, the fast pointer will catch up to the slow pointer.
5. Reset one of the pointers (e.g., slow) to the head of the list.
6. Move both pointers one step at a time. The point where they meet again is the start of the cycle.

```java
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null; // No cycle if list is empty or has only one node
        }

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;           // Move slow pointer one step
            fast = fast.next.next;      // Move fast pointer two steps

            // If slow and fast meet, a cycle exists
            if (slow == fast) {
                // Step 2: Find the start of the cycle
                ListNode entry = head;  // Reset entry pointer to head
                while (entry != slow) {
                    entry = entry.next;  // Move entry pointer one step
                    slow = slow.next;     // Move slow pointer one step
                }
                // Entry is now at the start of the cycle
                return entry; // Start of the cycle
            }
        }
        return null; // No cycle found
    }
}

```
**Time Complexity:**<br>
O(n): Both pointers will traverse the array linearly.<br>
**Space Complexity:**<br>
O(1): Only constant space is used for the pointers.

## Happy Number (medium)
- [happy number](https://leetcode.com/problems/happy-number/)

Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

1. Starting with any positive integer, replace the number by the sum of the squares of its digits.
2. Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
3. Those numbers for which this process ends in 1 are happy.
4. Return true if n is a happy number, and false if not.

```java
Example 1:

Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
Example 2:

Input: n = 2
Output: false
```
**findHappyNumber(23)//true**


23 is a happy number, Here are the steps to find out that 23 is a happy number:

2² + 3² = 4 + 9 = 13
1² + 3² = 1 + 9 = 10
1² + 0² = 1 + 0 = 1

**findHappyNumber(12)//false**

12 is not a happy number, Here are the steps to find out that 12 is not a happy number:

1²+2²= 1 + 4 = 5
5² = 25
2² + 5² = 4 + 25 = 29
2² + 9² = 4 + 81 = 85
8² + 5² = 64 + 25 = 89
8² + 9² = 64 + 81 = 145
1² + 4² + 5²= 1 + 16 + 25 = 42
4² + 2² = 16 + 4 = 20
2² + 0² = 4 + 0 = 4
4²= 16
1² + 6² = 1 + 36 = 37
3² + 7² = 9 + 49 = 58
5² + 8²= 25 + 64 = 89 Step 13 leads us back to step 5 as the number becomes equal to 89’, this means that we can never reach 1, therefore, 12` is not a happy number.

findHappyNumber(19)//true

19 is a happy number, Here are the steps to find out that 19 is a happy number:

1² + 9² = 82
8² + 2² = 68
6² + 8² = 100
1² + 0² + 0² = 1

```java
public class Solution {
    public boolean findHappyNumber(int num) {
        int slow = num;
        int fast = num;

        // Loop until we find a cycle
        while (true) {
            // Move slow one step
            slow = findSquareSum(slow);
            // Move fast two steps
            fast = findSquareSum(findSquareSum(fast));

            // If both pointers meet, a cycle is detected
            if (slow == fast) {
                break;
            }
        }

        // Check if the cycle ends at 1
        return slow == 1;
    }

    // Helper function to find the sum of squares of digits
    private int findSquareSum(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10; // Get the last digit
            sum += digit * digit;  // Add the square of the digit
            num = num / 10;        // Remove the last digit
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int number = 19; // Example input
        boolean isHappy = solution.findHappyNumber(number);
        System.out.println("Is " + number + " a happy number? " + isHappy);
    }
}

```
**Time Complexity:**<br>
In practice, the number of iterations needed to reach a conclusion (either finding a happy number or detecting a cycle) is generally logarithmic in the size of the number. Thus, the time complexity is O(log n), where n is the input number.<br>
**Space Complexity:**<br>
The space complexity is O(1), as we are only using a constant amount of extra space for pointers (to track slow and fast).
## 287. Find the Duplicate Number
- Leetcode Link : [Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number/description/)

Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and using only constant extra space.

```java
Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
Example 3:

Input: nums = [3,3,3,3,3]
Output: 3
Follow up:
How can we prove that at least one duplicate number must exist in nums?
Can you solve the problem in linear runtime complexity?
```
**- Approach 1 :**<br>
Run two loops one inside the other to find if it satisfies the condition arr[i]==arr[j], satisfies or not.<br>
**Time Complexity-O(n*n), Space Complexity-O(1)**

**Approach 2**<br>
* Step 1: Sort the array, Time Complexity-O(nlogn)
* Step 2: Run a loop to find if the adjacent elements are the same or not?
* **TC-O(n), so total Time Complexity-O(nlogn)+O(n)**
* **Space Complexity-O(1)**

**Approach 3**
Using the approach of hashing

* Step 1: Use another array for storing the frequency of the elements. The element whose frequency is greater than 1, that is the repeating/ duplicate element.
* **TimeComplexity-O(n), Space Complexity-O(n)**

**Approach Using Slow and Fast Pointer:**<br>
**Intuition :**
Treat the array like a linked list where each element points to the index of the next element, i.e., nums[i] points to nums[nums[i]]. This creates a cycle, and the duplicate number is part of this cycle.

**Two Pointers Approach :**
- **Fast pointer:** Moves two steps at a time.
- **Slow pointer:** Moves one step at a time.
- First, find the point where the two pointers meet inside the cycle.
- Then, reset one of the pointers to the start of the array and move both pointers one step at a time. The point where they meet is the duplicate number.

```java
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // Phase 1: Detect the cycle
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: Find the entrance to the cycle (which is the duplicate number)
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow; // or return fast, both are at the duplicate number
    }
}

```
**Time Complexity:**<br>
O(n): Both pointers will traverse the array linearly.<br>
**Space Complexity:**<br>
O(1): Only constant space is used for the pointers.




## Middle Of Linked List
[Middle Of Linked List](https://leetcode.com/problems/middle-of-the-linked-list/)<br>
Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.

The algorithm can be summarized as follows:

1. Initialize two pointers, `slow` and `fast`, pointing to the head of the linked list.
2. Move the `fast` pointer two nodes at a time and the `slow` pointer one node at a time.
3. When the `fast` pointer reaches the end of the linked list (i.e., `fast` reaches the last node or `fast.next` becomes `None`), the `slow` pointer will be at the middle element.
4. Return the value of the node pointed to by the `slow` pointer as the middle element

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head ,fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
        
    }
}
```

**Time Complexity:**<br>
O(n): Both pointers will traverse the array linearly.<br>
**Space Complexity:**<br>
O(1): Only constant space is used for the pointers.

Follow-up question using Middle of Linked List
- [Delete the Middle Node of a Linked List](https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/)

