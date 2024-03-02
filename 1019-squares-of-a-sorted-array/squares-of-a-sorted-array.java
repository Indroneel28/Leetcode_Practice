class Solution {
    public int[] sortedSquares(int[] nums) {
        //USING TWO POINTERS METHOD
        int li= Integer.MIN_VALUE;
        int tp= 0, tn= 0;
        for (int i=0; i<nums.length; i++){
            if (nums[i]>=0)
                tp++;
            else
                tn--;
            if (nums[i]<0 && i>li)
                li= i;
        }
        int pi= li+1;
        
        //li and pi are indexes
        
        //ALL are positive numbers
        if (tn==0){
            for (int i=0; i<nums.length; i++){
                nums[i]= nums[i]*nums[i];
            }
            return nums;
        }

        //ALL are negative numbers
        else if (tp==0){
            int j= nums.length-1;
            int[] ans= new int[nums.length];
            for (int i=0; i<nums.length; i++){
                ans[i]= nums[j]*nums[j];
                j--;
            }
            return ans;
        }
        
        System.out.println("Executed");
        //We got positive and negative index
        int[] ans= new int[nums.length];
        int i= 0;
        
        while (li>=0 && pi<nums.length){
            if (nums[li]*nums[li] <= nums[pi]*nums[pi]){
                ans[i]= nums[li]*nums[li];
                li--;
            }
            else if (nums[li]*nums[li] > nums[pi]*nums[pi]){
                ans[i]= nums[pi]*nums[pi];
                pi++;
            }
            i++;
        }
        System.out.println("Executed");
        while (li>=0){
            ans[i]= nums[li]*nums[li];
            li--; i++;
        }
        while (pi<nums.length){
            ans[i]= nums[pi]*nums[pi];
            pi++; i++;
        }
        return ans;
    }
}