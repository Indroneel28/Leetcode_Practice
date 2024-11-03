class Solution {
    public boolean rotateString(String s, String goal) {
        //TRICK
        return s.length()==goal.length() && (s+s).contains(goal);
    }
}