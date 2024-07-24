class Solution {
    public int removeDuplicates(int[] nums) {
        //METHOD 1:- USING ARRAYLIST
        /*
        ArrayList<Integer> list= new ArrayList<>();
        for (int i=0; i<nums.length; i++){
            if (!list.contains(nums[i]))
                list.add(nums[i]);
        }
        for (int i=0; i<list.size(); i++)
            nums[i]= list.get(i);
        return list.size();
         */

        //METHOD 2:- USING TWO POINTERS APPROACH
        /*
        int index= 1;
        for (int i=0; i<nums.length-1; i++){
            if (nums[i]!=nums[i+1]){
                nums[index]= nums[i+1];
                index++;
            }
        }
        return index;
         */

        //METHOD 3:- USING SET DATA STRUCTURE
        /*
        Set<Integer> set= new HashSet<>();
        int i=0;
        for (int num: nums) {
            if (set.add(num)){
                nums[i]= num;
                i++;
            }
        }
        return set.size();
         */

        //METHOD 4:- USING TWO POINTERS OPTIMIZED APPROACH
        int i=0;
        for (int j=1; j<nums.length; j++){
            if (nums[i]!=nums[j]){
                i++;
                nums[i]= nums[j];
            }
        }
        return i+1;
    }
}