class Solution {
    public int commonFactors(int a, int b) {
        int countCommonFactors= 0;
        int range= Math.min(a,b);
        for (int i=1; i<=range; i++){ //WE can also vake i<=b NP
            if (a%i==0 && b%i==0)
                countCommonFactors++;
        }
        return countCommonFactors;
    }
}