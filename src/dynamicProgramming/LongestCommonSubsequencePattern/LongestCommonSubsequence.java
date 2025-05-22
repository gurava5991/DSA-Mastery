package dynamicProgramming.LongestCommonSubsequencePattern;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "abcde" ,  s2 = "ace";
        int m = s1.length() , n = s2.length();
        int[][] dp = new int[m][n];
        for(int[] arr : dp)
            Arrays.fill(arr , -1);
        int len = LCSUsingMemoization(m - 1 , n - 1 , s1 , s2,dp);
        System.out.println(len);
        int count = LCSUsingTabulation(m,n,s1,s2);
        System.out.println(count);
    }

    private static int LCSUsingTabulation(int m, int n, String s1, String s2) {
        int[][] dp = new int[m + 1][n + 1];

        //base cases
        for(int i = 0 ; i <= m ; i++)
            dp[i][0] = 0;
        for(int i = 0 ; i <= n ; i++)
            dp[0][i] = 0;

        for(int i = 1 ; i <= m ; i++){
            for(int j = 1 ; j <= n ; j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i -1][j] , dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }

    private static int LCSUsingMemoization(int m, int n, String s1, String s2, int[][] dp) {
        if(m < 0 || n < 0)
            return 0;
        if(dp[m][n] != -1)
            return dp[m][n];
        if(s1.charAt(m) == s2.charAt(n))
            return dp[m][n] = 1 + LCSUsingMemoization(m - 1 , n - 1 , s1 , s2,dp);
        return dp[m][n] = Math.max(LCSUsingMemoization(m - 1 , n, s1, s2,dp) , LCSUsingMemoization(m , n -1 , s1 , s2 , dp));
    }
}
/*
Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.
Input: text1 = "abcde", text2 = "ace"
Output: 3
Explanation: The longest common subsequence is "ace" and its length is 3.
 */
