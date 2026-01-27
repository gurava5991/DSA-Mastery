What is linked list ?
Linked list is a linear data structure, which consists of a group of nodes in a sequence [OR] Linked list in which we store data in linear from
ut, Array also stores data in linear form. Then what's the difference!

In array we have to first define the size of the Array
Let's say:-
int arr[] = new int[8]
Array :- [10, 20, 15, 18, 16, 10, 20, 16]
And each bit has its memory address, where 1 bit size = 4, therefore 8 bit = 8 * 4 = 32 bit.
But linked list is dynamic, we don't have to define it's size.
Types of LinkedLists :
There are 4 types of Linked list we have , however we generally use 3types only.
1.Single-Linked-List:linked list in which each node points to next node and last nod points to null
2.Double-Linked-List : linked list in which each node have two pointers ,p and n . p points to previous node and n points to next node.
3.Circular-Linked-List: linked list in which each node points to next node and last node points back to first node.
4.Circular-Linked-List : linked list in which each node have two pointers p,n . p points to previous node and n points to next . here last node next points to fist and first node previous points to last node.
Leetcode 876 : Middle Of linked List
Problem Statement :-
Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explainations :
we will create two pointer slow and fast 
i) slow pointer will move at the speed of 1x
ii)fast pointer will move at the speed of 2x
if fast pointer reaches null , or fast.next is reaches null we should return slow pointer 
234. Palindrome Linked List
Problem Statement :-
Input: head = [1,2,2,1]
Output: true
Explanation:-
First we will get the mid so, that we can divide a linked list into two.
After that, we will reverse the half of the linked list
Then we have our slow pointer on new head & we will compare the value with old head i.e. head
We will check these value & move both the pointer's slow & head until slow reaches null.
If slow reaches null we will return true, otherwise false.
141. Linked List Cycle

Problem Statement :-
Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation:-
We will create 2 pointer's fast & slow
Fast pointer will move at the speed of 2X
Slow pointer will move at the speed of 1X
If fast pointer & slow pointer meet each other we will return true otherwise they there is no cycle we will return false!!

160. Intersection of Two Linked Lists

Problem Statement :-
Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
Output: Intersected at '8'
Explanation:-
So, what we doing is
Take 2 pointer's: pointer A walks through List A and List B (since once it hits null, it goes to List B's head).
Pointer B also walks through List B and List A.
Regardless of the length of the two lists, the sum of the lengths are the same (i.e. a+b = b+a), which means that the pointers sync up at the point of intersection.
If the lists never intersected, it's fine too, because they'll sync up at the end of each list, both of which are null.