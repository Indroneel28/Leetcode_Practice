class Solution {
    public int[] rearrangeArray(int[] nums) {
        //USING 3-POINTERS METHOD
        int[] newArray= new int[nums.length];
        int m= 0, n=1; //m is pointing +ve number and n is pointing -ve number
        for (int i=0; i<newArray.length; i++){
            if (nums[i]>=0){
                newArray[m]= nums[i];
                m+=2;
            }
            else {
                newArray[n]= nums[i];
                n+=2;
            }
        }
        return newArray;
    }
}