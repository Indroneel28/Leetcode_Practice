class Solution {
    public void moveZeroes(int[] nums) {
        int m=0;
        for (int i=0; i<nums.length; i++){
            if (nums[i]!=0)
                nums[m++]= nums[i];
        }
        for (int i=m; i<nums.length; i++)
            nums[i]= 0;
    }
}