class Solution {
    //Helper Method to find the first occurrence
    private int firstOccurrence(int[] nums, int target){
        int occurrence= -1;
        int left= 0, right= nums.length-1;
        while (left<=right){
            int mid= (left+right)/2;
            if (nums[mid]==target){
                occurrence= mid;
                right= mid-1; //Check left
            }
            else if (nums[mid]>target){
                right= mid-1;
            }
            else {
                left= mid+1;
            }
        }
        return occurrence;
    }

    //Helper Method to find the last occurrence
    private int lastOccurance(int[] nums, int target){
        int occurrence= -1;
        int left= 0, right= nums.length-1;
        while (left<=right){
            int mid= (left+right)/2;
            if (nums[mid]==target){
                occurrence= mid;
                left= mid+1; //Check right
            }
            else if (nums[mid]>target){
                right= mid-1;
            }
            else{
                left= mid+1;
            }
        }
        return occurrence;
    }

    public int[] searchRange(int[] nums, int target) {

        //Method 1:- Linear Search
        /*
        int[] arr= {-1,-1};
        for (int i=0; i<nums.length; i++){
            if (nums[i]==target){
                arr[1]= i;
                if (arr[0]==-1)
                    arr[0]= i;
            }
            if (nums[i]>target)
                break;
        }
        return arr;
         */

        //You must write an algorithm with O(log n) runtime complexity.
        //Method 2:- Binary Search
        return new int[]{firstOccurrence(nums,target),lastOccurance(nums,target)};
    }
}