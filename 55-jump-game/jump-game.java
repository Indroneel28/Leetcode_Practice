class Solution {
    public boolean canJump(int[] nums) {
        //OPTIMAL METHOD:- GREEDY APPROACH
        int maxIndex= 0;
        for (int i=0; i<nums.length; i++){
            if (i>maxIndex)
                return false;
            maxIndex= Math.max(maxIndex,i+nums[i]);
            if (maxIndex>= nums.length)
                return true;
        }
        return true;
        //TC is O(n) and SC is O(1)
    }
}