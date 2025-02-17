class Solution {
    //METHOD 2:- TABULATION (BOTTOM-UP APPROACH)
    //base case to top
    public int maxProfit(int k, int[] prices) {
        int n= prices.length;
        int[][][] dp= new int[n+1][k+1][2];
        for (int index= n-1; index>=0; index--){
            for (int kk= 0; kk<k; kk++){
                for (int buy= 1; buy>=0; buy--){
                    if (buy==1){
                        dp[index][kk][buy]= Math.max(-prices[index]+dp[index+1][kk][0],dp[index+1][kk][1]);
                    }
                    else {
                        dp[index][kk][buy]= Math.max(prices[index]+dp[index+1][kk+1][1],dp[index+1][kk][0]);
                    }
                }
            }
        }
        return dp[0][0][1];
    }
    //TC is O(n*k*2) and SC is O(n*k*2)
}