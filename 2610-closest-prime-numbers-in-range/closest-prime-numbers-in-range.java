class Solution {
    //METHOD 2:- USING SIEVE OF ERATOSTHENES
    public int[] closestPrimes(int left, int right) {
        boolean[] notPrimes= new boolean[right+1]; //0 means prime and 1 means not-prime
        notPrimes[1]= true;
        for (int i=2; i<=right; i++){
            if (!notPrimes[i]) {
                for (int j = i * 2; j <= right; j += i)
                    notPrimes[j] = true;
            }
        }

        int[] ans= new int[2];
        int prev= 0;
        for (int i=left; i<=right; i++){
            if (!notPrimes[i]){ //i is prime
                if (ans[0]==0)
                    ans[0]= i;
                else if (ans[1]==0)
                    ans[1]= i;
                else {
                    if (i-prev<ans[1]-ans[0]){
                        ans[0]= prev;
                        ans[1]= i;
                    }
                }
                prev= i;
            }
        }
        if(ans[0]==0 || ans[1]==0)
            ans[0]= ans[1]= -1;
        return ans;
    }
    //TC is O(nloglogn + n) and SC is O(right)
}