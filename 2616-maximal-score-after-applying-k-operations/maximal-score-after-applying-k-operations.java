class Solution {
    public long maxKelements(int[] nums, int k) {
        //OPTIMAL METHOD:- Using Priority Queue
        long score= 0;
        PriorityQueue<Integer> queue= new PriorityQueue<>(Collections.reverseOrder());
        for (int num: nums){
            queue.offer(num);
        }

        //Run k times
        for (int i=0; i<k; i++){
            int ele= queue.poll();
            score += ele;
            ele= Math.ceilDiv(ele,3);
            queue.offer(ele);
        }

        return score;
    }
}