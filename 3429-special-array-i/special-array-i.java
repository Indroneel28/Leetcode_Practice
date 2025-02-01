class Solution {
    public boolean isArraySpecial(int[] nums) {
        //OPTIMAL METHOD
        //Different parity means adjacent elements can't be neither both odd nor both even.
        for(int i=0; i<nums.length-1; i++){
            if((nums[i]&1) == (nums[i+1]&1))
                return false;
        }
        return true;
    }
}