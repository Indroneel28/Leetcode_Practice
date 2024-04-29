class Solution {
    public int maximumValue(String[] strs) {
        int maxLen=0;
        for (int i=0; i<strs.length; i++){
            int len=0;
            try{
                len= Integer.parseInt(strs[i]);
            }
            catch (NumberFormatException e){
                len= strs[i].length();
            }
            if (len>maxLen)
                maxLen= len;
        }
        return maxLen;
    }
}