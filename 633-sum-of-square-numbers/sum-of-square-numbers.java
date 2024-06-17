class Solution {
    public boolean judgeSquareSum(int c) {
        long i=0, j= (long)Math.sqrt(c);
        while (i<=j){
            long pow= i*i + j*j;
            if (pow==c)
                return true;
            else if (pow<c)
                i++;
            else
                j--;
        }
        return false;
    }
}