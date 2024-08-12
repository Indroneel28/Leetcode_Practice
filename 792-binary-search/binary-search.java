class Solution {
    public int search(int[] nums, int target) {
        //METHOD 1:- ITERATIVE APPROACH
        /*
        int low= 0, high= nums.length-1;
        while (low<=high){
            int mid =(low+high)/2;
            if (nums[mid]==target)
                return mid;
            else if (nums[mid]<target){
                low= mid+1;
            }
            else{
                high= mid-1;
            }
        }
        return -1;
         */
        //TC is O(logn) and SC is O(1)
        
        //METHOD 2:- RECURSIVE APPROACH
        return binarySearch(nums,target,0,nums.length-1);
        //TC is O(logn) and SC is O(logn) due too stack space
    }

    private int binarySearch(int[] nums, int target, int low, int high){
        if (low>high)
            return -1;
        int mid= (low+high)/2;
        if (nums[mid]==target)
            return mid;
        else if (nums[mid]>target)
            return binarySearch(nums,target,low,mid-1);
        else
            return binarySearch(nums,target,mid+1,high);
    }
}