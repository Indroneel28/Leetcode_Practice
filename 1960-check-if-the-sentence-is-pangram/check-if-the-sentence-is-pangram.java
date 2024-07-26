class Solution {
    public boolean checkIfPangram(String sentence) {
        char[] store= new char[26];
        for (int i=0; i<sentence.length(); i++){
            char c= sentence.charAt(i);
            store[c-97]++;
            //ASCII lower case characters start from 97 to 122
        }

        for (int ele: store){
            if (ele==0)
                return false;
        }
        return true;
    }
}