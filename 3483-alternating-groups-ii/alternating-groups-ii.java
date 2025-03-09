public class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        //METHOD 2:- USING SLIDING WINDOW
        int answer= 0, count= 1, n= colors.length;
        for (int i=1; i<colors.length+k-1; i++){
            if (colors[i%n] != colors[(i-1+n)%n])
                count++;
            else
                count= 1;
            if (count>=k)
                answer++;
        }
        return answer;
        //TC is O(n+k) and SC is O(1)
    }
}