package dynamicProgramming.LongestCommonSubsequencePattern;

import java.util.Arrays;

public class EditDistance {
    static int[][] dp ;
    public static void main(String[] args) {
        String s1 = "planet" , s2 = "plan";
        int m = s1.length() , n = s2.length();
        dp = new int[n][m];
        for(int[] arr : dp)
            Arrays.fill(arr , -1);
        int len = minDistance(s1,s2 , m -1 , n - 1);
        System.out.println(len);

    }

    private static int minDistance(String s1, String s2, int m, int n) {
        //what if given s1 length is empty which means we need to insert n characters
        if(m == 0)
            return n + 1;
        //what if given s2 length is empty which means we need to insert m characters
        if(n == 0)
            return m + 1;
        if(dp[m][n] != -1)
            return dp[m][n];
        if(s1.charAt(m) == s2.charAt(n))
            return minDistance(s1,s2,m - 1 , n - 1);
        //insert
        int insert = minDistance(s1,s2 , m - 1  , n);
        // replace
        int replace = minDistance(s1 , s2 , m -1 , n-1);
        //delete
        int delete =  minDistance(s1 , s2 , m , n - 1);
        return dp[m][n] = 1 + Math.min(insert , Math.min(replace , delete));
    }
}
/*
Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character
Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation:
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')

 */
