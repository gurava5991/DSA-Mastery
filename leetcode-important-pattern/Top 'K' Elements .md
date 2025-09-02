# Top K Elements Pattern
## Heap Sort Algorithm

### Find K Closest Elements

# 📌 Problem Statement

**Given** a sorted array `arr` of unique integers, an integer `k`, and a target value `x`, return exactly `k` elements that are closest to `x`.
If there’s a tie (equal distance), choose the smaller value.

---

# ✅ Method 1: Custom Sorting (Brute-force)

### 🔍 Intuition

Sort the array by proximity to `x`. If distances tie, choose the smaller number. Then return the smallest `k` elements (by original value order).

### 🧪 Dry Run

For arr = \[1, 2, 3, 4, 5], x = 3, k = 4:
Sorted by closeness: \[3, 2, 4, 1, 5]
Pick first 4: \[3, 2, 4, 1]
Sort final answer: \[1, 2, 3, 4]

### 💻 Java Code

```java
public List<Integer> findClosestElements_sorting(List<Integer> arr, int k, int x) {
    arr.sort((a, b) -> {
        int distA = Math.abs(a - x), distB = Math.abs(b - x);
        if (distA == distB) return Integer.compare(a, b);
        return Integer.compare(distA, distB);
    });
    List<Integer> result = new ArrayList<>(arr.subList(0, k));
    Collections.sort(result);
    return result;
}
```

### ⏱️ Complexity

* Time: O(n log n)
* Space: O(k)

---

# ✅ Method 2: Max-Heap (Priority Queue)

### 🔍 Intuition

Maintain a max-heap of size `k` with the closest elements to `x`. If a new number is closer, pop the farthest.

### 🧪 Dry Run

Insert distances into the heap:
\[(2,1), (1,2), (0,3), (1,4), (2,5)] → keep smallest k = 4 → \[2, 4, 3, 5]
Final sort: \[2, 3, 4, 5]

### 💻 Java Code

```java
public List<Integer> findClosestElements_heap(List<Integer> arr, int k, int x) {
    PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
        (a, b) -> (a[0] == b[0] ? b[1] - a[1] : b[0] - a[0])
    );

    for (int num : arr) {
        maxHeap.offer(new int[]{Math.abs(num - x), num});
        if (maxHeap.size() > k) {
            maxHeap.poll();
        }
    }

    List<Integer> result = new ArrayList<>();
    while (!maxHeap.isEmpty()) {
        result.add(maxHeap.poll()[1]);
    }

    Collections.sort(result);
    return result;
}
```

### ⏱️ Complexity

* Time: O(n log k + k log k)
* Space: O(k)

---

# ✅ Method 3: Sliding Window Binary Search (Most Optimal)

### 🔍 Intuition

Since the array is sorted, the answer must be a window of size `k`. Use binary search to find the best window.

### 🧪 Dry Run

arr = \[1, 2, 3, 4, 5], x = 3, k = 4
Search space: left = 0 to n - k = 1
At mid = 0 → compare 3 - 1 vs 5 - 3 → move right
Result: subarray \[1, 2, 3, 4]

### 💻 Java Code

```java
public List<Integer> findClosestElements_binarySearch(List<Integer> arr, int k, int x) {
    int left = 0, right = arr.size() - k;

    while (left < right) {
        int mid = (left + right) / 2;
        if (x - arr.get(mid) > arr.get(mid + k) - x) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }

    return arr.subList(left, left + k);
}
```

### ⏱️ Complexity

* Time: O(log(n - k) + k)
* Space: O(k)

---

# 🧠 Final Thoughts

| Method               | Time Complexity      | Space | Notes                        |
| -------------------- | -------------------- | ----- | ---------------------------- |
| Sorting              | O(n log n)           | O(k)  | Simple but slower            |
| Max Heap             | O(n log k + k log k) | O(k)  | Good for unsorted arrays     |
| Binary Search (Best) | O(log(n - k) + k)    | O(k)  | Best for large sorted arrays |


