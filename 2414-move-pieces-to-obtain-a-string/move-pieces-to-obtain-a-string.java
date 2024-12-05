class Solution {
    public boolean canChange(String start, String target) {
        //OPTIMAL METHOD:- USING TWO POINTERS
        int i=0, j=0;
        while (i<start.length() || j<target.length()){
            while (i<start.length() && start.charAt(i)=='_')
                i++;
            while (j<target.length() && target.charAt(j)=='_')
                j++;

            //If any index reaches the end
            if (i==start.length() || j==target.length())
                return i==start.length() && j==start.length();

            if (start.charAt(i)!=target.charAt(j) || (i<j && start.charAt(i)=='L') || (j<i && start.charAt(i)=='R'))
                return false;
            i++; j++;
        }
        return true;
        //TC is O(m+n) and SC is O(1)
    }
}