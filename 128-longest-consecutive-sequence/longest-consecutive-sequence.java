class Solution {
    public int longestConsecutive(int[] nums) {
        //METHOD 2:- BETTER APPROACH USING SORTING
        /*
        Arrays.sort(nums);
        int maxCount=0, count =1;
        //Count is 1 because any element count is 1
        if (nums.length==0 || nums.length==1)
            return nums.length;

        for (int i=0; i<nums.length-1; i++){
            if(nums[i]==nums[i+1]) //If elements are repeated then ignore them
                continue;
            if (nums[i]+1==nums[i+1]){
                count++;
                if (count>maxCount)
                    maxCount= count;
            }
            else{
                count=1;
            }
        }
        return maxCount;
         */
        //TC is O(NlogN) and SC is O(1)

        //METHOD 3:- OPTIMAL SOLUTION USING HASHSET
        int n= nums.length;
        if (n==0) //Empty array
            return 0;
        HashSet<Integer> set= new HashSet<>();

        //Adding all the elements in the hashset
        for (int ele: nums)
            set.add(ele);
        //Insertion in the HashSet takes O(1) if there is no collisions generally!!

        int maxCount= 1;
        //maxCount is 1 because any element can be taken, and it's size is 1 always.

        //Extract all the elements from the HashSet
        for (int ele: set){
            //If ele-1 does not exist in the set
            if (!set.contains(ele-1)){
                int count= 0;
                int dup= ele;
                while (set.contains(dup)){
                    count++;
                    dup++;
                }
                maxCount= Math.max(maxCount,count);
            }

        }
        return maxCount;
        //TC is O(N) and SC is O(N)
    }
}