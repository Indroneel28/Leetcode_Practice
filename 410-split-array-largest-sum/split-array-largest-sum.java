class Solution {
   public int splitArray(int[] nums, int k) {
        //METHOD 1:- LINEAR SEARCH
        /*
        int left= 0, right= 0;
        for (int num: nums){
            left= Math.max(left,num); //max in nums
            right+=num; //sum of all ele of nums
        }

        for (int i=left; i<=right; i++){
            if (count(nums,i)==k)
                return i;
        }
        return left;//dummy statement
         */
        //TC is O(n^2) and SC is O(1)

        //METHOD 2:- BINARY SEARCH
        int left= 0, right= 0;
        for (int num: nums){
            left= Math.max(left,num); //max in arr
            right+=num; //sum of all ele in arr
        }
        while (left<=right){
            int mid= (left+right)/2;
            if (count(nums,mid)>k)
                left= mid+1;
            else
                right= mid-1;
        }
        return left;
        //TC is O(nlogn) and SC is O(1)
    }

    //Helper Method
    private int count(int[] nums, int mid){
        int count= 1, c=0;
        for (int num: nums){
            if (num<=mid-c){
                c+= num;
            }
            else {
                count++;
                c= num;
            }
        }
        return count;
    }
}