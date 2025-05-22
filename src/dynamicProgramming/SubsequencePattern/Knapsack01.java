package dynamicProgramming.SubsequencePattern;


import java.util.Arrays;

public class Knapsack01 {
    public static void main(String[] args) {
        int wt[] = {4, 5, 1};
        int val[] = {1, 2, 3};
        int W = 4;
        //int res = knapscak01UsingMemoization(wt,val,W);
        //System.out.println(res);
        int ans = knapscak01UsingTabulation(wt,val,W);
        System.out.println(ans);
    }

    private static int knapscak01UsingMemoization(int[] wt, int[] val, int w) {
        int n = val.length;
        int[][] dp = new int[n][w + 1];
        for(int[] arr : dp)
            Arrays.fill(arr,-1);
        return memoization(n - 1 , wt,val,w,dp);
    }

    private static int memoization(int index , int[] wt, int[] val, int w, int[][] dp) {
        //base case
        if(index == 0){
            if(w >= wt[index])
                return val[index];
            return 0;
        }
        if(dp[index][w] != -1)
            return dp[index][w];
        //try out all possible ways
        int notTaken = memoization(index - 1 , wt,val,w,dp);
        int taken = Integer.MIN_VALUE;
        if(w >= wt[index])
            taken = val[index] + memoization(index - 1, wt, val, w - wt[index], dp);
        //find out maximum , out of all possible ways
        return dp[index][w] = Math.max(notTaken , taken);
    }

    private static int knapscak01UsingTabulation(int[] wt, int[] val, int w) {
        int[][] dp = new int[val.length][w + 1];
        for(int i = wt[0] ; i <= w ; i++)
            dp[0][i] = val[0];
        for(int i = 1 ; i < val.length ; i++){
            for(int cap = 0 ; cap <= w ; cap++){
                int notTaken = dp[i - 1] [cap];
                int taken = 0;
                if(cap >= wt[i])
                    //dp[i - 1][cap - wt[i]
                    taken = val[i] + dp[i - 1][cap - wt[i]];
                //find out maximum , out of all possible ways
                dp[i][cap]  = Math.max(notTaken , taken);
            }
        }
        return dp[val.length - 1][w];
    }
}
