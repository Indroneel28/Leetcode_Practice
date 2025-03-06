class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        //METHOD 1:- USING LIS CONCEPT
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] hash = new int[nums.length];
        for(int i=0; i<hash.length; i++){
            hash[i]= i;
        }
        int max = 1, maxIndex = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < 1 + dp[j]) {
                    dp[i] = 1 + dp[j];
                    hash[i] = j;
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                maxIndex = i;
            }
        }

        List<Integer> list = new ArrayList<Integer>();
        while (maxIndex != hash[maxIndex]) {
            list.add(0, nums[maxIndex]);
            maxIndex = hash[maxIndex];
        }
        list.add(0,nums[maxIndex]);
        return list;
        //TC is O(n^2 + n) and SC is O(2n)
    }
}