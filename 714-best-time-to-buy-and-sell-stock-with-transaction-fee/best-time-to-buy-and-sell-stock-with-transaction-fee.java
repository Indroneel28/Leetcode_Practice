class Solution {
    //METHOD 1:- MEMOIZATION (TOP-DOWN APPROACH)
    public int maxProfit(int[] prices, int fee) {
        int[][] dp= new int[prices.length][2];
        for (int[] arr: dp)
            Arrays.fill(arr,-1);
        return memoize(prices,0,1,dp,fee);
    }
    //Helper Method
    private int memoize(int[] prices, int index, int buy, int[][] dp, int fee){
        if (index==prices.length)
            return 0;
        if (dp[index][buy]!=-1)
            return dp[index][buy];
        
        if (buy==1){ //Buy
            return dp[index][buy]= Math.max(-prices[index]+memoize(prices,index+1,0,dp,fee),memoize(prices,index+1,1,dp,fee));
        }
        else {
            return dp[index][buy]= Math.max(prices[index]-fee+memoize(prices,index+1,1,dp,fee),memoize(prices,index+1,0,dp,fee));
        }
    }
    //TC is O(n*2) and SC is O(n*2 + n)
}