class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        //METHOD 1:- BRUTE FORCE USING LINEAR SEARCH
        /*
        for (int i=1; i<Integer.MAX_VALUE; i++){
            int sum= 0;
            for (int j=0; j<nums.length; j++){
                sum+= Math.ceilDiv(nums[j],i);
            }
            if (sum<=threshold)
                return i;
        }
        return -1;
         */
        //TC is O(n^2) and SC is O(1)

        //METHOD 2:- OPTIMAL SOLUTION USING BINARY SEARCH
        //1 <= nums[i] <= 10^6 //CONSTRAINTS!
        int left= 1, right= 1000000;
        while (left<=right){
            int mid= (left+right)/2;
            if (check(nums,mid,threshold))
                right= mid-1;
            else
                left= mid+1;
        }
        return left;
        //TC is O(nlogn) and SC is O(1)
    }

    private boolean check(int[] nums, int mid, int threshold){
        int sum= 0;
        for (int num: nums){
            sum+= Math.ceilDiv(num,mid);
        }
        return sum<=threshold;
    }
}