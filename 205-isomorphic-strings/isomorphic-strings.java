class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length()!=t.length())
            return false;

        HashMap<Character,Character> hashMap= new HashMap<>();
        for (int i=0; i<s.length(); i++){
            char original= s.charAt(i);
            char replacement= t.charAt(i);

            if (!hashMap.containsKey(original)){
                if (!hashMap.containsValue(replacement)){
                    hashMap.put(original,replacement);
                }
                else
                    return false;
            }
            else {
                if (replacement != hashMap.get(original))
                    return false;
            }
        }
        return true;
    }
}