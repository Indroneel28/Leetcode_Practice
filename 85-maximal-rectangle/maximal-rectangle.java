class Solution {
    public int maximalRectangle(char[][] matrix) {
        //OPTIMAL SOLUTION:- Using Largest Rectangle in Histogram Concept
        int rows= matrix.length, cols= matrix[0].length;
        int[] preHeights= new int[cols];
        int maxArea= 0;
        for (int i=0; i<rows; i++){
            Stack<Integer> stack= new Stack<>(); //Monotonic Stack
            for (int j=0; j<cols; j++){
                if (matrix[i][j]=='0')
                    preHeights[j]=0;
                else
                    preHeights[j]+=1;
                //System.out.println(Arrays.toString(preHeights));
                while (!stack.isEmpty() && preHeights[stack.peek()]>=preHeights[j]){
                    int index= stack.pop();
                    int left= -1;
                    if (!stack.isEmpty())
                        left= stack.peek();
                    int right= j;
                    maxArea= Math.max(maxArea, preHeights[index]*(right-left-1));
                }
                stack.push(j);
            }
            while (!stack.isEmpty()){
                int index= stack.pop();
                int left= -1;
                if (!stack.isEmpty())
                    left= stack.peek();
                int right= cols;
                maxArea= Math.max(maxArea,preHeights[index]*(right-left-1));
            }
        }
        return maxArea;
        //TC is O(rows*(cols+cols)) and SC is O(cols)
    }
}