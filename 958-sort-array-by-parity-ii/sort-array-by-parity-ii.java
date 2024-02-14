class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        //METHOD 1:- USING EXTRA ARRAY
        int[] store= new int[nums.length];
        int m=0, n=1;
        //Even indexes(0,2,4,...) should be even and odd indexes(1,3,5,...) should be odd
        for (int i=0; i<nums.length; i++){
            if(nums[i]%2==0){
                store[m]= nums[i];
                m+=2;
            }
            else {
                store[n]= nums[i];
                n+=2;
            }
        }
        return store;
    }
}