class Solution {
    public long subArrayRanges(int[] nums) {
        //BRUTE FORCE METHOD:- FIND ALL THE SUB-ARRAYS AND THEIR RANGES
        long sum= 0;
        for (int i=0; i<nums.length; i++){
            long max=Long.MIN_VALUE, min=Long.MAX_VALUE;
            for (int j=i; j<nums.length ; j++){
                max= Math.max(max,nums[j]);
                min= Math.min(min,nums[j]);
                sum+= (max-min);
            }
        }
        return sum;
        //TC is O(n^2) and SC is O(1)
    }
}