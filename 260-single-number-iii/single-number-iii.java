class Solution {
    public int[] singleNumber(int[] nums) {
        List<Integer> list= new ArrayList<>();
        for (int ele: nums){
            if (list.contains(ele))
                list.remove((Object)ele);
            else 
                list.add(ele);
        }
        return new int[]{list.get(0),list.get(1)}; 
    }
}