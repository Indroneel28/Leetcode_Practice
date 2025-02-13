class Solution {
    //METHOD 2:- MEMOIZATION (TOP-DOWN APPROACH)
    public int minDistance(String word1, String word2) {
        int[][] dp= new int[word1.length()][word2.length()];
        for (int[] row: dp)
            Arrays.fill(row,-1);
        int lcs= memoize(word1,word2,word1.length()-1,word2.length()-1,dp);
        
        //minimum steps required to make word1 and word2 the same.
        return (word1.length()-lcs) + (word2.length()-lcs);
        //after performing this, s1 and s2 will become lcs of old s1 and old s2.
    }
    //Helper Method
    private int memoize(String word1, String word2, int i, int j, int[][] dp){
        if (i<0 || j<0)
            return 0;
        if (dp[i][j]!=-1)
            return dp[i][j];
        if (word1.charAt(i)==word2.charAt(j))
            return dp[i][j]= 1 + memoize(word1,word2,i-1,j-1,dp);
        //else
        return dp[i][j]= Math.max(memoize(word1,word2,i-1,j,dp),memoize(word1,word2,i,j-1,dp));
    }
    //TC is O(m*n) and SC is O(m*n + (m+n)
}