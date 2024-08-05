class Solution {
    public String kthDistinct(String[] arr, int k) {
        //METHOD 1:- BRUTE FORCE APPROACH
        /*
        int count= 0;
        for (int i=0; i<arr.length; i++){
            int occurence= 0; //will count occurrence of arr[1
            for (int j=0; j<arr.length; j++){
                if (arr[i].equals(arr[j])){
                    occurence++;
                }
            }
            if (occurence==1){ //means arr[i] is distinct and unique in the array
                count++;
                if (count==k)
                    return arr[i];
            }
        }
        return "";
        */
        //TC is O(n^2) and SC is O(1)

        //METHOD 2:-BY USING HASHMAP
        LinkedHashMap<String, Integer> map= new LinkedHashMap<>();
        //NOTE:- LinkedHashMap maintains the order of elements inserted into it while HashMap is unordered.
        for (String str: arr){
            map.put(str, map.getOrDefault(str,0)+1);
        }
        int count= 0;
        for (String str: map.keySet()){
            if (map.get(str)==1){
                count++;
                if (count==k)
                    return str;
            }
        }
        return "";
        //TC is O(n) and SC is O(n)
    }
}