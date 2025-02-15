class Solution {
    //METHOD 3:- MEMOIZATION (TOP-DOWN APPROACH) [STRIVER'S METHOD]
    public boolean isMatch(String s, String p) {
        int n= p.length(), m= s.length();
        int[][] dp= new int[n][m];
        for (int[] row: dp)
            Arrays.fill(row,-1);
        return memoize(p,s,n-1,m-1,dp);
    }
    //Helper Method
    private boolean memoize(String pattern, String str, int i, int j, int[][] dp){
        //Base cases
        if (i<0 && j<0)
            return true;
        else if (i<0) //pattern pointer over
            return false;
        else if (j<0){ //string pointer over
            //Check whether everything in remaining pattern is '*'
            for (int k=0; k<=i; k++){
                if (pattern.charAt(k)!='*')
                    return false;
            }
            return true;
        }
        if (dp[i][j]!=-1)
            return dp[i][j]==1; //true or false
        
        if (pattern.charAt(i)==str.charAt(j) || pattern.charAt(i)=='?') {
            dp[i][j] = memoize(pattern, str, i - 1, j - 1, dp) ? 1 : 0;
            return dp[i][j]==1;
        }
        else if (pattern.charAt(i)=='*'){
            // pick OR not-pick
            dp[i][j]= (memoize(pattern,str,i-1,j,dp) || memoize(pattern,str,i,j-1,dp)) ? 1 : 0;
            return dp[i][j]==1;
        }
        else {
            dp[i][j]= 0;
            return false;
        }
    }
    //TC is O(n*m) and SC is O(n*m + (n+m))
}