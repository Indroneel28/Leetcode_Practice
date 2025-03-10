class Solution {
    public long countOfSubstrings(String word, int k) {
        int[] isVowel = new int[128]; // To mark vowels
        int[] freq = new int[128]; // To track frequency of characters
        String vowels = "aeiou";

        // Mark vowels in the isVowel array
        for (char v : vowels.toCharArray()) {
            isVowel[v] = 1;
        }

        long response = 0;
        int currentK = 0, vowelCount = 0, extraLeft = 0, left = 0;

        int length = word.length();

        for (int right = 0; right < length; right++) {
            char rightChar = word.charAt(right);

            if (isVowel[rightChar] == 1) {
                if (++freq[rightChar] == 1) vowelCount++;
            } else {
                currentK++;
            }

            // Shrink window if consonant count exceeds k
            while (currentK > k) {
                char leftChar = word.charAt(left);
                if (isVowel[leftChar] == 1) {
                    if (--freq[leftChar] == 0) vowelCount--;
                } else {
                    currentK--;
                }
                left++;
                extraLeft = 0;
            }

            // Adjust left pointer to remove extra vowels
            while (vowelCount == 5 && currentK == k && left < right && isVowel[word.charAt(left)] == 1 && freq[word.charAt(left)] > 1) {
                extraLeft++;
                freq[word.charAt(left)]--;
                left++;
            }

            // Count valid substrings
            if (currentK == k && vowelCount == 5) {
                response += (1 + extraLeft);
            }
        }

        return response;
    }
}