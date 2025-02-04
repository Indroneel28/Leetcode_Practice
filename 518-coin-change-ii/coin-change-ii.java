class Solution {
    //METHOD 2:- MEMOIZATION (TOP-DOWN APPROACH)
    public int change(int amount, int[] coins) {
        int[][] dp= new int[coins.length][amount+1];
        for (int[] row: dp)
            Arrays.fill(row,-1);
        return memoize(amount,coins,coins.length-1,dp);
    }
    //Helper Method
    private int memoize(int amount, int[] coins, int index, int[][] dp){
        if (index==0){
            if (amount%coins[index]==0)
                return 1;
            else 
                return 0;
        }
        if (dp[index][amount]!=-1)
            return dp[index][amount];
        //pick or not-pick
        int notPick= memoize(amount,coins,index-1,dp);
        int pick= 0;
        if (amount>=coins[index])
            pick= memoize(amount-coins[index],coins,index,dp);
        dp[index][amount]= pick+notPick;
        return dp[index][amount];
    }
    //TC is O(n*amount) and SC is O(n*amount + n)
}