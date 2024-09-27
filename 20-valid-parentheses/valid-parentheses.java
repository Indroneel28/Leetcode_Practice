class Solution {
    public boolean isValid(String s) {
        //METHOD 1:- Using Stack by inserting starting brackets
        /*
        Stack<Character> stack= new Stack<>();
        for (int i=0; i<s.length(); i++){
            char c= s.charAt(i);
            if (c=='(' || c=='{' || c=='[')
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return false;
                else if ((c==')' && stack.peek()=='(') || (c=='}' && stack.peek()=='{') || (c==']' && stack.peek()=='[')) {
                    stack.pop();
                }
                else
                    return false;
            }
        }
        return stack.isEmpty();
         */
        //TC is O(n) and SC is O(n)
        //Beat 98.56%

        //METHOD 2:- Using Stack by inserting ending brackets
        Stack<Character> stack= new Stack<>();
        for (int i=0; i<s.length(); i++){
            char c= s.charAt(i);
            if (c=='(')
                stack.push(')');
            else if (c=='{')
                stack.push('}');
            else if (c=='[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop()!=c)
                return false;
        }
        return stack.isEmpty();
        //TC is O(n) and SC is O(n)
    }
}