class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        //OPTIMAL METHOD:- USING SLIDING WINDOW
        return traverse(nums,k)-traverse(nums,k-1);
        //TC is O(4n) and SC is O(1)
    }
    private int traverse(int[] nums, int k){
        int left= 0, right= 0, countOdds= 0, subArrays= 0;
        while (right<nums.length){
            if ((nums[right]&1)==1) //Odd Number
                countOdds++;
            while (countOdds>k){
                if((nums[left]&1)==1) //Odd Number
                    countOdds--;
                left++;
            }
            subArrays+= right-left+1; 
            right++;
        }
        return subArrays;
    }
}