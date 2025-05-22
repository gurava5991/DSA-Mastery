package linkedList;
import java.util.Set;

public class CircularArrayLoop {
    public static  boolean circularArrayLoop(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean isForward = arr[i] >= 0;  // Determine the direction of movement (forward or backward)
            int slow = i, fast = i;

            // Continue looping until the slow and fast pointers meet, or we hit -1 indicating no cycle
            while (true) {
                slow = findNextIndex(arr, isForward, slow);  // Move slow pointer
                fast = findNextIndex(arr, isForward, fast);  // Move fast pointer once
                if (fast != -1) {
                    fast = findNextIndex(arr, isForward, fast);  // Move fast pointer again
                }
                if (slow == -1 || fast == -1 || slow == fast) {
                    break;  // Break if no cycle or slow and fast meet
                }
            }

            // If slow and fast pointers meet, and neither is -1, we found a cycle
            if (slow != -1 && slow == fast) {
                return true;
            }
        }
        return false;
    }
    private static  int findNextIndex(int[] arr, boolean isForward, int currentIndex) {
        boolean direction = arr[currentIndex] >= 0;  // Determine the direction of movement (forward or backward)

        // If the direction changes, return -1 (not allowed)
        if (isForward != direction) {
            return -1;
        }

        // Calculate the next index
        int nextIndex = (currentIndex + arr[currentIndex]) % arr.length;
        if (nextIndex < 0) {
            nextIndex += arr.length;  // Handle negative wrapping
        }

        // If we form a one-element cycle, return -1 (cycle length cannot be 1)
        if (nextIndex == currentIndex) {
            return -1;
        }

        return nextIndex;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(circularArrayLoop(new int[] {1, 2, -1, 2, 2})); // true
        System.out.println(circularArrayLoop(new int[] {2, 2, -1, 2}));    // true
        System.out.println(circularArrayLoop(new int[] {2, 1, -1, -2}));   // false
    }
}
