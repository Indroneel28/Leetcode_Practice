class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        if (nums.length%3!=0)
            return new int[][]{};
        System.out.println(Arrays.toString(nums));

        int[][] store = new int[nums.length/3][3];
        int m=0, n=0;
        for (int i=0; i<nums.length; i++){
            store[m][n]= nums[i];
            if (n==2){
                if (store[m][2]-store[m][0]>k)
                    return new int[][]{};
                m++;
                n=0;
            }
            else
                n++;
        }
        return store;
    }
}