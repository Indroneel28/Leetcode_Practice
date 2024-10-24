class Solution {
    public int largestRectangleArea(int[] heights) {
        //OPTIMAL METHOD
        Stack<Integer> stack= new Stack<>();
        int maxArea= 0;
        for (int i=0; i<heights.length; i++){
            while (!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                int index= stack.pop();
                //While popping compute the area
                int left= -1;
                if (!stack.isEmpty())
                    left= stack.peek();
                int right= i;
                maxArea= Math.max(maxArea,heights[index]*(right-left-1));
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            int index= stack.pop();
            //While popping compute the area
            int left= -1;
            if (!stack.isEmpty())
                left= stack.peek();
            int right= heights.length;
            maxArea= Math.max(maxArea,heights[index]*(right-left-1));
        }
        return maxArea;
        //TC is O(2n) and SC is O(n)
    }
}