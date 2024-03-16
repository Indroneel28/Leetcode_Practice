class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        HashMap<Integer,Integer> hashMap= new HashMap<>();
        for (int num: nums){
            hashMap.put(num,hashMap.getOrDefault(num,0)+1);
        }

        ArrayList<Integer> arrayList= new ArrayList<>();
        for (Integer key: hashMap.keySet()){
            if (hashMap.get(key)>1)
                arrayList.add(key);
        }
        return arrayList;
    }
}