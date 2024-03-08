class Solution {
    public int maxFrequencyElements(int[] nums) {
        //USING ARRAY
        int arr[]= new int[101]; //1 <= nums[i] <= 100
        for (int i=0; i<nums.length; i++)
            arr[nums[i]]++;
        int max= 0;
        for (int a: arr){
            if (a>max)
                max= a;
        }

        int count= 0;
        for(int a: arr){
            if (a==max)
                count+=a;
        }
        return count;
    }
}