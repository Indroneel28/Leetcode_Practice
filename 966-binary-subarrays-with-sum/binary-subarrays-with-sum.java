class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        //OPTIMAL METHOD
        // sum==goal  =>  sum<=goal - sum<goal  =>  sum<=goal -sum<=goal-1
        return traverse(nums,goal)-traverse(nums,goal-1);
        //TC is O(4n) and SC is O(1)
    }

    //Helper Method
    private int traverse(int[] nums, int goal){
        if (goal<0)
            return 0;
        int left= 0, right= 0, sum= 0, countSubArrays= 0;
        while (right<nums.length){
            sum+=nums[right];
            while (sum>goal){
                sum-=nums[left];
                left++;
            }
            countSubArrays+= (right-left+1);
            right++;
        }
        return countSubArrays;
    }
}