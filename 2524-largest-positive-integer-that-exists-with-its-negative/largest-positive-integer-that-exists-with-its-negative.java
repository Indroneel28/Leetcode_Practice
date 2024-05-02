class Solution {
    public int findMaxK(int[] nums) {
        //Sorting and two pointers
        Arrays.sort(nums);
        int left=0, right= nums.length-1;
        int max= -1;
        while (left<right){
            if (nums[left]==-nums[right]){
                if (Math.abs(nums[left])>max){
                    max= Math.abs(nums[left]);
                }
                left++;
                right--;
            }
            else if (Math.abs(nums[left])<Math.abs(nums[right]))
                right--;
            else 
                left++;
        }
        return max;
    }
}