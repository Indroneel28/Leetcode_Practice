class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // Arrays.sort(nums);
        HashSet<List<Integer>> answer= new HashSet<>();
        traverse(answer,new ArrayList<>(),nums,0);
        return new ArrayList<>(answer);
    }
    private void traverse(HashSet<List<Integer>> answer, List<Integer> list, int[] nums, int index){
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