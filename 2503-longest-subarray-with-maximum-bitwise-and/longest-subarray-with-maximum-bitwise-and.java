class Solution {
    public int longestSubarray(int[] nums) {
        //OPTIMAL METHOD:- Find the maximum element and it's consecutive occurrences
        int maxOccur= nums[0], maxCount= 1, count= 1;
        int prev= nums[0];
        for (int i=1; i< nums.length; i++ ){
            if (nums[i]>prev && nums[i]>maxOccur) {
                maxOccur = nums[i];
                count= 1;
                maxCount= 1;
            }
            else if (nums[i]>prev && nums[i]>=maxOccur){
                count=1;
            }
            else if (nums[i]==prev && nums[i]==maxOccur) {
                count++;
            }
            maxCount = Math.max(count, maxCount);
            prev= nums[i];
        }
        return maxCount;
        //TC is O(n) and SC is O(1)
    }
}