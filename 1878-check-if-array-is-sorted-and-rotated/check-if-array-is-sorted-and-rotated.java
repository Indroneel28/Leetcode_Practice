class Solution {
    //OPTIMAL METHOD
    public boolean check(int[] nums) {
        int count= 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]<=nums[(i+1)%nums.length])
                count++;
        }
        return count>=nums.length-1;
    }
    //TC is O(n) and SC is O(1)
}