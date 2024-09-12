class Solution {
    public int minBitFlips(int start, int goal) {
        //BETTER APPROACH:- BY USING XOR RULES
        int countFlipBits= 0, xor= start^goal;
        while (xor!=0){
            countFlipBits += xor&1;
            xor>>>=1;
        }
        return countFlipBits;
        //TC is O(number of bits) and SC is O(1)
    }
}