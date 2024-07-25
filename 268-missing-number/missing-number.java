class Solution {
    public int missingNumber(int[] nums) {
        //NOTE:- There is only one missing number in the array from range (0 to n)

        //METHOD 1:- BRUTE FORCE APPROACH
        /*
        int n= nums.length;
        for (int i=0; i<=n; i++){
            boolean exists= false;
            for (int j=0; j<n; j++){
                if (i==nums[j]){
                    exists= true; //i exists is nums
                    break;
                }
            }
            if (!exists) //If i does not exist in nums
                return i;
        }
        return -1;//This line will never execute according to constraints
         */
        //TC is O(n^2) and SC is O(1)


        //METHOD 2:- BETTER APPROACH (USING ARRAY)
        /*
        int[] arr= new int[nums.length+1];
        for (int ele: nums){
            arr[ele]= 1;
        }
        for (int i=0; i<arr.length; i++){
            if (arr[i]==0)
                return i;
        }
        return -1;//This line will never execute according to constraints
         */
        //TC is O(2n) and SC is O(n)

        //NOTE:- THERE ARE TWO OPTIMAL SOLUTIONS

        //METHOD 3:- OPTIMAL SOLUTION (USING GAUSS LAW)
        //Sum of n numbers= (n)*(n+1)/2
        /*
        int n= nums.length;
        int sum= (n*(n+1))/2;

        int total=0;
        for (int ele: nums)
            total+= ele;

        return sum-total;
         */
        //TC is O(n) and SC is O(1)

        //METHOD 4:- OPTIMAL SOLUTION (USING XOR OPERATORS)
        //RULES:------- Xx can be any integer
        // x ^ x = 0
        // x ^ 0 = x
        int xor1= 0, xor2= 0, n= nums.length;
        for (int i=0; i<n; i++) {
            xor1 ^= (i+1); 
            xor2 ^= nums[i];
        }
        return xor1^xor2;
        //TC is O(n) and Sc is O(1)
        //This is better optimal solution than Method 3
    }
}