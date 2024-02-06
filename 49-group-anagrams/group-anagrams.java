class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap= new HashMap<>();
        for (int i=0; i<strs.length; i++){
            char[] arr= strs[i].toCharArray();
            Arrays.sort(arr);
            String str= new String(arr);
            if (hashMap.containsKey(str)){
                hashMap.get(str).add(strs[i]);
            }
            else {
                hashMap.put(str, new ArrayList<>());
                hashMap.get(str).add(strs[i]);
            }
        }

        List<List<String>> result= new ArrayList<>();
        result.addAll(hashMap.values()); //Will add all the values List<String> in result
        return result;
    }
}