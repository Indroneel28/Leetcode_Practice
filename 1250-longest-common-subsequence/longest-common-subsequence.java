class Solution {
    //METHOD 3:- MEMOIZATION (TOP-DOWN APPROACH)
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp= new int[text1.length()][text2.length()];
        for (int[] row: dp)
            Arrays.fill(row,-1);
        return memoize(text1,text2,text1.length()-1,text2.length()-1,dp);
    }
    //Helper Method
    private int memoize(String text1, String text2, int i, int j, int[][] dp){
        if (i<0 || j<0)
            return 0;
        if (dp[i][j]!=-1)
            return dp[i][j];
        if (text1.charAt(i)==text2.charAt(j))
            return dp[i][j]= 1 + memoize(text1,text2,i-1,j-1,dp);
        return dp[i][j]= Math.max(memoize(text1,text2,i-1,j,dp),memoize(text1,text2,i,j-1,dp));
    }
    //TC is O(m*n) and SC is O(m*n + (m+n)) 
    // m+n extra space due to recursion stack
}