class KthLargest {
    //MIN HEAP APPROACH
    PriorityQueue<Integer> queue= new PriorityQueue<>();
    //Will store elements in ascending order
    int k;

    public KthLargest(int k, int[] nums) {
        for (int num: nums)
            queue.offer(num);
        this.k= k;
        while (queue.size()>k){
            queue.poll();
        }
    }

    public int add(int val) {
        queue.offer(val);
        if (queue.size()>k)
            queue.poll(); //Remove the smallest element
        return queue.peek(); //We will get the kth largest element
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */