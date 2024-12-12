class Solution {
    //METHOD 1:- TABULATION (BTTOM-UP APPROACH)
    public int minPathSum(int[][] grid) {
        int[][] matrix= new int[grid.length][grid[0].length];
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                if (i==0 && j==0) {
                    matrix[i][j] = grid[i][j];
                }
                else {
                    int sum1 = Integer.MAX_VALUE;
                    if (i > 0)
                        sum1 = matrix[i - 1][j];
                    int sum2 = Integer.MAX_VALUE;
                    if (j > 0)
                        sum2 = matrix[i][j - 1];
                    matrix[i][j] = grid[i][j] + Math.min(sum1, sum2);
                }
            }
        }
        return matrix[grid.length-1][grid[0].length-1];
    }
    //TC is O(m*n) and SC is O(m*n)
}