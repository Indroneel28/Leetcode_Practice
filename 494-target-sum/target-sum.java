class Solution {
    //METHOD 1:- RECURSION
    public int findTargetSumWays(int[] nums, int target) {
        return recursion(nums,target,nums.length-1,0);
    }
    private int recursion(int[] nums, int target, int index, int sum){
        if (target==sum && index==-1)
            return 1;
        if (index==-1)
            return 0;
        int add= 0, subtract= 0;
        add= recursion(nums,target,index-1,sum-nums[index]);
        subtract= recursion(nums,target,index-1, sum+nums[index]);
        return add + subtract;
    } 
}