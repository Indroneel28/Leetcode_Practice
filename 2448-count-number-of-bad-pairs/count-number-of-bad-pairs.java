class Solution {
    public long countBadPairs(int[] nums) {
        //OPTIMAL METHOD:- USING HASHMAP
        // bad-pair if j-i != nums[j]-nums[i]
        // => nums[i]-i != nums[j]-j where i<j
        HashMap<Integer,Integer> map= new HashMap<>();
        long badPairs= 0;
        for (int i=0; i<nums.length; i++){
            int ele= nums[i]-i;
            badPairs += (i-map.getOrDefault(ele,0));
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        return badPairs;
        //TC is O(n) and SC is O(n)
    }
}