class Solution {
    public String addSpaces(String s, int[] spaces) {
        //OPTIMAL METHOD:- Using String Builder
        StringBuilder sb= new StringBuilder(s);
        int count= 0;
        for (int space: spaces){
            sb.insert(count+space,' ');
            count++;
        }
        return sb.toString();
        //TC is O(n) and SC is O(n)
    }
}