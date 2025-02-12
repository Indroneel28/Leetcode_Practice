class Solution {
    //METHOD 2:- MEMOIZATION (TOP-DOWN APPROACH)
    public int longestPalindromeSubseq(String s) {
        int[][] dp= new int[s.length()][s.length()];
        for (int[] row: dp)
            Arrays.fill(row,-1);;
        return memoize(s,new StringBuilder(s).reverse().toString(),s.length()-1,s.length()-1,dp);
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
    //TC is O(m*n) and SC is O(m*n + (m+n))
}