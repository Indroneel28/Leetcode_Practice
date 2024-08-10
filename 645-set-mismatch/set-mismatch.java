class Solution {
    public int[] findErrorNums(int[] nums) {
        //METHOD 1:- BRUTE FORCE APPROACH
        /*
        int n= nums.length;
        int repeating= -1, missing= -1;
        for (int i=1; i<=n; i++){
            int count= 0;
            for (int j=0; j<n; j++){
                if (nums[j]==i)
                    count++;
            }
            if (count==2)
                repeating= i;
            if (count==0)
                missing= i;
            if (repeating!=-1 && missing!=-1)
                break;
        }
        return new int[]{repeating,missing};
        */
        //TC is O(n^2) and SC is O(2)

        //METHOD 2:- BETTER SOLUTION
        int n= nums.length;
        int[] store= new int[n];
        for (int num: nums){
            store[num-1]++;
        }

        int missing= -1, repeating= -1;
        for (int i=0; i<n; i++){
            if (store[i]==0)
                missing= i+1;
            if (store[i]==2)
                repeating= i+1;
            if (missing!=-1 && repeating!=-1)
                break;
        }
        return new int[]{repeating,missing};
        //TC is O(2n) and SC is O(1)
    }
}