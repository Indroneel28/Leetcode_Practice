class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //METHOD 1:- LINEAR SEARCH
        /*
        int ans= 1;
        while (true){
            long sum= 0;
            for (int pile: piles){
                sum+= Math.ceilDiv(pile,ans);
            }
            if (sum<=h)
                break;
            else
                ans++;
        }
        return ans;
         */
        //TC is O(n^2) and SC is O(1)
        //TLE
        
        //METHOD 2:- BINARY SEARCH
        int left= 1, right= maximum(piles);
        while (left<=right){
            int mid= (left+right)/2;
            if (check(piles,mid)<=h){
                right= mid-1;
            }
            else {
                left= mid+1;
            }
        }
        return left; //Left will always point
        //Here, we can also use variable to store the answer BUT let's go advance
        //TC is O(nlogn) and SC is O(1)
    }
    
    //Method to find the maximum element in the array
    private int maximum(int[] arr){
        int max= arr[0];
        for (int i=1; i<arr.length; i++){
            if (arr[i]>max)
                max= arr[i];
        }
        return max;
    }
    
    //Method to find total hours
    private long check(int[] piles, int hour){
        long totalHours= 0;
        for (int pile: piles){
            totalHours+= Math.ceilDiv(pile,hour);
        }
        return totalHours;
    }
}