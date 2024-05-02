class Solution {
    public int findMaxK(int[] nums) {
        //Brute Force
        int max= -1;
        for (int i=0; i<nums.length; i++){
            for (int j=i+1; j<nums.length; j++){
                if (nums[i]==-nums[j]){
                    if (Math.abs(nums[i])>max)
                        max= Math.abs(nums[i]);
                }
            }
        }
        return max;
    }
}