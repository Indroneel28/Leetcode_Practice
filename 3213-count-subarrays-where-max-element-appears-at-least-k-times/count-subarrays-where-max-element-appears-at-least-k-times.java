class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxEle= nums[0];
        for (int num: nums){
            maxEle= Math.max(num,maxEle);
        }

        long left= 0, right= 0, ans= 0, count =0;
        while (right<nums.length || left>right){
            if (nums[(int)right]==maxEle)
                count++;

            //If count is greater than or equal to k, calculate subarrays count
            while (count>=k){
                if (nums[(int) left]==maxEle)
                    count--;
                left++;
                ans+=nums.length-right;
            }
            right++;
        }
        return ans;
    }
}