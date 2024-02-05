class Solution {
    public char repeatedCharacter(String s) {
        //METHOD 1:- USING HASHMAP
        HashMap<Character,Integer> hashMap= new HashMap<>();
        for (int i=0; i<s.length(); i++){
            hashMap.put(s.charAt(i),hashMap.getOrDefault(s.charAt(i),0)+1);
            if (hashMap.get(s.charAt(i))==2)
                return s.charAt(i);
        }
        return 'A'; //This will never execute
    }
}