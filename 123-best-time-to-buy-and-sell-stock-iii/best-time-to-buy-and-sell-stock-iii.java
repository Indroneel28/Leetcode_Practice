class Solution {
    //METHOD 6:- TABULATION with 2D DP
    public int maxProfit(int[] prices) {
        int n= prices.length;
        int[][] dp= new int[n+1][5];
        for (int index=n-1; index>=0; index--){
            for (int transaction=0; transaction<4; transaction++){
                if (transaction%2==0){
                    dp[index][transaction]= Math.max(-prices[index]+dp[index+1][transaction+1],dp[index+1][transaction]);
                }
                else{
                    dp[index][transaction]= Math.max(prices[index]+dp[index+1][transaction+1],dp[index+1][transaction]);
                }
            }
        }
        //System.out.println(Arrays.deepToString(dp));
        return dp[0][0];
    }
    //TC is O(n*4) and SC is O(n*4)
}