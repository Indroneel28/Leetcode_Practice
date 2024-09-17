class Solution {
    public int divide(int dividend, int divisor) {
        //METHOD 1:- USING / OPERATOR
        //return dividend/divisor;

        //METHOD 2:- USING OPTIMA METHOD
        //Edge cases
        //Here, quotient will overflow so better to handle it
        if (dividend==Integer.MIN_VALUE && divisor==-1)
            return Integer.MAX_VALUE;

        boolean negative= dividend < 0 ^ divisor < 0;

        dividend= Math.abs(dividend);
        divisor= Math.abs(divisor);

        int quotient= 0, subQuot= 0;

        while (dividend - divisor >= 0) {
            for (subQuot = 0; dividend - (divisor << subQuot << 1) >= 0; subQuot++);
            quotient += 1 << subQuot; //Add to the quotient
            dividend -= divisor << subQuot; //Substract from dividend to start over with the remaining
        }
        return negative ? -quotient : quotient;
        //TC is O(divident) and SC is O(1) in worst case
        //CAN'T UNDERSTAND
    }
}