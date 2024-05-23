class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        return subsets(nums,k,new ArrayList<>(),0);
    }
    private int subsets(int[] nums, int k, ArrayList<Integer> list, int index){
        if (index==nums.length){
            if (list.isEmpty())
                return 0;
            else if (list.size()==1)
                return 1;
            else
                return check(list,k);
        }
        list.add(nums[index]);
        int x= subsets(nums,k,list,index+1);
        list.remove(list.size()-1);
        int y= subsets(nums,k,list,index+1);
        return x+y;
    }
    private int check(ArrayList<Integer> list, int k){
        for (int i=0; i<list.size(); i++){
            for (int j=i+1; j<list.size(); j++){
                if (Math.abs(list.get(i)-list.get(j))==k)
                    return 0;
            }
        }
        return 1;
    }
}