class Solution {
    public String frequencySort(String s) {
        //APPROACH:- We will use HashMap data structure
        HashMap<Character, Integer> hashMap= new HashMap<>();
        for (int i=0; i<s.length(); i++){
            char c= s.charAt(i);
            hashMap.put(c,hashMap.getOrDefault(c,0)+1);
        }
        
        String answer="";
        while (!hashMap.isEmpty()){
            char c='0'; int frequency= 0;
            for (char key: hashMap.keySet()){
                if (hashMap.get(key)>frequency){
                    c= key;
                    frequency= hashMap.get(key);
                }
            }
            for (int i=1; i<=frequency; i++){
                answer+=c;
            }
            hashMap.remove(c);
        }
        return answer;
    }
}