class Solution {
    public int waysToSplitArray(int[] nums) {
        //BETTER METHOD:- USING RIGHT ARRAY AND LEFT ARRAY
        int n= nums.length;
        long[] leftArray= new long[n];
        long[] rightArray= new long[n];
        
        leftArray[0]= nums[0];
        for (int i=1; i<n;i++){
            leftArray[i]= leftArray[i-1]+nums[i];
        }
        rightArray[n-1]= nums[n-1];
        for (int i=n-2; i>=0; i--){
            rightArray[i]= rightArray[i+1]+nums[i];
        }

        int count= 0;
        for (int i=0; i<n-1; i++){
            if (leftArray[i]>=rightArray[i+1])
                count++;
        }
        return count;
        //TC is O(3n) and SC is O(2n)
        
        //NOTE:- We can further optimize it into TC= O(2n) and SC= O(n) by using only rightArray.
    }
}