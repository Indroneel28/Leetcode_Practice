class Solution {
    public int[] nextGreaterElements(int[] nums) {
        //BRUTE FORCE METHOD:- USING PROPERTIES OF CIRCULAR ARRAY
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
        //TC is O(n^2) and SC is O(n)
    }
}