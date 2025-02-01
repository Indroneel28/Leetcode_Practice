class Solution {
    public int findNumbers(int[] nums) {
        //OPTIMAL METHOD
        int count= 0;
        for(int num: nums){
            if(isEvenDigits(num))
                count++;
        }
        return count;
        //TC is O(nlogn) and SC is O(1)
    }
    private boolean isEvenDigits(int num){
        int c= 0; //Count number of digits
        while(num!=0){
            c++; 
            num/= 10;
        }
        return (c&1)==0; //Even number
    }
}