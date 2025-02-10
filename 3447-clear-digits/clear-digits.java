class Solution {
    public String clearDigits(String s) {
        //OPTIMAL METHOD:- USING STACK
        Stack<Character> stack= new Stack<>();
        for (char c: s.toCharArray()){
            if (Character.isDigit(c))
                stack.pop();
            else
                stack.push(c);
        }
        StringBuilder sb= new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}