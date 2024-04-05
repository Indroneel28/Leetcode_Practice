class Solution {
    public String makeGood(String s) {
        //METHOD 2:- USING STRING BUILDER
        StringBuilder sb= new StringBuilder();
        for (int i=0; i<s.length(); i++){
            if (!sb.isEmpty() && Math.abs(sb.charAt(sb.length()-1) - s.charAt(i))==32)
                sb.deleteCharAt(sb.length()-1);
            else 
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}