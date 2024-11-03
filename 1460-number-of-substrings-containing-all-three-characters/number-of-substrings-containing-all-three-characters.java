class Solution {
    public int numberOfSubstrings(String s) {
        //OPTIMAL METHOD:- USING SLIDING WINDOW
        int[] lastseen= {-1,-1,-1}; //last seen for a, and c
        int substrings= 0;
        for (int i=0; i<s.length(); i++){
            char c= s.charAt(i);
            lastseen[c-97]= i;
            
            int min= Math.min(lastseen[0],Math.min(lastseen[1],lastseen[2]));
            if (min != -1)
                substrings += min+1;
        }
        return substrings;
        //TC is O(n) and SC is O(3)
    }
}