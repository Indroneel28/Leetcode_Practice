class Solution {
    public int minSubarray(int[] nums, int p) {
        //BRUTE FORCE METHOD
        /*
        int sum= 0;
        for (int num: nums)
            sum+=num;
        if (sum%p==0)
            return 0;

        int lengthOfSmallestSubarray= Integer.MAX_VALUE;
        for (int i=0; i<nums.length; i++){
            int s= 0;
            for (int j=i; j<nums.length; j++){
                s+=nums[j];
                if ((sum-s)%p == 0 && j-i+1!= nums.length)
                    lengthOfSmallestSubarray= Math.min(lengthOfSmallestSubarray,j-i+1);
            }
        }
        if (lengthOfSmallestSubarray==Integer.MAX_VALUE)
            return -1;
        return lengthOfSmallestSubarray;
        //TC is O(n + n^2) and SC is O(1)
         */

        //OPTIMAL METHOD:- USING HASHMAP
        int sum= 0;
        for (int ele: nums)
            sum= (sum+ele)%p;

        int target= sum%p;

        if (target==0) //No need to delete any sub-array
            return 0;

        HashMap<Integer,Integer> map= new HashMap<>();
        map.put(0,-1);

        int curr= 0, result= nums.length;
        for (int i=0; i< nums.length; i++){
            curr= (curr+nums[i])%p;

            int rem= (curr-target+p)%p;
            if (map.containsKey(rem)){
                result= Math.min(result,i-map.get(rem));
            }
            map.put(curr,i);
        }
        return result== nums.length ? -1 : result;
        //TC is O(n) and SC is O(2n)
    }
}