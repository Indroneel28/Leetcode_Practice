class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //METHOD 1:- BETTER SOLUTION USING HASHMAP
        /*
        HashMap<Integer,Integer> store = new HashMap<>();
        for (int i=0; i< nums.length; i++){
            store.put(nums[i],store.getOrDefault(nums[i],0)+1);
        }

        Set<Integer> keySet= store.keySet();
        int length= nums.length;
        List<Integer> list= new ArrayList<>();
        for (Integer key: keySet){
            if (store.get(key) > length/3)
                list.add(key);
        }
        return list;
         */
        //TC is O(n) and SC is O(n)

        //METHOD 2- OPTIMAL SOLUTION
        //By Observation we found that there can be atmost 2 MAJORITY ELEMENT only
        //Applying the Extending Boyer's Moore Algorithm
        int ele1= Integer.MIN_VALUE, count1= 0;
        int ele2= Integer.MIN_VALUE, count2= 0;

        for (int num: nums){
            if (count1==0 && num!=ele2) {
                ele1= num;
                count1++;
            }
            else if (count2==0 && num!=ele1) {
                ele2= num;
                count2++;
            }
            else if (num==ele1)
                count1++;
            else if (num==ele2)
                count2++;
            else {
                count1--;
                count2--;
            }
        }
        
        List<Integer> list= new ArrayList<>();
        //Now, lets check whether ele1 and ele2 are majority elements or not.
        count1= 0; count2= 0;
        for (int num: nums){
            if (num==ele1)
                count1++;
            if (num==ele2)
                count2++;
        }
        if (count1>(nums.length/3))
            list.add(ele1);
        if (count2>(nums.length/3))
            list.add(ele2);
        return list;
        //TC is O(2n) and SC is O(1)
    }
}