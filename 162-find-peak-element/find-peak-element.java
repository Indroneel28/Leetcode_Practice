class Solution {
    public int findPeakElement(int[] nums) {
        // If the array contains multiple peaks, return the index to any of the peaks.
        if (nums.length==1)
            return 0;
    
        int i=0, j= nums.length-1;
         while (i<=j){
            int mid= (i+j)/2;
            if (mid==0 && nums[mid]>nums[mid+1])
                return mid;
            else if (mid==nums.length-1 && nums[mid]>nums[mid-1])
                return mid;
            else if (nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1])
                return mid;
            
            else if (nums[mid]<nums[mid+1])
                i= mid+1;
            else
                j= mid-1;
        }
        return -1; //will never execute as for constraints

    }
}