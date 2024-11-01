class Solution {
    public int lengthOfLongestSubstring(String s) {
        //BETTER METHOD:- USING SLIDING WINDOW AND TWO POINTERS WITH HASHSET
        HashSet<Character> set= new HashSet<>();
        int left= 0, right= 0, maxLen= 0;
        while (right<s.length()){
            while (set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLen= Math.max(maxLen,right-left+1);
            right++;
        }
        return maxLen;
        //TC is O(2n) and SC is O(n)
    }
}