class Solution {
    public int longestOnes(int[] nums, int k) {
        //BETTER METHOD:- TWO POINTERS AND SLIDING WINDOW
        int maxLen=0, count0= 0;
        int left=0, right= 0;
        while (right<nums.length){
            if (nums[right]==0)
                count0++;
            while (count0>k){
                if (nums[left]==0)
                    count0--;
                left++;
            }
            maxLen= Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;
        //TC is O(2n) and SC is O(n)
    }
}