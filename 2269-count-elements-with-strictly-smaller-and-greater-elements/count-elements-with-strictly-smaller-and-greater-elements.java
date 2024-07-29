class Solution {
    public int countElements(int[] nums) {
        int count= 0;
        for (int i=0; i<nums.length; i++){
            boolean small= false, large= false;
            for (int j=0; j<nums.length; j++){
                if (nums[j]<nums[i])
                    small= true;
                else if (nums[j]>nums[i])
                    large= true;
                if (large && small){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}