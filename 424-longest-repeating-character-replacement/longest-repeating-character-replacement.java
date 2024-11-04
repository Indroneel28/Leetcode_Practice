class Solution {
    public int characterReplacement(String s, int k) {
        //BETTER METHOD:- USING SLIDING WINDOW AND TWO POINTERS
        int left= 0, right= 0, maxLen= 0, maxFreq= 0;
        HashMap<Character,Integer> map= new HashMap<>();
        while (right<s.length()){
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
            maxFreq= Math.max(maxFreq, map.get(s.charAt(right)));
            while (right-left+1 - maxFreq > k){
                char c= s.charAt(left);
                if (map.get(c)==1)
                    map.remove(c);
                else
                    map.put(c,map.get(c)-1);
                
                //WITHOUT DECREASING FREQUENCY
                left++;
            }
            maxLen= Math.max(maxLen,right-left+1);
            right++;
        }
        return maxLen;
        //TC is O(2n) and SC is O(n)
    }
}