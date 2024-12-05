class Solution {
    public int climbStairs(int n) {
        //THIS IS SAME LIKE FIB SERIES QUESTION BUT BASE CASES ARE DIFFERENT
        //OPTIMAL METHOD:- TABULATION (BOTTOM-UP APPROACH) WITH SPACE OPTIMIZATION

        if (n<=3) //n<=2 is also okay
            return n;
        int prev= 1, prev2= 1;
        for (int i=2; i<=n; i++){
            int sum= prev + prev2;
            prev2= prev;
            prev= sum;
        }
        return prev;
        //TC is O(n) and SC is O(2n)
    }
}