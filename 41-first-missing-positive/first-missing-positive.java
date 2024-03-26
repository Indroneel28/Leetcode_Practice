class Solution {
    public int firstMissingPositive(int[] nums) {
        //USING HASHMAP
        HashMap<Integer,Integer> hashMap= new HashMap<>();
        for (int ele: nums){
            if (ele>0){
                hashMap.put(ele,hashMap.getOrDefault(ele,0)+1);
            }
        }

        for (int i=1; i<=Integer.MAX_VALUE; i++){
            if (!hashMap.containsKey(i))
                return i;
        }
        return -1;
    }
}