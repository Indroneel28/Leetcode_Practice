class Solution {
    public int myAtoi(String s) {
        int sign = 1, i = 0, result = 0; 
        boolean beforeInt = true; 
        int len = s.length();

        while (i < len && s.charAt(i) == ' ') 
            i++; 
        
        if (i < len && s.charAt(i) == '-' ){
            sign = -1; 
            i++; 
        } else if (i < len && s.charAt(i) == '+' )
            i++; 
        
        while (i < len && Character.isDigit(s.charAt(i))){
            int digit = Character.getNumericValue(s.charAt(i));

            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) 
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            
            result= result*10 + digit; 
            i++; 
        }
        return result*sign; 
    }
}