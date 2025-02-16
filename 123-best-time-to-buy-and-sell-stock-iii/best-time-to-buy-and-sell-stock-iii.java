class Solution {
    //METHOD 2:- MEMOIZATION (TOP-DOWN APPROACH) [BY NEEL'S OWN]
    //Using 3d array
    public int maxProfit(int[] prices) {
        int[][][] dp= new int[prices.length][2][2];
        for (int[][] matrix: dp){
            for (int[] row: matrix)
                Arrays.fill(row,-1);
        }
        return memoize(prices,0,1,0,dp);
    }
    //Helper Method
    private int memoize(int[] prices, int index, int buy, int again, int[][][] dp){
        //Base cases
        if (index==prices.length)
            return 0;
        if (again==2)
            return 0;
        if (dp[index][buy][again]!=-1)
            return dp[index][buy][again];
        
        if (buy==1){
            if (again==0){
                return dp[index][buy][again]= Math.max(-prices[index] + memoize(prices,index+1,0,0,dp) , memoize(prices,index+1,1,0,dp));
            }
            else { //again==1
                return dp[index][buy][again]= Math.max(-prices[index]+ memoize(prices,index+1,0,1,dp) , memoize(prices,index+1,1,1,dp));
            }
        }
        else { //buy == 0
            if (again==0){
                return dp[index][buy][again]= Math.max(prices[index] + memoize(prices,index+1,1,1,dp) , memoize(prices,index+1,0,0,dp));
            }
            else { //again==1
                return dp[index][buy][again]= Math.max(prices[index]+ memoize(prices,index+1,1,2,dp) , memoize(prices,index+1,0,1,dp));
            }
        }
    }
    //TC is O(n*2*2) and SC is O(n*2*2 + (n))
}