class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return traverse(nums,goal)-traverse(nums,goal-1);
    }
    private int traverse(int[] nums, int goal){
        //USING TWO POINTERS METHOD
        int start=0, sum=0, ans= 0;

        for (int end=0; end<nums.length; end++){
            sum+=nums[end];
            while (sum>goal && start<=end){
                sum-=nums[start];
                start++;
            }
            ans+=end-start+1;
        }
        return ans;
    }
}