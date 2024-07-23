class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map= new HashMap<>();
        for (int num: nums)
            map.put(num,map.getOrDefault(num,0)+1);


        List<Map.Entry<Integer,Integer>> list= new ArrayList<>(map.entrySet());
        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o1.getValue() < o2.getValue())
                    return -1;
                else if (o1.getValue() > o2.getValue())
                    return 1;
                else {
                    return Integer.compare(o2.getKey(), o1.getKey());
                }
            }
        });
        //System.out.println(list);
        int m= 0;
        for (int i=0; i<list.size(); i++){
            int times= list.get(i).getValue();
            int key= list.get(i).getKey();
            //System.out.println(key+" "+times);
            for (int j=0; j<times; j++){
                nums[m]= key; m++;
            }
        }
        return nums;
    }
}