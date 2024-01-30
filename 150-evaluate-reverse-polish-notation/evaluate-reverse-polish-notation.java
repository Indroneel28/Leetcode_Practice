class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack= new Stack<>();
        for (int i=0; i<tokens.length; i++){
            if (tokens[i].equals("+")){
                int secondNum= Integer.parseInt(stack.pop());
                int firstNum= Integer.parseInt(stack.pop());
                stack.push(firstNum+secondNum+"");
            }
            else if (tokens[i].equals("-")){
                int secondNum= Integer.parseInt(stack.pop());
                int firstNum= Integer.parseInt(stack.pop());
                stack.push(firstNum-secondNum+"");
            }
            else if (tokens[i].equals("*")){
                int secondNum= Integer.parseInt(stack.pop());
                int firstNum= Integer.parseInt(stack.pop());
                stack.push(firstNum*secondNum+"");
            }
            else if (tokens[i].equals("/")){
                int secondNum= Integer.parseInt(stack.pop());
                int firstNum= Integer.parseInt(stack.pop());
                stack.push(firstNum/secondNum+"");
            }
            else 
                stack.push(tokens[i]);
        }
        return Integer.parseInt(stack.pop());
    }
}