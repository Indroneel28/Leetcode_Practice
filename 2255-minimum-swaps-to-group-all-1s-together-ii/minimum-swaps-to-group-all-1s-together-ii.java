class Solution {
    public int minSwaps(int[] nums) {
        //SLIDING WINDOW METHOD USING TWO POINTERS
        
        int n= nums.length, totalOnes= 0;

        for (int num: nums){
            totalOnes+=num;
        }

        //Edge cases
        if (totalOnes==0 || totalOnes==n)
            return 0;

        int currentOnes= 0;

        //Total sum of ones of sliding window of size totalOnes
        for (int i=0; i<totalOnes; i++){
            currentOnes+= nums[i];
        }

        int maxOnes= currentOnes;

        //Using two pointers to slide the window
        for (int i=0; i<nums.length; i++){
            currentOnes-= nums[i];
            currentOnes+= nums[(i+totalOnes)%n];

            if (currentOnes>maxOnes)
                maxOnes= currentOnes;
        }

        return totalOnes-maxOnes;
    }
}