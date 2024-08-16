class Solution {
    public boolean search(int[] nums, int target) {
        //METHOD 1:- LINEAR SEARCH
        for (int num: nums){
            if (num==target)
                return true; //target is present
        }
        return false; //target is not present
        //TC is O(n) and SC is O(1)
    }
}