class Solution {
    public int[] sortArray(int[] nums) {
        //METHOD 1:- Heap Sort (using Priority Queue)
        //Tc is O(nlogn) and SC is O(1)
        PriorityQueue<Integer> queue= new PriorityQueue<>();
        for (int num: nums)
            queue.add(num);
        for (int i=0; i<nums.length; i++)
            nums[i]= queue.poll();
        return nums;
    }


}