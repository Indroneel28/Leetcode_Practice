class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //BRUTE FORCE METHOD :- LINEAR SEARCH
        //TRAVERSE EACH ELEMENT OF THE MATRIX AND CHECK WHETHER THE TARGET MATCHES OR NOT
        /*
        for (int[] row: matrix){
            for (int ele: row){
                if (ele==target)
                    return true;
                else if (ele>target)
                    return false;
            }
        }
        return false;
         */
        //TC is O(rows*cols) OR O(n) and SC is O(1)
        //n= rows*cols = number of elements in the matrix


        //OPTIMAL METHOD:- USING BINARY SEARCH
        /*
        int rows= matrix.length, cols= matrix[0].length;
        int left =0 , right= rows-1;
        while (left<=right){
            int mid= (left+right)/2;
            if (target>=matrix[mid][0] && target<=matrix[mid][cols-1]){
                //target can be only inside the row "mid"
                int low= 0, high= cols-1;
                while (low<=high){
                    int m= (low+high)/2;
                    System.out.println(mid+" "+m);
                    if (matrix[mid][m]==target)
                        return true;
                    else if (matrix[mid][m]>target)
                        low= m+1;
                    else
                        high= m-1;
                }
                return false; //target not found in row "mid" and can't be in some other row!!
            }
            else if (target>matrix[mid][cols-1]){
                left= mid+1;
            }
            else{
                right= mid-1;
            }
        }
        return false;
         */
        //TC IS O(Log(m*n)) ans SC is O(1)


        //OPTIMAL METHOD:- USING ADVANCE BINARY SEARCH
        //2D array -> flattened into 1D array
        int rows= matrix.length, cols= matrix[0].length;
        int left= 0, right= rows*cols-1;
        while (left<=right){
            int mid= (left+right)/2;
            int row= mid/cols;
            int col= mid%cols;
            if (matrix[row][col]==target)
                return true;
            else if (target > matrix[row][col])
                left= mid+1;
            else
                right= mid-1;
        }
        return false;
        //TC IS O(Log(m*n)) ans SC is O(1)
    }
}