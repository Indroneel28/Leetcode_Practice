class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        //OPTIMAL APPROACH:- USING HASHSET
        if (allowed.length()==26)
            return words.length; //All words will be consistent

        int count= 0;
        HashSet<Character> set= new HashSet<>();
        for (int i=0; i<allowed.length(); i++)
            set.add(allowed.charAt(i));

        for (String word: words){
            boolean contain= true;
            for (int i=0; i<word.length(); i++){
                if (!set.contains(word.charAt(i))) { //O(1)
                    contain = false;
                    break;
                }
            }
            if (contain)
                count++;
        }
        return count;
    }
}