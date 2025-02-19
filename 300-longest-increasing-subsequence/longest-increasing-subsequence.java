class Solution {
    //METHOD 4:- SPACE OPTIMIZATION
    public int lengthOfLIS(int[] nums) {
        int n= nums.length;
        int[] curr= new int[n+1], ahead= new int[n+1];
        for (int index=n-1; index>=0; index--){
            //Shifting of indices for prevIndex
            for (int prevIndex= index-1; prevIndex>=-1; prevIndex--){
                //not-pick
                int notPick= ahead[prevIndex+1];
                int pick= 0;
                if (prevIndex==-1 || nums[index]>nums[prevIndex]){
                    pick= 1 + ahead[index+1];
                }
                curr[prevIndex+1]= Math.max(pick,notPick);
            }
            ahead= Arrays.copyOfRange(curr,0,n+2);
        }
        return ahead[-1+1];
    }
    //TC is O(n^2) and SC is O(2n)
}