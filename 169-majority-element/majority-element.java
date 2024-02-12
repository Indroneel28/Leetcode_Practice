class Solution {
    public int majorityElement(int[] nums) {
        int major= 0, count=0;
        for (int i=0; i< nums.length; i++){
            if (nums[i]==major)
                count++;
            else 
                count--;
            if (count<0){
                major= nums[i];
                count=1;
            }
        }
        return major;
    }
}