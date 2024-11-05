class Solution {
    public String minWindow(String s, String t) {
        //OPTIMAL METHOD:- USING SLIDING WINDOW
        int m= s.length(), n= t.length();

        //Edge case
        if (n>m)
            return "";

        int left= 0, right= 0, minLength= Integer.MAX_VALUE, count= 0, index= -1;
        HashMap<Character,Integer> map= new HashMap<>();

        //Inserting characters of string t
        for (int i=0; i<n; i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }

        while (right < s.length()){
            if (map.containsKey(s.charAt(right)) && map.get(s.charAt(right))>0)
                count++;
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)-1); //Reduction

            //If count == n
            while (count == n){ //All characters of t are present including duplicates
                char c= s.charAt(left);
                //if it's minimum length
                if (right - left + 1 < minLength) {
                    minLength= right-left+1;
                    index= left;
                }
                //remove left char
                map.put(c,map.get(c)+1);
                if (map.get(c)>0)
                    count--;
                left++;
            }
            right++;
        }
        if (index==-1)
            return "";
        return s.substring(index,index+minLength); //substring
        //TC is O(2n + m) and SC is O(26)
    }
}