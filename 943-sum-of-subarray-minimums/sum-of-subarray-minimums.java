class Solution {
    public int sumSubarrayMins(int[] arr) {
        //BRUTE FORCE METHOD:- Find all the sub-arrays and sum their minimums
        /*
        int sumOfMin= 0;
        for (int i=0; i<arr.length; i++){
            int min= Integer.MAX_VALUE;
            for (int j=i; j<arr.length; j++){
                min= Math.min(min,arr[j]);
                sumOfMin= (sumOfMin+min)%(1000000007);
            }
        }
        return sumOfMin;
         */
        //TC is O(n^2) and SC is O(1)
        ///TLE

        //OPTIMAL METHOD:- USING STACK

        //Step 1:- Find NSE (Next Smaller Element Index) for each element of arr.
        int[] nse= nse(arr);

        //Step 2:- Find PSEE (Previous Smaller or Equal Element Index) for each element of arr.
        int[] psee= psee(arr);

        //Step 3:- Find ths sum
        long total= 0;
        for (int i=0; i<arr.length; i++){
            long left= i-psee[i];
            long right= nse[i]-i;
            total= (total + (left*right*arr[i])%1000000007)%1000000007;
        }
        return (int)total;
        //TC is O(2n+2n+n) and SC is O(2n+2n+n) 
    }

    //To Find next smaller element's index for each element of arr
    private int[] nse(int[] arr){
        int[] store= new int[arr.length];
        Stack<Integer> monotonicStack= new Stack<>();
        for (int i=arr.length-1 ; i>=0 ; i--){
            int nse= arr.length;
            while (!monotonicStack.isEmpty() && arr[monotonicStack.peek()]>=arr[i])
                monotonicStack.pop();
            if (!monotonicStack.isEmpty())
                nse= monotonicStack.peek();
            store[i]= nse;
            monotonicStack.push(i); //To the current index
        }
        return store;
        //TC is O(2n)
    }
    
    //To find previous smaller or equal to element's index for each element of arr
    private int[] psee(int[] arr){
        int[] store= new int[arr.length];
        Stack<Integer> montonicStack= new Stack<>();
        for (int i=0; i<arr.length; i++){
            int psee= -1;
            while (!montonicStack.isEmpty() && arr[montonicStack.peek()]>arr[i])
                montonicStack.pop();
            if (!montonicStack.isEmpty())
                psee= montonicStack.peek();
            store[i]= psee;
            montonicStack.push(i);
        }
        return store;
        //TC is O(2n)
    }
}