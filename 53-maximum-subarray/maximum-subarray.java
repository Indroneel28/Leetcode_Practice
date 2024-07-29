class Solution {
    public int maxSubArray(int[] nums) {
        //STRIVER'S A TO Z DSA COURSE

        //METHOD 1:- BRUTE FORCE METHOD
        //Generate all the sub arrays sum
        //Using two loops (OPTIMIZED BRUTE FORCE)

        /*
        int maxSum= 0;
        for (int i=0; i<nums.length; i++){
            int sum= 0;
            for (int j=i; j<nums.length; j++){
                sum+= nums[j];
                maxSum= Math.max(sum,maxSum);
            }
        }
        return maxSum;
         */
        //TC is O(n^2) and Sc is O(1)
        
        //METHOD 2:- KADANE'S ALGORITHM
        int sum=0, maxSum=Integer.MIN_VALUE;
        for (int num: nums){
            sum+= num;
            maxSum= Math.max(sum,maxSum);
            if (sum<0)
                sum= 0;
        }
        return maxSum;
    }
}