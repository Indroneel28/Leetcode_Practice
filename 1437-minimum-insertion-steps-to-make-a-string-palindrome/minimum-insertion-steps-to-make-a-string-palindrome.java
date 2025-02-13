class Solution {
    //METHOD 2:- MEMOIZATION (TOP-DOWN APPROACH)
    public int minInsertions(String s) {
        int n= s.length();
        int[][] dp= new int[n][n];
        for (int[] row: dp)
            Arrays.fill(row,-1);
        int lps= memoize(s,new StringBuilder(s).reverse().toString(),n-1,n-1,dp);

        //Most Important
        int answer= n - lps;
        return answer;
    }
    //Helper Method
    private int memoize(String s1, String s2, int i, int j, int[][] dp){
        if (i<0 || j<0)
            return 0;
        if (dp[i][j]!=-1)
            return dp[i][j];
        if (s1.charAt(i)==s2.charAt(j))
            return dp[i][j]= 1 + memoize(s1,s2,i-1,j-1,dp);
        return dp[i][j]= Math.max(memoize(s1,s2,i-1,j,dp),memoize(s1,s2,i,j-1,dp));
    }
}