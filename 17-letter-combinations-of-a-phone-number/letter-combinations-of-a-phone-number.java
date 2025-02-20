class Solution {
    //USING RECURSION AND BACKTRACKING
    public List<String> letterCombinations(String digits) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        map.put(0, "");

        List<String> answer = new ArrayList<>();
        if (digits.isEmpty())
            return answer;
        backtrack(answer, new StringBuilder(), map, digits,0);
        return answer;
    }

    //Helper Method
    private void backtrack(List<String> answer, StringBuilder sb, HashMap<Integer, String> map, String digits, int i) {
        if (i == digits.length()) {
            answer.add(sb.toString());
            return;
        }

        String str = map.get(digits.charAt(i)-48);
        for (int j = 0; j < str.length(); j++) {
            sb.append(str.charAt(j));
            backtrack(answer, sb, map, digits,i+1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    //TC is Exponential and SC is O(n)
}