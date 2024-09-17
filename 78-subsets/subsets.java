class Solution {
    //METHOD 1:- USING RECURSION AND BACKTRACKING
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer= new ArrayList<>();
        traverse(answer,nums,new ArrayList<>(),0);
        return answer;
    }
    //TC is O(2^n) and SC is O(n)

    //Recursion and Backtracking
    private void traverse(List<List<Integer>> answer, int[] nums, List<Integer> list, int index){
        if (index==nums.length) {
            answer.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        traverse(answer,nums,list,index+1);
        list.remove(list.size()-1); //Remove the last inserted element //BACKTRACK
        traverse(answer,nums,list,index+1);
    }
}