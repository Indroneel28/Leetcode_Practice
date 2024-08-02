class Solution {
    public void setZeroes(int[][] matrix) {
        for (int i=0; i<matrix.length; i++){
            for (int j= 0; j<matrix[0].length; j++){
                if (matrix[i][j]==0){
                    set0RowCol(matrix,i,j);
                }
            }
        }

        for (int i=0; i<matrix.length; i++){
            for (int j= 0; j<matrix[0].length; j++){
                if (matrix[i][j]==-100000){
                    matrix[i][j]=0;
                }
            }
        }
    }

    //Method to set row and colums to 0
    private void set0RowCol(int[][] matrix, int row, int col){
        //Setting column element
        for (int k=0; k<matrix.length; k++){
            if (matrix[k][col]!=0){
                matrix[k][col]= -100000;
            }
        }

        //Setting row element
        for (int k=0; k<matrix[0].length; k++){
            if (matrix[row][k]!=0){
                matrix[row][k]= -100000;
            }
        }
    }
}