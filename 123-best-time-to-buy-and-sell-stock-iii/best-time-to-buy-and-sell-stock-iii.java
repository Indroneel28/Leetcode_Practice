class Solution {
    //METHOD 4:- TABULATION (BOTTOM-UP APPROACH)
    public int maxProfit(int[] prices) {
        int n= prices.length;
        int[][][] dp= new int[n+1][2][3]; // n - buy - again

        //no need of base case as it initializes to 0 which is ofcourse

        for (int index=n-1; index>=0; index--){
            for (int buy= 0; buy<=1; buy++){
                for (int again= 0; again<=1; again++){
                    if (buy==1) { //Allowed to buy
                        dp[index][buy][again] = Math.max(-prices[index]+dp[index+1][0][again],dp[index+1][1][again]);
                    }
                    else { //Not allowed to buy -> Sell
                        dp[index][buy][again] = Math.max(prices[index]+dp[index+1][1][again+1],dp[index+1][0][again]);
                    }
                }
            }
        }
        //System.out.println(Arrays.deepToString(dp));
        return dp[0][1][0];
    }
    //TC is O(n*2*3) and SC is O(n*2*3)
}