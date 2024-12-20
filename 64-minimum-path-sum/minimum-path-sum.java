class Solution {
    //METHOD 2:- TOP-DOWN APPROACH (MEMOIZATION)
    public int minPathSum(int[][] grid) {
        return memoization(grid,new int[grid.length][grid[0].length],grid.length-1,grid[0].length-1);
    }
    private int memoization(int[][] grid, int dp[][], int i, int j){
        if (i==0 && j==0)
            return grid[i][j];
        if (i<0 || j<0)
            return Integer.MAX_VALUE;
        if (dp[i][j]!=0)
            return dp[i][j];
        return  dp[i][j]= grid[i][j] + Math.min(memoization(grid,dp,i-1,j),memoization(grid,dp,i,j-1));
    }
    //TC is O(m*n) and SC is O(m*n + m + n)
}