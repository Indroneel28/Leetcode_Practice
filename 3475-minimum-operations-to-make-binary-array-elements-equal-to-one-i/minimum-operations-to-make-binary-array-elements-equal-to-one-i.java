class Solution {
    public int minOperations(int[] nums) {
        //METHOD 1:- GREEDY WORKS!!
        int count= 0;
        for (int i=0; i<nums.length-2; i++){
            if(nums[i]==0){
                nums[i]= 1;
                nums[i+1]= (nums[i+1]==0) ? 1 : 0;
                nums[i+2]=  (nums[i+2]==0) ? 1 : 0;
                count++;
            }
        }
        if(nums[nums.length-1]==1 && nums[nums.length-2]==1)
            return count;
        else //impossible
            return -1;
        //TC is O(n) and SC is O(1)
    }
}