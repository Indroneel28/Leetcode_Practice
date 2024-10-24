class Solution {
    public int largestRectangleArea(int[] heights) {
        //OPTIMAL METHOD:-
        //Step 1:- Find NSE index of array heights
        int[] nse= nseFind(heights);
        //Step 2:- Find PSE index of array hieghts
        int[] pse= pseFind(heights);
        //Step 3:- Calculate the area
        int maxArea= 0;
        for (int i=0; i<heights.length; i++){
            //Area= base X height
            int base= nse[i]-pse[i]-1; //Base
            int height= heights[i]; //Height
            int currArea= base*height; //Area
            maxArea= Math.max(maxArea,currArea);
        }
        return maxArea;
        //TC is O(2n+2n+n) and SC is O(2n+2n)
    }
    private int[] nseFind(int[] arr){
        int[] nseIndex= new int[arr.length];
        Stack<Integer> stack= new Stack<>();
        for (int i=arr.length-1; i>=0; i--){
            int nse= arr.length;
            while (!stack.isEmpty() && arr[stack.peek()]>=arr[i])
                stack.pop();
            if (!stack.isEmpty())
                nse= stack.peek();
            nseIndex[i]= nse;
            stack.push(i);
        }
        return nseIndex;
        //TC is O(2n) and SC is O(2n)
    }

    private int[] pseFind(int[] arr){
        int[] pseIndex= new int[arr.length];
        Stack<Integer> stack= new Stack<>();
        for (int i=0; i<arr.length; i++){
            int pse= -1;
            while (!stack.isEmpty() && arr[stack.peek()]>=arr[i])
                stack.pop();
            if (!stack.isEmpty())
                pse= stack.peek();
            pseIndex[i]= pse;
            stack.push(i);
        }
        return pseIndex;
        //TC is O(2n) and SC is O(2n)
    }
}