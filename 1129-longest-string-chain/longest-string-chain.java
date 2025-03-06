class Solution {
    //METHOD 1:- USING LIS (DP)
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)-> a.length()-b.length());
        int maxi= 1;
        int[] dp= new int[words.length];
        Arrays.fill(dp,1);
        for (int i=1; i<dp.length; i++){
            for (int j=0; j<i; j++){
                if (checkPredecessor(words[i],words[j]) && dp[i]<1+dp[j]){
                    dp[i]= 1+dp[j];
                    maxi= Math.max(maxi,dp[i]);
                }
            }
        }
        return maxi;
    }
    //Helper Method
    private boolean checkPredecessor(String s1, String s2){
        if (s1.length()!=s2.length()+1)
            return false;
        int p= 0, q= 0;
        while (p<s1.length()){
            if (q<s2.length() && s1.charAt(p)==s2.charAt(q)){
                p++; q++;
            }
            else {
                p++;
            }
        }
        return p==s1.length() && q==s2.length();
    }
    //TC is O(nlogn + n*n*s) and SC is O(n)
}