class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list= new ArrayList<>();
        if (nums.length==0)
            return list;
        int j= 0;
        for (int i=0; i<nums.length; i++){
            if (i+1==nums.length || nums[i]!=nums[i+1]-1 ){
                if (i==j)
                    list.add(String.valueOf(nums[i]));
                else
                    list.add(String.valueOf(nums[j]+"->"+nums[i]));
                j= i+1;
            }
        }
        return list;
    }
}