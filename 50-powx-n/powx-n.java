class Solution {
    public double myPow(double x, int n) {
        //OPTIMAL METHOD:- ITERATIVE APPROACH

        //sucking edge case (just ignore it)
        if (n == Integer.MIN_VALUE)
            return 1/x * myPow(x, n + 1); //ignore it

        if(n<0){ //power is negative
            n= -n; //make power positive
            x= 1.0/x;
        }

        double ans= 1.0;
        while (n!=0){
            if (n%2==1){
                ans *= x;
                n = n-1;
            }
            else { //n%2==0
                x *= x;
                n = n/2;
            }
        }
        return ans;
        //TC is O(logn) and SC is O(1)
    }
}