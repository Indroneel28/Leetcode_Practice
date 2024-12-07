class Solution {
    //METHOD 2:- MEMOIZATION
    public int rob(int[] nums) {
        int[] dp= new int[nums.length];
        Arrays.fill(dp,-1);
        return memoization(nums,dp,0);
    }
    private int memoization(int[] nums, int[] dp, int index){
        if (index>=nums.length)
            return 0;
        if (index==nums.length-1)
            return nums[index];
        if (dp[index]!=-1)
            return dp[index];
        return dp[index]= Math.max(nums[index]+memoization(nums,dp,index+2),nums[index+1]+memoization(nums,dp,index+3));
    }
    //TC is O(n) and SC is O(2n)
}