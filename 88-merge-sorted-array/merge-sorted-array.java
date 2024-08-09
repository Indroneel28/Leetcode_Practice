class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //METHOD 1:- USING SORTING (BRAIN)
        /*
        for (int i = 0 , j = m ; i < n ; i++){
            nums1[j]= nums2[i];
            j++;
        }
        Arrays.sort(nums1);
         */
        //TC is O(nlogn) and SC is O(1)

        //METHOD 2:- BRUTE FORCE APPROACH
        /*
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
         */
        //TC is O(2n) and SC is O(n)

        //METHOD 3:- OPTIMAL SOLUTION
        int i= m-1, j= n-1, k= m+n-1;
        while (i>=0 && j>=0){
            if (nums1[i]>nums2[j]){
                nums1[k--]= nums1[i--];
            }
            else{
                nums1[k--]= nums2[j--];
            }
        }
        while (i>=0){
            nums1[k--]= nums1[i--];
        }
        while (j>=0){
            nums1[k--]= nums2[j--];
        }
        //TC is O(m+n) and SC is O(1)
    }
}