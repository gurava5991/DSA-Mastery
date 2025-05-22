package dynamicProgramming.FibonaccePattern;

import java.util.Arrays;


public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        int dp[] = new int[nums.length];
        Arrays.fill(dp , -1);
        System.out.println(rob(nums.length - 1 , nums,dp));

    }

    private static int rob(int index , int[] nums,int[] dp) {
        if(index == 0)
            return nums[index];
        if(index < 0)
            return 0;
        if(dp[index] != -1)
            return dp[index];
        //pick the current element
        int pick = nums[index] + rob(index - 2 , nums,dp);
        int notPick = 0 + rob(index - 1,nums,dp);
        return dp[index] = Math.max(pick,notPick);


    }
}
/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.

 */
