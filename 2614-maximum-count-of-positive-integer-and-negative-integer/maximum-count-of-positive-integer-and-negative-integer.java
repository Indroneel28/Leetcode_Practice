class Solution {
    //METHOD 1:- BRUTE FORCE APPROACH
    public int maximumCount(int[] nums) {
        int neg= 0, pos= 0;
        for(int num: nums){
            if(num<0)
                neg++;
            if(num>0)
                pos++;
        }
        return Math.max(pos,neg);
    }
    //TC is O(n) and SC is O(1)
}