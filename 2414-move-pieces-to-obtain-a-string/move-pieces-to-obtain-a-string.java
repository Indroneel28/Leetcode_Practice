class Solution {
    public boolean canChange(String start, String target) {
        //OPTIMAL METHOD:- USING TWO POINTERS
        int i=0, j=0;
        int cl1=0, cl2=0, cr1=0, cr2=0;
        while (i<start.length() && j<target.length()){
            if (i<start.length() && start.charAt(i)=='_')
                i++;
            else if (j<target.length() && target.charAt(j)=='_')
                j++;
            else{
                char l = start.charAt(i), r = target.charAt(j);
                if (l=='L')
                    cl1++;
                else if (l=='R')
                    cr1++;
                if (r=='L')
                    cl2++;
                else if (r=='R')
                    cr2++;

                if (start.charAt(i) == target.charAt(j)) {
                    if (j > i && l == 'L')
                        return false;
                    else if (i > j && r == 'R')
                        return false;
                    else {
                        i++;
                        j++;
                    }
                }
                else //char does not match at-all
                    return false;
            }
        }
        while (i<start.length()){
            if (start.charAt(i)=='L')
                cl1++;
            else if(start.charAt(i)=='R')
                cr1++;
            i++;
        }
        while (j<target.length()){
            if (target.charAt(j)=='L')
                cl2++;
            else if (target.charAt(j)=='R')
                cr2++;
            j++;
        }
        return cl1==cl2 && cr1==cr2;
        //TC is O(m+n) and SC is O(1)
    }
}