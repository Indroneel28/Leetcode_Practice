class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //BRUTE FORCE METHOD
        int[] arr= new int[nums1.length];
        for (int i=0; i<nums1.length; i++){
            int ele= nums1[i];
            int nge= -1;
            boolean found= false;
            for (int j=0; j<nums2.length; j++){
                if (ele==nums2[j])
                    found= true;
                if (found && nums2[j]>ele){
                    nge= nums2[j];
                    break;
                }
            }
            arr[i]= nge;
        }
        return arr;
        //TC is O(n^2) and SC is O(1)
    }
}