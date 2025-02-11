class Solution {
    public String removeOccurrences(String s, String part) {
        //BRUTE FORCE METHOD
        while (s.contains(part)){
            s= s.replaceFirst(part,"");
        }
        return s;
        //TC is O(n^2)
    }
}