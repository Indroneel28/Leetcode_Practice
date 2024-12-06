class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        //FIRST METHOD:- USING HASHSET
        Set<Integer> set= new HashSet<>();
        for (int ele: banned)
            set.add(ele);

        int count= 0, sum= 0;
        for (int i=1; i<=n; i++){
            if (!set.contains(i)) {
                sum += i;
                //If sum exceeds maxSum then i can't be added
                if (sum > maxSum)
                    return count;
                count++;
            }
        }
        return count;
        //TC is O(2n) and SC is O(1)
    }
}