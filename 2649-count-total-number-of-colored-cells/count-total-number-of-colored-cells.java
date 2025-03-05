class Solution {
    public long coloredCells(int n) {
        //METHOD 1:- MATHEMATICAL LOGIC AND CALCULATION
        long ans= 1;
        for(int i=1; i<n; i++){
            ans += (4*i);
        }
        return ans;
        //TC is O(n) and SC is O(1)
    }
}