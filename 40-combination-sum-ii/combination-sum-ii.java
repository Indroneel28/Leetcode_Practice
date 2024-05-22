class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> answer = new ArrayList<>();
        traverse(answer, new ArrayList<>(), candidates, target,  0);
        return answer;
    }

    private void traverse(List<List<Integer>> answer, List<Integer> list, int[] candidates, int target, int index) {
        if (target == 0) {
            answer.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) 
                continue;
            if (candidates[i] > target) 
                break;        
            list.add(candidates[i]);
            traverse(answer, list, candidates, target - candidates[i], i + 1); // Move to the next index
            list.remove(list.size() - 1); // Backtrack
        }
    }
}