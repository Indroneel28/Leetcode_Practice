class Solution {
    public boolean divideArray(int[] nums) {
        HashMap<Integer,Integer> hashMap= new HashMap<>();
        for (int num: nums){
            hashMap.put(num,hashMap.getOrDefault(num,0)+1);
        }
        for (int ele: hashMap.keySet()){
            if (hashMap.get(ele)%2!=0)
                return false;
        }
        return true;
    }
}