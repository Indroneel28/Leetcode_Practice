class Solution {
    public int maxScore(int[] cardPoints, int k) {
        //OPTIMAL METHOD:- SLIDING WINDOW WITH TWO POINTERS
        int leftSum= 0, left=0;
        while (left<k){
            leftSum+= cardPoints[left];
            left++;
        }
        left--;
        if (cardPoints.length==k)
            return leftSum;
        int rightSum=0, right= cardPoints.length-1, maxSum= leftSum;
        while (left>=0){
            leftSum-=cardPoints[left];
            rightSum+= cardPoints[right];
            maxSum= Math.max(maxSum,leftSum+rightSum);
            right--;
            left--;
        }
        return maxSum;
        //TC is O(2k) and SC is O(1)
    }
}