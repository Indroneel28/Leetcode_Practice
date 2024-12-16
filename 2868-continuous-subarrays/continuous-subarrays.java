class Solution {
    //OPTIMAL METHOD:- USING SLIDING WINDOW
    public long continuousSubarrays(int[] nums) {
        int i=0,j=0;
        long count= 0;
        int mini= nums[0], maxi= nums[0];
        while (j<nums.length){
            maxi= Math.max(maxi,nums[j]);
            mini= Math.min(mini,nums[j]);
            while (Math.abs(maxi-mini)>2){
                if (nums[i]==mini){
                    mini= Integer.MAX_VALUE;
                    for (int k=i+1;k<=j; k++){
                        mini= Math.min(nums[k],mini);
                    }
                }
                if (nums[i]==maxi){
                    maxi= Integer.MIN_VALUE;
                    for (int k=i+1;k<=j; k++){
                        maxi= Math.max(nums[k],maxi);
                    }
                }
                i++;
            }
            count += (j-i+1);
            j++;
        }
        return count;
    }
    //TC is O(2n) and SC is O(1)
}