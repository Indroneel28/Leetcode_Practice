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
        for (int ele: arr){
            if (ele<=k)
                k++;
            else
                break;
        }
        return k;
        //TC is O(n) and SC is O(1)
    }
}