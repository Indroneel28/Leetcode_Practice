class Solution {
    public double myPow(double x, int n) {
        //ONE LINER:- Using Math Class
        //return Math.pow(x,n);
        //Beat 100%

        //BRUTE FORCE METHOD
        /*
        int m= Math.abs(n);
        double ans= 1;
        for (int i=1 ;i<=m; i++){
            ans *= x;
        }
        if (n>=0)
            return ans;
        else  //For negative power
            return 1.0/ans;
         */
        //TC is O(n) and SC is O(1)
        //TLE

        //OPTIMAL METHOD:- RECURSIVE APPROACH
        /*
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
         */
        //TC is O(logn) and SC is O(logn)

        //OPTIMAL METHOD:- ITERATIVE APPROACH
        /*
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
         */
        //TC is O(logn) and SC is O(1)

        //SUPER OPTIMAL SOLUTION
        //here, somehow sucking edge case is avoided
        if (n<0){ //If power is negative
            n= -n;
            x= 1.0/x;
        }
        double ans= 1.0;
        while (n!=0){
            if ((n & 1) == 1){ //power is odd
                ans *= x;
            }
            x= x*x;
            n= n>>>1; // n= n/2 in bitwise
        }
        return ans;
        //TC is O(logn) and SC is O(1)
    }
}