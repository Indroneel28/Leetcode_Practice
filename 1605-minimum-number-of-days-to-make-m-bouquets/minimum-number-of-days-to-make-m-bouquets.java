class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if (m*k>bloomDay.length)
            return -1;
        int start= 0, end= 0;
        for (int day: bloomDay){
            end= Math.max(end,day);
        }

        int minDays= -1;
        while (start<=end){
            int mid= (start+end)/2;

            if(getNumOfBouquets(bloomDay,mid,k)>=m){
                minDays= mid;
                end= mid-1;
            }
            else
                start= mid+1;
        }
        return minDays;
    }

    //Helper Method
    private int getNumOfBouquets(int[] bloomDay, int mid, int k){
        int numOfBouqets= 0, count= 0;
        for (int i=0; i<bloomDay.length; i++){
            if (bloomDay[i]<=mid)
                count++;
            else
                count= 0;

            if (count==k){
                numOfBouqets++;
                count= 0;
            }
        }

        return numOfBouqets;
    }
}

//O(N∗Log(Max(Bloomday))