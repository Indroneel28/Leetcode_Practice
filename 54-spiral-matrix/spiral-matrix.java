class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        //n= Number of rows & m= Number of columns
        int n= matrix.length, m= matrix[0].length;

        //4 variables are declared
        int left= 0, right= m-1, top= 0, bottom= n-1;

        //Data structure in which we will store the traversed elements
        List<Integer> answer= new ArrayList<>();

        while (left<=right && top<=bottom){
            //Move rightwards
            for (int i=left; i<=right; i++){
                answer.add(matrix[top][i]);
            }
            top++;
            
            //Move downwards
            for (int i=top; i<=bottom; i++){
                answer.add(matrix[i][right]);
            }
            right--;
            
            //Move leftwards
            if(top<=bottom) {
                for (int i = right; i >= left; i--) {
                    answer.add(matrix[bottom][i]);
                }
                bottom--;
            }
            
            //Move upwards
            if (left<=right) {
                for (int i = bottom; i >= top; i--) {
                    answer.add(matrix[i][left]);
                }
                left++;
            }
        }
        
        return answer;
        //TC is O(n^2) and SC is O(1)
    }
}