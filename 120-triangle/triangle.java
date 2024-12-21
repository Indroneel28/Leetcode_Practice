class Solution {
    //METHOD 3:- TABULATION (BOTTOM-UP APPROACH)
    public int minimumTotal(List<List<Integer>> triangle) {
        int n= triangle.size();
        List<Integer> list= new ArrayList<>(triangle.get(n-1));

        for (int i=n-2; i>=0; i--){
            for (int j=0; j<=i; j++) {
                int left = list.get(j);
                int right = list.get(j + 1);
                list.set(j,triangle.get(i).get(j)+Math.min(left,right));
            }
            list.remove(list.size()-1);
        }
        return list.get(0);
    }
    //TC is O(n^2) and SC is O(n)
}