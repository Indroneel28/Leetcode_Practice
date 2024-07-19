class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer= new ArrayList<>();
        List<Integer> p= new ArrayList<>();
        boolean[] check= new boolean[nums.length];
        permutation(answer,p,nums,check);
        return answer;
    }

    private void permutation(List<List<Integer>> answer, List<Integer> p, int[] nums, boolean[] check){
        if (p.size()==nums.length){
            answer.add(new ArrayList<>(p));
            //System.out.println(p);
            return;
        }
        for (int i=0; i<nums.length; i++){
            if (!check[i]){ //check[i] is false      
                p.add(nums[i]);
                check[i]= true;
                
                permutation(answer,p,nums,check);
                
                p.remove(p.size()-1);
                check[i]= false;
            }
        }
    }
}