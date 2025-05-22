# **📌 Java Stack (`Stack` vs `ArrayDeque`) - A Comprehensive Guide**

## **1️⃣ Introduction**
Java's Collection Framework provides a `Stack` class that models and implements a **stack data structure**. A stack follows the **Last-In-First-Out (LIFO)** principle, meaning the **last element inserted** is the **first one to be removed**.

However, **`Stack` is a legacy class** (inheriting from `Vector`) and is **synchronized**, which makes it thread-safe but incurs performance overhead.  
For better efficiency in single-threaded applications, **`ArrayDeque`** is recommended as a **faster alternative**.

---

## **2️⃣ Stack Class (`java.util.Stack`)**
### **✔ Key Methods**
| **Method** | **Description** | **Time Complexity** |
|------------|---------------|--------------------|
| `push(E e)` | Adds an element to the **top** of the stack | **O(1)** |
| `pop()` | Removes and returns the **top** element | **O(1)** |
| `peek()` | Returns the **top** element **without** removing it | **O(1)** |
| `empty()` | Checks if the stack is **empty** | **O(1)** |
| `search(Object o)` | Returns the **position** of an element from the **top** | **O(n)** |
| `size()` | Returns the **number of elements** in the stack | **O(1)** |

---

## **3️⃣ Example: Basic Stack Operations Using `ArrayDeque` (Recommended ✅)**
```java
import java.util.ArrayDeque;  // Import ArrayDeque class

public class StackExample {
    public static void main(String[] args) {
        // Using ArrayDeque as a Stack
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        // Pushing elements
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Peeking at the top element
        System.out.println("Top element: " + stack.peek()); // Output: 30

        // Popping elements
        System.out.println("Popped: " + stack.pop()); // Output: 30
        System.out.println("Top element after pop: " + stack.peek()); // Output: 20
    }
}
```
### **🔹 Output**
```
Top element: 30
Popped: 30
Top element after pop: 20
```

---

## **4️⃣ Example: Additional Stack Operations Using `ArrayDeque`**
```java
import java.util.ArrayDeque;

public class StackOperations {
    public static void main(String[] args) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        // Push elements
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Check size and emptiness
        System.out.println("Stack size: " + stack.size());  // Output: 3
        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: false
    }
}
```
### **🔹 Output**
```
Stack size: 3
Is stack empty? false
```

---

## **5️⃣ Why Use `ArrayDeque` Instead of `Stack`?**
| **Feature** | **`Stack` (Legacy)** | **`ArrayDeque` (Recommended ✅)** |
|------------|-----------------|---------------------|
| **Performance** | Slower (Synchronized, inherits from `Vector`) | Faster (Better memory & execution) |
| **Thread-Safety** | Thread-safe (but overhead) | Not thread-safe (use `Collections.synchronizedDeque()` for safety) |
| **Implementation** | Extends `Vector` (Inefficient) | Uses **resizable array** (Efficient) |
| **Recommended For** | **Multi-threaded environments** (Rare use case) | **General-purpose stack usage** |

---
### Stack Implementation Using Array, Linked List, and Two Queues

A **stack** is a linear data structure that follows the **LIFO (Last In, First Out)** principle. It supports the following primary operations:

1. **push(x)** → Insert an element in the stack.
2. **pop()** → Remove and return the topmost element of the stack.
3. **top()** → Returns the topmost element of the stack.
4. **size()** → Returns the number of remaining elements in the stack.
5. **isEmpty()** → Returns true if the stack is empty, otherwise false.

## 1. Stack Implementation Using Array

```java
class Stack {
    int size;
    int top;
    int[] arr;
    
    public Stack(int size) {
        this.size = size;
        this.top = -1;
        arr = new int[size];
    }

    public void push(int element) {
        if (top == size - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = element;
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[top--];
    }

    public int top() {
        return (top == -1) ? -1 : arr[top];
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
```

### Time Complexity:
- **Push:** O(1)
- **Pop:** O(1)
- **Top:** O(1)
- **Size:** O(1)

## 2. Stack Implementation Using Linked List

```java
class Node {
    int data;
    Node next;
    
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class StackLinkedList {
    private Node top;
    
    public StackLinkedList() {
        this.top = null;
    }
    
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }
    
    public int pop() {
        if (top == null) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int popped = top.data;
        top = top.next;
        return popped;
    }
    
    public int top() {
        return (top == null) ? -1 : top.data;
    }
    
    public boolean isEmpty() {
        return top == null;
    }
}
```

### Time Complexity:
- **Push:** O(1)
- **Pop:** O(1)
- **Top:** O(1)
- **Space Complexity:** O(n) (since each element requires a node)

