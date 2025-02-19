class Solution {
    //METHOD 3:- TABULATION (BOTTOM-UP APPROACH)
    public int lengthOfLIS(int[] nums) {
        int n= nums.length;
        int[][] dp= new int[n+1][n+1];
        for (int index=n-1; index>=0; index--){
            //Shifting of indices for prevIndex
            for (int prevIndex= index-1; prevIndex>=-1; prevIndex--){
                //not-pick
                int notPick= dp[index+1][prevIndex+1];
                int pick= 0;
                if (prevIndex==-1 || nums[index]>nums[prevIndex]){
                    pick= 1 + dp[index+1][index+1];
                }
                dp[index][prevIndex+1]= Math.max(pick,notPick);
            }
        }
        //System.out.println(Arrays.deepToString(dp));
        return dp[0][-1+1];
    }
    //TC is O(n^2) and SC is O(n^2)
}