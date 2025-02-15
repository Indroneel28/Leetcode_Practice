class Solution {
    //METHOD 4:- SPACE OPTIMIZATION
    public int maxProfit(int[] prices) {
        int n= prices.length;
        int[] curr= new int[2], ahead= new int[2];
        //Base case
        ahead[0]= ahead[1]= 0;
        for (int index=n-1; index>=0; index--){
            for (int buy=0; buy<=1; buy++){
                if (buy==1){
                    curr[buy]= Math.max(-prices[index]+ahead[0],ahead[1]);
                }
                else {
                    curr[buy]= Math.max(prices[index]+ahead[1],ahead[0]);
                }
            }
            ahead= Arrays.copyOfRange(curr,0,2);
        }
        return ahead[1];
    }
    //TC is O(n*2) and SC is O(4)
}