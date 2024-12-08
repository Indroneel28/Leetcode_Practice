class Solution {
    //METHOD 2:- MEMOIZATION (Top-down Approach)
    //STRIVER's METHOD
    public int rob(int[] nums) {
        int[] dp= new int[nums.length];
        Arrays.fill(dp,-1);
        return memoization(nums,dp,nums.length-1);
    }
    private int memoization(int[] nums, int[] dp, int index){
        if (index==0)
            return nums[index];
        if (index<0)
            return 0;
        if (dp[index]!=-1)
            return dp[index];
        int pick= nums[index] + memoization(nums,dp,index-2);
        int notPick= memoization(nums,dp,index-1);
        return dp[index]= Math.max(pick,notPick);
    }
    //TC is O(n) and SC is O(2n)
}