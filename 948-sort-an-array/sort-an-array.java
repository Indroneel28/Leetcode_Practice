class Solution {
    public int[] sortArray(int[] nums) {
        //METHOD 1:- Heap Sort (using Priority Queue)
        //TC is O(nlogn) and SC is O(1)
        /*
        PriorityQueue<Integer> queue= new PriorityQueue<>();
        for (int num: nums)
            queue.add(num);
        for (int i=0; i<nums.length; i++)
            nums[i]= queue.poll();
        return nums;
         */
        //86 ms Beats 19.37%

        //METHOD 2:- Merge Sort
        //TC is O(nlogn) and SC is O(n)
        mergesort(nums);
        return nums;
    }

    private void mergesort(int[] arr){
        mergeSorting(arr,0,arr.length-1);
    }
    private void mergeSorting(int[] arr, int low, int high){
        if (low>=high)
            return;
        int mid= (low+high)/2;
        mergeSorting(arr,low,mid);
        mergeSorting(arr,mid+1,high);
        merge(arr,low,mid,high);
    }
    private void merge(int[] arr, int low, int mid, int high){
        int[] temp= new int[high-low+1];
        int k= 0;
        int i= low, j= mid+1;

        //Sorting using two pointers i and j
        while (i<=mid && j<=high){
            if (arr[i]<arr[j]){
                temp[k++]= arr[i++];
            }
            else{
                temp[k++]= arr[j++];
            }
        }
        //Inserting remaining elements
        while (i<=mid){
            temp[k++]= arr[i++];
        }
        while(j<=high){
            temp[k++]= arr[j++];
        }

        //Storing in arr from temp
        for (int m=low; m<=high; m++){
            arr[m]= temp[m-low];
        }
    }
}