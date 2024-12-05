class Solution {
    public int climbStairs(int n) {
        //THIS IS SAME LIKE FIB SERIES QUESTION BUT BASE CASES RE DIFFERENT
        //BETTER METHOD:- MEMOIZATION (TOP-DOWN APPROACH)

        int[] dp= new int[n+1];
        Arrays.fill(dp,-1);
        return memoize(n,dp);
        //TC is O(n) and SC is O(2n)
    }

    public int memoize(int n, int[] dp){
        if (n<=2) //THIS IS ALSO GOOD
            return n;
        if (dp[n]!=-1)
            return dp[n]; //No need to calculate again
        return dp[n]= memoize(n-1,dp)+memoize(n-2,dp);
    }
}