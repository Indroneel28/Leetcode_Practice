class Solution {
    //USING RECURSION AND BACKTRACKING
    public String getHappyString(int n, int k) {
        ArrayList<String> list = new ArrayList<>();
        traverse(n, list, new boolean[n], "");
        if (list.size()<k)
            return "";
        return list.get(k-1);
    }

    //Helper Method
    private void traverse(int n, ArrayList<String> list, boolean[] check, String s) {
        if (s.length() == n) {
            //System.out.println(s);
            list.add(s);
            return;
        }

        for (char c = 'a'; c <= 'c'; c++) {
            if (s.isEmpty() || s.charAt(s.length() - 1) != c) {
                traverse(n, list, check, s + c);
            }
        }

    }
    //TC is Exponential and SC is O(n) coz of stack space
}