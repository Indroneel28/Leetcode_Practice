class Solution {
    //METHOD 1:- RECURSION
    public int findTargetSumWays(int[] nums, int target) {
        return traverse(nums,target,nums.length-1);
    }
    //Helper Method
    private int traverse(int[] nums, int target, int index){
        if (index==-1)
            return target==0 ? 1 : 0;
        int subtract= traverse(nums,target-nums[index],index-1);
        int addition= traverse(nums,target+nums[index],index-1);
        return addition + subtract;
    }
    //TC is O(2^n) and SC is O(n) due to stack space
}