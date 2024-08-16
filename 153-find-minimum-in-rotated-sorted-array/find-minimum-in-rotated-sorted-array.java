class Solution {
    public int findMin(int[] nums) {
        //METHOD 1:- LINEAR SEARCH
        int min= nums[0];
        for (int num: nums){
            min= Math.min(min,num);
        }
        return min;
        //TC is O(n) and SC is O(1)
    }
}