class Solution {
    //USING MIN-HEAP (PRIORITY QUEUE)
    //GIVEN, The input is generated such that an answer always exists.  => queue will never be less than 2 elements
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> queue= new PriorityQueue<>();
        for (int num: nums)
            queue.add((long) num);
        int count= 0;
        while (queue.peek()<k){
            long x= queue.poll();
            long y= queue.poll();
            queue.add(Math.min(x,y)*2 + Math.max(x,y));
            count++;
        }
        return count;
    }
    //TC is O(nlogn) and SC is O(n)
}