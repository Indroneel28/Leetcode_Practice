class Solution {
    public String compressedString(String word) {
        //SIMPLE BRUTE FORCE METHOD
        char last =word.charAt(0); int count= 0;
        StringBuilder sb= new StringBuilder();
        for (int i=0; i<word.length(); i++){
            char c= word.charAt(i);
            if (last == c)
                count++;
            else{
                if (count!=0) {
                    sb.append(count);
                    sb.append(last);
                }
                count= 1;
                last= c;
            }
            if (count==9){
                sb.append(9);
                sb.append(last);
                count-=9;
            }
        }
        if (count!=0) {
            sb.append(count); //For last element occurrence
            sb.append(last); //For the lst element
        }
        return sb.toString();
        //TC is O(n) and SC is O(newString's length)
    }
}