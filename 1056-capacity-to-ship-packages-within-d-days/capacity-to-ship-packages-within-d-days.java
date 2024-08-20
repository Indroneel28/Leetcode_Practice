class Solution {
    public int shipWithinDays(int[] weights, int days) {

        //int left= 1, right= sum(weights);

        //OR

        //left will be the maximum and right will be the sum
        int left= 0, right= 0;
        for (int ele: weights){
            if (ele>left)
                left= ele; //max
            right+= ele; //sum
        }

        //BINARY SEARCH
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
}