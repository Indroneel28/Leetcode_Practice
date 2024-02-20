class Solution {
    public int missingNumber(int[] nums) {
        // Arrays.sort(nums);
        // if(nums.length==1 && nums[0]==0)
        //     return 1;
        // boolean val= false;
        // for (int i=0; i<nums.length-1; i++){
        //     if (nums[i]+1 != nums[i+1])
        //         return nums[i]+1;
        //         if(nums[i]==0)
        //         val=true;
        // }
        // return val==true ? nums.length : 0;

        //Follow-up
        //By using Gauss Law
        int sum= (nums.length)*(nums.length+1)/2;
        int total=0;
        for (int i=0; i< nums.length; i++){
            total+=nums[i];
        }
        return sum-total;
        //Here, TC is O(N)
    }
}