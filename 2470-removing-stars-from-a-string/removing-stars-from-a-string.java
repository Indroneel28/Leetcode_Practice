class Solution {
    public String removeStars(String s) {
        //METHOD 2:- USING STACK
        Stack<Character> stack= new Stack<>();
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i)!='*')
                stack.push(s.charAt(i));
            else
                stack.pop();
        }
        StringBuilder str= new StringBuilder();
        while (!stack.isEmpty()){
            str.append(stack.pop());
        }
        return str.reverse().toString();
    }
}