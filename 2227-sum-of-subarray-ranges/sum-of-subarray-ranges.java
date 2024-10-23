class Solution {
    public long subArrayRanges(int[] nums) {
        //BRUTE FORCE METHOD:- FIND ALL THE SUB-ARRAYS AND THEIR RANGES
        /*
        long sum= 0;
        for (int i=0; i<nums.length; i++){
            long max=Long.MIN_VALUE, min=Long.MAX_VALUE;
            for (int j=i; j<nums.length ; j++){
                max= Math.max(max,nums[j]);
                min= Math.min(min,nums[j]);
                sum+= (max-min);
            }
        }
        return sum;
         */
        //TC is O(n^2) and SC is O(1)

        //OPTIMAL METHOD
        //Step 1:- Find the sum of subarray minimum
        int[] nse= findNSE(nums);
        int[] psee= findPSEE(nums);

        //Step 2:- Find the sum of subarray maximum
        int[] nge= findNGE(nums);
        int[] pgee= findPGEE(nums);

        long sumOfMax= 0, sumOfMin= 0;
        for (int i=0; i<nums.length; i++){
            int leftS= i-psee[i];
            int rightS= nse[i]- i;
            int leftG= i-pgee[i];
            int rightG= nge[i]- i;
            sumOfMin+=((long) leftS *rightS*nums[i]);
            sumOfMax+=((long) leftG *rightG*nums[i]);
        }
        return sumOfMax-sumOfMin;
        //TC is O(2n+2n+2n+2n+n) and SC is O(2n+2n+2n+2n)
    }
    private int[] findNGE(int[] arr){
        int[] store= new int[arr.length];
        Stack<Integer> stack= new Stack<>(); //Decreasing order monotonic stack
        for (int i=arr.length-1; i>=0; i--){
            int ngeIndex= arr.length;
            while (!stack.isEmpty() && arr[stack.peek()]<=arr[i])
                stack.pop();
            if (!stack.isEmpty())
                ngeIndex= stack.peek();
            stack.push(i);
            store[i]= ngeIndex;
        }
        return store;
    }

    private int[] findNSE(int[] arr){
        int[] store= new int[arr.length];
        Stack<Integer> stack= new Stack<>(); //Increasing order monotonic stack
        for (int i=arr.length-1; i>=0; i--){
            int nseIndex= arr.length;
            while (!stack.isEmpty() && arr[stack.peek()]>=arr[i])
                stack.pop();
            if (!stack.isEmpty())
                nseIndex= stack.peek();
            stack.push(i);
            store[i]= nseIndex;
        }
        return store;
    }

    private int[] findPGEE(int[] arr){
        int[] store= new int[arr.length];
        Stack<Integer> stack= new Stack<>(); //Decreasing order monotonic stack
        for (int i=0; i<arr.length; i++){
            int pgeeIndex= -1;
            while (!stack.isEmpty() && arr[stack.peek()]<arr[i])
                stack.pop();
            if (!stack.isEmpty())
                pgeeIndex= stack.peek();
            stack.push(i);
            store[i]= pgeeIndex;
        }
        return store;
    }

    private int[] findPSEE(int[] arr){
        int[] store= new int[arr.length];
        Stack<Integer> stack= new Stack<>(); //Decreasing order monotonic stack
        for (int i=0; i<arr.length; i++){
            int pseeIndex= -1;
            while (!stack.isEmpty() && arr[stack.peek()]>arr[i])
                stack.pop();
            if (!stack.isEmpty())
                pseeIndex= stack.peek();
            stack.push(i);
            store[i]= pseeIndex;
        }
        return store;
    }
}