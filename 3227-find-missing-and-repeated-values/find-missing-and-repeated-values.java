class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        //METHOD 1:- USING ARRAY
        int[] store= new int[grid.length*grid.length+1];
        for(int[] row: grid){
            for(int num: row){
                store[num]++;
            }
        }
        int[] ans= new int[2];
        for(int i=1; i<store.length; i++){
            if(store[i]==2)
                ans[0]= i;
            else if(store[i]==0)
                ans[1]= i;
        }
        return ans;
        //TC is O(n^2) and SC is O(n^2)
    }
}