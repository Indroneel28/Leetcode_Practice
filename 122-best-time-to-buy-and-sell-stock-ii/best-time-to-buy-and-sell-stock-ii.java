class Solution {
    //METHOD 3:- TABULATION (BOTTOM-UP APPROACH)
    public int maxProfit(int[] prices) {
        int n= prices.length;
        int[][] dp= new int[n+1][2];

        //Base case
        dp[n][0]= dp[n][1]= 0;
        for (int index=n-1; index>=0; index--){
            for (int buy=0; buy<=1; buy++){
                if (buy==1){
                    dp[index][buy]= Math.max(-prices[index]+dp[index+1][0],dp[index+1][1]);
                }
                else {
                    dp[index][buy]= Math.max(prices[index]+dp[index+1][1],dp[index+1][0]);
                }
            }
        }
        return dp[0][1];
    }
    //TC is O(n*2) and SC is O(n*2)
}