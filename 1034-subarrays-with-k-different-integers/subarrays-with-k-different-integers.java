class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        //OPTIMAL METHOD
        return traverse(nums,k) - traverse(nums,k-1);
        //TC is O(4n) and SC is O(2n)
    }
    private int traverse(int[] nums, int k){
        int left= 0, right= 0, subArray= 0;
        Map<Integer,Integer> map= new HashMap<>();
        while (right<nums.length){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while (map.size()>k){
                int rem= nums[left];
                if (map.get(rem)==1)
                    map.remove(rem);
                else
                    map.put(rem,map.get(rem)-1);
                left++;
            }
            subArray += right-left+1;
            right++;
        }
        return subArray;
    }
}