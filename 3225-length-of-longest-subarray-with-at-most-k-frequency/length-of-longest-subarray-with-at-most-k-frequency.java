class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        //METHOD 2:- USING SLIDING WINDOW AND TWO POINTERS
        int maxLen= 0;
        HashMap<Integer,Integer> hashMap= new HashMap<>();
        int left=0;
        for (int right=0; right<nums.length; right++){
            int ele= nums[right];
            hashMap.put(ele,hashMap.getOrDefault(ele,0)+1);
            while (hashMap.get(ele)>k){
                hashMap.put(nums[left],hashMap.get(nums[left])-1);
                left++;
            }
            maxLen= Math.max(maxLen,right-left+1);
        }
        return maxLen;
    }
}