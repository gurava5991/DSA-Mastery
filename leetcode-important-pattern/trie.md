# 📘 **Trie (Prefix Tree)**

## ⭐ **1. What is a Trie?**

A **Trie** (pronounced "try") is a **tree-based data structure** used to store strings efficiently, especially when many strings share **common prefixes**.

It is widely used for:

* Auto-complete
* Spell checking
* Prefix search
* IP routing
* Dictionary word storage

---

# ⭐ **2. Structure of a Trie**

Each node contains:

* **Links/children** → map or array to next character nodes
* **isEndOfWord flag** → marks the end of a valid word
* (Optional) count fields (for prefix counting)

### Example Node in Java:

```java
class Node {
    Node[] links = new Node[26];   // for lowercase a-z
    boolean isEnd = false;

    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }
    Node get(char ch) {
        return links[ch - 'a'];
    }
    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }
}
```

---

# ⭐ **3. Trie Class**

```java
class Trie {
    Node root;

    Trie() {
        root = new Node();
    }

    // insert, search, startsWith ...
}
```

---

# ⭐ **4. Operations on Trie**

## ✔ **A) Insert a Word**

### **Goal:** Insert characters one by one.

If a character doesn't exist → create a new node.

### Pseudocode:

```
node = root
for each char in word:
    if node does not contain char:
        create new node
    node = node.get(char)
mark isEndOfWord = true
```

### Java Implementation:

```java
public void insert(String word) {
    Node node = root;
    for (char ch : word.toCharArray()) {
        if (!node.containsKey(ch)) {
            node.put(ch, new Node());
        }
        node = node.get(ch);
    }
    node.isEnd = true;
}
```

---

## ✔ **B) Search a Word**

### **Goal:** Check if a word exists in the Trie.

### Pseudocode:

```
node = root
for each char in word:
    if char not in trie:
        return false
return node.isEndOfWord
```

### Java Code:

```java
public boolean search(String word) {
    Node node = root;
    for (char ch : word.toCharArray()) {
        if (!node.containsKey(ch)) return false;
        node = node.get(ch);
    }
    return node.isEnd;
}
```

---

## ✔ **C) Prefix Search (`startsWith`)**

Check if a prefix exists (used for auto-complete).

### Java Code:

```java
public boolean startsWith(String prefix) {
    Node node = root;
    for (char ch : prefix.toCharArray()) {
        if (!node.containsKey(ch)) return false;
        node = node.get(ch);
    }
    return true;
}
```

---

# ⭐ **5. Complexity Analysis**

| Operation     | Time Complexity | Space Complexity     |
| ------------- | --------------- | -------------------- |
| Insert a word | **O(L)**        | O(L × alphabet_size) |
| Search a word | **O(L)**        | —                    |
| Prefix search | **O(L)**        | —                    |

Where **L = length of word/prefix**.

---

# ⭐ **6. Advantages of Trie**

* **Very fast prefix queries**
* Searching is based on characters, not entire words
* Useful when storing **large dictionaries**
* Avoids repeated storage of prefixes (memory efficient for similar words)

---

# ⭐ **7. Disadvantages**

* Consumes more memory than a hash table due to node pointers
* Implementation is more complex
* For sparse datasets, memory is wasted

---

# ⭐ **8. Applications of Trie**

1. **Autocomplete Systems**
2. **Search Engines**
3. **Spell Checkers**
4. **IP Routing (Longest prefix match)**
5. **Word Games (Boggle, Scrabble)**
6. **Pattern Matching**
7. **Storing sorted dictionaries**

---

# ⭐ **9. Variants of Trie**

| Variant                          | Purpose                               |
| -------------------------------- | ------------------------------------- |
| **Compressed Trie / Radix Tree** | Compresses long chains to save memory |
| **Suffix Trie**                  | Used for substring search             |
| **Patricia Trie**                | Space-optimized (bitwise)             |
| **Ternary Search Tree**          | Stores characters in BST nodes        |

---

# ⭐ **10 Java Implementation (Trie + Node)**

