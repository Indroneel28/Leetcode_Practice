class Solution {
    //RECURSION AND BACKTRACKING
    public int numTilePossibilities(String tiles) {
        return traverse(tiles,new int[tiles.length()],"", new HashSet<>());
    }
    //Helper Method
    private int traverse(String tiles, int[] track, String s, HashSet<String> set){
        int k= 0;
        for (int i=0; i<track.length; i++){
            if (track[i]==1)
                k++;
        }
        if (k==track.length){
            if (s.isEmpty())
                return 0;
            else if (set.add(s))
                return 1;
            else
                return 0;
        }
        int c= 0;
        for (int i=0; i<track.length; i++){
            if (track[i]==0){
                s += tiles.charAt(i);
                track[i]= 1;
                c += traverse(tiles,track,s,set);

                s= s.substring(0,s.length()-1);
                c += traverse(tiles,track,s,set);

                track[i]= 0;
            }
        }
        return c;
    }
    //TC is Exponential and SC is O(2n)
}