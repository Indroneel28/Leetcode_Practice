class Solution {
    public int maxOR= 0, count= 0, orOpr= 0;
    public int countMaxOrSubsets(int[] nums) {
        subsequence(nums,0,new boolean[nums.length]);
        return this.count;
        //TC is O(2^n * n) and SC is O(n)
    }

    //Recursion and Backtracking to find all the subsets
    private void subsequence(int[] nums, int index, boolean[] store){
        if (index==nums.length)
            return;
        for (int i=index; i<nums.length; i++){
            if (!store[i]){
                store[i]= true;
                int previous= orOpr;
                orOpr|=nums[i]; //orOpr with nums[i]

                System.out.println(orOpr);
                if (orOpr>this.maxOR){
                    maxOR= orOpr;
                    count=1;
                }
                else if (orOpr==this.maxOR)
                    count++;

                subsequence(nums,i+1,store);

                //Backtrack
                orOpr= previous;
                store[i]= false;
            }
        }
    }
}