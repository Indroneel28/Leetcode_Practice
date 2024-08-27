class Solution {
    public int[] findPeakGrid(int[][] mat) {
        //METHOD 1:- BRUTE FORCE APPROACH
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
        //TC is O(rows*cols) and SC is O(2)
    }
}