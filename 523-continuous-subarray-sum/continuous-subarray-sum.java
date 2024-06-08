class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        //METHOD 2:- Modulo ki Jai Ho Method
        HashMap<Integer,Integer> hashMap= new HashMap<>();
        hashMap.put(0,-1);
        int sum= 0;

        for (int i=0; i<nums.length; i++){
            sum= (sum+nums[i])%k;
            if (hashMap.containsKey(sum)){
                if (i-hashMap.get(sum)>=2)
                    return true;
            }
            else
                hashMap.put(sum,i);
        }
        return false;
    }
}