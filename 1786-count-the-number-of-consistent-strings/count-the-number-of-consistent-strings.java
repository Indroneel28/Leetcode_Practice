class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        //BRUTE FORCE APPROACH
        int count= 0;
        for (String word: words){
            boolean contain= true;
            for (int i=0; i<word.length(); i++){
                if (!allowed.contains(word.charAt(i)+"")){
                    contain= false;
                    break;
                }
            }
            if (contain)
                count++;
        }
        return count;
    }
}