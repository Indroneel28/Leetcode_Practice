class Solution {
    public boolean isValid(String s) {
        //METHOD 1:- Using Stack
        Stack<Character> stack= new Stack<>();
        for (int i=0; i<s.length(); i++){
            char c= s.charAt(i);
            if (c=='(' || c=='{' || c=='[')
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return false;
                else if ((c==')' && stack.peek()=='(') || (c=='}' && stack.peek()=='{') || (c==']' && stack.peek()=='[')) 
                    stack.pop();
                else
                    return false;
            }
        }
        return stack.isEmpty();
        //TC is O(n) and SC is O(n)
    }
}