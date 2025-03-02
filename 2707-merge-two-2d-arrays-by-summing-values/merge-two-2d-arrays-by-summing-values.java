class Solution {
    //METHOD 1:- USING THREE POINTERS
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int[][] merged= new int[nums1.length+nums2.length][2];
        int i= 0, j= 0, k= 0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i][0]==nums2[j][0]){
                merged[k][0]= nums1[i][0];
                merged[k][1]= nums1[i][1] + nums2[j][1];
                k++; i++; j++;
            }
            else if(nums1[i][0]<nums2[j][0]){
                merged[k][0]= nums1[i][0];
                merged[k][1]= nums1[i][1];
                k++; i++;
            }
            else{
                merged[k][0]= nums2[j][0];
                merged[k][1]= nums2[j][1];
                k++; j++;
            }
        }
        while(i<nums1.length){
            merged[k][0]= nums1[i][0];
            merged[k][1]= nums1[i][1];
            k++; i++;
        }
        while(j<nums2.length){
            merged[k][0]= nums2[j][0];
            merged[k][1]= nums2[j][1];
            k++; j++;
        }
        return Arrays.copyOf(merged,k);
    }
    //TC is O(m+n) and SC is O(m+n)
}