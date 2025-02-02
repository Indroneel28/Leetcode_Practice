class Solution {
    public boolean checkString(String s) {
        //BY STRING METHOD
        if(s.contains("a") && s.contains("b")){
            return s.lastIndexOf("a") < s.indexOf("b");
        }
        return true;
    }
}