# In-place Reversal of a LinkedList
In a lot of problems, we are asked to reverse the links between a set of nodes of a LinkedList. Often, the constraint is that we need to do this in-place, i.e., using the existing node objects and without using extra memory.

in-place Reversal of a LinkedList pattern describes an efficient way to solve the above problem.

## Reverse a LinkedList (easy)

Leetcode link : [Reverse a LinkedList](https://leetcode.com/problems/reverse-linked-list/)

Given the head of a Singly LinkedList, reverse the LinkedList. Write a function to return the new head of the reversed LinkedList.

To reverse a LinkedList, we need to reverse one node at a time. We will start with a variable current which will initially point to the head of the LinkedList and a variable previous which will point to the previous node that we have processed; initially previous will point to null.

In a stepwise manner, we will reverse the current node by pointing it to the previous before moving on to the next node. Also, we will update the previous to always point to the previous node that we have processed.

```java
class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
        this.next = null;
    }

    // Function to print the linked list
    public void printList() {
        Node temp = this;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class LinkedListReversal {

    // Function to reverse the linked list
    public static Node reverse(Node head) {
        Node current = head;
        Node previous = null;
        Node next = null;

        while (current != null) {
            next = current.next; // temporarily store the next node
            current.next = previous; // reverse the current node
            previous = current; // move previous to current
            current = next; // move to next node
        }
        return previous; // 'previous' will be the new head
    }

    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(4);
        head.next.next = new Node(6);
        head.next.next.next = new Node(8);
        head.next.next.next.next = new Node(10);

        System.out.print("Nodes of original LinkedList are: ");
        head.printList();

        Node reversedHead = reverse(head);
        System.out.print("Nodes of reversed LinkedList are: ");
        reversedHead.printList();
    }
}

```

**Time Complexity:**
- O(n): The list is traversed once.

**Space Complexity:**<br>
O(1): Only a constant amount of extra space is used regardless of the input size.

## Reverse a Sub-list (medium)

Leetcode Link : [Reverse a Sub-list](https://leetcode.com/problems/reverse-linked-list-ii/)

Given the head of a LinkedList and two positions p and q, reverse the LinkedList from position p to q.

The problem follows the in-place Reversal of a LinkedList pattern. We can use a similar approach as discussed in Reverse a LinkedList. Here are the steps we need to follow:

1. Skip the first p-1 nodes, to reach the node at position p.
2. Remember the node at position p-1 to be used later to connect with the reversed sub-list.
3. Next, reverse the nodes from p to q using the same approach discussed in Reverse a LinkedList.
4. Connect the p-1 and q+1 nodes to the reversed sub-list.

```java
class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
        this.next = null;
    }

    public String getList() {
        StringBuilder result = new StringBuilder();
        Node temp = this;
        while (temp != null) {
            result.append(temp.value).append(" ");
            temp = temp.next;
        }
        return result.toString();
    }
}

public class ReverseSubList {

    public static Node reverseSubList(Node head, int p, int q) {
        if (p == q) {
            return head;  // If the range is a single node, no need to reverse
        }

        Node current = head;
        Node previous = null;
        int i = 0;

        // Move `current` to the `p`-th position
        while (current != null && i < p - 1) {
            previous = current;
            current = current.next;
            i++;
        }

        // We will reverse the nodes between `p` and `q`
        Node lastNodeOfFirstPart = previous;  // The node before `p`
        Node lastNodeOfSubList = current;  // The node at `p`
        Node next = null;

        // Reverse the sublist between `p` and `q`
        i = 0;
        while (current != null && i < q - p + 1) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            i++;
        }

        // Connect the first part of the list
        if (lastNodeOfFirstPart != null) {
            lastNodeOfFirstPart.next = previous;  // Connect to the reversed sublist
        } else {
            head = previous;  // If reversing starts from the first node
        }

        // Connect the last part of the list
        lastNodeOfSubList.next = current;

        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Nodes of original LinkedList are: " + head.getList());
        Node reversedList = reverseSubList(head, 2, 4);
        System.out.println("Nodes of reversed LinkedList are: " + reversedList.getList());
    }
}

```

**Time Complexity:**
- The time complexity of the Reverse Sub-list algorithm is O(n), where n is the number of nodes in the linked list.

**Space Complexity:**
- The space complexity of the algorithm is O(1).

## Reverse every K-element Sub-list
- Leetcode Link [Reverse every K-element Sub-list](https://leetcode.com/problems/reverse-nodes-in-k-group/)

Given the head of a LinkedList and a number ‘k’, reverse every ‘k’ sized sub-list starting from the head. If, in the end, you are left with a sub-list with less than ‘k’ elements, reverse it too.

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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Edge cases
        if (k <= 1 || head == null) {
            return head;
        }

        ListNode current = head;
        ListNode previous = null;

        while (current != null) {
            // Step 1: Check if there are at least 'k' nodes left to reverse
            ListNode check = current;
            int count = 0;
            while (check != null && count < k) {
                check = check.next;
                count++;
            }
            if (count < k) {
                break; // Less than 'k' nodes remaining, no need to reverse
            }
            // Save the node before the 'k' elements to be reversed
            ListNode lastNodeOfPreviousPart = previous;

            // After reversing the LinkedList, 'current' will become the last node of the sublist
            ListNode lastNodeOfSubList = current;

            // Will be used to temporarily store the next node
            ListNode next = null;

            int i = 0;

            // Reverse 'k' nodes
            while (current != null && i < k) {
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
                i++;
            }

            // Connect with the previous part
            if (lastNodeOfPreviousPart != null) {
                lastNodeOfPreviousPart.next = previous;
            } else {
                head = previous;  // Update head when reversing the first part
            }

            // Connect with the next part
            lastNodeOfSubList.next = current;

            // Prepare for the next iteration
            previous = lastNodeOfSubList;
        }

        return head;
    }
}
```

* The time complexity of our algorithm will be O(N) where N is the total number of nodes in the LinkedList.
* We only used constant space, therefore, the space complexity of our algorithm is O(1).

## Reverse alternating K-element Sub-list (medium)

Given the head of a LinkedList and a number K, reverse every alternating K sized sub-list starting from the head.

If, in the end, you are left with a sub-list with less than K elements, reverse it too.

The problem follows the in-place Reversal of a LinkedList pattern and is quite similar to Reverse every K-element Sub-list. The only difference is that we have to skip K alternating elements. We can follow a similar approach, and in each iteration after reversing K elements, we will skip the next K elements.

```java
class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
        this.next = null;
    }

    // Helper function to print the linked list
    void printList() {
        Node temp = this;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class ReverseAlternateKElements {
    public static Node reverseAlternateKElements(Node head, int k) {
        if (head == null || k <= 1) return head;

        Node current = head;
        Node previous = null;

        while (current != null) {
            Node lastNodeOfPreviousPart = previous;
            Node lastNodeOfSubList = current;
            Node next = null;

            // Reverse `k` nodes
            int i = 0;
            while (current != null && i < k) {
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
                i++;
            }

            // Connect with the previous part
            if (lastNodeOfPreviousPart != null) {
                lastNodeOfPreviousPart.next = previous;
            } else {
                head = previous;
            }

            // Connect with the next part
            lastNodeOfSubList.next = current;

            // Skip `k` nodes
            i = 0;
            while (current != null && i < k) {
                previous = current;
                current = current.next;
                i++;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);

        System.out.print("Nodes of original LinkedList are: ");
        head.printList();

        Node result = reverseAlternateKElements(head, 2);
        System.out.print("Nodes of reversed LinkedList are: ");
        result.printList();
    }
}

```

# Combination of Fast & slow and In place Reversal Linked List Technique

## Palindrome Linked List

Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

```java
Input: 2 -> 4 -> 6 -> 4 -> 2 -> null
Output: true

Input: 2 -> 4 -> 6 -> 4 -> 2 -> 2 -> null
Output: false
```

As we know, a palindrome LinkedList will have nodes values that read the same backward or forward. This means that if we divide the LinkedList into two halves, the node values of the first half in the forward direction should be similar to the node values of the second half in the backward direction. As we have been given a Singly LinkedList, we can’t move in the backward direction. To handle this, we will perform the following steps:

* We can use the Fast & Slow pointers method similar to Middle of the LinkedList to find the middle node of the LinkedList.
* Once we have the middle of the LinkedList, we will reverse the second half.
* Then, we will compare the first half with the reversed second half to see if the LinkedList represents a palindrome.
* Finally, we will reverse the second half of the LinkedList again to revert and bring the LinkedList back to its original form.

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
    public boolean isPalindrome(ListNode head) {
        //find the midle of the linked list 
        //after that reverse the right of linked list 
        //we can assign one more entry pointer and chceck from slow and entry data 
        ListNode fast = head , slow = head , entry = head;
        //find the middle of linked list 
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //reverse the linked list 
        ListNode rightHalfHead = reverseLinkedList(slow);
        while(rightHalfHead != null){
            if(entry.val != rightHalfHead.val)
                return false;
            entry = entry.next;
            rightHalfHead = rightHalfHead.next;
        }
        return true;
    }
    public ListNode reverseLinkedList(ListNode head){
        ListNode prev1 = null , prev2 = null , curr = head;
        while(curr != null){
            prev1 = prev2;
            prev2 = curr;
            curr = curr.next;
            prev2.next = prev1;
        }
        return prev2;
    }
}
```

- The above algorithm will have a time complexity of O(N) where N is the number of nodes in the LinkedList.
- The algorithm runs in constant space O(1).

## Reorder List

You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln

Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …

You may not modify the values in the list's nodes. Only nodes themselves may be changed.

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
    public void reorderList(ListNode head) {
        //1. find the middle linked list using linked list 
        ListNode slow = head , fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //2.reverse the second half 
        ListNode secondHalf = reversed(slow.next);
        slow.next = null;
        mergeLinkedList(head , secondHalf);
        
    }
    void mergeLinkedList(ListNode l1 , ListNode l2){
        while(l2 != null){
            ListNode next1 = l1.next , next2 = l2.next;
            l1.next = l2;
            l2.next = next1;
            l1 = next1;
            l2 = next2;
        }
    }
    ListNode reversed(ListNode head){
        ListNode prev1 = null , prev2 = null , curr = head;
        while(curr != null){
            prev1 = prev2;
            prev2 = curr;
            curr = curr.next;
            prev2.next = prev1;
        }
        return prev2;
    }
}
```

Follow-up Questions 

- [Partition List](https://leetcode.com/problems/partition-list/description/)
- [Swap Nodes In Pairs](https://leetcode.com/problems/swap-nodes-in-pairs/description/) Same Question of Reverse every K-element Sub-list
- [Rotate List](https://leetcode.com/problems/rotate-list/description/) Hint : we shall convert Linked List into circular Linked List
- [Odd Even Linked List](https://leetcode.com/problems/odd-even-linked-list/description/)


