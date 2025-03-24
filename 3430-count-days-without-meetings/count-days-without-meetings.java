class Solution {
    //METHOD 1:- GREEDY METHOD
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings,(a,b)-> a[0]-b[0]);
        int count= 0, latest= -1;
        for (int[] meeting: meetings){
            if (meeting[1]>=latest){
                count += (meeting[1]-Math.max(meeting[0],latest)+1);
                latest= meeting[1]+1;
            }
        }
        return days-count;
    }
    //TC is O(nlogn) and SC is O(1)
}