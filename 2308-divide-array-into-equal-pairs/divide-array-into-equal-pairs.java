class Solution {
    public boolean divideArray(int[] nums) {
        //USING HASHMAP
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(int val: map.values()){
            if(val%2==1)
                return false;
        }
        return true;
        //TC is O(2n) and SC is O(2n)
    }
}