class Solution {
    //METHOD 1:- USING check[] array
    /*
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer= new ArrayList<>();
        List<Integer> p= new ArrayList<>();
        boolean[] check= new boolean[nums.length];
        permutation(answer,p,nums,check);
        return answer;
    }

    //Striver's Recursion L12
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
    */

    //METHOD 2:- USING  index VARIABLE

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer= new ArrayList<>();
        int index= 0;
        permutation(answer,nums,index);
        return answer;
    }

    //Striver's Recursion L13
    private void permutation(List<List<Integer>> answer, int[] nums, int index){
        if (index==nums.length) {
            ArrayList<Integer> list= new ArrayList<>();
            for (int num: nums)
                list.add(num);
            answer.add(new ArrayList<>(list));
            return;
        }
        for (int i=index; i<nums.length; i++){
            swap(nums,index,i);
            permutation(answer,nums,index+1);
            swap(nums,index,i);
        }
    }

    private void swap(int[] nums, int i, int j){
        int dup= nums[i];
        nums[i]= nums[j];
        nums[j]= dup;
    }
}