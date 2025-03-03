class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        //METHOD 2:- USING TWO POINTERS AND ARRAY
        int left= 0, right= nums.length-1;
        int[] temp= new int[nums.length];

        for(int i=0; i<nums.length; i++){
            if (nums[i]<pivot)
                temp[left++]= nums[i];
        }

        for (int j=nums.length-1; j>=0; j--){
            if (nums[j]>pivot)
                temp[right--]= nums[j];
        }

        for (int i=left; i<=right; i++){
            temp[i]= pivot;
        }
        return temp;
        //TC is O(2n) and SC is O(n)
    }
}