class Solution {
    //METHOD 1:;- TABULATION (BOTTOM-UP APPROACH DP)
    public int countSquares(int[][] matrix) {
        int[][] dp= new int[matrix.length][matrix[0].length];
        int countSquareSubmatrices= 0;
        for (int i=0; i<matrix.length; i++){
            dp[i][0]= matrix[i][0];
            countSquareSubmatrices += dp[i][0];
            System.out.println(countSquareSubmatrices);
        }
        for (int j=1; j<matrix[0].length; j++){
            dp[0][j]= matrix[0][j];
            countSquareSubmatrices += dp[0][j];
            System.out.println(countSquareSubmatrices);
        }

        for (int i=1; i<matrix.length; i++){
            for (int j=1; j<matrix[0].length; j++){
                if (matrix[i][j]==1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    countSquareSubmatrices += dp[i][j];
                    System.out.println(countSquareSubmatrices);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return countSquareSubmatrices;
    }
    //TC is O(n*m) and SC is O(n*m)
}