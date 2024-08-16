class Solution {
    public int search(int[] nums, int target) {
        //METHOD 1:- LINEAR SEARCH
        /*
        for (int i=0; i<nums.length; i++){
            if (nums[i]==target)
                return i;
        }
        return -1;
         */
        //TC is O(n) and SC is O(1)

        //METHOD 2:- BINARY SEARCH
        int left= 0, right= nums.length-1;
        while (left<=right){
            int mid= (left+right)/2;
            if (nums[mid]==target)
                return mid;

            //This means left array is sorted
            else if (nums[left]<=nums[mid]){
                if (nums[left]<=target && target<=nums[mid]){
                    right= mid-1;
                }
                else{
                    left= mid+1;
                }
            }

            //This means right array is sorted
            else{
                if (nums[mid]<=target && target<=nums[right]){
                    left= mid+1;
                }
                else {
                    right= mid-1;
                }
            }
        }
        return -1; //target not found
    }
}