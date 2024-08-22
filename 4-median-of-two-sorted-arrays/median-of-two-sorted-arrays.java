class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //METHOD 1:- BRUTE FORCE APPROACH
        int n= nums1.length+nums2.length;
        int[] store= new int[n];
        int i= 0, j= 0, k= 0;
        while (i<nums1.length && j<nums2.length){
            if (nums1[i]<=nums2[j])
                store[k++]= nums1[i++];
            else
                store[k++]= nums2[j++];
        }
        while (i<nums1.length)
            store[k++]= nums1[i++];
        while (j<nums2.length)
            store[k++]= nums2[j++];

        if (n%2==0){
            //Two medians are there
            return (store[n/2]+store[n/2-1])/2.0;
        }
        else
            return store[n/2];
        //TC is O(n1+n2) and SC is O(n1+n2)
    }
}