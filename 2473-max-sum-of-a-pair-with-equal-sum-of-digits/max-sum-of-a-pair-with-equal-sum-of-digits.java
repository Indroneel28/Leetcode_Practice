class Solution {
    //METHOD 2:- USING HASHMAP
    private int sumOfDigits(int num){
        int sum= 0;
        while (num!=0){
            sum += (num%10);
            num /= 10;
        }
        return sum;
    }
    public int maximumSum(int[] nums) {
        HashMap<Integer, int[]> map= new HashMap<>();
        int maxSum= -1;
        for (int num: nums){
            int key= sumOfDigits(num);
            map.putIfAbsent(key,new int[2]);
            int first= map.get(key)[0], second= map.get(key)[1];
            if (first==0) //Index 0 is empty
                map.get(key)[0]= num;
            else if (second==0) //Index 1 is empty
                map.get(key)[1]= num;
            else { //Both are occupied
                //Put num in min value
                if (first<=second && num>first)
                    map.get(key)[0]= num;
                else if (second<=first && num>second)
                    map.get(key)[1]= num;
            }
            if (map.get(key)[0]!=0 && map.get(key)[1]!=0)
                maxSum= Math.max(maxSum,map.get(key)[0]+map.get(key)[1]);
        }
        return maxSum;
    }
    //TC is O(nlog10n) and SC is around O(2n)
}