class Solution {
    public void rotate(int[][] matrix) {
        int n= matrix.length;
        int[][] store= new int[n][n];

        //Store the rotated elements in store
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                store[j][n-1-i]= matrix[i][j];
            }
        }

        //Update the Matrix values
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                matrix[i][j]= store[i][j];
            }
        }
    }
}