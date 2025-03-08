class Solution {
    //METHOD 1:- USING SLIDING WINDOW
    public int minimumRecolors(String blocks, int k) {
        int countWhite=0;
        for (int i=0; i<k; i++){
            if (blocks.charAt(i)=='W')
                countWhite++;
        }
        int mini= countWhite;
        int left= 0, right= k;
        while (right<blocks.length()){
            if (blocks.charAt(right)=='W')
                countWhite++;
            if (blocks.charAt(left)=='W')
                countWhite--;
            mini= Math.min(mini,countWhite);
            right++; left++;
        }
        return mini;
    }
    //TC is O(n) and SC is O(1)
}