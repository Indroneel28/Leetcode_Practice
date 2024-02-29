class Solution {
    public int singleNonDuplicate(int[] nums) {
        //If array contains only one element
        if(nums.length==1){
            return nums[0];
        }
        //Checking for  last element
        if (nums[nums.length-1]!=nums[nums.length-2])
            return nums[nums.length-1];
        for (int i=0; i<nums.length-1; i+=2){
            if (nums[i]!=nums[i+1])
                return nums[i];
        }
        return -1;
    }
}