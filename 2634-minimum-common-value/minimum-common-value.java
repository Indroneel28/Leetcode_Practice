class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int x= 0, y= 0;
        while (x<nums1.length && y<nums2.length){
            if (nums1[x]==nums2[y])
                return nums1[x];
            if (nums1[x]>nums2[y])
                y++;
            else 
                x++;
        }
        return -1;
    }
}