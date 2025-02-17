class Solution {
    //METHOD 5:- SPACE OPTIMIZATION [OPTIMAL METHOD]
    public int maxProfit(int k, int[] prices) {
        int n= prices.length;
        int[][] dp= new int[n+1][k*2+1];
        
        int[] curr= new int[k*2+1], ahead= new int[k*2+1];
        for (int index= n-1; index>=0; index--){
            for (int transaction= 0; transaction<k*2; transaction++){
                if (transaction%2==0) //Buy
                    curr[transaction]= Math.max(-prices[index]+ahead[transaction+1],ahead[transaction]);
                else //Sell
                    curr[transaction]= Math.max(prices[index]+ahead[transaction+1],ahead[transaction]);
            }
            ahead= Arrays.copyOfRange(curr,0,2*k+1);
        }
        return ahead[0];
    }
    //TC is O(n*k*2) and SC is O(k*2)
}