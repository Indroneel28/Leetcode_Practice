class Solution {
    public String reversePrefix(String word, char ch) {
        int index= word.indexOf(ch);
        String newStr="";
        for (int i=0; i<=index; i++){
            newStr= word.charAt(i) + newStr;
        }
        newStr+=word.substring(index+1);
        return newStr;
    }
}