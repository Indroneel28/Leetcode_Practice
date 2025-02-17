class Solution {
    //METHOD 7:- SPACE OPTIMIZATION TO 1D ARRAY [OPTIMAL SOLUTION]
    public int maxProfit(int[] prices) {
        int n= prices.length;
        int[][] dp= new int[n+1][5];
        
        int[] curr= new int[5], ahead= new int[5];
        for (int index=n-1; index>=0; index--){
            for (int transaction=0; transaction<4; transaction++){
                if (transaction%2==0){
                    curr[transaction]= Math.max(-prices[index]+ahead[transaction+1],ahead[transaction]);
                }
                else{
                    curr[transaction]= Math.max(prices[index]+ahead[transaction+1],ahead[transaction]);
                }
            }
            ahead= Arrays.copyOfRange(curr,0,5);
        }
        return ahead[0];
    }
    //TC is O(n*4) and SC is O(4)
}