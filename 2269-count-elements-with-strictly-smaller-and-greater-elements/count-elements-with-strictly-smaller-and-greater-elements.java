class Solution {
    public int countElements(int[] nums) {
        //METHOD 1:- Brute Force Method
        /*
        int count= 0;
        for (int i=0; i<nums.length; i++){
            boolean small= false, large= false;
            //Finding smaller and larger elements than nums[i]
            for (int j=0; j<nums.length; j++){
                if (nums[j]<nums[i]) //For smaller element
                    small= true;
                else if (nums[j]>nums[i]) //For larger element
                    large= true;
                if (large && small){ //if large and small element exists
                    count++;
                    break;
                }
            }
        }
        return count;
         */
        //TC is O(N^2) and SC is O(1)

        //METHOD 2:- USING BRAIN
        //Let's find smallest and largest element of the array
        int largest= nums[0], smallest= nums[0];
        for (int num: nums){
            if (num>largest)
                largest= num;
            else if (num<smallest)
                smallest= num;
        }
        
        int count= 0;
        for (int num: nums){
            if (num!=largest && num!=smallest)
                count++;
        }
        return count;
        //TC is O(2n) and Sc is O(1)
    }
}