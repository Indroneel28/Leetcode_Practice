class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOne= 0, countOne= 0;
        for (int i=0; i<nums.length; i++){
            if (nums[i]==0)
                countOne= 0;
            else{
                countOne++;
                if (countOne>maxOne)
                    maxOne= countOne;
            }
        }
        return maxOne;
    }
}