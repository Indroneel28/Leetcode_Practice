class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOne= 0, countOne= 0;
        for (int num: nums){
            if (num==1) {
                countOne++;
                maxOne= Math.max(maxOne,countOne);
            }
            else
                countOne= 0;
        }
        return maxOne;
    }
}