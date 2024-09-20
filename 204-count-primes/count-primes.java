class Solution {
    public int countPrimes(int n) {
        int primes= 0;
        int[] checkPrime= new int[n];
        for (int i=2; i<n; i++){
            if (checkPrime[i]==0){
                primes++;
                for (int j=i+i ; j<n; j+=i){
                    checkPrime[j]= 1;
                }
            }
        }
        return primes;
        //TC is O(n^2) approx and SC is O(n)
    }
}