class Solution {
    public int findKthPositive(int[] arr, int k) {
        //METHOD 1:- BRUTE FORCE METHOD
        /*
        int count= 0, ans= 1;
        while (true){
            boolean found= false;
            for (int ele: arr){
                if (ans==ele)
                    found= true;
            }
            if (!found){
                count++;
                if (count==k) {
                    return ans;
                }
            }
            ans++;
        }
         */
        //TC is O(n^2) and SC is O(1)

        //METHOD 2:- BETTER SOLUTION
        /*
        for (int ele: arr){
            if (ele<=k)
                k++;
            else
                break;
        }
        return k;
         */
        //TC is O(n) and SC is O(1)

        //METHOD 3:- OPTIMAL SOLUTION
        int left= 0, right= arr.length-1;
        while (left<=right){
            int mid= (left+right)/2;
            int missing= arr[mid]-(mid+1);
            if (missing<k)
                left= mid+1;
            else
                right= mid-1;
        }
        //return k+right+1;
        return k+left;
        //TC is O(logn) and SC is O(1)
    }
}