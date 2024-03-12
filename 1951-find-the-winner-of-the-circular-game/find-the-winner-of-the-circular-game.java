class Solution {
    public int findTheWinner(int n, int k) {
        //METHOD 1:- USING QUEUE DATA STRUCTURE
        /*
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
         */
         //ACTUALLY QUEUE IS MORE APPROPRIATE

        //METHOD 2:- USING LOOP
        int ans= 0;
        for (int i=1; i<=n; i++){
            ans= (ans+k)%i;
        }
        return ans+1;
    }
}