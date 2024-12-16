class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        //OPTIMAL METHOD:- USING PRIORITY QUEUE
        PriorityQueue<int[]> queue= new PriorityQueue<>(new Comparator<int[]>(){
            //Sort on the basis of highest current pass ratio to lowest current pass ratio.
            @Override
            public int compare(int[] a, int[] b){
                return Double.compare((double)(b[0]+1)/(b[1]+1) - (double)b[0]/b[1] , (double) (a[0]+1)/(a[1]+1) - (double)a[0]/a[1]);
            }
        });

        for (int[] arr:classes){
            queue.add(arr);
        }

        for (int i=0; i<extraStudents; i++){
            int[] extract= queue.poll();
            queue.add(new int[]{extract[0]+1,extract[1]+1});
        }

        //Find the average after adding extra students
        double avg= 0;
        while (!queue.isEmpty()){
            int[] extract= queue.poll();
            avg += ((double) extract[0]/extract[1]);
        }
        return avg/classes.length;

        //TC is O(nlogn + n + extra + n)
    }
}