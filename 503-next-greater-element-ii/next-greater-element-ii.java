class Solution {
    public int[] nextGreaterElements(int[] nums) {
        //BRUTE FORCE METHOD:- USING PROPERTIES OF CIRCULAR ARRAY
        /*
        int[] ans= new int[nums.length];
        for (int i=0; i<nums.length; i++){ //run n times
            int nge= -1;
            for (int j=1; j<=nums.length-1;j++){ //run n-1 times
                int index= (i+j)%nums.length;
                if (nums[index]>nums[i]){
                    nge= nums[index];
                    break;
                }
            }
            ans[i]= nge;
        }
        return ans;
         */
        //TC is O(n^2) and SC is O(n)

        //OPTIMAL METHOD :- USING MONOTONIC STACK
        int[] ans= new int[nums.length];
        Stack<Integer> stack= new Stack<>();
        //We will run loop 2n times
        for (int i=2*nums.length-1; i>=0; i--){
            int index= i%nums.length; //Find index
            int nge= -1; //next greater element
            while (!stack.isEmpty() && stack.peek()<=nums[index])
                stack.pop();
            if (!stack.isEmpty())
                nge= stack.peek();
            ans[index]= nge; //store nge
            stack.push(nums[index]);
        }
        return ans;
        //TC is O(4n) and SC is O(n+n)
    }
}