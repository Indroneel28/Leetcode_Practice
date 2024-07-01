class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answer= new ArrayList<>();
        List<Integer> list= new ArrayList<>();
        recursion(answer,list,nums,0,nums.length);
        return answer;
    }

    private void recursion(List<List<Integer>> answer, List<Integer> list, int[] nums, int index, int len){
        if (index>=len){
            Collections.sort(list);
            
            //If list is not there inside answer then we have to add it
            if (!checkIfContains(answer, list)) {
                answer.add(new ArrayList<>(list));
            }
            
            return;
        }
        list.add(nums[index]);
        recursion(answer,list,nums,index+1,len);
        list.remove(list.size()-1);
        recursion(answer,list,nums,index+1,len);
    }

    private boolean checkIfContains(List<List<Integer>> answer, List<Integer> list){
        for (List<Integer> element: answer){
            if (list.size()==element.size()){
                int c= 0;
                for (int i=0; i<element.size(); i++){
                    if (element.get(i).equals(list.get(i)))
                        c++;
                }
                if(c==element.size())
                     return true;
            }
        }
        return false;
    }
}