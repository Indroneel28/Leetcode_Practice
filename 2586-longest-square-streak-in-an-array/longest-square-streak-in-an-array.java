class Solution {
    public int longestSquareStreak(int[] nums) {
        //USING HASHSET
        HashSet<Integer> set= new HashSet<>();
        
        int max= 0, maxStreak= 0;
        for (int ele: nums) {
            set.add(ele);
            max= Math.max(ele,max);
        }

        for (int i=2; i<=max; i++){
            if (set.contains(i)){
                int ele= i;
                int streak= 0;
                while (set.contains(ele)){
                    streak++;
                    set.remove(ele);
                    ele= ele*ele;
                }
                maxStreak= Math.max(maxStreak,streak);
            }
        }

        if (maxStreak>1)
            return maxStreak;
        else 
            return -1;
        
        //TC is O(n+max) and SC is O(n)
    }
}