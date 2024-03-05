class Solution {
    public int minimumLength(String s) {
        //USING TWO-POINTERS
        int i=0, j= s.length()-1;
        while (i<=j){
            if (i==j)
                return 1;
            else if (s.charAt(i)!=s.charAt(j))
                return j-i+1;
            else if (s.charAt(i)==s.charAt(j) && i+1<j && s.charAt(i)==s.charAt(i+1))
                i++;
            else if (s.charAt(i)==s.charAt(j) && j-1>i && s.charAt(j)==s.charAt(j-1))
                j--;
            else if (s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }
        }
        return 0;
    }
}