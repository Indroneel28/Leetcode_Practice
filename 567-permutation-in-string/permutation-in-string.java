class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //METHOD 1:- FIND ALL PERMUTATIONS
        //TC is O(n!) and SC is O(n)

        //METHOD 2:- USING SORTING

        int n= s2.length(), m= s1.length();
        if (m>n)
            return false;

        char[] arr1= s1.toCharArray();
        Arrays.sort(arr1);
        s1= new String(arr1);


        for (int i=0; i<n-m+1; i++){
            String k= s2.substring(i,m+i);
            char[] arr2= k.toCharArray();
            Arrays.sort(arr2);
            k= new String(arr2);
            if (s1.equals(k))
                return true;
        }
        return false;
        //TC is O(n^2 + n*nlogn) and SC is O(n)
    }
}