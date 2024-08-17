class Solution {
    public int findPeakElement(int[] nums) {
        //STRIVER'S A TO Z

        //METHOD 1:- LINEAR SEARCH
        /*
        int n= nums.length;

        //EDGE CASES
        if (nums.length==1)
            return 0;
        if (nums[0]>nums[1])
            return 0;
        if (nums[n-1]>nums[n-2])
            return n-1;

        for (int i=1; i<n-1; i++){
            if (nums[i]>nums[i-1] && nums[i]>nums[i+1])
                return i;
        }
        return -1; //Dummy statement
         */

        //TC is O(n) and SC is O(1)

        //METHOD 2:- BINARY SEARCH
        int n= nums.length;

        //EDGE CASES
        if (n==1)
            return 0;
        if (nums[0]>nums[1])
            return 0;
        if (nums[n-1]>nums[n-2])
            return n-1;

        //int left= 0, right= n-1; //It's Correct NP
        int left= 1, right= n-2; //Better to write (professional)
        while (left<=right){
            int mid= (left+right)/2;
            if (nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1])
                return mid; //Index of the peak element
            else if (nums[mid+1]>nums[mid]){
                //peak is present at right
                left= mid+1;
            }
            else {
                //peak is present at left
                right= mid-1;
            }
        }
        return -1;
    }
}