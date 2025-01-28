class Solution {
    //METHOD 2:- MEMOIZATION
    public boolean canPartition(int[] nums) {
        int sum= 0;
        for (int num: nums)
            sum+=num;
        if (sum%2==1)
            return false;
        else{
            //target is sum/2
            int[][] dp= new int[nums.length][sum/2+1];
            return memoize(nums,nums.length-1,sum/2,dp);
        }
    }
    //Helper Method
    private boolean memoize(int[] nums, int index, int target, int[][] dp){
        if (target==0)
            return true;
        if (index==0)
            return nums[0]==target;
        if (dp[index][target]!=0)
            return dp[index][target]==1;
        boolean pick= false, notPick= false;
        if (target>=nums[index])
            pick= memoize(nums,index-1,target-nums[index],dp);
        notPick= memoize(nums,index-1,target,dp);
        dp[index][target]= pick || notPick ? 1: -1;
        return pick || notPick;
    }
    //TC is O(n*target) and SC is O(n*target + n)
}