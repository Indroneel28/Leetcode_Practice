class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        //OPTIMAL METHOD:- USING TWO POINTERS
        int i= 0, j= 0;
        while (i<str1.length() && j<str2.length()){
            if (str1.charAt(i)==str2.charAt(j) || (char)(str1.charAt(i)+1)==str2.charAt(j) || (str1.charAt(i)=='z' && 'a'== str2.charAt(j))){
                i++; j++;
                if (j==str2.length())
                    return true;
            }
            else
                i++;
        }
        return false;
        //TC is O(m+n) and SC is O(1)
    }
}