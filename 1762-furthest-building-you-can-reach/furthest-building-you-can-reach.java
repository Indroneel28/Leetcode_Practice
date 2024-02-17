class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> queue= new PriorityQueue<>();
        int usedBricks= 0;
        
        for (int i=1; i<heights.length; i++){
            int diff= heights[i]-heights[i-1];
            if (diff<0)
                continue;
            if (diff>0)
                queue.add(diff);
            if (!queue.isEmpty() && queue.size()>ladders){
                usedBricks+=queue.poll();
                if (usedBricks>bricks)
                    return i-1; //Coz we can't climb ith index from (i-1)th index
            }
        }
        return heights.length-1;
    }
}