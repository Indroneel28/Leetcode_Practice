class Solution {
    public int singleNonDuplicate(int[] nums) {
        //If array contains only one element
        if(nums.length==1){
            return nums[0];
        }
        //Checking for only first and last element
        if (nums[0]!=nums[1])
            return nums[0];
        if (nums[nums.length-1]!=nums[nums.length-2])
            return nums[nums.length-1];
        for (int i=1; i<nums.length; i++){
            if (nums[i-1]!=nums[i] && nums[i]!=nums[i+1])
                return nums[i];
        }
        return -1;
    }
}