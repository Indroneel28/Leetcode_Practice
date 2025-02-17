class Solution {
    //Instead of three parameters like earlier :- index, buy, again
    //METHOD 5:- MEMOIZATION (STRIVER'S METHOD) USING TWO PARAMETERS:- index, transaction
    public int maxProfit(int[] prices) {
        int[][] dp= new int[prices.length][2*2]; // buy * days
        for (int[] row: dp)
            Arrays.fill(row,-1);
        return memoize(prices,0,0,dp);
    }
    //Helper Method
    private int memoize(int[] prices, int index, int transaction, int[][] dp){
        if (index==prices.length || transaction==4)
            return 0;
        if (dp[index][transaction]!=-1)
            return dp[index][transaction];

        if (transaction%2==0){ //Buy
            return dp[index][transaction]= Math.max(-prices[index]+memoize(prices,index+1,transaction+1,dp),memoize(prices,index+1,transaction,dp));
        }
        else{ //Sell
            return dp[index][transaction]= Math.max(prices[index]+memoize(prices,index+1,transaction+1,dp),memoize(prices,index+1,transaction,dp));
        }
    }
    //TC is O(n*4) and SC is O(n*4 + n)
}