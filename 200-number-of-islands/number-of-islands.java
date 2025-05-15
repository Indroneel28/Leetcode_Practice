class Solution {
    //METHOD 1:- DFS Traversal
    public int numIslands(char[][] grid) {
        boolean[][] isVisited= new boolean[grid.length][grid[0].length];
        int count= 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(!isVisited[i][j] && grid[i][j]=='1'){
                    dfs(grid,isVisited,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, boolean[][] isVisited, int row, int col){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || isVisited[row][col])
            return;
        if(grid[row][col]=='1'){
            isVisited[row][col]= true;
            dfs(grid,isVisited,row+1,col); //down
            dfs(grid,isVisited,row-1,col); //up
            dfs(grid,isVisited,row,col-1); //left
            dfs(grid,isVisited,row,col+1); //right
        }
    }
}