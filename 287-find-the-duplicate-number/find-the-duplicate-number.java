class Solution {
    public int findDuplicate(int[] nums) {
        //METHOD 1:- BY SORTING
        /*
        Arrays.sort(nums);
        for (int i=0; i<nums.length-1; i++){
            if (nums[i]==nums[i+1])
                return nums[i];
        }
        return -1;
         */

        //METHOD 2:- BY USING ARRAY
        //BEATS 100%
        /*
        int[] arr= new int[nums.length];
        for (int num: nums){
            if (arr[num]==0) //If it's 0 means we approach
                arr[num]= 1;
            else
                return num; //arr[num]=1 means it's duplicate
        }
        return nums.length;
         */

        //METHOD 3:- TC: O(N), SC: O(N)
        int slow= 0, fast= 0;
        do{
            slow= nums[slow];
            fast= nums[nums[fast]];
        }while (slow!=fast);

        slow= 0;
        while (slow!=fast){
            slow= nums[slow];
            fast= nums[fast];
        }
        return slow;
    }
}