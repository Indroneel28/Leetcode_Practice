class Solution {
    public int longestConsecutive(int[] nums) {
        //USING SORTING
        Arrays.sort(nums);
        int maxCount=1, count =1;
        //Count is 1 because any element count is 1

        if (nums.length==0 || nums.length==1)
            return nums.length;
        
        for (int i=0; i<nums.length-1; i++){
            if(nums[i]==nums[i+1])
                continue;
            if (nums[i]+1==nums[i+1]){
                count++;
                if (count>maxCount)
                    maxCount= count;
            }
            else{
                count=1;
            }
        }
        return maxCount;
    }
}