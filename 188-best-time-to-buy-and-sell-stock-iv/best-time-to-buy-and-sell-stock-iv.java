class Solution {
    //METHOD 4:- TABULATION WITH 2d ARRAY
    public int maxProfit(int k, int[] prices) {
        int n= prices.length;
        int[][] dp= new int[n+1][k*2+1];
        for (int index= n-1; index>=0; index--){
            for (int transaction= 0; transaction<k*2; transaction++){
                if (transaction%2==0) //Buy
                    dp[index][transaction]= Math.max(-prices[index]+dp[index+1][transaction+1],dp[index+1][transaction]);
                else //Sell
                    dp[index][transaction]= Math.max(prices[index]+dp[index+1][transaction+1],dp[index+1][transaction]);
            }
        }
        return dp[0][0];
    }
    //TC is O(n*k*2) and SC is O(n*k*2)
}