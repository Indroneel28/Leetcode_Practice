class Solution {
    //METHOD 2:- MEMOIZATION (TOP-DOWN APPROACH) DP
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return memoization(obstacleGrid, new int[obstacleGrid.length][obstacleGrid[0].length], obstacleGrid.length-1, obstacleGrid[0].length-1);
    }

    private int memoization(int[][] obstaclesGrid, int[][] dp, int i, int j){
        if (i<0 || j<0 || obstaclesGrid[i][j]==1)
            return 0;
        if (i==0 && j==0)
            return 1;
        if (dp[i][j]!=0)
            return dp[i][j];
        return dp[i][j]=  memoization(obstaclesGrid,dp,i-1,j) + memoization(obstaclesGrid,dp,i,j-1);
    }
    //TC is O(m*n) and SC is O(m*n + m+n)
}