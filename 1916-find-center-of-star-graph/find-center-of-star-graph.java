class Solution {
    public int findCenter(int[][] edges) {
        //Given edges.length == n-1 and n>=3
        //So, edges.length>=2
        int a= edges[0][0], b= edges[0][1], c= edges[1][0], d= edges[1][1];
        if (a==c || a==d)
            return a;
        if (b==c || b==d) //This will definitely execute as it's confirm as given in constraint
            return b;
        
        return -1; //This will never execute
    }
}