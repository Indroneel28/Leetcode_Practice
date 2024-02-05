class Solution {
    public int commonFactors(int a, int b) {
        int countCommonFactors= 0;
        for (int i=1; i<=a; i++){ //WE can also vake i<=b NP
            if (a%i==0 && b%i==0)
                countCommonFactors++;
        }
        return countCommonFactors;
    }
}