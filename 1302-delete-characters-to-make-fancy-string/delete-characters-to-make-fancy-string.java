class Solution {
    public String makeFancyString(String s) {
        char c= '?';
        long count= 0;
        StringBuilder sb= new StringBuilder();
        for (int i=0; i<s.length(); i++){
            if (c==s.charAt(i)){
                count++;
                if (count<3)
                    sb.append(c);
            }
            else{
                c= s.charAt(i);
                count= 1;
                sb.append(c);
            }
        }
        return sb.toString();
    }
}