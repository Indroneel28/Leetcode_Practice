class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        //BRUTE FORCE APPROACH
        int[] store= new int[(n*(n+1))/2];
        int k=0;
        for (int i=0; i<n; i++){
            int sum= 0;
            for (int j=i; j<n; j++){
                sum+= nums[j];
                store[k]= sum;
                k++;
            }
        }

        //Sort the store array in non-decreasing order.
        Arrays.sort(store);

        //left and right are 1-based indexing
        int answer= 0;
        long modulo= 1000000000+7;
        for (int i=left-1; i<right; i++)
            answer= (int) ((answer+store[i])%modulo);
        
        return answer;
        //TC is O(N^2) AND SC is O(N)
    }
}