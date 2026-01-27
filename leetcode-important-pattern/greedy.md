# Greedy Algorithms — Introduction and Intuition

---

## 🌟 **1. What is a Greedy Algorithm?**

A **greedy algorithm** is a problem-solving approach that builds up a solution **step by step**, always choosing the option that **seems best at the moment** (the *locally optimal* choice), with the hope that these choices will lead to a **globally optimal** solution.

> 💡 Think of it like:
> *“Take the best bite now, and hope the entire meal ends up great.”*

---

## ⚙️ **2. General Idea**

At each step:

1. **Select** the best available option according to some criterion (e.g., maximum profit, minimum cost).
2. **Decide** that this choice will be part of the final solution.
3. **Reduce** the problem size (eliminate chosen items or update constraints).
4. **Repeat** until the problem is solved.

---

## 🔍 **3. Key Property — Greedy Choice Property**

A problem can be solved using a greedy approach if:

> A **locally optimal choice** at each step leads to a **globally optimal solution**.

Formally:

> A problem exhibits the **greedy choice property** if an optimal solution can be built by making greedy choices *without revisiting or revising* past decisions.

---

## 🔗 **4. Another Important Concept — Optimal Substructure**

A problem has **optimal substructure** if:

> The optimal solution to the overall problem contains optimal solutions to its subproblems.

This property is shared by **Dynamic Programming (DP)** problems too —
but the key difference is in **decision dependency**:

* In **Greedy**, once a choice is made, it’s never changed.
* In **DP**, choices depend on future outcomes — so we explore all possibilities.

---

## ⚔️ **5. Greedy vs Dynamic Programming**

| Feature                  | Greedy                     | Dynamic Programming               |
| ------------------------ | -------------------------- | --------------------------------- |
| Strategy                 | Make best choice now       | Explore all choices and pick best |
| Reconsider past choices? | ❌ No                       | ✅ Yes                             |
| Complexity               | Usually O(n log n) or O(n) | Usually O(n²) or more             |
| Suitable for             | Independent local choices  | Dependent subproblems             |
| Examples                 | Kruskal, Prim, Huffman     | LIS, Knapsack (0/1), Matrix Chain |

---

## 💡 **6. Steps to Design a Greedy Algorithm**

1. **Understand the problem** and constraints.
2. **Identify the greedy criterion** (what’s the “best” choice at each step?).
3. **Prove correctness** — show it satisfies:

    * Greedy choice property
    * Optimal substructure
4. **Implement** efficiently (use sorting, priority queues, etc.)
5. **Validate** with edge cases.

---

## 🧩 **7. Common Examples**

| Problem                           | Goal                                        | Greedy Strategy                               |
| --------------------------------- | ------------------------------------------- | --------------------------------------------- |
| **Coin Change (Infinite coins)**  | Minimum coins for value V                   | Always use the largest possible denomination  |
| **Activity Selection**            | Max number of non-overlapping intervals     | Pick activity with earliest finish time       |
| **Fractional Knapsack**           | Maximize total profit                       | Pick item with highest `value/weight` ratio   |
| **Huffman Encoding**              | Minimize average code length                | Merge two least frequent symbols each time    |
| **Kruskal’s Algorithm**           | Minimum Spanning Tree                       | Pick smallest edge that doesn’t form a cycle  |
| **Prim’s Algorithm**              | Minimum Spanning Tree                       | Expand MST using smallest edge to new vertex  |
| **Dijkstra’s Algorithm**          | Shortest path in weighted graph             | Pick next node with smallest current distance |
| **Job Sequencing with Deadlines** | Max profit jobs                             | Schedule job with highest profit first        |
| **Egyptian Fraction**             | Represent fraction as sum of unit fractions | Always choose largest possible unit fraction  |

---

## 🧠 **8. Example: Activity Selection Problem**

**Problem:**
Given start and end times of activities, choose maximum number of activities that can be done by one person (no overlap).

### Step 1: Sort activities by finishing time.

### Step 2: Select first activity, then always pick next that starts after previous finishes.

### Example:

| Activity | Start | End |
| -------- | ----- | --- |
| A1       | 1     | 3   |
| A2       | 2     | 4   |
| A3       | 3     | 5   |
| A4       | 0     | 6   |
| A5       | 5     | 7   |

✅ Sorted by finish time: (A1, A3, A5)
→ Pick A1 (ends at 3)
→ Next with start ≥ 3 → A3 (ends 5)
→ Next with start ≥ 5 → A5 (ends 7)
✅ Maximum = 3 activities.

---

## 🧮 **9. Mathematical Idea: Exchange Argument**

To prove correctness:

> Show that any optimal solution can be converted into one produced by the greedy algorithm *without reducing its optimality.*

This is called the **exchange argument** —
it’s the formal way to justify that the greedy choice doesn’t “ruin” the final solution.

---

## 🧰 **10. Implementation Tools**

Greedy algorithms often use:

* **Sorting** — to order items by ratio, finish time, or cost.
* **Priority Queues / Heaps** — to repeatedly extract the “best” element.
* **Union-Find (Disjoint Set)** — for cycle detection (in Kruskal).
* **Hashing or Maps** — for frequency-based greedy approaches (e.g., Huffman).

---

## 🚀 **11. Advantages**

* Usually **simple and fast**.
* Often **O(n log n)** or **O(n)**.
* Requires **less memory** than DP.
* Works well for problems with local independence.

---

## ⚠️ **12. Disadvantages**

* Doesn’t always guarantee an optimal solution.
* Harder to prove correctness.
* Sometimes only provides **approximation** (e.g., Traveling Salesman Problem).

---

## 🧩 **13. Real-world Applications**

* Scheduling systems (job allocation, CPU scheduling)
* Network design (MST → Kruskal/Prim)
* Compression (Huffman coding)
* Routing (Dijkstra)
* Resource allocation, portfolio optimization
* Task prioritization problems

---

## 🏁 **14. Summary Table**

| Concept              | Description                                      |
| -------------------- | ------------------------------------------------ |
| Greedy Choice        | Local optimal step                               |
| Optimal Substructure | Best overall includes best subparts              |
| Implementation       | Sort, PQ, or iteration                           |
| Proof Technique      | Exchange argument                                |
| When to Use          | When local decisions don’t affect global optimum |

---