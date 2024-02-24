class Solution {
    public int diagonalSum(int[][] mat) {
        //Given, mat is a square matrix
        int sum=0, j= mat.length-1;
        for (int i=0; i<mat.length; i++,j--){
            if (i==j)
                sum+=mat[i][i]; //Ignore the duplicate one
            else
                sum+=(mat[i][i]+mat[i][j]);
        }
        return sum;
    }
}