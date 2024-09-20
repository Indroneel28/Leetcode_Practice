class Solution {
    public double myPow(double x, int n) {
        //OPTIMAL METHOD:- RECURSIVE APPROACH

        //sucking edge case (just ignore it)
        if (n == Integer.MIN_VALUE) 
            return 1/x * myPow(x, n + 1); //ignore it

        if (n<0){ //n is negative
            n= -n; //make n positive
            x= 1.0/x; 
        }
        if (n==0)
            return 1;
        else if (n%2==0)
            return myPow(x*x,n/2);
        else //n%2==1
            return x * myPow(x*x,n/2);
        //TC is O(logn) and SC is O(logn)
    }
}