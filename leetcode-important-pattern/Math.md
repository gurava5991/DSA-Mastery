## **Sieve of Eratosthenes**

---

### 🧠 Math Logic

The idea is:

* A prime number is only divisible by 1 and itself.
* If a number `p` is prime, then all multiples of `p` (i.e., `2p`, `3p`, ..., up to `n`) cannot be prime.
* So we start from the smallest prime `2` and eliminate all its multiples, then move to the next unmarked number, and repeat.

Only need to go up to `√n` because:

* If `n = a * b` and `a <= b`, then `a * a <= a * b = n` → `a <= √n`.

---

### ✅ Approach

1. Create a boolean array `isPrime[0..n]` and set all entries to `true`.
2. Mark `0` and `1` as not prime.
3. For each number `i` from `2` to `√n`:

    * If `isPrime[i]` is true, mark all multiples of `i` as false (`i*i, i*i+i, i*i+2i, ...`).
4. The remaining true entries in the array are primes.

---

```javaimport java.util.*;

public class SieveOfEratosthenes {

    // Function to find all primes <= n using Sieve of Eratosthenes
    public static List<Integer> sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true); // Assume all numbers are prime

        isPrime[0] = false;
        isPrime[1] = false;

        // Only go up to sqrt(n)
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                // Mark all multiples of i as non-prime
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Collect primes
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }

    public static void main(String[] args) {
        int n = 50;
        List<Integer> primes = sieve(n);
        System.out.println("Prime numbers up to " + n + ": " + primes);
    }
}

```

### 🧮 Time Complexity

* **Initialization**: `O(n)`
* **Sieve Process**:

    * For each prime `p`, we mark \~`n/p` numbers.
    * Total complexity ≈ `n * (1/2 + 1/3 + 1/4 + ... + 1/n)` = `O(n log log n)`

So overall time: **O(n log log n)** — very efficient.

---

Let me know if you'd like a version that prints primes in a range or finds primes in multiple queries efficiently using segmented sieve.
