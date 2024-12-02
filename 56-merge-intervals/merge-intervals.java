class Solution {
    public int[][] merge(int[][] intervals) {
        //OPTIMAL METHOD:- GREEDY APPROACH
        // Sort the intervals on the basis of earliest start time first.
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0],b[0]));
        //Using lambda expressions

        ArrayList<int[]> list= new ArrayList<>();
        for (int[] interval: intervals){
            if (!list.isEmpty()){
                if (interval[0]<=list.get(list.size()-1)[1]){
                    list.get(list.size()-1)[1]= Math.max(list.get(list.size()-1)[1],interval[1]);
                }
                else 
                    list.add(interval);
            }
            else
                list.add(interval);
        }
        
        return list.toArray(new int[list.size()][]);
        //TC is O(n*2) and SC is O(n*2)
    }
}