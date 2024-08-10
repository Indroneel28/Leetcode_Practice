class Solution {
    public int[] findErrorNums(int[] nums) {
        // METHOD 1:- BRUTE FORCE APPROACH
        int n = nums.length;
        int repeating = -1, missing = -1;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] == i)
                    count++;
            }
            if (count == 2)
                repeating = i;
            if (count == 0)
                missing = i;
            if (repeating != -1 && missing != -1)
                break;
        }
        return new int[] { repeating, missing };
    }
}