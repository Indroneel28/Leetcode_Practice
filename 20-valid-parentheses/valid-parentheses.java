class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack= new Stack<>();
        for (int i=0; i<s.length(); i++){
            char c= s.charAt(i);
            if (c=='(' || c=='[' || c=='{')
                stack.push(s.charAt(i));
            else if (c==')'){
                if (stack.isEmpty())
                    return false;
                char m= stack.pop();
                if (m!='(')
                    return false;
            }
            else if (c==']'){
                if (stack.isEmpty())
                    return false;
                char m= stack.pop();
                if (m!='[')
                    return false;
            }
            else if (c=='}'){
                if (stack.isEmpty())
                    return false;
                char m= stack.pop();
                if (m!='{')
                    return false;
            }
        }
        return stack.isEmpty();
    }
}