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
        //TC os O(n*m) or O(rows*cols) and SC is O(1)

        //METHOD 2:- BETTER APPROACH
        //Binary Search in each row
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
        //TC is O(rows*log(cols)) and SC is O(1)
    }
}