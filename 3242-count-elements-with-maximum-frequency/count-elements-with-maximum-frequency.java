class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> hashMap= new HashMap<>();
        for (int element: nums){
            hashMap.put(element,hashMap.getOrDefault(element,0)+1);
        }

        int max= 0; //We are finding the max value
        for (int value: hashMap.values()){
            if (value > max)
                max= value;
        }

        int count=0;
        for (int key: hashMap.keySet()){
            if (max==hashMap.get(key)) //key.value== max then count+= add value
                count+=hashMap.get(key);
        }

        return count;
    }
}