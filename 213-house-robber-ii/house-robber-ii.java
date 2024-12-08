class Solution {
    //OPTIMAL METHOD:- TABULATION METHOD WITH SPACE-OPTIMIZATION
    public int rob(int[] nums) {
        if (nums.length==1)
            return nums[0];
        else if (nums.length==2)
            return Math.max(nums[0],nums[1]);
        else {
            ArrayList<Integer> list1= new ArrayList<>();
            ArrayList<Integer> list2= new ArrayList<>();
            for (int i=0;i<nums.length;i++){
                if (i!=0)
                    list1.add(nums[i]);
                if (i!=nums.length-1)
                    list2.add(nums[i]);
            }
            //In list 1, 0th element is not there.
            //In list 2, (n-1)th element is not there.
            return Math.max(tabulation(list1,nums.length-1),tabulation(list2,nums.length-1));
        }
    }
    public int tabulation(ArrayList<Integer> list, int index){
        int prev2= list.get(0);
        int prev= Math.max(list.get(0),list.get(1));
        for (int i=2;i<list.size(); i++){
            int pick= list.get(i) + prev2;
            int notPick= prev;
            prev2= prev;
            prev= Math.max(pick,notPick);
        }
        return prev;
    }
    //TC is O(3n) and SC is O(2n)
}