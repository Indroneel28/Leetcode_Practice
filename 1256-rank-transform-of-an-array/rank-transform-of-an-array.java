class Solution {
    public int[] arrayRankTransform(int[] arr) {
        //USING DIFFERENT DATA STRUCTURES
        //Unique elements in sorted manner
        SortedSet<Integer> set= new TreeSet<>();
        for (int ele:arr){
            set.add(ele);
        }

        //Element with their rank
        HashMap<Integer,Integer> map= new HashMap<>();
        int rank= 1;
        for (int ele: set){
            map.put(ele,rank);
            rank++;
        }

        int[] answer= new int[arr.length];
        for (int i=0; i<answer.length; i++)
            answer[i]= map.get(arr[i]);
        return answer;
        //TC is O(nlogn+2n) and SC is O(n+2n+n)
    }
}