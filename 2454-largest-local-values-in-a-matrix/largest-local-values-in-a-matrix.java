class Solution {
    public int max(int[][] matrix, int i, int j){
        int maximum= 0;
        for (int m= i-1; m<=i+1; m++){
            for (int n= j-1; n<=j+1; n++){
                // System.out.println(matrix[m][n]);
                if (matrix[m][n]>maximum)
                    maximum= matrix[m][n];
            }
        }
        return maximum;
    }
    public int[][] largestLocal(int[][] grid) {
        int[][] ans= new int[grid.length-2][grid[0].length-2];
        int k=0, l=0;
        for (int i=1; i<grid.length-1; i++){
            for (int j=1; j<grid[0].length-1; j++){
                ans[k][l]= max(grid,i,j);
                l++;
                if (l==ans.length){
                    k++; l= 0;
                }
            }
        }
        return ans;
    }
}