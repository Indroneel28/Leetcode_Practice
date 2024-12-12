class Solution {
    //OPTIMAL METHOD:- USING PRIORITY QUEUE
    public long pickGifts(int[] gifts, int k) {
        long sum= 0;
        PriorityQueue<Integer> queue= new PriorityQueue<>(Comparator.reverseOrder());
        for (int gift: gifts) {
            sum += gift;
            queue.add(gift);
        }
        for (int i=0; i<k; i++){
            int removeGift= queue.poll();
            int leftGift= (int)Math.floor(Math.sqrt(removeGift));
            queue.offer(leftGift);
            sum -= (removeGift-leftGift);
        }
        return sum;
    }
    //Insertion and removal in Priority Queue takes O(logn) TC
    //TC is O(n*logn + k*logn) and SC is O(n)
}