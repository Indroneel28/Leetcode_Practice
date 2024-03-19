class Solution {
    public int leastInterval(char[] tasks, int n) {
        //USING GREEDY APPROACH

        int[] store= new int[26];

        int max= 0;
        for (char c: tasks){
            store[c-65]++;
            max= Integer.max(store[c-65],max);
        }

        int maxStore= 0;
        for (int i: store){
            if (i==max)
                maxStore++;
        }

        return Math.max(tasks.length, (max-1)*(n+1) + maxStore);
    }
}