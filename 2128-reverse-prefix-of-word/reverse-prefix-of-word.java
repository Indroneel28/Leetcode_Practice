class Solution {
    public String reversePrefix(String word, char ch) {
        //METHOD 1:- USING STRING
        /*
        int index= word.indexOf(ch);
        String newStr="";
        for (int i=0; i<=index; i++){
            newStr= word.charAt(i) + newStr;
        }
        newStr+=word.substring(index+1);
        return newStr;
         */

        //method 2:- using string builder
        StringBuilder sb= new StringBuilder(word.substring(0,word.indexOf(ch)+1));
        sb.reverse();
        sb.append(word,word.indexOf(ch)+1,word.length());
        return sb.toString();
    }
}