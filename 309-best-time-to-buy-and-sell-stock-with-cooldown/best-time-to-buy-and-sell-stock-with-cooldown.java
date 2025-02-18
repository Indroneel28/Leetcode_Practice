class Solution {
    //METHOD 3:- USING VARIABLES
    public int maxProfit(int[] prices) {
        int n= prices.length;
        int currBuy= 0, currNotBuy= 0, frontBuy= 0, frontNotBuy= 0, front2Buy= 0, frontNot2Buy= 0;
        for (int index= n-1; index>=0; index--){
            currBuy= Math.max(-prices[index]+frontNotBuy,frontBuy);
            currNotBuy= Math.max(prices[index]+front2Buy,frontNotBuy);
            
            frontNot2Buy= frontNotBuy;
            front2Buy= frontBuy;
            frontNotBuy= currNotBuy;
            frontBuy= currBuy;
        }
        return currBuy;
    }
    //TC is O(n) and SC is O(4)
}