class Solution {
    //METHOD 3:- TABULATION (BOTTOM-UP APPROACH)
    public int uniquePaths(int m, int n) {
        int[][] dp= new int[m][n];

        //Goal:- Fill 0th column and 0th row with 1.
        for (int i=0; i<dp.length; i++){
            dp[i][0]= 1;
        }
        for (int i=0; i<dp[0].length; i++){
            dp[0][i]= 1;
        }

        for (int i=1; i<dp.length; i++){
            for (int j=1; j<dp[0].length; j++){
                dp[i][j]= dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
    //TC is O(m*n + m + n) and SC is O(m*n)
}