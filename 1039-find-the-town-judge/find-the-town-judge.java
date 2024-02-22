class Solution {
    public int findJudge(int n, int[][] trust) {
        HashSet<Integer> hashSet= new HashSet<>();
        for (int i=1; i<=n; i++)
            hashSet.add(i);
        for (int i=0; i<trust.length; i++){
            hashSet.remove(trust[i][0]);
        }
        if (hashSet.size()==1){
            int judge= (int) (hashSet.toArray()[0]);
            HashSet<Integer> list= new HashSet<>();
            for (int i=0; i<trust.length; i++){
                if (trust[i][1]== judge)
                    list.add(trust[i][0]);
            }
            if (list.size()==n-1)
                return judge;
        }
        return -1;
    }
}