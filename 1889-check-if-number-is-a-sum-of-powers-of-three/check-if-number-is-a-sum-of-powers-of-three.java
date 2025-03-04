class Solution {
    //METHOD 2:- USING TERNARY REPRESENTATION
    public boolean checkPowersOfThree(int n) {
        while (n!=0){
            if (n%3==2)
                return false;
            n/=3;
        }
        return true;
    }
    //TC is O(n) and SC is O(1)
}