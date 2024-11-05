class Solution {
    public int minChanges(String s) {
        //OPTIMAL METHOD USING BRAIN
        //2 <= s.length <= 10^5 (CONSTRAINTS)

       int count= 0;
       for (int i=0; i<s.length(); i+=2){
           if (s.charAt(i)!=s.charAt(i+1))
               count++;
       }
       return count;
       //TC is O(n) and SC is O(1)
    }
}