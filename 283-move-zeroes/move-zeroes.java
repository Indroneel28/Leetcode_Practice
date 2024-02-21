class Solution {
    public void moveZeroes(int[] nums) {
        //USING TWO POINTERS METHOD

        //COMPLEX METHOD
        /*
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
        //BUT ONLY ONE FOR LOOP SO IT'S GOOD
         */

        //EASY METHOD
        int c= 0;
        for (int i=0; i<nums.length; i++){
            if (nums[i]!=0){
                nums[c]= nums[i];
                c++;
            }
        }
        
        for (int i=c; i<nums.length; i++)
            nums[i]= 0;
    }
}