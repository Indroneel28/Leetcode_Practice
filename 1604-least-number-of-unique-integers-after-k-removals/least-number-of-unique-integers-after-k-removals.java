class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        // HashMap<Integer,Integer> hashMap= new HashMap<>();
        // for (int element: arr){
        //     hashMap.put(element,hashMap.getOrDefault(element,0)+1);
        // }

        // ArrayList<Integer> list= new ArrayList<>(hashMap.values());
        // list.sort(null);

        // int m= 0;
        // for (int index= 0; index<list.size(); index++){
        //     m+=list.get(index);
        //     if (m==k)
        //         return list.size()-index-1;
        //     if (m>k)
        //         return list.size()-index;
        // }
        // return -1;
        HashMap<Integer,Integer> hashMap= new HashMap<>();
        for (int element: arr){
            hashMap.put(element,hashMap.getOrDefault(element,0)+1);
        }

        PriorityQueue<Integer> list= new PriorityQueue<>(hashMap.values());
        System.out.println(list);

        int m= 0;
        while (!list.isEmpty()){
            m+=list.poll();
            if(m==k)
                return list.size();
            if (m>=k)
                return list.size()+1;
        }
        return -1;
    }
}