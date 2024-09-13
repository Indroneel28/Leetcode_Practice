class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        //BRUTE FORCE METHOD
        int[] answer= new int[queries.length]; //queries size = answer array size

        int k=0;
        for (int[] query: queries){
            int xor= 0;
            for (int i= query[0]; i<=query[1]; i++){
                xor ^= arr[i];
            }
            answer[k++]= xor;
        }

        return answer;
        //TC is O(queries.length*arr.length) and SC is O(queries.length)
    }
}