class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack= new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                int secondNum = stack.pop();
                int firstNum = stack.pop();
                stack.push(firstNum + secondNum);
            } 
            else if (token.equals("-")) {
                int secondNum = stack.pop();
                int firstNum = stack.pop();
                stack.push(firstNum - secondNum);
            } 
            else if (token.equals("*")) {
                int secondNum = stack.pop();
                int firstNum = stack.pop();
                stack.push(firstNum * secondNum);
            } 
            else if (token.equals("/")) {
                int secondNum = stack.pop();
                int firstNum = stack.pop();
                stack.push(firstNum / secondNum);
            } 
            else
                stack.push(Integer.parseInt(token));
        }
        return stack.pop();
    }
}