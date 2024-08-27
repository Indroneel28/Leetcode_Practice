class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //METHOD 1:- BRUTE FORCE METHOD
        /*
        for(int[] row: matrix){
            for (int ele: row){
                if (ele==target)
                    return true;
            }
        }
        return false;
         */
        //TC is O(n*m) or O(rows*cols) and SC is O(1)

        //METHOD 2:- BETTER APPROACH
        //Binary Search in each row
        /*
        int cols= matrix[0].length;
        for (int[] row: matrix){
            int left= 0, right= cols-1;
            while (left<=right){
                int mid= (left+right)/2;
                if (row[mid]==target)
                    return true;
                else if (target>row[mid])
                    left= mid+1;
                else
                    right= mid-1;
            }
        }
        return false;
         */
        //TC is O(rows*log(cols)) and SC is O(1)

        //METHOD 3:- USING TRICK
        int row= 0, col= matrix[0].length-1; //col = number of columns - 1
        //We are at top-right corner.

        while (row<matrix.length && col>=0){
            if (matrix[row][col]==target)
                return true;
            else if (matrix[row][col]<target)
                row++;
            else
                col--;
        }
        return false;
        //TC is O(rows+cols) and SC is O(1)
    }
}