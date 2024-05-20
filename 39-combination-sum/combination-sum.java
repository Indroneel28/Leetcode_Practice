class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        addList(ans, new ArrayList<>(),target,candidates, 0);
        return ans;
    }
    private void addList(List<List<Integer>> ans, List<Integer> list, int target, int[] candidates, int index){
        if (index>=candidates.length){
            if (target==0) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        if (candidates[index]<=target){
            list.add(candidates[index]);
            addList(ans,list,target-candidates[index],candidates,index);
            list.remove(list.size()-1);
        }
        addList(ans,list,target, candidates, index+1); //Index is increased by 1
    }
}