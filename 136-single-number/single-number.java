class Solution {
    //METHOD 1:- BRUTE FORCE APPROACH
    /*
    public int singleNumber(int[] nums) {
        for (int i=0; i<nums.length; i++){
            int count= 0;
            for (int j=0; j<nums.length; j++){
                if (nums[i]==nums[j])
                    count++;
            }
            if (count==1)
                return nums[i];
        }
        return -1; //This line will never execute
    }
     */
    //TC is O(n^2) and SC is O(1)

    //METHOD 2:- BETTER SOLUTION using HashMap
    /*
    public static int singleNumber(int[] nums) {
        HashMap<Integer,Integer> map= new HashMap<>();
        for (int ele: nums) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        for (int key: map.keySet()){
            if (map.get(key)==1)
                return key;
        }
        return -1; //This line will never execute
    }
     */
    //TC is O(n) and SC is O(n)

    //METHOD 3:- OPTIMAL SOLUTION
    //Given only one number appears once and rest number appear twice.
    //We will use XOR Concept
    // x ^ x = 0 and x ^ 0 = x and 0 ^ 0 = 0
    
    public int singleNumber(int[] nums) {
        int ans= 0;
        for (int num: nums)
            ans^=num;
        return ans;
    }
    //TC is O(n) and SC is O(1)
}