class Solution {
    //METHOD 2:- TABULATION (BOTTOM-UP APPROACH)  [OPTIMAL SOLUTION]
    //Shifting of indices is there that is 1-based indexing
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        int[][] dp = new int[n + 1][m + 1];

        //Creating DP Table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int i = n, j = m;
        StringBuilder sb = new StringBuilder();
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.append(str1.charAt(i - 1));
                i--; j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) { //Up
                sb.append(str1.charAt(i - 1));
                i--;
            } else { //Left
                sb.append(str2.charAt(j - 1));
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
    //TC is O(m*n + (m+n)) and SC is O(m*n)
}