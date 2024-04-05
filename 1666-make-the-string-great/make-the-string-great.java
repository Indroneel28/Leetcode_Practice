class Solution {
    public String makeGood(String s) {
        Stack<Character> stack= new Stack<>();
        for (int i=0; i<s.length(); i++){
            char c= s.charAt(i);
            if (!stack.isEmpty() && Math.abs(stack.peek()-c)==32)
                stack.pop();
            else
                stack.push(c);
        }
        s= "";
        for (char ele: stack){
            s+= ele;
        }
        return s;
    }
}