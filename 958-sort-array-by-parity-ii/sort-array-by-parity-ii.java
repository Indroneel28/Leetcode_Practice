class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        //METHOD 1:- USING EXTRA ARRAY
        /*
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
         */
        //TC is O(n)

        // Follow Up: Could you solve it in-place?
        //Let's solve using inplace algorithm

        //METHOD 2:- INPLACE ALGORITHM

        int x= nums.length-1;
        for (int i=0; i<nums.length; i++){
            if ((i%2==0 && nums[i]%2==1) || (i%2==1 && nums[i]%2==0)){
                    //Exchange number at index x and i
                    int store= nums[i];
                    nums[i]= nums[x];
                    nums[x]= store;
                    x--; i--; //I-- BECAUSE i-- + i++ = 0 means i is not incremented

            }
            else 
                x= nums.length-1;
        }
        return nums;
    }
}