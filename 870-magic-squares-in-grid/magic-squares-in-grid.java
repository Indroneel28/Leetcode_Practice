class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int count= 0;
        for (int i=1;i<grid.length-1;i++){
            for (int j=1; j<grid[0].length-1; j++){
                if (validMagicSquare(grid,i,j))
                    count++;
            }
        }
        return count;
    }
    private boolean validMagicSquare(int[][] grid, int i, int j){
        HashSet<Integer> set= new HashSet<>();
        for (int k= i-1; k<=i+1; k++){
            for (int l=j-1; l<=j+1; l++){
                if (grid[k][l]>9 || grid[k][l]<1)
                    return false;
                else if (set.contains(grid[k][l]))
                    return false;
                else 
                    set.add(grid[k][l]);
            }
        }
        int row1= grid[i-1][j-1]+grid[i-1][j]+grid[i-1][j+1];
        int row2= grid[i][j-1]+grid[i][j]+grid[i][j+1];
        int row3= grid[i+1][j-1]+grid[i+1][j]+grid[i+1][j+1];
        int col1= grid[i-1][j-1]+grid[i][j-1]+grid[i+1][j-1];
        int col2= grid[i-1][j]+grid[i][j]+grid[i+1][j];
        int col3= grid[i-1][j+1]+grid[i][j+1]+grid[i+1][j+1];
        int dia1= grid[i-1][j-1]+grid[i][j]+grid[i+1][j+1];
        int dia2= grid[i-1][j+1]+grid[i][j]+grid[i+1][j-1];
        return row1==row2 && row2==row3 && row3==col1 && col1==col2&&col2==col3&&col3==dia1&&dia1==dia2;
    }
}