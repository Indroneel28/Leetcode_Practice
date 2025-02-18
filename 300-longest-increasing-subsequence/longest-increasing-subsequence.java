class Solution {
    //METHOD 2:- MEMOIZATION (TOP-DOWN APPROACH)
    public int lengthOfLIS(int[] nums) {
        int[][] dp= new int[nums.length][nums.length+1];
        for (int[] row: dp)
            Arrays.fill(row,-1);
        return memoize(nums,0,-1,dp);
    }
    //Helper Method
    private int memoize(int[] nums, int index, int prevIndex, int[][] dp){
        if (index==nums.length)
            return 0;
        if (dp[index][prevIndex+1]!=-1)
            return dp[index][prevIndex+1];
        
        //pick and not-pick
        int pick= 0;
        if (prevIndex==-1 || nums[index]>nums[prevIndex]){
            pick= 1 + memoize(nums,index+1,index,dp);
        }
        int notPick= memoize(nums,index+1,prevIndex,dp);
        return dp[index][prevIndex+1]= Math.max(pick,notPick);
    }
    //TC is O(n^2) and SC is O(n^2 + n)
}