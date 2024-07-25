class Solution {
    public void moveZeroes(int[] nums) {
        //Two Pointers with swapping in single iteration
        int m=0;
        for (int i=0; i<nums.length; i++){
            if (nums[i]!=0) {
                //swap nums[m] && nums[i]
                int temp= nums[m];
                nums[m] = nums[i];
                nums[i]= temp;
                m++;
            }
        }
    }
}