```java
class Node {
    Node[] links = new Node[26];
    boolean isEnd = false;

    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }
    Node get(char ch) {
        return links[ch - 'a'];
    }
    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }
}

class Trie {
    Node root;

    Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
                node.put(ch, new Node());
            }
            node = node.get(ch);
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) return false;
            node = node.get(ch);
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for (char ch : prefix.toCharArray()) {
            if (!node.containsKey(ch)) return false;
            node = node.get(ch);
        }
        return true;
    }
}
```

---

# ⭐ **11. Visualization**

```
Insert: "cat", "cap", "dog"

root
 ├── c
 │    └── a
 │         ├── t*
 │         └── p*
 └── d
      └── o
           └── g*
```

`*` marks end of word.

---# ✅ **TRIE – ADVANCED PATTERNS & PROBLEMS**
✔ Advanced Trie Operations <br>
✔ Longest Word With All Prefixes <br>
✔ Longest Common Prefix <br>
✔ Number of Distinct Substrings <br>
✔ Maximum XOR of Two Numbers <br>
✔ Maximum XOR With an Element <br>
✔ Longest Common Prefix Length Between Arrays <br>
✔ Lexicographical Numbers <br>



---

# 📘 **🔥 TRIE – ADVANCED DOCUMENTATION (INTERVIEW LEVEL)**

