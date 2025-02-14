class Solution {
    //METHOD 3:- MEMOIZATION (TOP-DOWN APPROACH)
    public int numDistinct(String s, String t) {
        int n= s.length(), m= t.length();
        int[][] dp= new int[n][m];
        for (int[] row: dp)
            Arrays.fill(row,-1);
        return memoize(s,t,n-1,m-1,dp);
    }
    //Helper Method
    private int memoize(String s, String t, int i, int j, int[][] dp){
        if (j<0)
            return 1;
        if (i<0)
            return 0;
        if (dp[i][j]!=-1)
            return dp[i][j];
        if (s.charAt(i)==t.charAt(j))
            return dp[i][j]= memoize(s,t,i-1,j-1,dp) + memoize(s,t,i-1,j,dp); //pick + not-pick
        else
            return dp[i][j]= memoize(s,t,i-1,j,dp); //not-pick
    }
    //TC is O(n*m) and SC is O(n*m + (n+m))
}