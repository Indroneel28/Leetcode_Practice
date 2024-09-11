class Solution {
    public int minBitFlips(int start, int goal) {
        //BY COUNTING THE UNMATCHED BITS
        int countFlipBits= 0;
        while (start!=0 || goal!=0) {
            int rem1 = start % 2, rem2 = goal % 2;
            if (rem1 != rem2)
                countFlipBits++;
            start/=2; goal/=2;
        }
        return countFlipBits;
        //TC is O(logn) and SC is O(1)
    }
}