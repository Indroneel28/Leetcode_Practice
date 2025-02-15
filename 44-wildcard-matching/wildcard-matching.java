class Solution {
    //METHOD 2:- MEMOIZATION (TOP-DOWN APPROACH) [DONE BY NEEL OWN  WITHOUT STRIVER]
    public boolean isMatch(String s, String p) {
        while (p.contains("**")) {
            p = p.replace("**","*");
        }
        // if (p.startsWith("*"))
        //     p= p.substring(1);
        // if (p.isEmpty())
        //     return true;
        int[][] dp= new int[p.length()][s.length()];
        for (int[] row: dp)
            Arrays.fill(row,-1);
        return memoize(p,s,p.length()-1,s.length()-1,dp);
    }
    //Helper Method
    private boolean memoize(String str1, String str2, int i, int j, int[][] dp){
        //System.out.println(i+" "+j);
        if (i<0 && j<0)
            return true;
        else if (i<0)
            return false;
        else if (j<0){
            String k= str1.substring(0,i+1);
            for (int m=0; m<=i; m++){
                if (k.charAt(m)!='*')
                    return false;
            }
            return true;
        }
        if (dp[i][j]!=-1)
            return dp[i][j]==1; //true if 1 else false
        if (str1.charAt(i)==str2.charAt(j)){
            dp[i][j]= memoize(str1,str2,i-1,j-1,dp) ? 1 : 0;
            return dp[i][j]==1;
        }
        else if (str1.charAt(i)=='?'){
            dp[i][j]= memoize(str1,str2,i-1,j-1,dp) ? 1 : 0;
            return dp[i][j]==1;
        }
        else if (str1.charAt(i)=='*'){
            if(i==0) {
                dp[i][j]= 1;
                return true;
            }
            char c= str1.charAt(i-1);
            if (c==str2.charAt(j) || c=='?'){ //matches
                dp[i][j]= (memoize(str1,str2,i-2,j-1,dp) || memoize(str1,str2,i,j-1,dp)) ? 1 : 0;//pick || not-pick
                return dp[i][j]==1; 
            }
            else {
                dp[i][j]= memoize(str1,str2,i,j-1,dp) ? 1 : 0;
                return dp[i][j]==1;
            }
        }
        else {
            dp[i][j]= 0;
            return false;
        }
    }
    //TC is O(m*n) and SC is O(m*n + (m+n))
}