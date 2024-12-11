class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length, res=1, i=0, j=0,m=0;
        while(j<len){
            while(i<j && nums[i]+k<nums[j]-k){
                i++;
            }
            res = Math.max(j-i+1, res);
            j++;
        }
        return res;
    }
}