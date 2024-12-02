class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        //GREEDY APPROACH
        ArrayList<int[]> list= new ArrayList<>();
        //This is ArrayList of Integer Array
        int i=0;
        while (i<intervals.length && intervals[i][1]<newInterval[0]){
            list.add(intervals[i]);
            i++;
        }
        
        //Update newInterval if overlapping of newInterval is there with interval
        while (i<intervals.length && intervals[i][0]<=newInterval[1]){
            newInterval[0]= Math.min(newInterval[0],intervals[i][0]);
            newInterval[1]= Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        list.add(newInterval);

        while (i<intervals.length && newInterval[1]<intervals[i][0]){
            list.add(intervals[i]);
            i++;
        }

        return list.toArray(new int[list.size()][]);
        //TC is O(n) and SC is O(n)
    }
}