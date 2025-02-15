class Solution {
    //METHOD 6:- GREEDY WORKS!!
    //Logic:- Check adjacent days and if profit then add
    public int maxProfit(int[] prices) {
        int profit= 0;
        for (int i=0; i<prices.length-1; i++){
            if (prices[i]<prices[i+1])
                profit += (prices[i+1]-prices[i]);
        }
        return profit;
    }
    //TC is O(n) and SC is O(1)
}