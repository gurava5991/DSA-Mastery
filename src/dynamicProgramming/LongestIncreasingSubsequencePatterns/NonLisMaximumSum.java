package dynamicProgramming.LongestIncreasingSubsequencePatterns;

import java.util.Arrays;

public class NonLisMaximumSum {
    public static void main(String[] args) {

        //7 2 5 5 1 5
        int[] arr = {7, 2, 5, 5, 1, 5};
        System.out.println(nonLisMaxSum(arr));
    }
    public static int nonLisMaxSum(int[] arr) {
        // code here
        int n = arr.length;
        int totalSum = Arrays.stream(arr).sum();

        // dp[i] stores length of LIS ending at i
        int[] dp = new int[n];
        // prev[i] stores the index of previous element in LIS ending at i
        int[] sum = new int[n];
        Arrays.fill(dp, 1);
        int maxLen = 0;

        // Build LIS
        for (int i = 0; i < n; i++) {
            sum[i] = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    sum[i] = sum[j] + arr[i];
                }
            }
            if(dp[i] > maxLen ){
                maxLen = dp[i];
            }
        }
        int minSum = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            if(dp[i] == maxLen){
                minSum = Math.min(minSum , sum[i]);
            }
        }
        return totalSum - minSum;


    }
}
