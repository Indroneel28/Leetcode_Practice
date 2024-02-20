class Solution {
    public boolean check(int[] nums) {
        // if(nums.length>2 && nums[0]>nums[1])
        //     return false;
        int count= 0;
        for (int i=0; i<nums.length; i++){
            if (nums[(i+1)%nums.length]-nums[i]<0)
                count++;
        }
        return count <= 1;
    }
}