class Solution {
    //METHOD 2:- MEMOIZATION (TOP-DOWN APPROACH)
    public int uniquePaths(int m, int n) {
        int[][] matrix= new int[m][n];
        int[][] dp= new int[m][n];
        return memoization(matrix,dp,m-1,n-1);
    }

    public int memoization(int[][] matrix, int[][] dp, int i, int j){
        if (i==0 && j==0)
            return 1;
        if (i<0 || j<0)
            return 0;
        if (dp[i][j]!=0)
            return dp[i][j];
        return dp[i][j]= memoization(matrix,dp,i-1,j) + memoization(matrix,dp,i,j-1);
    }
    //TC is O(m*n) and SC is O(m+n+m*n)
}