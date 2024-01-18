class Solution {
    public double myPow(double x, int n) {
    //     if((n==Integer.MAX_VALUE || n== Integer.MIN_VALUE) && x<1)
    //         return 0.00000;
    //     if ((n==Integer.MAX_VALUE || n== Integer.MIN_VALUE) && x==1.00000)
    //         return 1;
        
    //     double store= pow(x,Math.abs(n));
    //     if (n>=0)
    //         return store;
    //     else 
    //         return 1/store;
    // }

    // public double pow(double x, int n){
    //     if (n==0)
    //         return 1;
    //     return x*pow(x,n-1);
    
        return Math.pow(x,n);
    }
}