class Solution {
    public int waysToSplitArray(int[] nums) {
        //OPTIMAL METHOD:- OPTIMIZED PREFIX SUM WITHOUT USING ARRAY
        long endSum= 0;
        for (int ele: nums)
            endSum+= ele;

        long startSum= 0;
        int count= 0;
        for (int i=0; i<nums.length-1; i++){
            startSum+= nums[i];
            endSum-= nums[i];
            if (startSum>=endSum)
                count++;
        }
        return count;
        //TC is O(2n) and SC is O(1)
    }
}