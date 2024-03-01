class Solution {
    public String maximumOddBinaryNumber(String s) {
        int total= s.length();
        int count= 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '1')
                count++;
        }
        
        String result="";
        for (int i=1; i<count; i++)
            result+=1;
        for (int i=0; i<total-count; i++)
            result+=0;
        return result+1;
    }
}