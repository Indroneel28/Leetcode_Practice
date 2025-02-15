class Solution {
    //METHOD 2:- MEMOIZATION (TOP-DOWN APPROACH)
    public int maxProfit(int[] prices) {
        int[][] dp= new int[prices.length][2];
        for (int[] row: dp)
            Arrays.fill(row,-1);
        return memoize(prices,0,1,dp);
    }
    //Helper Method
    private int memoize(int[] prices, int index, int buy, int[][] dp){
        if (index==prices.length)
            return 0;
        if (dp[index][buy]!=-1)
            return dp[index][buy];
        if (buy==1){
            return dp[index][buy]= Math.max( -prices[index] + memoize(prices,index+1,0,dp),memoize(prices,index+1,1,dp));  
        }
        else {
            return dp[index][buy]= Math.max(prices[index] + memoize(prices,index+1,1,dp),memoize(prices,index+1,0,dp));
        }
    }
    //TC is O(n*2) and SC is O(n*2 + n)
}