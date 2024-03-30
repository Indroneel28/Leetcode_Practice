class Solution {
    public int minMaxGame(int[] nums) {
        while (nums.length!=1){
            int[] store= new int[nums.length/2];
            for (int i=0; i<store.length; i++){
                if (i%2==0)
                    store[i]= Math.min(nums[2*i],nums[2*i+1]);
                else
                    store[i]= Math.max(nums[2*i],nums[2*i+1]);
            }
            nums= store;
        }
        return nums[0];
    }
}