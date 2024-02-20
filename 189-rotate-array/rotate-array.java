class Solution {
    public void rotate(int[] nums, int k) {
        //METHOD 1
        /*
        for (int i=0; i<k; i++){
            int x= nums[nums.length-1];
            for (int j= nums.length-1; j>0; j--){
                nums[j]= nums[j-1];
            }
            nums[0]= x;
        }
        //TLE
        */
        //Time Complexity is O(n^2) and space complexity is O(1)


        //METHOD 2
        
        int len= nums.length;
        int arr[] = new int[len];
        k= k%len;
        for (int i=len-1; i>=0; i--)
            arr[i]= nums[i-k<0 ? Math.abs(len+i-k)%len : i-k];
        for (int i=0; i<nums.length; i++)
            nums[i]= arr[i];
            
        //TC is O(n^2) and SC is O(n^2)

        //METHOD 3
    //     k %= nums.length;
    // reverse(nums, 0, nums.length - 1);
    // reverse(nums, 0, k - 1);
    // reverse(nums, k, nums.length - 1);
    // }

    // public void reverse(int[] nums, int start, int end) {
    // while (start < end) {
    //     int temp = nums[start];
    //     nums[start] = nums[end];
    //     nums[end] = temp;
    //     start++;
    //     end--;
    // }
    }
}