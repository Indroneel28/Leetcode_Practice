class Solution {
    //METHOD 1:- MEMOIZATION (TOP-DOWN APPROACH)
    //Shifting of index concept is there (1-based indexing)
    public String shortestCommonSupersequence(String str1, String str2) {
        int n= str1.length(), m= str2.length();
        int[][] dp= new int[n+1][m+1];
        for (int[] row: dp)
            Arrays.fill(row,-1);

        //Forming the DP Table
        memoize(str1,str2,n,m,dp);

        StringBuilder sb= new StringBuilder();
        int i= n, j= m;
        while (i>0 && j>0){
            if (str1.charAt(i-1)==str2.charAt(j-1)){ //Move diagonally up-left
                sb.append(str1.charAt(i-1));
                i--; j--;
            }
            else if (dp[i-1][j]>dp[i][j-1]){ //Move up
                sb.append(str1.charAt(i-1));
                i--;
            }
            else{ //Move up
                sb.append(str2.charAt(j-1));
                j--;
            }
        }
        while (i>0){
            sb.append(str1.charAt(i-1));
            i--;
        }
        while (j>0){
            sb.append(str2.charAt(j-1));
            j--;
        }
        return sb.reverse().toString();
    }
    //Helper Method
    private int memoize(String str1, String str2, int i, int j, int[][] dp){
        if (i<= 0 || j<=0)
            return 0;
        if (dp[i][j]!=-1)
            return dp[i][j];
        if (str1.charAt(i-1)==str2.charAt(j-1))
            return dp[i][j]= 1 + memoize(str1,str2,i-1,j-1,dp);
        return dp[i][j]= Math.max(memoize(str1,str2,i-1,j,dp),memoize(str1,str2,i,j-1,dp));
    }
    //TC is O(m*n + (m+n)) and SC is O(m*n + (m+n))
}