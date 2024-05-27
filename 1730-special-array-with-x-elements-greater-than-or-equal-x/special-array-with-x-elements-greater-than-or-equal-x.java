class Solution {
    public int specialArray(int[] nums) {
        int len= nums.length;
        for (int i=len; i>=0; i--){
            int count= 0;
            for (int j=0; j<nums.length; j++){
                if (nums[j]>=i)
                    count++;
            }
            if (i==count)
                return i;
        }
        return -1;
    }
}