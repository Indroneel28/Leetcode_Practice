class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> answer= new ArrayList<>();
        traverse(answer,new ArrayList<>(),nums,0);
        return new ArrayList<>(answer);
    }
    private void traverse(ArrayList<List<Integer>> answer, List<Integer> list, int[] nums, int index){
        if (index==nums.length){
            answer.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        traverse(answer,list,nums,index+1);
        list.remove(list.size()-1);
        traverse(answer,list,nums,index+1);
    }
}