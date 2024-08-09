class Solution {
    public int[][] merge(int[][] intervals) {
        //Sorting on the basis of Earliest starting time
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        List<List<Integer>> list= new ArrayList<>();
        for (int i=0; i<intervals.length; i++){
            if (!list.isEmpty() && intervals[i][0] <= list.get(list.size()-1).get(1)){
                if (intervals[i][1]>list.get(list.size()-1).get(1)){
                    List<Integer> l= new ArrayList<>();
                    l.add(list.get(list.size()-1).get(0));
                    l.add(intervals[i][1]);
                    list.set(list.size()-1,l);
                }
            }
            else {
                List<Integer> l= new ArrayList<>();
                l.add(intervals[i][0]);
                l.add(intervals[i][1]);
                list.add(l);
            }
        }

        //Storing in int[][]
        int[][] answer= new int[list.size()][2];
        for (int i=0; i< list.size(); i++) {
            answer[i][0] = list.get(i).get(0);
            answer[i][1] = list.get(i).get(1);
        }
        return answer;
    }
}