![Image](https://media.geeksforgeeks.org/wp-content/uploads/20220828232752/Triedatastructure1.png?utm_source=chatgpt.com)

![Image](https://he-s3.s3.amazonaws.com/media/uploads/fb14630.png?utm_source=chatgpt.com)

---

# 1️⃣ **Basic Trie Implementation**

### **Node Structure**

```java
class Node {
    Node[] links = new Node[26];
    boolean isEnd = false;

    boolean containsKey(char ch) { return links[ch - 'a'] != null; }
    Node get(char ch) { return links[ch - 'a']; }
    void put(char ch, Node node) { links[ch - 'a'] = node; }
}
```

### **Trie Class**

```java
class Trie {
    Node root = new Node();

    public void insert(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
                node.put(ch, new Node());
            }
            node = node.get(ch);
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) return false;
            node = node.get(ch);
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for (char ch : prefix.toCharArray()) {
            if (!node.containsKey(ch)) return false;
            node = node.get(ch);
        }
        return true;
    }
}
```

---

# 2️⃣ **Longest Word With All Prefixes**

**Problem:**
Given words like → `["n","ni","nin","ninj","ninja","ninga"]`
Find the **longest word such that ALL prefixes exist**.

✔ Result → `"ninja"`

### **Approach**

* Insert all words in Trie
* While inserting, maintain `countPrefix` (or simply check search(prefix))
* For each word, verify all prefixes are valid words.

### Implementation

```java
class Node {
    // To store references to child nodes
    Node[] links = new Node[26];
    // Flag to indicate end of a word
    boolean flag = false;

    // Checks if the current character link exists
    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    // Returns the next node corresponding to the character
    Node get(char ch) {
        return links[ch - 'a'];
    }

    // Creates a link to the next node for the current character
    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    // Marks the end of a word
    void setEnd() {
        flag = true;
    }

    // Checks if the current node is the end of a word
    boolean isEnd() {
        return flag;
    }
}

class Trie{
    private Node root;
    Trie(){
        root = new Node();
    }
    public void insert(String word){
        Node node = root;
        for(char ch : word.toCharArray()){
            if(!node.containsKey(ch)){
                node.put(ch , new Node());
            }
            node = node.get(ch);
        }
        node.setEnd();

    }
    public boolean checkIfAllPrefixExists(String word){
        Node node = root;
        for(char ch : word.toCharArray()){
            if(node.containsKey(ch)){
                node = node.get(ch);
                if(!node.isEnd())
                    return false;
            }
            else
            {
                return false;
            }
        }
        return true;
    }
}
class Solution {
    public String completeString(List<String> nums) {
        //your code goes here
        Trie obj = new Trie();

        // Insert all words into the Trie
        for (String num : nums) {
            obj.insert(num);
        }

        String longest = ""; // Stores the longest valid word
        for (String num : nums) {
            if (obj.checkIfAllPrefixExists(num)) {
                if (num.length() > longest.length()) {
                    longest = num;
                } else if (num.length() == longest.length() && num.compareTo(longest) < 0) {
                    longest = num; // Lexicographically smaller word
                }
            }
        }
        return longest.isEmpty() ? "None" : longest;

    }
}
```

---

# 3️⃣ **Longest Common Prefix in an Array**

### Logic:

Insert all words into Trie →
Perform DFS from root → Continue until a branching occurs.

### Implementation:

```java
class Node{
    Node[] links;
    boolean isEnd;
    int wordCount;
    Node(){
        links = new Node[26];
        wordCount = 0;
    }

    public boolean containsKey(char ch){
        return links[ch - 'a'] != null;
    }
    public void put(char ch , Node node){
        links[ch - 'a'] = node;
    }
    public Node get(char ch){
        return links[ch - 'a'];
    }
    public void setEnd(){
        isEnd = true;
    }
    public boolean getEnd(){
        return isEnd;
    }
    public void incrementWordCount(){
        wordCount++;
    }
    public int getWordCount(){
        return wordCount;
    }
}
class Trie{
    Node root;
    Trie(){
        root = new Node();
    }

    public void insert(String word){
        Node node = root;
        for(char ch : word.toCharArray()){
            if(!node.containsKey(ch)){
                node.put(ch , new Node());
                node.wordCount++;
            }
            node = node.get(ch);
        }
        node.setEnd();

    }
    public String walk(String firstStr){
        Node node = root;
        int i = 0;

        while (node.wordCount == 1 && !node.isEnd) {
            int idx = firstStr.charAt(i) - 'a';
            if (node.links[idx] == null) break;
            node = node.links[idx];
            i++;
        }

        return firstStr.substring(0, i);

    }
}
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        Trie trie = new Trie();

        for (String s : strs) {
            trie.insert(s);
        }
        return trie.walk(strs[0]);

    }
}
```

---

# 4️⃣ **Number of Distinct Substrings of a String**

📌 Key Concept:
Insert **all suffixes** into Trie.
Each new Trie node = **a new distinct substring**.

### Example:

String = `"aba"`
Suffixes = `"aba"`, `"ba"`, `"a"`

### Implementation:

```java
class Node {
    Node[] links = new Node[26];  // For 26 lowercase English letters

    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }
}
class Solution {
    public int countDistinctSubstring(String s) {
        //your code goes here
        int count = 0;
        Node root = new Node();
        for(int i = 0 ; i < s.length() ; i++){
            Node node = root;
            for(int j = i ; j < s.length() ; j++){
                char ch = s.charAt(j);
                if(!node.containsKey(ch)){
                    node.put(ch , new Node());
                    count++;
                }
                node = node.get(ch);
            }
        }
        return count + 1;


    }
}
```

---

# 5️⃣ **Maximum XOR of Two Numbers in an Array (Trie of Bits)**

![Image](https://media.geeksforgeeks.org/wp-content/uploads/trie-maximum-xor-1.png?utm_source=chatgpt.com)

![Image](https://iq.opengenus.org/content/images/2021/04/trie.png?utm_source=chatgpt.com)

### **Concept**

* Store numbers in **binary form** using a 32-bit Trie.
* For each bit:

    * To maximize XOR, go opposite direction (0→1 or 1→0).

### Node:

```java
class BitNode {
    BitNode[] bits = new BitNode[2];
}
```

### Insert:

```java
void insert(int num) {
    BitNode node = root;
    for (int i = 31; i >= 0; i--) {
        int bit = (num >> i) & 1;
        if (node.bits[bit] == null)
            node.bits[bit] = new BitNode();
        node = node.bits[bit];
    }
}
```

### Query:

```java
int getMaxXor(int num) {
    BitNode node = root;
    int xor = 0;

    for (int i = 31; i >= 0; i--) {
        int bit = (num >> i) & 1;
        int opp = 1 - bit;

        if (node.bits[opp] != null) {
            xor |= (1 << i);
            node = node.bits[opp];
        } else {
            node = node.bits[bit];
        }
    }
    return xor;
}
```

### Full solution:

```java
public int findMaximumXOR(int[] nums) {
    for (int n : nums) insert(n);
    int max = 0;
    for (int n : nums) max = Math.max(max, getMaxXor(n));
    return max;
}
```

---

# 6️⃣ **Maximum XOR With an Element From Array (Offline Query)**

Given:

* `arr[]`
* Queries: `(x, m)` → maximize `x XOR num` for all `num ≤ m`.

### Technique:

* Sort array by value
* Sort queries by `m`
* Insert allowable values into Trie
* Query like earlier XOR method

This is a classical **offline Trie + sorting** problem.

```java
import java.util.*;

class Node {
    Node[] links;
    Node() { links = new Node[2]; }
    boolean containsKey(int bit) { return links[bit] != null; }
    Node get(int bit) { return links[bit]; }
    void put(int bit, Node node) { links[bit] = node; }
}

class Trie {
    Node root;
    Trie() { root = new Node(); }

    void insert(int num) {
        Node node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (!node.containsKey(bit))
                node.put(bit, new Node());
            node = node.get(bit);
        }
    }

    // renamed to getMax to match your implementation below
    public int getMax(int num) {
        Node node = root;
        int maxNum = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int toggled = 1 - bit;
            if (node.containsKey(toggled)) {
                maxNum |= (1 << i);
                node = node.get(toggled);
            } else {
                node = node.get(bit);
            }
        }
        return maxNum;
    }
}

class Solution {
    public List<Integer> maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);

        // offlineQueries: [mi, xi, originalIndex]
        List<int[]> offlineQueries = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            offlineQueries.add(new int[] { queries[i][1], queries[i][0], i });
        }

        // sort by mi (the allowed max value)
        offlineQueries.sort(Comparator.comparingInt(a -> a[0]));

        // create mutable list initialized with -1 so we can set by index safely
        List<Integer> ans = new ArrayList<>(Collections.nCopies(queries.length, -1));

        int i = 0; // pointer for nums
        Trie trie = new Trie();

        for (int[] q : offlineQueries) {
            int mi = q[0];
            int xi = q[1];
            int originalIndex = q[2];

            // insert all numbers <= mi
            while (i < nums.length && nums[i] <= mi) {
                trie.insert(nums[i]);
                i++;
            }

            if (i != 0) {
                ans.set(originalIndex, trie.getMax(xi)); // use getMax (matching Trie)
            } else {
                ans.set(originalIndex, -1); // no numbers were inserted
            }
        }

        return ans;
    }

}
```

---

# 7️⃣ **Find the Length of Longest Common Prefix Between Two Arrays**

💡 Use Trie + Query.

Example:

arr1 = ["apple", "ape", "april"]
arr2 = ["apex", "apply"]
```

Steps:

1. Insert arr1 words into Trie
2. For each arr2 word, compute the longest prefix using Trie
3. Return the maximum length

### Code:

```java
public int longestCommonPrefix(String[] A, String[] B) {
    Trie t = new Trie();
    for (String s : A) t.insert(s);

    int maxLen = 0;
    for (String s : B) {
        Node node = t.root;
        int len = 0;
        for (char ch : s.toCharArray()) {
            if (!node.containsKey(ch)) break;
            node = node.get(ch);
            len++;
        }
        maxLen = Math.max(maxLen, len);
    }
    return maxLen;
}
```

---

# 8️⃣ **Lexicographical Numbers (1 to n)**
📌 **Key Insight:**
Lexicographical ordering of numbers = DFS traversal of an **implicit Trie of digits**.

Example for `n=13`:

```
1
 ├──10
 │    └──100 ...
 ├──11
 ├──12
 └──13
2
3
...
```

### Elegant DFS:

```java
public List<Integer> lexicalOrder(int n) {
    List<Integer> res = new ArrayList<>();

    for (int i = 1; i <= 9; i++)
        dfs(i, n, res);

    return res;
}

void dfs(int curr, int n, List<Integer> res) {
    if (curr > n) return;

    res.add(curr);

    for (int i = 0; i <= 9; i++) {
        dfs(curr * 10 + i, n, res);
    }
}
```

Time = O(n)

---


