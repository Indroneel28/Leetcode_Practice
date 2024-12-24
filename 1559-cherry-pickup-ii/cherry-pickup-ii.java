class Solution {
    //METHOD 2:- MEMOIZATION (TOP-DOWN APPROACH)
    public int cherryPickup(int[][] grid) {
        int n= grid.length, m= grid[0].length;
        int[][][] dp= new int[n][m][m];
        for (int[][] row1: dp)
            for (int[] row2: row1)
                Arrays.fill(row2,-1);
        return memoize(grid,dp,0,0,grid[0].length-1);
    }
    //Helper Method
    private int memoize(int[][] grid, int[][][] dp, int i, int j1, int j2){
        if (j1<0 || j2<0 || j1>=grid[0].length || j2>=grid[0].length)
            return 0;
        if (i==grid.length)
            return 0;
        if (dp[i][j1][j2]!=-1)
            return dp[i][j1][j2];

        int maxi= Integer.MIN_VALUE;

        //All possible ways
        for (int k=-1; k<=1; k++){
            for (int l=-1; l<=1; l++){
               if (j1==j2)
                   maxi= Math.max(maxi,grid[i][j1]+memoize(grid,dp,i+1,j1+k,j2+l));
               else
                   maxi= Math.max(maxi,grid[i][j1]+grid[i][j2]+memoize(grid,dp,i+1,j1+k,j2+l));
            }
        }
        dp[i][j1][j2]= maxi;
        return maxi;
    }
    //TC is O(n*m*m)*9 and SC is O(n*m*m + n)
}