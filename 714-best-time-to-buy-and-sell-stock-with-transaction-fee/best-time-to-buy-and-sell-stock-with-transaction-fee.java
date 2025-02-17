class Solution {
    //METHOD 4:- USING 4 VARIABLES [OPTIMAL METHOD]
    public int maxProfit(int[] prices, int fee) {
        int n= prices.length;
        int currBuy, aheadBuy= 0, currNotBuy, aheadNotBuy= 0;
        for (int index=n-1; index>=0; index--){
            //Buying
            currBuy=  Math.max(-prices[index]+aheadNotBuy,aheadBuy);
            
            //Selling
            currNotBuy= Math.max(prices[index]-fee+aheadBuy,aheadNotBuy);
            
            aheadBuy= currBuy;
            aheadNotBuy= currNotBuy;
        }
        return aheadBuy;
    }
    //TC is O(n) and SC is O(4)
}