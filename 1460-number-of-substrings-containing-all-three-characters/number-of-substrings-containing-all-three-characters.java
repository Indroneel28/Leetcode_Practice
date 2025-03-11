class Solution {
    //METHOD 2:- USING SLIDING WINDOW
    public int numberOfSubstrings(String s) {
        int count= 0;
        int[] store= {-1,-1,-1};
        for (int i=0; i<s.length(); i++){
            store[s.charAt(i)-'a']= i;
            int mini= Math.min(store[0],Math.min(store[1],store[2]));
            if (mini!=-1)
                count += (mini+1);
        }
        return count;
    }
    //TC is O(n) and SC is O(3)
}