## 3. Stack Implementation Using Two Queues

There are two approaches to implementing a stack using two queues:

### Approach 1: **Push Costly**

```java
import java.util.LinkedList;
import java.util.Queue;

class StackUsingQueuesPushCostly {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    
    public void push(int x) {
        q2.add(x);
        while (!q1.isEmpty()) {
            q2.add(q1.poll());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    
    public int pop() {
        return q1.isEmpty() ? -1 : q1.poll();
    }
    
    public int top() {
        return q1.isEmpty() ? -1 : q1.peek();
    }
    
    public boolean isEmpty() {
        return q1.isEmpty();
    }
}
```

### Approach 2: **Pop Costly**

```java
import java.util.LinkedList;
import java.util.Queue;

class StackUsingQueuesPopCostly {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    
    public void push(int x) {
        q1.add(x);
    }
    
    public int pop() {
        if (q1.isEmpty()) return -1;
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }
        int popped = q1.poll();
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return popped;
    }
    
    public int top() {
        if (q1.isEmpty()) return -1;
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }
        int top = q1.peek();
        q2.add(q1.poll());
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return top;
    }
    
    public boolean isEmpty() {
        return q1.isEmpty();
    }
}
```

### Time Complexity:
#### Push Costly Approach:
- **Push:** O(n) (as all elements need to be shifted to q2)
- **Pop:** O(1)

#### Pop Costly Approach:
- **Push:** O(1)
- **Pop:** O(n) (as we shift n-1 elements to q2)

## Conclusion
| Implementation | Push Complexity | Pop Complexity | Space Complexity |
|---------------|----------------|----------------|------------------|
| Array | O(1) | O(1) | O(n) |
| Linked List | O(1) | O(1) | O(n) |
| Two Queues (Push Costly) | O(n) | O(1) | O(n) |
| Two Queues (Pop Costly) | O(1) | O(n) | O(n) |




### **Delete Mid of a Stack**
Given a stack s, delete the **middle element** of the stack without using any **additional data structure**.

Middle element:- **floor((size_of_stack+1)/2)** (1-based indexing) from the bottom of the stack.

Note: The output shown by the compiler is the stack from top to bottom.  

We can solve this problem **recursively** by:
1. **Finding the middle index** using `(size_of_stack + 1) / 2` (1-based index).
2. **Recursively popping elements** until we reach the middle.
3. **Removing the middle element**.
4. **Pushing the popped elements back** in their original order.

---

### **Algorithm**
1. **Base Case**: If we reach the middle index, remove that element.
2. **Recursive Case**: Pop elements from the stack and recurse until we reach the middle.
3. **Push back the elements** after deleting the middle one to maintain the original order.

### **Java Implementation**
```java
import java.util.Stack;

class Solution {
    public void deleteMid(Stack<Integer> s, int size) {
        int mid = (size + 1) / 2;  // 1-based middle index
        if(size % 2 == 0)
            mid++;
        deleteMiddleHelper(s, mid);
    }

    private void deleteMiddleHelper(Stack<Integer> s, int k) {
        // Base case: Remove middle element
        if (k == 1) {
            s.pop();
            return;
        }

        // Store top element and remove it temporarily
        int top = s.pop();

        // Recursive call to reach the middle
        deleteMiddleHelper(s, k - 1);

        // Push back stored element after middle deletion
        s.push(top);
    }

    // Utility function to print stack (for testing)
    public static void printStack(Stack<Integer> s) {
        if (s.isEmpty()) return;
        int x = s.pop();
        printStack(s);
        System.out.print(x + " ");
        s.push(x);
    }

    // Main function for testing
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        Solution solution = new Solution();
        solution.deleteMid(stack, stack.size());

        // Print stack after deletion
        printStack(stack);
    }
}
```
---

### **Dry Run Example**
#### **Input Stack (Bottom to Top):**
`1 2 3 4 5`
#### **Steps:**
1. Pop `5`, recurse.
2. Pop `4`, recurse.
3. Pop `3` (**Middle Element, Remove It**).
4. Push `4` back.
5. Push `5` back.

#### **Final Output (Top to Bottom):**
`5 4 2 1`

---

### **Time and Space Complexity**
- **Time Complexity:** `O(N)` (since we pop and push N/2 elements).
- **Space Complexity:** `O(N)` (due to recursive call stack).

---
### **Reversing an Array Using Stack in Java**

1. **Push all elements of the array into a stack** → The last element goes to the top.
2. **Pop elements from the stack back into the array** → Since the stack follows LIFO, the last inserted element comes out first, effectively reversing the array.

