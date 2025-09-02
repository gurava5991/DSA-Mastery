package StringProblems;

import java.util.*;

public class Main {
    static final int MAX_CHAR = 26;

    public static char nonRep(String s) {
        int[] vis = new int[MAX_CHAR];
        Arrays.fill(vis, -1);

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (vis[index] == -1) {

                // Store the index when character is first seen
                vis[index] = i;
            } else {

                // Mark character as repeated
                vis[index] = -2;
            }
        }

        int idx = -1;

        // Find the smallest index of the non-repeating characters
        for (int i = 0; i < MAX_CHAR; i++) {
            if (vis[i] >= 0 && (idx == -1 || vis[i] < vis[idx])) {
                idx = i;
            }
        }

        return (idx == -1) ? '$' : s.charAt(vis[idx]);
    }

    public static void main(String[] args) {
        String s = "aabbcccd";
        System.out.println(nonRep(s));
    }
}
