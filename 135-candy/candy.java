class Solution {
    public int candy(int[] ratings) {
        //BETTER METHOD:- GREEDY APPROACH
        int[] store= new int[ratings.length];
        store[0]= 1;
        for (int i=1; i<ratings.length; i++){
            if (ratings[i-1]<ratings[i])
                store[i]= store[i-1]+1;
            else
                store[i]= 1;
        }

        int minCandies= store[store.length-1];
        int candy= 1;
        for (int i=ratings.length-2; i>=0; i--){
            if (ratings[i]>ratings[i+1])
                candy++;
            else 
                candy= 1;
            minCandies+=Math.max(store[i],candy);
        }
        return minCandies;
        //TC is O(2n) and SC is O(n)
    }
}