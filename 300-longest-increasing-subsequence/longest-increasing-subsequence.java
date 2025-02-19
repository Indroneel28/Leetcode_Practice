class Solution {
    //METHOD 5:- ADVANCE TABULATION
    public int lengthOfLIS(int[] nums) {
        int n= nums.length, maxi= 1;
        int[] dp= new int[n];
        Arrays.fill(dp,1);
        for (int curr=0; curr<n; curr++){
            for (int prev=0; prev<curr; prev++){
                if (nums[prev]<nums[curr]){
                    dp[curr]= Math.max(dp[curr],1+dp[prev]);
                    maxi= Math.max(maxi,dp[curr]);
                }
            }
        }
        return maxi;
    }
    //TC is O(n^2) and SC is O(n)
}