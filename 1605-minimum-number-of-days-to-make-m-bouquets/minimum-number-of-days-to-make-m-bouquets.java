class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        //OPTIMAL METHOD:- USING BINARY SEARCH
        if (bloomDay.length<(long)m*(long)k)
            return -1;
        int left= min(bloomDay), right= max(bloomDay);
        //int ans= -1;
        while(left<=right){
            int mid= (left+right)/2;
            if (check(bloomDay,m,k,mid)){
                //ans= mid;
                right= mid-1;
            }
            else{
                left= mid+1;
            }
        }
        //return ans;
        return left;
        //TC is O(nlogn) and SC is O(1)
    }

    private boolean check(int[] arr, int m, int k, int mid){
        int count= 0, c= 0;
        for (int ele: arr){
            int x= ele-mid;
            if (x<=0){
                c++;
            }
            else{
                count += (c/k);
                c= 0;
            }
        }
        count += (c/k); //For last iteration
        return count>=m;
    }

    private int max(int[] arr){
        int maximum= 0;
        for (int ele: arr){
            maximum= Math.max(maximum,ele);
        }
        return maximum;
    }
    private int min(int[] arr){
        int maximum= 0;
        for (int ele: arr){
            maximum= Math.min(maximum,ele);
        }
        return maximum;
    }
}