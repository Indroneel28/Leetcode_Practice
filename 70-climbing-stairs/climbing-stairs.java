class Solution {
    public int climbStairs(int n) {
        //THIS IS SAME LIKE FIB SERIES QUESTION
        //BETTER METHOD:- MEMOIZATION (TOP-DOWN APPROACH)
        
        int[] dp= new int[n+1];
        Arrays.fill(dp,-1);
        return memoize(n,dp);
        //TC is O(n) and SC is O(2n)
    }
    
    public int memoize(int n, int[] dp){
        if (n<=1)
            return 1;
        if (dp[n]!=-1)
            return dp[n]; //No need to calculate again
        return dp[n]= memoize(n-1,dp)+memoize(n-2,dp);
    }
}