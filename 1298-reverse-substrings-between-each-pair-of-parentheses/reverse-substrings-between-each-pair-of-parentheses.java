class Solution {
    public String reverseParentheses(String s) {
        //USING STACK APPROACH
        //Strings will be reversed automatically in Stack

        Stack<Character> stack= new Stack<>();
        for (int i=0; i<s.length(); i++){
            char c= s.charAt(i);

            //Push each and any type of character in the stack
            stack.push(c);

            //If character inserted is ')' then we will extract characters one by one
            if (stack.peek()==')') {
                StringBuilder sb= new StringBuilder();
                stack.pop(); //Extract ')'
                while (stack.peek() != '(') {
                    sb.append(stack.pop()); //Extract one by one character from last and put inside sb
                }
                stack.pop(); //Extract '(' and kick it out
                for (int j=0; j<sb.length(); j++){
                    stack.push(sb.charAt(j));
                }
            }
        }
        StringBuilder answer= new StringBuilder();
        while (!stack.isEmpty()){
            answer.insert(0,stack.pop()); //Reversed
        }
        return answer.toString();
    }
}