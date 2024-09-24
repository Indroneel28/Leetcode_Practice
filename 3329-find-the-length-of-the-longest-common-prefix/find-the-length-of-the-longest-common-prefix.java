class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        //METHOD 1:- USING HASHMAP
        HashMap<String,Integer> map= new HashMap<>();

        //Store prefixes in map
        //Find all the prefixes of each num of arr1
        for (int num: arr1){
            String strNum= Integer.toString(num); //Integer to String
            StringBuilder sb= new StringBuilder(); //SB
            for (char c: strNum.toCharArray()){
                sb.append(c);
                map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+1);
            }
        }

        //Find all the prefixes of each num of arr2
        int maxLength= 0;
        for (int num: arr2){
            String strNum= Integer.toString(num);
            StringBuilder sb= new StringBuilder();
            for (char c: strNum.toCharArray()){
                sb.append(c);
                if (map.containsKey(sb.toString())){
                    maxLength= Math.max(maxLength,sb.length());
                }
            }
        }

        return maxLength;
    }
}