class Solution {
    public int[] findPeakGrid(int[][] mat) {
        //METHOD 1:- BRUTE FORCE APPROACH
        /*
        int rows= mat.length, cols= mat[0].length;
        int[] answer= new int[2];
        answer[0]= -1; answer[1]= -1;
        for (int i=0; i< mat.length; i++){
            for (int j=0; j<mat[0].length; j++){
                int count= 0;

                //UP
                if (i==0 || mat[i][j]>mat[i-1][j])
                    count++;
                //RIGHT
                if(j==cols-1 || mat[i][j]>mat[i][j+1])
                    count++;
                //DOWN
                if (i==rows-1 || mat[i][j]>mat[i+1][j])
                    count++;
                //LEFT
                if (j==0 || mat[i][j]>mat[i][j-1])
                    count++;

                //COUNT
                if (count==4) {
                    answer[0] = i;
                    answer[1] = j;
                    return answer;
                }
            }
        }
        return answer;
         */
        //TC is O(rows*cols) and SC is O(2)

        //METHOD 2:- OPTIMAL APPROACH
        int left= 0, right= mat[0].length;
        while (left<=right){
            int mid= (left+right)/2; //mid is the col
            int row= maxElement(mat,mid);

            //CHECKING LEFT AND RIGHT
            int leftElement= mid>0 ? mat[row][mid-1] : -1;
            int rightElement= mid<mat[0].length-1 ? mat[row][mid+1] : -1;
            if (mat[row][mid]>leftElement && mat[row][mid]>rightElement){
                return new int[]{row,mid};
            }
            else if (leftElement > mat[row][mid])
                right= mid-1; //Move Left
            else
                left= mid+1; //Move right
        }
        return new int[]{-1,-1}; //dummy statement
        //TC is O(rows*log(cols)) and SC is O(2)
    }

    private int maxElement(int[][] arr, int col){
        int row= -1, maxElement= Integer.MIN_VALUE;
        //CHECKING UP TO DOWN
        for (int i=0; i<arr.length; i++){ //Explore all rows and check
            if (arr[i][col]>maxElement){
                maxElement= arr[i][col];
                row= i;
            }
        }
        return row;
    }
}