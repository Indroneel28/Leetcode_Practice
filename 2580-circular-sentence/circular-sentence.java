class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] store= sentence.split(" ");
        int n= store.length;
        for (int i=0; i<n; i++){
            if (store[i].charAt(store[i].length()-1)!=store[(i+1)%n].charAt(0))
                return false;
        }
        return true;
    }
}