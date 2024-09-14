class Solution {
    public int longestSubarray(int[] nums) {
        //OPTIMAL METHOD:- Find the maximum element and it's consecutive occurrences (maxStreak)
        int maxOccur= nums[0], maxStreak= 1, streak= 1;

        for (int i=1; i< nums.length; i++ ){
            if (nums[i]>maxOccur) { //New max element
                maxOccur = nums[i];
                streak= maxStreak= 1;
            }
            else if (nums[i]==maxOccur) //same occurrence again
                streak++;
            else
                streak= 0; //make current streak= 0
            maxStreak = Math.max(streak, maxStreak);
        }
        return maxStreak;
        //TC is O(n) and SC is O(1)

        //THIS IS BETTER SOLUTION AS COMPARED TO OTHERS BECUASE IN ONE FOR LOOP IT"S SOLVED
    }
}