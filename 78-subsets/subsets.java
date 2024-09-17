class Solution {
    //METHOD 2:- USING BIT MANIPULATION
    public List<List<Integer>> subsets(int[] nums) {
        //To store the subsets
        List<List<Integer>> answer= new ArrayList<>();
        
        int limit= (int) Math.pow(2,nums.length);
        //If len=3 then power set will contain 2^3= 8 elements
        
        for (int i=0; i<limit; i++){
            List<Integer> list= new ArrayList<>();
            int index= i;
            for (int j=0; j<nums.length; j++){
                if ((index&1) == 1)
                    list.add(nums[j]);
                index= index>>>1;
            }
            answer.add(list);
        }
        return answer;
        //TC is O(2^n * n) and SC is O(2^n * n)
    }
}