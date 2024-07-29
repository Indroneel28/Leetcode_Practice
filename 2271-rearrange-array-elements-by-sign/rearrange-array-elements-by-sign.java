class Solution {
    public int[] rearrangeArray(int[] nums) {
        //METHOD 1:- BRUTE FORCE ALGORITHM
        //Storing positives and negatives in separated lists
        /*
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
         */
        //TC is O(N)+O(N/2) and SC is O(N/2)+O(N/2)=O(N)

        //METHOD 2:- USING TWO POINTERS
        int[] answer= new int[nums.length];
        int positive= 0, negative= 1;
        for (int i=0; i<nums.length; i++){
            if (nums[i]>0){
                answer[positive]= nums[i];
                positive+=2;
            }
            else{
                answer[negative]= nums[i];
                negative+=2;
            }
        }
        return answer;
        //TC is O(N) and SC is O(N)
        //This method is slightly better
    }
}