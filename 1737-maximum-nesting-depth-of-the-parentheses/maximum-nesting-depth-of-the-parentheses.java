class Solution {
    public int maxDepth(String s) {
        //String s is a VPS given
        //METHOD 1:- USING STACK
        /*
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
        TC:- O(n), SC:- O(n)
         */
        //METHOD 2:- USING COUNTER
        int depth=0, count= 0;
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i)=='(')
                count++;
            else if (s.charAt(i)==')')
                count--;
            if (depth<count)
                depth= count;
        }
        return depth;
    }
}