---

```java
import java.util.*;

class ReverseArrayUsingStack {
    public static void reverseArray(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        // Step 1: Push all elements into the stack
        for (int num : arr) {
            stack.push(num);
        }

        // Step 2: Pop elements back into the array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        
        System.out.println("Original Array: " + Arrays.toString(arr));
        
        reverseArray(arr);
        
        System.out.println("Reversed Array: " + Arrays.toString(arr));
    }
}
```

---

## **Step-by-Step Dry Run**
**Input Array:**  
`[1, 2, 3, 4, 5]`

### **Step 1: Push Elements into the Stack**
| Operation  | Stack (Top → Bottom) |
|------------|----------------------|
| Push(1)    | `1`                  |
| Push(2)    | `2, 1`               |
| Push(3)    | `3, 2, 1`            |
| Push(4)    | `4, 3, 2, 1`         |
| Push(5)    | `5, 4, 3, 2, 1`      |

### **Step 2: Pop Elements Back into the Array**
| Operation  | Stack (Top → Bottom) | Modified Array |
|------------|----------------------|---------------|
| Pop() → 5  | `4, 3, 2, 1`         | `[5, _, _, _, _]` |
| Pop() → 4  | `3, 2, 1`            | `[5, 4, _, _, _]` |
| Pop() → 3  | `2, 1`               | `[5, 4, 3, _, _]` |
| Pop() → 2  | `1`                  | `[5, 4, 3, 2, _]` |
| Pop() → 1  | `Empty`              | `[5, 4, 3, 2, 1]` |

**Final Output:**  
`[5, 4, 3, 2, 1]` ✅ (Reversed Array)

---

## **Time Complexity Analysis**
- **Pushing all elements into the stack** → `O(n)`
- **Popping all elements back into the array** → `O(n)`
- **Total Complexity** → **`O(n)`**

## **Space Complexity**
- **Stack stores `n` elements** → **`O(n)`** (extra space)

---

## ** Get Min At Pop


### **Efficient Approach: Using an Auxiliary Stack**
We can use an **auxiliary stack (`minStack`)** to keep track of the minimum element at each step.

#### **Approach**
1. **Push elements into the main stack (`stack`)** while also maintaining a **minimum stack (`minStack`)**:
    - If the stack is empty, push the current element into `minStack`.
    - Otherwise, push the **minimum** of the current element and the top of `minStack`.
2. **Pop elements from the main stack** and **print the top of `minStack`**, which represents the minimum at that moment.
3. **Pop the top of `minStack` simultaneously** to maintain correctness.

---

### **Java Implementation**
```java
import java.util.*;

class MinStack {
    public static void minAtEachPop(int[] A) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack = new Stack<>(); // To track minimum values

        // Push elements into both stacks
        for (int num : A) {
            stack.push(num);
            if (minStack.isEmpty()) {
                minStack.push(num);
            } else {
                minStack.push(Math.min(num, minStack.peek()));
            }
        }

        // Pop elements and print the min value
        while (!stack.isEmpty()) {
            System.out.println(minStack.peek()); // Print minimum value
            stack.pop();
            minStack.pop();
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 6, 2, 4, 5};
        minAtEachPop(A);
    }
}
```

---

### **Dry Run**
#### **Input**
```plaintext
A = {1, 6, 2, 4, 5}
```
#### **Step 1: Push Elements into Both Stacks**
| Operation | Stack (Top → Bottom) | Min Stack (Top → Bottom) |
|-----------|----------------------|--------------------------|
| Push(1)   | `1`                  | `1`                      |
| Push(6)   | `6, 1`               | `1, 1`                   |
| Push(2)   | `2, 6, 1`            | `1, 1, 1`                |
| Push(4)   | `4, 2, 6, 1`         | `1, 1, 1, 1`             |
| Push(5)   | `5, 4, 2, 6, 1`      | `1, 1, 1, 1, 1`          |

#### **Step 2: Pop Elements and Print Min**
| Pop Operation | Stack (Top → Bottom) After Pop | Min Stack (Top → Bottom) After Pop | Printed Min |
|--------------|--------------------------------|----------------------------------|-------------|
| Pop() → 5   | `4, 2, 6, 1`                   | `1, 1, 1, 1`                     | **1**       |
| Pop() → 4   | `2, 6, 1`                      | `1, 1, 1`                        | **1**       |
| Pop() → 2   | `6, 1`                         | `1, 1`                           | **1**       |
| Pop() → 6   | `1`                            | `1`                              | **1**       |
| Pop() → 1   | `Empty`                        | `Empty`                          | **1**       |

