class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        //BRUTE FORCE METHOD
        String[] arr= sentence.split(" ");
        for (int i=0; i<arr.length; i++){
            if (arr[i].startsWith(searchWord))
                return i+1;
        }
        return -1;
        //TC is O(n) and SC is O(n)
    }
}