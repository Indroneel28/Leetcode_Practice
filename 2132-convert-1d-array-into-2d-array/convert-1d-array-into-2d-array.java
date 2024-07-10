class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length!=m*n)
            return new int[0][0];

        int[][] matrix= new int[m][n]; // m is no. of rows and n is no. of columns
        int x= 0, y= 0;
        
        //Using only one loop not 2 loops
        for (int i=0; i<original.length; i++){
            matrix[x][y]= original[i];
            y++;
            if (y==n){
                y=0;
                x++;
            }
        }
        return matrix;
    }
}