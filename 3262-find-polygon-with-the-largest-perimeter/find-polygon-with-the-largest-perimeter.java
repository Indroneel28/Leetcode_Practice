class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n= nums.length-1;
        for (int i=n; i>=0; i--){
            long sum= 0;
            for (int j= i-1; j>=0; j--){
                sum+= nums[j];
            }
            if (sum>nums[i])
                return sum+nums[i];
        }
        return -1;
    }
}