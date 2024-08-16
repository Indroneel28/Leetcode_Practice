class Solution {
    public int findMin(int[] nums) {
        //METHOD 1:- LINEAR SEARCH
        /*
        int min= nums[0];
        for (int num: nums){
            min= Math.min(min,num);
        }
        return min;
         */
        //TC is O(n) and SC is O(1)

        //METHOD 2:- BINARY SEARCH
        int left= 0, right= nums.length-1, min= Integer.MAX_VALUE;
        while (left<=right){
            int mid= (left+right)/2;
            //If left part is sorted
            if (nums[left]<=nums[mid]){
                min= Math.min(min,nums[left]); //nums[left] is the smallest in the left part
                left= mid+1; //Move to right part
            }
            //If right part is sorted
            else{
                min= Math.min(min,nums[mid]); //nums[mid] is the smallest in the right part
                right= mid-1; //Move to the left part
            }
        }
        return min;
        //TC is O(logN) and SC is O(1)
    }
}