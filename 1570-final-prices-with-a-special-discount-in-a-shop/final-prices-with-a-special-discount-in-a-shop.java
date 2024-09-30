class Solution {
    public int[] finalPrices(int[] prices) {
        //OPTIMAL METHOD:- USING MONOTONIC STACK
        int[] finalPrice= new int[prices.length];
        Stack<Integer> stack= new Stack<>();
        //We need history of next iterations
        for (int i=prices.length-1; i>=0; i--){
            int ele= prices[i];
            finalPrice[i]= ele;
            while (!stack.isEmpty() && stack.peek()>ele)
                stack.pop();
            if (!stack.isEmpty())
                finalPrice[i]= finalPrice[i]-stack.peek();
            stack.push(ele);
        }
        return finalPrice;
        //TC is O(2n) and SC is O(2n)
    }
}