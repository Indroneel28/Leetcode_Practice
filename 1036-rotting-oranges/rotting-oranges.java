class Solution {
    //Note:- DFS will not work here.

    //METHOD 1:- BFS
    public int orangesRotting(int[][] grid) {
        int n= grid.length, m= grid[0].length;

        int count= 0;
        while(true){
            boolean change= false;
            int[][] newGrid= new int[n][m];

            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    newGrid[i][j]= grid[i][j];
                }
            }

            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(grid[i][j]==2){
                        boolean changeHuaKya= bfs(grid,i,j,newGrid);
                        if(changeHuaKya){
                            change= true;
                        }
                    }
                }
            }
            
            // Apply newGrid to grid
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = newGrid[i][j];
                }
            }

            if(!change)
                break;
            count++;
        }

        // Check for remaining fresh oranges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1)
                    return -1;
            }
        }

        return count;
    }

    
    //Visited Array is not required
    private boolean bfs(int[][] grid, int row, int col, int[][] newGrid){
        int n= grid.length, m= grid[0].length;
        boolean change= false;
        newGrid[row][col]= 2;
        if(row-1>=0 && grid[row-1][col]==1){
            newGrid[row-1][col]= 2;
            change= true;
        }
        if(row+1<n && grid[row+1][col]==1){
            newGrid[row+1][col]= 2;
            change= true;
        }
        if(col-1>=0 && grid[row][col-1]==1){
            newGrid[row][col-1]= 2;
            change= true;
        }
        if(col+1<m && grid[row][col+1]==1){
            newGrid[row][col+1]= 2;
            change= true;
        }
        return change; 
    }
}