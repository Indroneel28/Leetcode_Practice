class Solution {
    public boolean checkIfPangram(String sentence) {
        //METHOD 1:- USING EXTRA ARRAY
        /*
        char[] store= new char[26];
        for (int i=0; i<sentence.length(); i++){
            char c= sentence.charAt(i);
            store[c-97]++;
            //ASCII lower case characters start from 97 to 122
        }

        for (int ele: store){
            if (ele==0)
                return false;
        }
        return true;
        //TC is O(n) and SC is O(26)
         */

        //METHOD 2:- USING HASHSET
        HashSet<Character> set= new HashSet<>();
        for (int i=0; i<sentence.length(); i++){
            set.add(sentence.charAt(i));
        }
        return set.size()==26;
        //Tc is O(n) and SC is O(n)
    }
}