#### **Final Output**
```plaintext
1
1
1
1
1
```
This means that at each pop operation, the minimum in the stack remained **1**.

---

### **Time Complexity Analysis**
- **Pushing each element** takes **O(1)**.
- **Popping each element** takes **O(1)**.
- **Total Complexity:** **O(n)**

### **Space Complexity Analysis**
- We use an **extra stack (`minStack`)**, which requires **O(n)** space.
- **Total Space Complexity:** **O(n)**

---

### **Alternative Approach: Using a Single Stack (Space-Optimized)**
Instead of maintaining two stacks (`stack` and `minStack`), we can store the **minimum value within the stack itself** using an **encoding technique**.

#### **key Observation from the above problem**
- We maintain a `minValue` variable to track the minimum element.
- If a new element **is smaller than `minValue`**, we store a **modified value** in the stack.
- When popping, if we detect that the stored value was modified, we **restore the old `minValue`**.

---

### **How Encoding Works?**
1. **If the stack is empty**, push the first element as `minValue`.
2. **If the new element is smaller than `minValue`**, store a **modified value**:
    - `2 * new_value - minValue`
    - Update `minValue` to the new element.
3. **While popping**, check:
    - If the popped value is **less than `minValue`**, it was **a modified value**.
    - Restore `minValue` using:  
      `minValue = 2 * minValue - popped_value`

This technique allows us to use **only one stack while keeping track of the minimum**.

---

### **Java Implementation**
```java
import java.util.*;

class MinStackOptimized {
    static int minValue; // Stores the current minimum value

    public static void minAtEachPop(int[] A) {
        Stack<Integer> stack = new Stack<>();
        minValue = Integer.MAX_VALUE;

        // Push elements with encoding
        for (int num : A) {
            if (stack.isEmpty()) {
                minValue = num;
                stack.push(num);
            } else {
                if (num < minValue) {  // Encoding step
                    stack.push(2 * num - minValue);
                    minValue = num;
                } else {
                    stack.push(num);
                }
            }
        }

        // Pop elements and print minimum
        while (!stack.isEmpty()) {
            System.out.println(minValue);

            int popped = stack.pop();
            if (popped < minValue) { // Restore previous min
                minValue = 2 * minValue - popped;
            }
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 6, 2, 4, 5};
        minAtEachPop(A);
    }
}
```

---

### **Dry Run**
#### **Input:**
```plaintext
A = {1, 6, 2, 4, 5}
```
#### **Step 1: Push Elements into Stack**
| Operation | Stack (Top → Bottom) | minValue |
|-----------|----------------------|----------|
| Push(1)   | `1`                  | `1`      |
| Push(6)   | `6, 1`               | `1`      |
| Push(2)   | `2, 6, 1`            | `1`      |
| Push(4)   | `4, 2, 6, 1`         | `1`      |
| Push(5)   | `5, 4, 2, 6, 1`      | `1`      |

#### **Step 2: Pop Elements and Print Min**
| Pop Operation | Stack After Pop | minValue Before Pop | minValue After Pop | Printed Min |
|--------------|----------------|----------------------|---------------------|-------------|
| Pop() → 5   | `4, 2, 6, 1`   | `1`                  | `1`                 | **1**       |
| Pop() → 4   | `2, 6, 1`      | `1`                  | `1`                 | **1**       |
| Pop() → 2   | `6, 1`         | `1`                  | `1`                 | **1**       |
| Pop() → 6   | `1`            | `1`                  | `1`                 | **1**       |
| Pop() → 1   | `Empty`        | `1`                  | `Empty`             | **1**       |

#### **Final Output**
```plaintext
1
1
1
1
1
```
---

### **Time Complexity Analysis**
- **Pushing elements** → **O(1)**
- **Popping elements** → **O(1)**
- **Total Complexity:** **O(n)**

### **Space Complexity Analysis**
- **Only one stack (`O(n)`) instead of two stacks (`O(2n)`)**
- **Total Space Complexity:** **O(n)** (but no extra stack for `minStack`)

---

### **Comparison Between Two Approaches**
| Approach  | Time Complexity | Space Complexity | Extra Stack? |
|-----------|---------------|----------------|-------------|
| **Two Stacks** (Original) | O(n) | O(n) | ✅ Yes (`minStack`) |
| **Single Stack (Optimized)** | O(n) | O(n) | ❌ No Extra Stack |

**The single-stack approach is more space-efficient but slightly harder to understand.**

### ** Check for Balanced Parenthesis : **
Given a string containing just the characters `'(', ')', '{', '}', '[' and ']'`, determine if the input string is valid.  
An input string is valid if:
1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.
3. Every close bracket has a corresponding open bracket of the same type.

