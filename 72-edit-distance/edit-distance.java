class Solution {
    //METHOD 1:- MEMOIZATION (TOP-DOWN APPROACH)
    public int minDistance(String word1, String word2) {
        int[][] dp= new int[word1.length()][word2.length()];
        for (int[] row: dp)
            Arrays.fill(row,-1);
        return memoize(word1,word2,word1.length()-1,word2.length()-1,dp);
    }
    //Helper Method
    private int memoize(String word1, String word2, int i, int j, int[][] dp){
        if (i<0)
            return j+1;
        if (j<0)
            return i+1;
        if (dp[i][j]!=-1)
            return dp[i][j];
        if (word1.charAt(i)==word2.charAt(j))
            return dp[i][j]= memoize(word1,word2,i-1,j-1,dp);
        else{
            int insertion= 1 + memoize(word1,word2,i,j-1,dp);
            int deletion= 1 + memoize(word1,word2,i-1,j,dp);
            int replace= 1 + memoize(word1,word2,i-1,j-1,dp);
            return dp[i][j]= Math.min(insertion,Math.min(deletion,replace));
        }
    }
    //TC is O(m*n) and SC is O(m*n + (m+n))
}