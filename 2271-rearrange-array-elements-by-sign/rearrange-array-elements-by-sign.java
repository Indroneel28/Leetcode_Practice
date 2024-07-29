class Solution {
    public int[] rearrangeArray(int[] nums) {
        //METHOD 1:- USING BRUTE FORCE
        //Storing postives and negatives in separated lists
        ArrayList<Integer> positives= new ArrayList<>();
        ArrayList<Integer> negatives= new ArrayList<>();
        for (int num: nums){
            if (num>0)
                positives.add(num);
            else 
                negatives.add(num);
        }
        
        //Storing in the array
        for (int i=0; i< nums.length/2; i++){
            nums[i*2]= positives.get(i);
            nums[(i*2)+1]= negatives.get(i);
        }
        return nums;
    }
}