class Solution {
    public int minIncrementForUnique(int[] nums) {
        //Using Greedy Approach to solve the program
        Arrays.sort(nums);

        //HashSet is used to store the unique numbers
        HashSet<Integer> set= new HashSet<>();
        int max= 0;
        int increment= 0;
        for (int num : nums) {
            boolean b = set.add(num);
            if (num>max){
                max= num;
            }
            if (!b) {
                increment+= (max+1-num);
                set.add(max+1);
                max++;
            }
        }
        return increment;
    }
}