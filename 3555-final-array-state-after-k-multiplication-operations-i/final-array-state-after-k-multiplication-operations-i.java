class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        //BRUTE FORCE METHOD
        for (int i=0; i<k; i++){
            //Find min
            int index= 0, min= nums[0];
            for (int j=1; j<nums.length; j++){
                if (nums[j]<min){
                    min= nums[j];
                    index= j;
                }
            }
            nums[index]= nums[index]*multiplier;
        }
        return nums;
    }
}