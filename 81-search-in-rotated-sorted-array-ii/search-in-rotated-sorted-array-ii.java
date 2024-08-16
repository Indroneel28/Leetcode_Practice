class Solution {
    public boolean search(int[] nums, int target) {
        //METHOD 1:- LINEAR SEARCH
        /*
        for (int num: nums){
            if (num==target)
                return true; //target is present
        }
        return false; //target is not present
        //TC is O(n) and SC is O(1)
         */

        //METHOD 2:- BINARY SEARCH
        int left= 0, right= nums.length-1;

        while (left<=right){
            int mid= (left+right)/2;

            if (nums[mid]==target)
                return true;

            //New condition added as we can't decide which part is sorted
            else if (nums[left]==nums[mid] && nums[mid]==nums[right]){
                left++;
                right--;
            }

            //If Left part is sorted
            else if (nums[left]<=nums[mid]){
                if (nums[left]<=target && target<=nums[mid]){
                    right= mid-1;
                }
                else{
                    left= mid+1;
                }
            }

            //If Right part is sorted
            else{
                if (nums[mid]<=target && target<=nums[right]){
                    left= mid+1;
                }
                else {
                    right= mid-1;
                }
            }
        }
        
        return false; //Element not found
        //TC is O(n/2) in worst case because if array contain only duplicates then it will run n/2 times.
        //SC is O(1)
    }
}