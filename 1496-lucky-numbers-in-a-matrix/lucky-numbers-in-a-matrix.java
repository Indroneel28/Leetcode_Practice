class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> answer= new ArrayList<>();
        for (int i=0; i<matrix.length; i++){
            //Checking minimum element in each row
            int min= matrix[i][0];
            int minIndex= 0;
            for (int j=1; j< matrix[i].length;j++){
                if (matrix[i][j]<min) {
                    min = matrix[i][j];
                    minIndex= j;
                }
            }
            
            //Checking maximum element in the column
            int max= matrix[0][minIndex];
            for (int k=1; k<matrix.length; k++){
                if (matrix[k][minIndex]>max){
                    max= matrix[k][minIndex];
                }
            }

            //System.out.println(max+" "+min);
            if (max==min)
                answer.add(max);
        }
        return answer;
    }
}