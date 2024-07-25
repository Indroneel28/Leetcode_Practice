class Solution {
    public void rotate(int[] nums, int k) {
        //IN INTERVIEWS, START FROM NAIVE TO OPTIMAL APPROACH

        //METHOD 1:- Brute Force Approach (First Method)
        /*
        for (int i=0; i<k; i++){
            int x= nums[nums.length-1];
            for (int j= nums.length-1; j>0; j--){
                nums[j]= nums[j-1];
            }
            nums[0]= x;
        }

         */
        //Time Complexity is O(n^2) and space complexity is O(1)

        //METHOD 2:- Using Extra data structure (Don't use this method)
        /*
        int len= nums.length;
        int arr[] = new int[len];
        for (int i=len-1; i>=0; i--)
            arr[i]= nums[i-k<0 ? Math.abs(len+i-k)%len : i-k];
        for (int i=0; i<nums.length; i++)
            nums[i]= arr[i];
        //TC is O(n) and SC is O(n)
         */

        //METHOD 3:- Using extra data structure of size k
        int n= nums.length;
        k= k%n;
        int[] temp= new int[k];
        for (int i=n-k; i<n; i++){
            temp[i-(n-k)]= nums[i];
        }
        for (int i=n-1; i>=k; i--){
            nums[i]= nums[i-k];
        }
        for (int i=0; i<k; i++){
            nums[i]= temp[i];
        }
    }
}