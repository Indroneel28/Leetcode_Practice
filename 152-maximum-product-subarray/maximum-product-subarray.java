class Solution {
    public int maxProduct(int[] nums) {
        //METHOD 1:- BRUTE FORCE APPROACH
        /*
        long max= Long.MIN_VALUE;
        for (int i=0; i< nums.length; i++){
            long pro= 1;
            for (int j=i; j<nums.length; j++){
                pro*=nums[j];
                System.out.println(pro);
                if (pro>max)
                    max= pro;
            }
        }
        return (int) max;
         */
        //TC is O(n^2) and SC is O(1)

        //METHOD 2:- OPTIMAL SOLUTION BY OBSERVATION
        int n= nums.length;
        if (n==1)
            return nums[0];
        //We are taking double for a nonsense testcase
        double pre= 1, suff= 1;
        double ans= Double.MIN_VALUE;
        for (int i=0; i<n; i++){
            if (pre==0)
                pre= 1;
            if (suff==0)
                suff=1;
            pre*=nums[i];
            suff*=nums[n-i-1];
            ans= Math.max(ans, Math.max(pre,suff));
        }
        return (int) ans;
        //TC is O(n) and SC is O(1)

        //METHOD 3:- MODIFIED KADANE'S ALGORITHM
        //THIS IS NOT AT ALL RECOMMENDED IN THE INTERVIEWS
        //IT'S NOT INTUITIVE
        //TC is O(n) and SC is O(1)
    }
}