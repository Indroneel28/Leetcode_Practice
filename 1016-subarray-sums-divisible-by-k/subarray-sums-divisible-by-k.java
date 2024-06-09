class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        //METHOD 2:- PREFIX SUM
        int prefixMod= 0, result= 0;

        int[] arr= new int[k];
        arr[0]= 1;

        for (int num: nums){
            prefixMod= (prefixMod + num%k + k)%k;
            result+= arr[prefixMod];
            arr[prefixMod]++;
        }
        return result;
    }
}