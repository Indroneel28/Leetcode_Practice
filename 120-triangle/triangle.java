class Solution {
    //METHOD 2:- MEMOIZATION (TOP-DOWN APPROACH)
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp= new ArrayList<>();
        for (int i=0; i<triangle.size(); i++){
            List<Integer> list= new ArrayList<>();
            for (int j=0; j<triangle.get(i).size(); j++){
                list.add(null);
            }
            dp.add(list);
        }
        return memoization(triangle,dp,0,0);
    }
    private int memoization(List<List<Integer>> triangle, List<List<Integer>> dp, int i, int j){
        if (i==triangle.size())
            return 0;
        if (j<0 || j>=triangle.get(i).size())
            return Integer.MAX_VALUE;
        if (dp.get(i).get(j)!=null)
            return dp.get(i).get(j);
        int mini= triangle.get(i).get(j) + Math.min(memoization(triangle,dp,i+1,j),memoization(triangle,dp,i+1,j+1));
        dp.get(i).set(j,mini);
        return mini;
    }
    //TC is O(n^2) and SC is O(n^2 + n)
}