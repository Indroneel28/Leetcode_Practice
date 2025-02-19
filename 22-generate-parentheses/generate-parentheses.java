class Solution {
    //USING RECURSION AND BACKTRACKING
    public List<String> generateParenthesis(int n) {
        List<String> answer= new ArrayList<>();
        parenthesis(answer, new StringBuilder(),0,0,n);
        return answer;
    }
    //Helper Method
    private void parenthesis(List<String> list, StringBuilder sb, int c1, int c2, int n){
        if (c1==n && c2==n){
            list.add(sb.toString());
            return;
        }
        if (c1<n){
            sb.append('(');
            parenthesis(list,sb,c1+1,c2,n);
            sb.deleteCharAt(sb.length()-1);
        }
        if (c2<n && c2<c1){
            sb.append(')');
            parenthesis(list,sb,c1,c2+1,n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    //TC is Exponential and SC is O(n) coz of stack space
    //We can ignore space for list coz return type of question is list
}