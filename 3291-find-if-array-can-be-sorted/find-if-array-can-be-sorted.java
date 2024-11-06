class Solution {
    public boolean canSortArray(int[] nums) {
        //BUBBLE SORT
        for (int i=0; i<nums.length-1; i++){
            for (int j=0; j<nums.length-1-i; j++){
                if (nums[j+1]<nums[j]){
                    if (Integer.bitCount(nums[j+1])==Integer.bitCount(nums[j])){
                        int temp= nums[j];
                        nums[j]= nums[j+1];
                        nums[j+1]=temp;
                    }
                    else
                        return false;
                }
            }
        }
        return true;
        //TC is O(n^2*256) and SC is O(1)
    }
}