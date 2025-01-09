class Solution {
    public int prefixCount(String[] words, String pref) {
        //BRUTE FORCE METHOD (BEST HERE)
        int count= 0;
        for(String word: words){
            if(word.startsWith(pref))
                count++;
        }
        return count;
    }
}