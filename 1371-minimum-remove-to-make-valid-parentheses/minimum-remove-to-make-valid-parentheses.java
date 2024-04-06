class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb= new StringBuilder();
        int count=0;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
                sb.append('(');
            } 
            else if (c == ')'){
                if (count > 0) {
                    count--;
                    sb.append(')');
                }
            }
            else 
                sb.append(s.charAt(i));
        }
        int c=0;
        for (int i=0; i<sb.length(); i++){
            if (sb.charAt(i)==')')
                c++;
        }
        StringBuilder ans= new StringBuilder();
        for (int i=0; i<sb.length(); i++){
            if (sb.charAt(i) == '(') {
                if (c>0) {
                    ans.append(sb.charAt(i));
                    c--;
                }
            }
            else 
                ans.append(sb.charAt(i));
        }
        return ans.toString();
    }
}