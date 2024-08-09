class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //METHOD 1:- USING SORTING
        /*
        for (int i = 0 , j = m ; i < n ; i++){
            nums1[j]= nums2[i];
            j++;
        }
        Arrays.sort(nums1);
         */
        //TC is O(nlogn) and SC is O(1)

        //METHOD 2:- BRUTE FORCE APPROACH
        int[] store= new int[m+n];
        int i= 0, j= 0, k= 0;
        while (i<m && j<n){
            if (nums1[i]<=nums2[j]){
                store[k++]= nums1[i++];
            }
            else{
                store[k++]= nums2[j++];
            }
        }
        while (i<m)
            store[k++]= nums1[i++];
        while (j<n)
            store[k++]= nums2[j++];
        for (int x=0; x<m+n; x++){
            nums1[x]= store[x];
        }
        //TC is O(n) and SC is O(n)
    }
}