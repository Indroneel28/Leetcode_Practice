class Solution {
    public long largestPerimeter(int[] nums) {
        //USING GREEDY STRATEGY:- SORT IN INCREASING ORDER
        /*
        Arrays.sort(nums);
        int n= nums.length-1;
        for (int i=n; i>=0; i--){
            long sum= 0;
            for (int j= i-1; j>=0; j--){
                sum+= nums[j];
            }
            if (sum > nums[i]) //strictly greater
                return sum+nums[i];
        }
        return -1;
         */
        //TC:- O(n^2)

        //USING GREEDY STRATEGY 2
        Arrays.sort(nums);
        long previousSum= 0;
        long ans= -1;
        for (int num: nums){
            if (previousSum > num)
                ans= previousSum+num;
            previousSum+=num;
        }
        return ans;
        //TC:- O(nlog) because sorting dominates
    }
}