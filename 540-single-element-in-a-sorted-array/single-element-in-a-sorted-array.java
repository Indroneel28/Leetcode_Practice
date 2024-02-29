class Solution {
    public int singleNonDuplicate(int[] nums) {
        /*
        //If array contains only one element
        if(nums.length==1){
            return nums[0];
        }
        //Checking for  last element
        if (nums[nums.length-1]!=nums[nums.length-2])
            return nums[nums.length-1];
        for (int i=0; i<nums.length-1; i+=2){
            if (nums[i]!=nums[i+1])
                return nums[i];
        }
        return -1;
        */
        //USING BINARY SEARCH

        //If array contains only one element
        if(nums.length==1){
            return nums[0];
        }
        //Checking for first element
        if (nums[0]!=nums[1])
            return nums[0];
        //Checking for  last element
        if (nums[nums.length-1]!=nums[nums.length-2])
            return nums[nums.length-1];

        //Binary Search
        // 0, 1, 2 , 3, 4, 5, 6,
        //1,  1, 2,  2, 3, 4,  4,
        int i= 1, j= nums.length-1;
        while (i<=j){
            int mid= (i+j)/2;
            if (nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1])
                return nums[mid];
            if (mid%2==1 && nums[mid]==nums[mid-1]){
                i= mid+1;
            }
            else if (mid%2==1 && nums[mid]==nums[mid+1]){
                j= mid-1;
            }
            else if (mid%2==0 && nums[mid]==nums[mid+1]){
                i= mid+1;
            }
            else if (mid%2==0 && nums[mid]==nums[mid-1]){
                j= mid-1;
            }
        }
        return -1;
    }
}