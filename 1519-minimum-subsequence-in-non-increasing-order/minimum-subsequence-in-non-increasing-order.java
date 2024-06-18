class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> list= new ArrayList<>();

        if (nums.length==1){
            list.add(nums[0]);
            return list;
        }

        int left= 0, right= nums.length-1, totalR= 0, totalL= 0;
        Arrays.sort(nums); //Sorting the numbers

        while (left<=right){
            if (totalR<=totalL) {
                totalR += nums[right];
                list.add(nums[right]);
                right--;
            }
            else {
                totalL += nums[left];
                left++;
            }
        }

        //Checking for the last stage( maybe totalL became greater than totalR at last stage)
        if (totalL>=totalR){
            list.add(nums[left-1]);
        }
        
        return list;
    }
}