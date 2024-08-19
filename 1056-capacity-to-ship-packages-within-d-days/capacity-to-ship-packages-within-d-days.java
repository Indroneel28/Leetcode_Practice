class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left= 1, right= sum(weights);

        while (left<=right){
            int mid= (left+right)/2;
            if (check(weights,mid,days)){
                right= mid-1;
            }
            else{
                left= mid+1;
            }
        }
        return left;
        //TC is O(nlogn) and SC is O(1)
    }

    private boolean check(int[] weights, int mid, int days){
        int c= 0, m=mid;
        for (int weight: weights){
            if(weight>mid)
                return false;
            if (m>=weight){
                m-=weight;
            }
            else{
                c++;
                m= mid-weight;
            }
        }
        if (m!=mid) //For last iteration
            c++;
        return c<=days;
    }

    private int sum(int[] weights){
        int s= 0;
        for(int weight: weights){
            s+= weight;
        }
        return s;
    }
}