class Solution {
    //METHOD 1:- USING LIS (DP)
    public int findNumberOfLIS(int[] nums) {
        int[] dp= new int[nums.length];
        int[] count= new int[nums.length];
        
        int maxi= 0;
        for (int i=0; i<nums.length; i++){
            dp[i]= 1;
            count[i]= 1;
            for (int j=0; j<i; j++){
                if (nums[i]>nums[j] && dp[i]<dp[j]+1){
                    dp[i]= 1+dp[j];
                    count[i]= count[j];
                }
                else if (nums[i]>nums[j] && dp[i]==dp[j]+1){
                    count[i]+= count[j];
                }
            }
            maxi= Math.max(maxi,dp[i]);
        }
        
        int c= 0;
        for (int i=0; i<nums.length; i++){
            if (dp[i]==maxi)
                c+= count[i];
        }
        return c;
    }
    //TC is O(n^2 + n) and SC is O(2n)
}