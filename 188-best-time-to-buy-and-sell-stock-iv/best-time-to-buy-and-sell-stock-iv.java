class Solution {
    //METHOD 1:- MEMOIZATION (TOP-DOWN APPROACH)
    public int maxProfit(int k, int[] prices) {
        int[][][] dp= new int[prices.length][k+1][2];
        for (int[][] mat: dp){
            for (int[] row: mat){
                Arrays.fill(row,-1);
            }
        }
        return memoize(prices,0,k,1,dp);
    }
    //Helper Method
    private int memoize(int[] prices, int index, int k, int buy, int[][][] dp){
        if (k==0 || index==prices.length)
            return 0;
        if (dp[index][k][buy]!=-1){
            return dp[index][k][buy];
        }
        if (buy==1){ //Allowed to buy
            return dp[index][k][buy]= Math.max(-prices[index]+memoize(prices,index+1,k,0,dp),memoize(prices,index+1,k,1,dp));
        }
        else { //Not Allowed to buy
            return dp[index][k][buy]= Math.max(prices[index]+memoize(prices,index+1,k-1,1,dp),memoize(prices,index+1,k,0,dp));
        }
    }
    //TC is O(n*k*2) and SC is O(n*k*2 + n)
}