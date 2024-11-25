class Solution {
    public int findContentChildren(int[] g, int[] s) {
        //OPTIMAL METHOD:- USING SORTING AND TWO POINTERS
        Arrays.sort(g);
        Arrays.sort(s);
        //Our goal is to maximize the number of children getting cookies

        int i = 0, j = 0;
        int maxChildren = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                maxChildren++;
                i++;
                j++;
            } else
                j++;
        }
        return maxChildren;
        //TC is O(nlogn+mlogn+m) and SC is O(1)
        //n is the length of array g
        //m is the length of the array s
    }
}