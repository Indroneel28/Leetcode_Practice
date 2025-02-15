class Solution {
    //METHOD 1:- RECURSION AND BACKTRACKING
    public int punishmentNumber(int n) {
        int punishmentNumber= 0;
        for (int i=1; i<=n; i++){
            int square= i*i;
            if (partition(square,i))
                punishmentNumber += square;
        }
        return punishmentNumber;
    }
    //Helper Method
    private boolean partition(int num, int target){
        if (target==num)
            return true;
        if (num<target || target<0)
            return false;
        return partition(num/10,target-(num%10)) || partition(num/100,target-(num%100)) || partition(num/1000,target-(num%1000));
    }
    //TC is exponential and SC is O(n^2)
}