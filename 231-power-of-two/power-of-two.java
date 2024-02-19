class Solution {
    public boolean isPowerOfTwo(int n) {
        // int i=1;
        // while (i<=n){
        //     if (n==i)
        //         return true;
        //     i*=2;
        // }
        // return false;

        return n>0 && (n & n-1)==0;
    }
}