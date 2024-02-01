class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        if (nums.length%3!=0)
            return new int[][]{};
        System.out.println(Arrays.toString(nums));

        int[][] store = new int[nums.length/3][3];
        int x= 0;
        for (int i=0; i<store.length; i++){
            for (int j=0; j<store[0].length; j++){
                store[i][j]= nums[x];
                x++;
            }
            
            if (store[i][2]-store[i][0]>k)
                return new int[][]{}; 
        }
        return store;
    }
}