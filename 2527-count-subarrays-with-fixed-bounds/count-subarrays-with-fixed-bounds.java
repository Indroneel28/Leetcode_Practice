class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long count = 0;
        int j=-1, prevMinKIndex= -1, prevMaxKIndex= -1;
        for (int i=0; i<nums.length; i++){
            if (nums[i]<minK || nums[i]>maxK)
                j=i;
            if (nums[i]==minK)
                prevMinKIndex= i;
            if (nums[i]==maxK)
                prevMaxKIndex= i;
            count+= Math.max(0,Math.min(prevMaxKIndex,prevMinKIndex)-j);
        }
        return count;
    }
}