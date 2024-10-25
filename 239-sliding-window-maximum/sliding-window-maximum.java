class Solution {
    //BRUTE FORCE METHOD:- Using Sliding Window
    /*
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] maxArray= new int[nums.length];
        for (int i=0;i<=nums.length-k;i++){
            maxArray[i]= max(nums,i,i+k-1);
        }
        return maxArray;
        //TC is O((n-k)*k) and SC is O(n)
    }
    private int max(int[] nums, int i, int j){
        int max= nums[i];
        for (int k=i+1; k<=j; k++){
            max= Math.max(max,nums[k]);
        }
        return max;
    }
     */
    //TLE

    //OPTIMAL METHOD:- Using Deque
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque= new ArrayDeque<>(); //To store indexes not elements
        //deque is like monotonic stack in decreasing order
        int[] answer= new int[nums.length-k+1];
        for (int i=0; i<nums.length; i++){
            //Remove extra elements from first
            if (!deque.isEmpty() && deque.peekFirst()<=i-k)
                deque.pollFirst();

            while (!deque.isEmpty() && nums[deque.peekLast()]<=nums[i])
                deque.pollLast();
            
            deque.offerLast(i);
            if (i>=k-1)
                answer[i-k+1]= nums[deque.peekFirst()];
        }
        return answer;
        //TC is O(2n) and SC is O(2n)
    }
}