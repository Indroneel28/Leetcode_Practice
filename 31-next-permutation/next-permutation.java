class Solution {
    public void nextPermutation(int[] nums) {

        //METHOD 1:- BRUTE FORCE ALGORITHM USING RECURSION
        //Step 1: Find all possible permutations of elements present and store them.
        //Step 2: Search input from all possible permutations.
        //Step 3: Print the next permutation present right after it.


        //METHOD 2:- OPTIMAL SOLUTION
        int n= nums.length;

        int i= n-2;

        // Step 1: Find the first decreasing element from the end
        while (i>=0 && nums[i]>=nums[i+1]){
            i--;
        }

        if(i>=0){
            // Step 2: Find the smallest element on the right side which is larger than nums[i]
            int j= n-1;
            while (nums[j]<=nums[i]){
                j--;
            }
            // Step 3: Swap the found elements
            swap(nums, i, j);
        }
        reverse(nums,i+1,n-1);
    }

    private void swap(int[] arr, int i, int j){
        int temp= arr[i];
        arr[i]= arr[j];
        arr[j]= temp;
    }

    private void reverse(int[] nums, int i, int j){
        while (i<j){
            swap(nums,i,j);
            i++; j--;
        }
    }
}