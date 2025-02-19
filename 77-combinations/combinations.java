class Solution {
    //METHOD 2:- RECURSION AND BACKTRACKING WITH START VARIABLE
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer= new ArrayList<>();
        traverse(n,k,1,answer,new ArrayList<>());
        return answer;
    }
    //Helper Method
    private void traverse(int n, int k, int start, List<List<Integer>> answer, List<Integer> list){
        if (k==0){
            answer.add(new ArrayList<>(list));
            list= new ArrayList<>();
        }
        for (int i= start; i<=n; i++){
            list.add(i);
            traverse(n,k-1,i+1,answer,list);
            list.remove(list.size()-1);
        }
    }
    //TC is Exponential and SC is O(n) coz of stack space
}