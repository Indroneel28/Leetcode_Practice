class Solution {
    //OPTIMAL METHOD:- Using variables and traversal
    public int longestMonotonicSubarray(int[] nums) {
        int maximum= 1;
        int prev= nums[0];
        int increase= 1, decrease= 1;
        for (int i=1; i<nums.length; i++){
            if (nums[i]>prev)
                increase++;
            else
                increase= 1;
            if (nums[i]<prev)
                decrease++;
            else
                decrease= 1;
            prev= nums[i];
            maximum= Math.max(maximum, Math.max(increase,decrease));
        }
        return maximum;
    }
    //TC is O(n) and SC is O(1)
}