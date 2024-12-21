class Solution {
    //METHOD 3:- TABULATION (BOTTOM-UP APPROACH)
    public int minFallingPathSum(int[][] matrix) {
        int rows= matrix.length, cols= matrix[0].length;
        int[][] dp= new int[rows][cols];
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[0].length; j++){
                if (i==0)
                    dp[i][j]= matrix[i][j];
                else {
                    int left= Integer.MAX_VALUE, right= Integer.MAX_VALUE;
                    if (j>0)
                        left= dp[i-1][j-1];
                    if (j<cols-1)
                        right= dp[i-1][j+1];
                    int mid= dp[i-1][j];
                    dp[i][j]= matrix[i][j] + Math.min(Math.min(left,right),mid);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        int mini= dp[rows-1][0];
        for (int j=1; j<cols; j++){
            mini= Math.min(mini,dp[rows-1][j]);
        }
        return mini;
    }
    //TC is O(m*n + m) and SC is O(m*n)
}