class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        //BRUTE FORCE METHOD
        /*
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
         */
        //TC is O(queries.length*arr.length) and SC is O(queries.length)

        //OPTIMAL METHOD:- Using Prefix xor
        int xor= 0;
        for (int i=0; i<arr.length; i++){
            xor^=arr[i];
            arr[i]= xor; //Each index i of arr will store xor from index 0 to index i
        }

        int[] answer= new int[queries.length]; // query size = answer array size
        int k= 0;
        for (int[] query: queries){
            int start= query[0], stop= query[1];
            if (start==0) //-1 index does not exist
                answer[k]= arr[stop]; //from index start=0 to stop
            else
                answer[k]= arr[start-1]^arr[stop]; //from index start>0 to stop
            k++;
        }
        return answer;
        //TC is O(arr.length+queries.length) and SC is O(queries.length)
    }
}