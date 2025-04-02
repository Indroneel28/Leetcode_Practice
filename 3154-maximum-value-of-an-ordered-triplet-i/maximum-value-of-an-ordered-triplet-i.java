class Solution {
    //METHOD 1:- BRUTE FORCE METHOD
    public long maximumTripletValue(int[] nums) {
        long maxi= 0;
        for (int i=0; i<nums.length; i++){
            for (int j=i+1; j<nums.length; j++){
                for (int k=j+1; k<nums.length; k++){
                    maxi= Math.max(maxi,((long)nums[i]-(long)nums[j])*((long)nums[k]));
                }
            }
        }
        return maxi;
    }
    //TC is O(n^3) and SC is O(1)
    //But constraints are very low i.e. array size will be 100 at max
}