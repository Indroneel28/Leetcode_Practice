class Solution {
    public int searchInsert(int[] nums, int target) {
        //USING BINARY SEARCH
        //HERE, WE WILL FIND THE CEIL
        int ceil= nums.length;
        int left= 0, right= nums.length-1;
        while(left<=right){
            int mid= (left+right)/2;
            if(nums[mid]>=target){
                ceil= mid;
                right= mid-1;
            }
            else{
                left= mid+1;
            }
        }
        return ceil;
    }
}