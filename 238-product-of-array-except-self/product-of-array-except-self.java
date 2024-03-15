class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans= new int[nums.length];
        int[] left= new int[nums.length];
        int[] right= new int[nums.length];
        int prol=1;
        for(int i=0; i<left.length; i++){
            left[i]= prol*nums[i];
            prol= left[i];
        }

        int pror= 1;
        for (int i=right.length-1; i>=0; i--){
            right[i]= pror*nums[i];
            pror= right[i];
        }

        ans[0]= right[1];
        for (int i=1; i<nums.length-1; i++){ //0th index and (n-1)th index skipped
            ans[i]= left[i-1]*right[i+1];
        }
        ans[nums.length-1]= left[nums.length-2];
        return ans;
    }
}