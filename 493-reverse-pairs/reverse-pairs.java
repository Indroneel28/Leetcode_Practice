class Solution {
    public int reversePairs(int[] nums) {
        //METHOD 1:- BRUTE FORCE APPROACH
        /*
        int count= 0;
        for (int i=0; i<nums.length; i++){
            for (int j=i+1; j<nums.length; j++){
                if (nums[i]>2*nums[j])
                    count++;
            }
        }
        return count;
         */
        //TC is O(n^2) and SC is O(1)

        //METHOD 2:- MERGE SORT METHOD
        return mergeSort(nums,0,nums.length-1);
    }

    private static void merge(int[] arr, int low, int mid, int high){
        ArrayList<Integer> temp= new ArrayList<>();
        int left= low, right= mid+1;

        while (left<=mid && right<=high){
            if (arr[left]<=arr[right]){
                temp.add(arr[left]);
                left++;
            }
            else{
                temp.add(arr[right]);
                right++;
            }
        }
        //If elements in left still left
        while (left<=mid){
            temp.add(arr[left]);
            left++;
        }
        //If elements in right still left
        while (right<=high){
            temp.add(arr[right]);
            right++;
        }

        //transferring all elements from temporary to arr
        for (int i=low; i<=high; i++){
            arr[i]= temp.get(i-low);
        }
    }

    private static int countPairs(int[] arr, int low, int mid, int high){
        int right= mid+1;
        int count= 0;
        for (int i=low; i<=mid; i++){
            while (right<=high && arr[i]>(2*(long)arr[right]))
                right++;
            count+= (right-(mid+1));
        }
        return count;
    }

    private static int mergeSort(int[] arr, int low, int high){
        int count= 0;
        if (low>=high)
            return 0;
        int mid= (low+high)/2;
        count += mergeSort(arr,low,mid);
        count += mergeSort(arr,mid+1,high);
        count += countPairs(arr,low,mid,high);
        merge(arr,low,mid,high);
        return count;
    }
}