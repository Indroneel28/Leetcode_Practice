class Solution {
    public int subsetXORSum(int[] nums) {
        return subset(nums,new ArrayList<Integer>(),0);
    }
    private int subset(int[] nums, ArrayList<Integer> list, int index){
        if (index>=nums.length){
            return xorOperation(list);
        }
        list.add(nums[index]);
        int x= subset(nums,list,index+1);
        list.remove(list.size()-1);
        int y= subset(nums,list,index+1);
        return x+y;
    }
    private int xorOperation(ArrayList<Integer> list){
        int xor= 0;
        for (int ele: list)
            xor= xor^ele;
        return xor;
    }
}