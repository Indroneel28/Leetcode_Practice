class Solution {
    public void moveZeroes(int[] nums) {
        //USING TWO POINTERS METHOD
        int j=0;
        for (int i=0; i<nums.length && j<nums.length; i++){
            if (nums[i]==0){
                if (nums[j]!=0){
                    //swap
                    int temp= nums[i];
                    nums[i]= nums[j];
                    nums[j]= temp;
                    j=i; //restore j again
                }
                i--;
            }
            j++;
        }
    }
}