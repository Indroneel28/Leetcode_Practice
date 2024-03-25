class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        //METHOD 1:- USING HASH MAP DATA STRUCTURE
        /*
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
         */

        //METHOD 2:- USING BRAIN
        ArrayList<Integer> dup= new ArrayList<>();
        for (int i=0; i<nums.length; i++){
            int ele= Math.abs(nums[i]);
            //we are playing with '-'
            //given, Each element in nums appears once or twice.
            if (nums[ele-1]<0)
                dup.add(ele);
            else{
                nums[ele-1]= -nums[ele-1];
            }
        }
        return dup;
    }
}