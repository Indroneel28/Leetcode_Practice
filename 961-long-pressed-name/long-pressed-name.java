class Solution {
    public boolean isLongPressedName(String name, String typed) {
        //Using Two Pointers Method
        int i=0, j=0;
        int m= name.length(), n= typed.length();

        while (i<m && j<n){
            char c1= name.charAt(i), c2= typed.charAt(j);
            if (c1!=c2)
                return false;
            int count1=0, count2=0;
            while (i<m && c1==name.charAt(i)){
                count1++; i++;
            }
            while (j<n && c2==typed.charAt(j)){
                count2++; j++;
            }
            if (count1>count2)
                return false;
        }
        return i==m && j==n;
    }
}