class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue= new LinkedList<>();
        for (int i=1; i<=n; i++)
            queue.add(i);

        int c=1;
        while (queue.size()!=1){
            int ele= queue.poll();
            if (c%k!=0){
                queue.offer(ele);
            }
            c++;
        }
        return queue.remove();
    }
}