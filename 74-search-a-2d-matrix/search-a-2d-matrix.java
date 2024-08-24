class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //USING BINARY SEARCH
        int rows= matrix.length, cols= matrix[0].length;
        int left =0 , right= rows-1;
        while (left<=right){
            int mid= (left+right)/2;
            if (target>=matrix[mid][0] && target<=matrix[mid][cols-1]){
                int low= 0, high= cols-1;
                while (low<=high){
                    int m= (low+high)/2;
                    if (matrix[mid][m]==target)
                        return true;
                    else if (matrix[mid][m]<target)
                        low= m+1;
                    else
                        high= m-1;
                }
                return false;
            }
            else if (target>matrix[mid][cols-1]){
                left= mid+1;
            }
            else{
                right= mid-1;
            }
        }
        return false;
        //TC IS O(og(m*n)) ans SC is O(1)
    }
}