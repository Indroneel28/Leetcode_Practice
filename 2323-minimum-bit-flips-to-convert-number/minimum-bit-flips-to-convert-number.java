class Solution {
    public int minBitFlips(int start, int goal) {
        //BRUTE FORCE METHOD:- BY COUNTING THE UNMATCHED BITS
        /*
        int countFlipBits= 0;
        while (start!=0 || goal!=0) {
            int rem1 = start % 2, rem2 = goal % 2;
            if (rem1 != rem2)
                countFlipBits++;
            start/=2; goal/=2;
        }
        return countFlipBits;
         */
        //TC is O(max bits) and SC is O(1)

        //BETTER APPROACH:- BY USING XOR RULES
        /*
        int countFlipBits= 0, xor= start^goal;
        while (xor!=0){
            countFlipBits += xor&1;
            xor>>>=1;
        }
        return countFlipBits;
         */
        //TC is O(number of bits) and SC is O(1)

        //OPTIMAL APPROACH:- Brian Kernighan’s Algorithm
        //By counting the number of set bits
        int countFlipBits= 0, xor= start^goal;
        while (xor!=0){
            xor= xor & (xor-1);
            countFlipBits++;
        }
        return countFlipBits;
        //TC is O(number of set bits) and SC is O(1)
    }
}