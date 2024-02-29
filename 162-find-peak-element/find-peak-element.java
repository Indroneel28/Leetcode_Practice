class Solution {
    public int findPeakElement(int[] nums) {
        int index=0, element=nums[0];
        for (int i=1; i<nums.length; i++){
            if (nums[i]>element){
                index= i;
                element= nums[i];
            }
        }
        return index;
    }
}