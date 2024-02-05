class Solution {
    public int firstUniqChar(String s) {
        //METHOD 1:- USING HASHMAP
        /*
        HashMap<Character,Integer> hashMap= new HashMap<>();
        for (int i=0; i<s.length(); i++){
            hashMap.put(s.charAt(i),hashMap.getOrDefault(s.charAt(i),0)+1);
        }
        //System.out.println(hashMap);

        for (int i=0; i<s.length(); i++){
            if (hashMap.get(s.charAt(i))==1)
                return i;
        }
        return -1;
         */

        //METHOD 2:- USING ARRAY
        int[] arr= new int[26];
        for (int i=0; i<s.length(); i++){
            arr[s.charAt(i)-97]++;
        }

        for (int i=0; i<s.length(); i++){
            if (arr[s.charAt(i)-97]==1)
                return i;
        }
        return -1;
    }
}