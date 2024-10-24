class Solution {
    public String removeKdigits(String num, int k) {
        //OPTIMAL METHOD:- USING STACK
        //Edge cases
        if (num.length()==k)
            return "0";
        //No leading zeros as mentioned in constraints
        int dup= k;
        Stack<Character> stack= new Stack<>(); //Monotonic Stack:- Increasing Order
        for (int i=0; i<num.length(); i++){
            char c= num.charAt(i);
            while (!stack.isEmpty() && dup>0 && stack.peek()>c) {
                stack.pop();
                dup--;
            }
            stack.push(c);
        }
        while (stack.size()>num.length()-k)
            stack.pop(); //Remove extra elements
        String ans= "";
        while (!stack.isEmpty())
            ans= stack.pop()+ans;
        while (ans.charAt(0)=='0' && ans.length()>1)
            ans= ans.substring(1);
        return ans;
        //TC is O(4n) and SC is O(2n)
    }
}