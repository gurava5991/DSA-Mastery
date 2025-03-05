package dynamicProgramming.GridPattern;

public class MinFallingPathSum {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 10, 4}, {100, 3, 2, 1}, {1, 1, 20, 2}, {1, 2, 2, 1}};
        int result = minFallingPathSum(matrix);
        System.out.println(result);
    }

    private static int minFallingPathSum(int[][] matrix) {
        //tabulation
        //tabulation
        int m = matrix.length , n = matrix[0].length;
        int[][] dp = new int[m][n];
        //we can start the index from first index in anywhere
        //cover first base case
        for(int j = 0 ; j < n ; j++){
            dp[0][j] = matrix[0][j];
        }

        for(int i = 1 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                int up = matrix[i][j] + dp[i - 1][j];
                int ld = matrix[i][j];
                if(j -1 >= 0){
                    ld += dp[i - 1][j - 1];
                }
                else ld = (int)1e9;
                int rd = matrix[i][j];
                if(j + 1 < n ){
                    rd += dp[i -1 ][j + 1];
                }
                else rd = (int)1e9;
                dp[i][j] = Math.min(up , Math.min(ld , rd));
            }
        }

        int result = Integer.MAX_VALUE;
        for(int j = 0 ; j < n ; j++){
            result = Math.min(result , dp[m - 1][j]);
        }
        return result;
    }
}
