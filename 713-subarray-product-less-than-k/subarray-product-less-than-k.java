class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //USING SLIDING WINDOW METHOD
        if (k==0){
            return 0;
        }
        int count= 0;
        int i=0, j=0;
        int pro=1;
        while (i<nums.length){
            pro=pro*nums[i];
            if (pro<k){
                count+=(i-j)+1;
            }
            else {
                while (pro>=k && j<=i){
                    pro/=nums[j];
                    j++;
                }
                count+=(i-j)+1;
            }
            i++;
        }
        return count;
    }
}