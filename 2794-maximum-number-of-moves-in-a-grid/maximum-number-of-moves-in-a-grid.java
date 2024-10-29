class Solution {
    int[] directions= {-1,0,1};
    public int maxMoves(int[][] grid) {
        int m= grid.length, n= grid[0].length;
        int result= 0;

        int[][] memo= new int[m][n];

        for (int row=0; row<m; row++){
            result= Math.max(result, dfs(row,0,grid,memo));
        }

        return result;
        //TC is O(m*n) and SC is O(m*n) for Memoization
    }

    private int dfs(int row, int col, int[][] grid, int[][] memo){
        int m= grid.length, n= grid[0].length;

        if (memo[row][col] != 0)
            return memo[row][col];

        int moves= 0;
        for (int dir: directions){
            int newRow= row+dir;
            int newCol= col+1;
            if (newRow>=0 && newRow<m && newCol<n && grid[newRow][newCol]>grid[row][col])
                moves= Math.max(moves,1+dfs(newRow,newCol,grid,memo));
        }
        memo[row][col]= moves;
        return moves;
    }
}