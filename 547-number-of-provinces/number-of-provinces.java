class Solution {
    //METHOD 2:- DFS Traversal
    public int findCircleNum(int[][] isConnected) {
        boolean[] isVisted= new boolean[isConnected.length];
        int provinces= 0;
        for (int i=0; i<isConnected.length; i++){
            if (!isVisted[i]){
                dfsTraversal(i,isVisted,isConnected);
                provinces++;
            }
        }
        return provinces;
    }
    private void dfsTraversal(int node, boolean[] isVisited, int[][] isConnected){
        isVisited[node]= true;
        for (int i=0; i<isConnected.length; i++){
            if (isConnected[node][i]==1 && !isVisited[i]){
                dfsTraversal(i,isVisited,isConnected);
            }
        }
    }
    //TC is O(N + N + 2E) and SC is O(2N)
}