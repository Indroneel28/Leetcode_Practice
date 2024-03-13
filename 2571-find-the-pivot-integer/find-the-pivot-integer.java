class Solution {
    public int pivotInteger(int n) {
        int i=1, j=n, sumi=0,sumj=0;
        sumi+=i; sumj+=j;
        while (i<=j){
            if (i==j && sumi==sumj){
                return i;
            }
            else if (i==j)
                return -1;
            else if (sumi==sumj){
                i++;
                j--;
                sumi+=i;
                sumj+=j;
            }
            else if (sumi<sumj) {
                i++;
                sumi+=i;
            }
            else if (sumi>sumj) {
                j--;
                sumj+=j;
            }
        }
        return -1;
    }
}