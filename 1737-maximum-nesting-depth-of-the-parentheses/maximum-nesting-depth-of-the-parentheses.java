class Solution {
    public int maxDepth(String s) {
        int depth= 0;
        Stack<Character> stack= new Stack<>();
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i)=='(')
                stack.push('(');
            else if (s.charAt(i)==')')
                stack.pop();
            if (stack.size()>depth)
                depth= stack.size();
        }
        return depth;
    }
}