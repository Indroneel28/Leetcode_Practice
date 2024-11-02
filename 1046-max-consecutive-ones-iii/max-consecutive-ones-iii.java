class Solution {
    public int longestOnes(int[] nums, int k) {
        //OPTIMAL METHOD:- SLIGHT CHANGES ON BETTER METHOD
        int maxLen= 0, count0= 0, left= 0, right= 0;
        while (right < nums.length){
            if (nums[right]==0)
                count0++;
            if (count0>k){
                if (nums[left]==0)
                    count0--;
                left++;
            }
            if (count0<=k){
                int len= right-left+1;
                maxLen= Math.max(maxLen,len);
            }
            right++;
        }
        return maxLen;
        //TC is O(n) and SC is O(n)
    }
}