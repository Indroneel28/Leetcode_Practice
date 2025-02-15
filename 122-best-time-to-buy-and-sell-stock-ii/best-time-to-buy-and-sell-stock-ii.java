class Solution {
    //METHOD 5:- USING 4 VARIABLES
    public int maxProfit(int[] prices) {
        int currBuy, currNotBuy, aheadBuy, aheadNotBuy;
        aheadBuy= aheadNotBuy= 0;
        int n= prices.length;
        for (int index= n-1; index>=0; index--){
            //Buying
            currBuy= Math.max(-prices[index]+aheadNotBuy,aheadBuy);
            
            //Selling (Not Buying)
            currNotBuy= Math.max(prices[index]+aheadBuy,aheadNotBuy);
            
            aheadBuy= currBuy;
            aheadNotBuy= currNotBuy;
        }
        return aheadBuy;
        //TC is O(n) and SC is O(4)
    }
}