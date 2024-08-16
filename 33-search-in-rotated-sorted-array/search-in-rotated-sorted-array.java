class Solution {
    public int search(int[] nums, int target) {
        //METHOD 1:- LINEAR SEARCH
        for (int i=0; i<nums.length; i++){
            if (nums[i]==target)
                return i;
        }
        return -1;
        //TC is O(n) and SC is O(1)
    }
}