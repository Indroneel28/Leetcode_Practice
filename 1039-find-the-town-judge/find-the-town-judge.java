class Solution {
    public int findJudge(int n, int[][] trust) {
        //USING ARRAY
        int[][] store= new int[n+1][2];
        for (int i=0; i<trust.length; i++){
            store[trust[i][0]][0]++;
            store[trust[i][1]][1]++;
        }
        //Ignore index 0 coz 1 to n given in question
        for (int i=1; i<store.length; i++){
            if (store[i][0]==0 && store[i][1]==n-1)
                return i;
        }
        return -1;
    }
}