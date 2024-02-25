class Solution {
    public boolean divideArray(int[] nums) {
        //METHOD 1:- USING HASHMAP
        /*
        HashMap<Integer,Integer> hashMap= new HashMap<>();
        for (int num: nums){
            hashMap.put(num,hashMap.getOrDefault(num,0)+1);
        }
        for (int ele: hashMap.keySet()){
            if (hashMap.get(ele)%2!=0)
                return false;
        }
        return true;
         */

        //METHOD 2:- USING ARRAY
        //1 <= nums[i] <= 500
        int[] store= new int[500+1];
        for (int num: nums)
            store[num]++;
        for (int ele: store){
            if (ele%2==1)
                return false;
        }
        return true;
    }
}