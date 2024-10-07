class Solution {
    public int minLength(String s) {
        //REMOVING THE SUBSTRINGS ONE_BY_ONE
        String str= new String(s);
        while (str.contains("AB") || str.contains("CD")){
            if (str.contains("AB")){
                int index= str.indexOf("AB");
                if (index+2<str.length())
                    str= str.substring(0,index)+str.substring(index+2);
                else
                    str= str.substring(0,index);
            }
            if (str.contains("CD")){
                int index= str.indexOf("CD");
                if (index+2<str.length())
                    str= str.substring(0,index)+str.substring(index+2);
                else
                    str= str.substring(0,index);
            }
        }
        return str.length();
        //TC is O(n^2) and SC is O(n)
    }
}