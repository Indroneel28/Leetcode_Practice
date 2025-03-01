class Solution {
    public int[] applyOperations(int[] nums) {
        //BRUTE FORCE METHOD
        int[] temp= new int[nums.length];
        int p= 0; //Points to temp array

        for(int i=0; i<nums.length-1; i++){
            if(nums[i]==nums[i+1]){
                nums[i]*=2;
                nums[i+1]= 0;
            }
            if(nums[i]!=0){
                temp[p++]= nums[i];
            }
        }
        temp[p++]= nums[nums.length-1];
        return temp;
        //TC is O(n) and SC is O(n)
    }
}