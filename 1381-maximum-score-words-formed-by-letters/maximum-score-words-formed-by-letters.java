class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        ArrayList<Character> chars = new ArrayList<>();
        for (char ele : letters)
            chars.add(ele);
        return maxScoreRecursive(words, new ArrayList<String>(), chars, score, 0);
    }

    private int maxScoreRecursive(String[] words, ArrayList<String> selectedWords, ArrayList<Character> chars, int[] score, int index) {
        if (index == words.length) {
            int sum = 0;
            for (String word : selectedWords) {
                int res = sumOfWord(word, chars, score);
                if (res == 0)
                    return 0;
                sum += res;
            }
            return sum;
        }
        selectedWords.add(words[index]);
        int x = maxScoreRecursive(words, selectedWords,  new ArrayList<>(chars), score, index+1); //new ArrayList is must
        selectedWords.remove(selectedWords.size() - 1);
        int y = maxScoreRecursive(words, selectedWords, new ArrayList<>(chars), score, index+1);
        return Math.max(x, y);
        /*
        Using new ArrayList<>(chars) is important to ensure that each recursive call works with its own copy of the character list, 
        thus preventing changes in one recursive branch from affecting another. .
         */
    }

    private int sumOfWord(String word, ArrayList<Character> chars, int[] score) {
        int sum = 0;
        ArrayList<Character> dup = new ArrayList<>(chars);
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!dup.contains(c)) {
                return 0;
            } else {
                sum += score[c - 97];
                dup.remove((Object)c);
            }
        }
        chars.clear();
        chars.addAll(dup);
        return sum;
    }
}