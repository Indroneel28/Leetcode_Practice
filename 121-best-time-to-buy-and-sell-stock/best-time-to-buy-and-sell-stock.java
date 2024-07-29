class Solution {
    public int maxProfit(int[] prices) {
        //METHOD 1:- BRUTE FORCE ALGORITHM
        //Note:- We can sell the stocks in the future only
        /*
        int maxProfit= 0;
        for (int i=0; i<prices.length; i++){
            for (int j=i+1; j<prices.length; j++){
                maxProfit= Math.max(maxProfit, prices[j]-prices[i]);
            }
        }
        return maxProfit;
         */
        //TC is O(N^2) and Sc is O(1)
        //TLE

        //METHOD 2:- OPTIMAL SOLUTION
        int maxProfit= 0, minimum= prices[0];
        for (int price: prices){
            if (price<minimum)
                minimum= price;
            if (price-minimum>maxProfit)
                maxProfit= price-minimum;
        }
        return maxProfit;
        //TC is O(N) AND SC is O(1)
    }
}