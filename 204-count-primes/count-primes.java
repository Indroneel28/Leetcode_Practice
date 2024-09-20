class Solution {
    //BRUTE FORCE METHOD:- CHECKING FROM 1 TO N-1 WHETHER PRIME OR NOT
    /*
    public int countPrimes(int n) { //TC is O(n * root n) and SC is O(1)
        int primes= 0;
        for (int i=2; i<n; i++){ //primes are starting from 2
            if (checkPrime(i))
                primes++;
        }
        return primes;
    }
    //TLE

    private boolean checkPrime(int num){ //TC is O(root num)
        if (num==1) //1 is neither a prime number nor a composite number
            return false;
        for (int i=2; i<=Math.sqrt(num); i++){
            if (num%i == 0) //Divisible by i
                return false;
        }
        return true;
    }
     */
    //TC is O(n * root n) and SC is O(1)

    //BETTER METHOD:- SIEVE OF ERATOSTHENES
    /*
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
        // 124 ms Beats 21.17%
    }
     */

    //OPTIMAL METHOD:- SIEVE OF ERATOSTHENES
    public int countPrimes(int n) {
        int primes= 0;
        int[] checkPrime= new int[n];
        for (int i=2; i<=Math.sqrt(n); i++){
             if (checkPrime[i]==0){
                 for (int j= i*i; j<n; j+=i){
                     checkPrime[j]= 1;
                 }
             }
        }
        for (int i=2; i<n; i++){
            if (checkPrime[i]==0)
                primes++;
        }
        return primes;
        //TC is O(nlog(logn) + n) and SC is O(n)
    }
}