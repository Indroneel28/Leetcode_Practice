class Solution {
    //METHOD 3:- MEMOIZATION WITH 2 PARAMETERS
    public int maxProfit(int k, int[] prices) {
        int[][] dp= new int[prices.length][k*2+1];
        for (int[] arr: dp)
            Arrays.fill(arr,-1);
        return memoize(prices,0,k*2,dp);
    }
    //Helper Method
    private int memoize(int[] prices, int index, int transaction, int[][] dp){
        //Base cases
        if (index==prices.length || transaction==0)
            return 0;
        if (dp[index][transaction]!=-1)
            return dp[index][transaction];

        if(transaction%2==0){ //Buy
            return dp[index][transaction]= Math.max(-prices[index]+memoize(prices,index+1,transaction-1,dp),memoize(prices,index+1,transaction,dp));
        }
        else{ //Not allowed to Buy => Sell
            return dp[index][transaction]= Math.max(prices[index]+memoize(prices,index+1,transaction-1,dp),memoize(prices,index+1,transaction,dp));
        }
    }
    //TC is O(n*2*k) and SC is O(n*2*k + n)
}