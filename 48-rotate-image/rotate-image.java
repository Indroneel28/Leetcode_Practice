class Solution {
    public void rotate(int[][] matrix) {
        //METHOD 1:- BRUTE FORCE APPROACH USING EXTRA SPACE
        //(BY ALLOCATING ANOTHER 2-D MATRIX)
        /*
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
         */
         //TC is O(N^2) and SC is O(N^2)

        //METHOD 2:- BY FINDING TRANSPOSE AND REVERSING THE ELEMENTS OF THE ROW
        int n= matrix.length;
        for (int i=0; i<n; i++){
            for (int j=i+1; j<n; j++){
                int temp= matrix[i][j];
                matrix[i][j]= matrix[j][i];
                matrix[j][i]= temp;
            }
        }
        //In place, we are storing the transpose now let's reverse the elements in each row
        for (int i=0; i<n; i++){
            //We will swap till j=0 to j=n/2
            for (int j=0; j<n/2; j++){
                int temp= matrix[i][j];
                matrix[i][j]= matrix[i][n-1-j];
                matrix[i][n-1-j]= temp;
            }
        }
        //TC is O(N^2) and SC is O(1)
    }

    private void swap(int[][] matrix, int i, int j){
        int temp= matrix[i][j];
        matrix[i][j]= matrix[j][i];
        matrix[j][i]= temp;
    }
}