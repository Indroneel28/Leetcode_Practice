class Solution {
    public void sortColors(int[] nums) {
        //STRIVER'S A TO Z COURSE

        //METHOD 1:- Sorting Algorithms like Bubble Sort, Merge Sort, etc
        /*
        for (int i=0; i<nums.length-1; i++){
            for (int j=0; j<nums.length-1; j++){
                if (nums[j]>nums[j+1]){
                    int temp= nums[j];
                    nums[j]= nums[j+1];
                    nums[j+1]= temp;
                }
            }
        }
         */
        //TC will be O(n^2) or O(nlogn)
        //SC will be O(1)

        //METHOD 2:- Using 3 variables and 4 loops
        /*
        int zero= 0, one= 0, two= 0;
        for (int num: nums){
            if (num==0) zero++;
            else if (num==1) one++;
            else two++;
        }

        for (int i=0; i<zero; i++) //runs zero times
            nums[i]= 0;
        for (int i=zero; i<zero+one; i++) //runs one times
            nums[i]= 1;
        for (int i=zero+one; i<nums.length; i++) //runs two times
            nums[i]= 2;
         */
        //TC is O(2n) and Sc is O(1)

        //METHOD 3:- DNF METHOD (Dutch National Flag)
        int low= 0, mid= 0, high= nums.length-1;
        while (mid<=high){
            if (nums[mid]==0){
                swap(nums,low,mid);
                low++; mid++;
            }
            else if (nums[mid]==1)
                mid++;
            else {
                swap(nums,mid,high);
                high--;
                //mid++; //WRONG Because gain we have to check
            }
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp= nums[i];
        nums[i]= nums[j];
        nums[j]= temp;
    }
}