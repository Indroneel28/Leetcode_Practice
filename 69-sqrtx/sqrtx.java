class Solution {
    public int mySqrt(int x) {
        int index= 0;
        for (long i=1; i<=x/2+1; i++){
            if (i*i<=x){
                index= (int)i;
            }
            else
                break;
        }
        return index;
    }
}