---

### **Approach: Using Stack**
1. **Use a stack** to keep track of opening brackets.
2. **Iterate through the string**:
   - If the character is an **opening bracket** (`(`, `{`, `[`), push it onto the stack.
   - If the character is a **closing bracket** (`)`, `}`, `]`):
      - Check if the stack is **empty** (which means there's no matching opening bracket) → **return false**.
      - Pop from the stack and check if it matches the expected closing bracket.
3. **After iterating**, the stack should be **empty** for the string to be balanced.

---

### **Implementation in Java**
```java
import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> brackets = Map.of(')', '(', '}', '{', ']', '[');

        for (char c : s.toCharArray()) {
            if (brackets.containsKey(c)) { // If it's a closing bracket
                if (stack.isEmpty() || stack.pop() != brackets.get(c)) {
                    return false;
                }
            } else { // If it's an opening bracket
                stack.push(c);
            }
        }

        return stack.isEmpty(); // Stack must be empty for valid parentheses
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("()"));        // true
        System.out.println(solution.isValid("()[]{}"));    // true
        System.out.println(solution.isValid("(]"));        // false
        System.out.println(solution.isValid("([)]"));      // false
        System.out.println(solution.isValid("{[]}"));      // true
    }
}
```

---

### **Dry Run Example**
#### **Input:** `s = "{[()]}"`

| Character | Stack Before | Action | Stack After |
|-----------|-------------|--------|-------------|
| `{`       | `[]`        | Push   | `[{]`       |
| `[`       | `[{]`       | Push   | `[{[]`      |
| `(`       | `[{[]`      | Push   | `[{[(]`     |
| `)`       | `[{[(]`     | Pop & Check (`(` matches) | `[{[]`      |
| `]`       | `[{[]`      | Pop & Check (`[` matches) | `[{]`       |
| `}`       | `[{]`       | Pop & Check (`{` matches) | `[]`        |

**Stack is empty at the end → Valid Parentheses ✅**

---

### **Time Complexity Analysis**
- **O(n)**: We iterate over the string once.
- Each operation (push/pop) in a stack is **O(1)**.
- **Overall Complexity: O(n).**

### **Space Complexity Analysis**
- **O(n)**: In the worst case, we might store all characters in the stack.

---

---
### **Expression Evaluation and Conversion Techniques**

In expression evaluation, different notations exist to represent mathematical expressions. The three primary types are **Infix, Prefix, and Postfix**. Understanding these notations and conversions between them is crucial for parsing and evaluating expressions efficiently using stacks.

---

## **1. Notations in Expressions**
### **(i) Infix Notation**
- The standard mathematical notation.
- Operators are written between operands.
- Example: `A + B * C`

### **(ii) Prefix Notation (Polish Notation)**
- Operators appear before operands.
- No need for parentheses.
- Example: `+ A * B C` (Equivalent to `A + (B * C)`)

### **(iii) Postfix Notation (Reverse Polish Notation)**
- Operators appear after operands.
- No need for parentheses.
- Example: `A B C * +` (Equivalent to `A + (B * C)`)

---

## **2. Conversion Between Notations**
### **(i) Infix to Postfix Conversion**
#### **Algorithm:**
1. Initialize an empty stack for operators and an empty result string.
2. Scan the infix expression from left to right.
3. If the scanned character is an operand, append it to the result.
4. If the scanned character is an operator:
    - Pop from the stack to the result while stack operators have higher precedence.
    - Push the current operator onto the stack.
5. If the scanned character is `(`, push it onto the stack.
6. If the scanned character is `)`, pop operators until `(` is encountered.
7. Pop all remaining operators and append to the result.

#### **Code (Java):**
```java
import java.util.*;

class InfixToPostfix {
    static int precedence(char ch) {
        switch (ch) {
            case '+': case '-': return 1;
            case '*': case '/': return 2;
            case '^': return 3;
        }
        return -1;
    }

    static String convert(String exp) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : exp.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String infix = "A+(B*C)";
        System.out.println("Postfix: " + convert(infix));  // Output: ABC*+
    }
}
```
---
### **(ii) Infix to Prefix Conversion**
#### **Algorithm:**
1. Reverse the infix expression.
2. Convert it to postfix using the above method.
3. Reverse the obtained postfix expression.

#### **Code (Java):**
```java
class InfixToPrefix {
    static String reverse(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    static String infixToPrefix(String infix) {
        infix = reverse(infix);
        infix = infix.replace('(', '#').replace(')', '(').replace('#', ')');
        String postfix = InfixToPostfix.convert(infix);
        return reverse(postfix);
    }

    public static void main(String[] args) {
        String infix = "A+(B*C)";
        System.out.println("Prefix: " + infixToPrefix(infix));  // Output: +A*BC
    }
}
```
---
### **(iii) Postfix to Infix Conversion**
#### **Algorithm:**
1. Use a stack.
2. Scan the postfix expression.
3. If an operand is encountered, push it onto the stack.
4. If an operator is encountered, pop two elements from the stack, form a new infix expression, and push it back onto the stack.
5. The final stack element is the result.

#### **Code (Java):**
```java
class PostfixToInfix {
    static String convert(String postfix) {
        Stack<String> stack = new Stack<>();

        for (char ch : postfix.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                stack.push(ch + "");
            } else {
                String b = stack.pop();
                String a = stack.pop();
                stack.push("(" + a + ch + b + ")");
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String postfix = "ABC*+";
        System.out.println("Infix: " + convert(postfix));  // Output: (A+(B*C))
    }
}
```
---
### **(iv) Prefix to Infix Conversion**
#### **Algorithm:**
1. Use a stack.
2. Scan the prefix expression from **right to left**.
3. If an operand is encountered, push it onto the stack.
4. If an operator is encountered, pop two elements, form an infix expression, and push it back.
5. The final stack element is the result.

#### **Code (Java):**
```java
class PrefixToInfix {
    static String convert(String prefix) {
        Stack<String> stack = new Stack<>();
        for (int i = prefix.length() - 1; i >= 0; i--) {
            char ch = prefix.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                stack.push(ch + "");
            } else {
                String a = stack.pop();
                String b = stack.pop();
                stack.push("(" + a + ch + b + ")");
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String prefix = "+A*BC";
        System.out.println("Infix: " + convert(prefix));  // Output: (A+(B*C))
    }
}
```
---
### **(v) Postfix to Prefix Conversion**
#### **Algorithm:**
1. Use a stack.
2. Scan the postfix expression.
3. If an operand is encountered, push it onto the stack.
4. If an operator is encountered, pop two elements, form a prefix expression, and push it back onto the stack.
5. The final stack element is the result.

#### **Code (Java):**
```java
class PostfixToPrefix {
    static String convert(String postfix) {
        Stack<String> stack = new Stack<>();
        for (char ch : postfix.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                stack.push(ch + "");
            } else {
                String b = stack.pop();
                String a = stack.pop();
                stack.push(ch + a + b);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String postfix = "ABC*+";
        System.out.println("Prefix: " + convert(postfix));  // Output: +A*BC
    }
}
```
---
### **(vi) Prefix to Postfix Conversion**
#### **Algorithm:**
1. Use a stack.
2. Scan the prefix expression from **right to left**.
3. If an operand is encountered, push it onto the stack.
4. If an operator is encountered, pop two elements, form a postfix expression, and push it back onto the stack.
5. The final stack element is the result.

#### **Code (Java):**
```java
class PrefixToPostfix {
    static String convert(String prefix) {
        Stack<String> stack = new Stack<>();
        for (int i = prefix.length() - 1; i >= 0; i--) {
            char ch = prefix.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                stack.push(ch + "");
            } else {
                String a = stack.pop();
                String b = stack.pop();
                stack.push(a + b + ch);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String prefix = "+A*BC";
        System.out.println("Postfix: " + convert(prefix));  // Output: ABC*+
    }
}
```
---
### **Complexity Analysis**
All the above operations run in **O(N)** time with **O(N) space** due to stack usage.

---


### **Monotonic Stack Pattern**

### **What is a Monotonic Stack?**
A monotonic stack is a stack that maintains its elements in either increasing or decreasing order. It is useful for solving problems that involve the **Next Greater Element (NGE), Previous Greater Element (PGE), Next Smaller Element (NSE), and Previous Smaller Element (PSE).**

---

## **Types of Monotonic Stacks**

### **1. Monotonic Increasing Stack**
- Maintains elements in **increasing order** (smallest element on top).
- **Used for:** Finding **Next Smaller Element (NSE) and Previous Smaller Element (PSE).**
- **How it works:**
   - As we traverse the array, we pop elements from the stack **until we find a smaller element**.
   - This ensures the stack remains increasing.

📌 **Example Problems:**
1. **Next Smaller Element (NSE)** - Find the first smaller element to the right of each element.
2. **Previous Smaller Element (PSE)** - Find the first smaller element to the left of each element.
3. **Largest Rectangle in Histogram** - Determines left and right boundaries of bars.
4. **Trapping Rain Water** - Determines water levels between bars.

---

### **2. Monotonic Decreasing Stack**
- Maintains elements in **decreasing order** (largest element on top).
- **Used for:** Finding **Next Greater Element (NGE) and Previous Greater Element (PGE).**
- **How it works:**
   - As we traverse the array, we pop elements from the stack **until we find a greater element**.
   - This ensures the stack remains decreasing.

📌 **Example Problems:**
1. **Next Greater Element (NGE)** - Find the first greater element to the right of each element.
2. **Previous Greater Element (PGE)** - Find the first greater element to the left of each element.
3. **Stock Span Problem** - Number of consecutive days the stock price was lower in the past.
4. **Daily Temperatures** - Number of days until the next warmer temperature.

---

## **Key Differences Between Increasing and Decreasing Stacks**

| Stack Type                  | Maintains Order | Used For                           | Example Problems |
|-----------------------------|----------------|------------------------------------|-----------------|
| **Monotonic Increasing**     | Increasing     | NSE, PSE, Histogram, Rainwater    | Largest Rectangle |
| **Monotonic Decreasing**     | Decreasing     | NGE, PGE, Stock Span, Temperature | Stock Span |

---

## **When to Use a Non-Increasing or Non-Decreasing Stack?**

- **Non-Increasing Stack** (Decreasing order with duplicates allowed): Used when elements must be **in non-increasing order**, meaning duplicates are **allowed**.
   - **Example**: Counting buildings that can see sunlight.

- **Non-Decreasing Stack** (Increasing order with duplicates allowed): Used when elements must be **in non-decreasing order**, meaning duplicates are **allowed**.
   - **Example**: Sliding Window Minimum.

---

# Next Greater and Smaller Elements using Monotonic Stack

## Introduction
The **Monotonic Stack** is a powerful technique for solving problems related to finding the next or previous greater/smaller elements in an array efficiently. Instead of using a brute-force approach with nested loops, we can leverage a stack to achieve an optimal time complexity of **O(n)**.

---
## 1. Next Greater Element (NGE)
For each element in the array, find the next greater element (i.e., the first element to the right that is greater than the current element). If no such element exists, return -1.

### Approach:
- Traverse the array from **right to left**.
- Use a **monotonic decreasing stack** (stores elements in decreasing order).
- While the top of the stack is smaller than or equal to the current element, pop it.
- If the stack is empty, assign **-1** as there is no greater element.
- Otherwise, the top of the stack is the next greater element.
- Push the current element onto the stack.

### Code Implementation (Java):
```java
class Solution {
    public int[] nextGreaterElement(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }
            result[i] = st.isEmpty() ? -1 : st.peek();
            st.push(arr[i]);
        }
        return result;
    }
}
```

---
## 2. Previous Greater Element (PGE)
For each element in the array, find the previous greater element (i.e., the first element to the left that is greater than the current element). If no such element exists, return -1.

### Approach:
- Traverse the array from **left to right**.
- Use a **monotonic decreasing stack**.
- Follow a similar logic to NGE but track previous elements instead.

### Code Implementation (Java):
```java
class Solution {
    public int[] previousGreaterElement(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }
            result[i] = st.isEmpty() ? -1 : st.peek();
            st.push(arr[i]);
        }
        return result;
    }
}
```

---
## 3. Next Smaller Element (NSE)
For each element in the array, find the next smaller element (i.e., the first element to the right that is smaller than the current element). If no such element exists, return -1.

### Approach:
- Traverse the array from **right to left**.
- Use a **monotonic increasing stack** (stores elements in increasing order).
- Follow a similar logic to NGE but track smaller elements instead.

### Code Implementation (Java):
```java
class Solution {
    public int[] nextSmallerElement(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() >= arr[i]) {
                st.pop();
            }
            result[i] = st.isEmpty() ? -1 : st.peek();
            st.push(arr[i]);
        }
        return result;
    }
}
```

---
## 4. Previous Smaller Element (PSE)
For each element in the array, find the previous smaller element (i.e., the first element to the left that is smaller than the current element). If no such element exists, return -1.

### Approach:
- Traverse the array from **left to right**.
- Use a **monotonic increasing stack**.
- Follow a similar logic to NSE but track previous elements instead.

### Code Implementation (Java):
```java
class Solution {
    public int[] previousSmallerElement(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && st.peek() >= arr[i]) {
                st.pop();
            }
            result[i] = st.isEmpty() ? -1 : st.peek();
            st.push(arr[i]);
        }
        return result;
    }
}
```

---
## Summary Table
| Operation | Stack Type | Traversal Order |
|-----------|-----------|----------------|
| Next Greater Element (NGE) | Monotonic Decreasing | Right to Left |
| Previous Greater Element (PGE) | Monotonic Decreasing | Left to Right |
| Next Smaller Element (NSE) | Monotonic Increasing | Right to Left |
| Previous Smaller Element (PSE) | Monotonic Increasing | Left to Right |

---
## Time Complexity
Each element is pushed and popped at most once, so the overall complexity is **O(n)**.

## Space Complexity
The stack stores at most **O(n)** elements in the worst case.

---
## Next Greater Element - II

### **Intuition:**

The problem is a variation of the **Next Greater Element (NGE)** where the array is circular. This means that for each element, we need to consider the elements both to the right and also wrap around to the beginning of the array.

### **Approach:**

1. **Using Monotonic Stack:**

    - We use a **decreasing monotonic stack**, meaning that we push elements onto the stack only if they are smaller than the current element.
    - If we encounter a greater element, we pop elements from the stack until we find an element greater than the current one (this ensures that we maintain only useful elements in the stack).
    - If the stack is empty after popping, it means there is no greater element to the right, so we store `-1`.

2. **Handling Circular Nature:**

    - Since the array is circular, we **traverse the array twice**:
        - First pass to fill NGE for the normal array.
        - Second pass ensures that the elements at the beginning of the array get a chance to find an NGE from the latter part of the array.

3. **Why Two Passes?**

    - In the first pass, we store the NGE for elements where the greater element exists to their right.
    - The second pass ensures that if an element didn’t find an NGE in the first pass, it gets a second chance from elements at the beginning.

---


### **Code Explanation:**

```java
class Solution {
    public int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];

        Deque<Integer> st = new ArrayDeque<>();
        
        // Process twice to handle circular nature
        nge(arr, result, st);
        nge(arr, result, st);
        
        return result;
    }

    public void nge(int[] arr, int[] result, Deque<Integer> st) {
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }
            result[i] = st.isEmpty() ? -1 : st.peek();
            st.push(arr[i]);
        }
    }
}
```
---
### **Dry Run Example:**

#### **Input:**

```java
arr = [1, 2, 1];
```

#### **Step-by-Step Execution:**

1. First Pass:

    - `1` → Push into stack.
    - `2` → Pop `1` from stack (since `2 > 1`), then push `2`.
    - `1` → Stack is not empty, `NGE = 2`, then push `1`.

   **Result after first pass:** `[2, -1, 2]`

2. Second Pass:

    - It ensures that elements at the beginning get another chance to find an NGE.

#### **Final Output:**

```
[2, -1, 2]
```
---

### **Time and Space Complexity:**

- **Time Complexity:**
    - Each element is pushed and popped from the stack at most once, making the complexity **O(N)**.
    - Since we traverse the array **twice**, the overall complexity is **O(2N) = O(N)**.
- **Space Complexity:**
    - **O(N)** for the `result` array.
    - **O(N)** for the stack in the worst case (when elements are strictly decreasing).
    - So, overall space complexity is **O(N)**.

---

### * 1106. Parsing A Boolean Expression*
```text
A boolean expression is an expression that evaluates to either true or false. It can be in one of the following shapes:

't' that evaluates to true.
'f' that evaluates to false.
'!(subExpr)' that evaluates to the logical NOT of the inner expression subExpr.
'&(subExpr1, subExpr2, ..., subExprn)' that evaluates to the logical AND of the inner expressions subExpr1, subExpr2, ..., subExprn where n >= 1.
'|(subExpr1, subExpr2, ..., subExprn)' that evaluates to the logical OR of the inner expressions subExpr1, subExpr2, ..., subExprn where n >= 1.
Given a string expression that represents a boolean expression, return the evaluation of that expression.

It is guaranteed that the given expression is valid and follows the given rules.
```
```text
Example 1:

Input: expression = "&(|(f))"
Output: false
Explanation: 
First, evaluate |(f) --> f. The expression is now "&(f)".
Then, evaluate &(f) --> f. The expression is now "f".
Finally, return false.
Example 2:

Input: expression = "|(f,f,f,t)"
Output: true
Explanation: The evaluation of (false OR false OR false OR true) is true.
Example 3:

Input: expression = "!(&(f,t))"
Output: true
Explanation: 
First, evaluate &(f,t) --> (false AND true) --> false --> f. The expression is now "!(f)".
Then, evaluate !(f) --> NOT false --> true. We return true.
 

Constraints:

1 <= expression.length <= 2 * 104
expression[i] is one following characters: '(', ')', '&', '|', '!', 't', 'f', and ','.
```




















